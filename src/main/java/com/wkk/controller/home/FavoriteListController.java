package com.wkk.controller.home;

import com.wkk.pojo.BO.FavoriteList;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.service.FavoriteListService;
import com.wkk.service.ShoppingCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 17:43
 */
@Controller
public class FavoriteListController {
    @Resource
    FavoriteListService favoriteListService;
    @Resource
    ShoppingCarService shoppingCarService;

    @RequestMapping("/toWishList")
    public String findAllWish(HttpSession session, Model model){
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<FavoriteList> favoriteLists = favoriteListService.findByUserAccount(user.getAccount());
        model.addAttribute("favoriteLists", favoriteLists);
        return "shop/wishlist";
    }

    @RequestMapping("/wishlist/delete/{name}")
    public String deleteWishlist(@PathVariable("name")String name, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        favoriteListService.deleteItem(user.getAccount(), name);
        return "forward:/toGallery";
    }

    @RequestMapping("/addToCarAndDeleteWishlist/{name}")
    public String addToCarAndDeleteWishlist(@PathVariable("name")String name, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");

        favoriteListService.deleteItem(user.getAccount(), name);
        shoppingCarService.addItem(name, user.getAccount());
        List<ShoppingCar> shoppingCarList = shoppingCarService.findByUserAccount(user.getAccount());
        Double shoppingCarTotalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            shoppingCarTotalPrice += shoppingCar.getTotalPrice();
        }
        session.setAttribute("shoppingCarList", shoppingCarList);
        session.setAttribute("shoppingCarSize", shoppingCarList.size());
        session.setAttribute("shoppingCarTotalPrice", shoppingCarTotalPrice);
        return "forward:/toGallery";
    }


    @RequestMapping("/addToWishlist/{name}")
    public String addToWishlist(@PathVariable("name")String name, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        favoriteListService.addItem(name, user.getAccount());
        return "forward:/toGallery";
    }
}
