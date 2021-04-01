package com.wkk.controller.home;

import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
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
 * @date 2021/4/1 17:42
 */
@Controller
public class ShoppingCarController {
    @Resource
    ShoppingCarService shoppingCarService;

    @RequestMapping("/toCart")
    public String toCart(HttpSession session, Model model){
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<ShoppingCar> shoppingCarList = shoppingCarService.findByUserAccount(user.getAccount());
        Double shoppingCarTotalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            shoppingCarTotalPrice += shoppingCar.getTotalPrice();
        }
        session.setAttribute("shoppingCarList", shoppingCarList);
        session.setAttribute("shoppingCarSize", shoppingCarList.size());
        session.setAttribute("shoppingCarTotalPrice", shoppingCarTotalPrice);
        return "shop/cart";
    }

    @RequestMapping("/shoppingCar/delete/{name}")
    public String deleteCarItem(@PathVariable("name")String name, HttpSession session, Model model){
        UserInfo user = (UserInfo) session.getAttribute("user");
        shoppingCarService.deleteItem(user.getAccount(), name);
        return "forward:/toCart";
    }

    @RequestMapping("/addToCart/{name}")
    public String addToCar(@PathVariable("name")String name, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        shoppingCarService.addItem(name, user.getAccount());
        List<ShoppingCar> shoppingCarList = shoppingCarService.findByUserAccount(user.getAccount());
        Double shoppingCarTotalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            shoppingCarTotalPrice += shoppingCar.getTotalPrice();
        }
        session.setAttribute("shoppingCarList", shoppingCarList);
        session.setAttribute("shoppingCarSize", shoppingCarList.size());
        session.setAttribute("shoppingCarTotalPrice", shoppingCarTotalPrice);
        return "forward:/toWishList";
    }
}
