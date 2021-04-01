package com.wkk.controller.home;

import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.OrderDetail;
import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.service.OrderDetailService;
import com.wkk.service.OrderService;
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
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    OrderDetailService orderDetailService;
    @Resource
    ShoppingCarService shoppingCarService;

    @RequestMapping("/checkoutOrder")
    public String checkoutOrder(HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<ShoppingCar> shoppingCarList = shoppingCarService.findByUserAccount(user.getAccount());
        Double shoppingCarTotalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            shoppingCarTotalPrice += shoppingCar.getTotalPrice();
        }
        session.setAttribute("shoppingCarList", shoppingCarList);
        session.setAttribute("shoppingCarSize", shoppingCarList.size());
        session.setAttribute("shoppingCarTotalPrice", shoppingCarTotalPrice);
        return "shop/checkout";
    }

    @RequestMapping("/order/add/{account}")
    public String addOrder(@PathVariable("account")Integer account){
        orderService.addOrder(account);
        return "shop/my-account";
    }
    @RequestMapping("/order/user/{account}")
    public String findByAccount(@PathVariable("account") Integer userAccount, Model model){
        List<Order> orderList = orderService.findByAccount(userAccount);
        model.addAttribute("orderList", orderList);
        return "shop/order-list";
    }

    @RequestMapping("/order/delete/{deliveryNo}")
    public String deliverOrder(@PathVariable("deliveryNo") String deliveryNo, Model model, HttpSession session){
        orderService.deleteOrder(deliveryNo);
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<Order> orderList = orderService.findByAccount(user.getAccount());
        model.addAttribute("orderList", orderList);
        return "shop/order-list";
    }

    @RequestMapping("/orderdetail/user/{account}")
    public String findByUserAccount(@PathVariable("account") Integer account, Model model){
        List<OrderDetail> orderDetailList = orderDetailService.findByUserAccount(account);
        model.addAttribute("orderDetailList", orderDetailList);
        return "shop/order-detail";
    }
    @RequestMapping("/orderdetail/find/{deliveryNo}")
    public String findByUserDeliveryNo(@PathVariable("deliveryNo") String deliveryNo, Model model){
        List<OrderDetail> orderDetailList = orderDetailService.findByDeliveryNo(deliveryNo);
        model.addAttribute("orderDetailList", orderDetailList);
        return "shop/order-detail";
    }

    @RequestMapping("/orderdetail/delete/{id}")
    public String deleteById(@PathVariable("id") Integer id, Model model, HttpSession session){
        orderDetailService.deleteById(id);
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<OrderDetail> orderDetailList = orderDetailService.findByUserAccount(user.getAccount());
        model.addAttribute("orderDetailList", orderDetailList);
        return "shop/order-detail";
    }

}
