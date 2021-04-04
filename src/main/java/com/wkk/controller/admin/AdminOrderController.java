package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.Order;
import com.wkk.pojo.BO.OrderDetail;
import com.wkk.service.OrderDetailService;
import com.wkk.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wkk
 * @date 2021/4/1 13:10
 */
@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    @Resource
    OrderService orderService;
    @Resource
    OrderDetailService orderDetailService;

    @RequestMapping("/order/list")
    public String listAllOrder(Model model){
        PageInfo<Order> pageInfo = orderService.pageOrder(1,5);
        List<Order> orderList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("orderList", orderList);
        model.addAttribute("page", pageInfo);
        return "admin/order/order-list";
    }

    @RequestMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Integer id){
        orderService.deleteOrder(id);
        return "forward:/admin/order/list";
    }

    @RequestMapping("/order/page/{pagenum}")
    public String pageOrder(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/order/list";
        }
        PageInfo<Order> pageInfo = orderService.pageOrder(pageNum,5);
        List<Order> orderList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(orderList == null || orderList.size() == 0){
            pageInfo = orderService.pageOrder(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            orderList = pageInfo.getList();
        }
        model.addAttribute("orderList", orderList);
        model.addAttribute("page", pageInfo);
        return "admin/order/order-list";
    }


    @RequestMapping("/order/send/{deliveryNo}")
    public String sendOrder(@PathVariable("deliveryNo") String deliveryNo){
        Order order = orderService.findByDeliveryNo(deliveryNo);
        order.setSendStatus("已发货");
        orderService.updatedOrder(order);
        return "forward:/admin/order/list";
    }


    @RequestMapping("/order/detail/{deliveryNo}")
    public String toInsertPage(@PathVariable("deliveryNo") String deliveryNo, Model model){
        List<OrderDetail> orderDetailList = orderDetailService.findByDeliveryNo(deliveryNo);
        model.addAttribute("orderDetailList", orderDetailList);
        return "admin/order/order-detail";
    }
}
