package com.wkk.controller.home;

import com.wkk.pojo.BO.ShoppingCar;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.UserInfoDO;
import com.wkk.service.ShoppingCarService;
import com.wkk.service.UserService;
import com.wkk.utils.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

/**
 * @author wkk
 * @date 2021/3/29 22:59
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private ShoppingCarService shoppingCarService;

    @RequestMapping("/register")
    public String register(UserInfoDO userInfoDO){
        String password = userInfoDO.getPassword();
        Random random = new Random();
        int salt = random.nextInt(10);
        userInfoDO.setStatus(0);
        userInfoDO.setGender(1);
        userInfoDO.setSalt(salt);
        userInfoDO.setPassword(MD5.encodeByMD5(password+salt));
        userService.insert(userInfoDO);
        return "/login";
    }

    @RequestMapping("/user/update")
    public String updatUserInfo(UserInfo param, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setId(user.getId());
        userInfoDO.setGender(user.getGender());
        userInfoDO.setStatus(user.getStatus().getCode());
        userInfoDO.setAccount(user.getAccount());
        userInfoDO.setSalt(user.getSalt());
        if(!param.getPassword().equals("") && param.getPassword() != null){
            userInfoDO.setPassword(MD5.encodeByMD5(param.getPassword()+user.getSalt()));
        }else{
            userInfoDO.setPassword(user.getPassword());
        }
        if(!param.getPhone().equals("") && param.getPhone() != null){
            userInfoDO.setPhone(param.getPhone());
        }else{
            userInfoDO.setPhone(user.getPhone());
        }
        if(!param.getAddress().equals("") && param.getAddress() != null){
            userInfoDO.setAddress(param.getAddress());
        }else{
            userInfoDO.setAddress(user.getAddress());
        }
        if(!param.getUserName().equals("") && param.getUserName() != null){
            userInfoDO.setUserName(param.getUserName());
        }else{
            userInfoDO.setUserName(user.getUserName());
        }
        if(!param.getGender().equals("") && param.getGender() != null){
            userInfoDO.setGender(param.getGender());
        }else{
            userInfoDO.setGender(user.getGender());
        }
        userService.update(userInfoDO);
        return "/login";
    }
    @RequestMapping(value = "/login")
    public String login(Integer account, String password, HttpSession session, Model model) {

        UserInfo user =  userService.findByAccount(account);;
        Integer salt = user.getSalt();
        String MD5Password = MD5.encodeByMD5(password+salt);
        if (user == null || !user.getPassword().equals(MD5Password) || !user.getStatus().getCode().equals(0)) {
            return "login";
        }
        if(account == 666666){
            return "admin/index";
        }

        List<ShoppingCar> shoppingCarList = shoppingCarService.findByUserAccount(account);

        Double shoppingCarTotalPrice = 0.00;
        for(ShoppingCar shoppingCar : shoppingCarList){
            shoppingCarTotalPrice += shoppingCar.getTotalPrice();
        }
        session.setAttribute("shoppingCarList", shoppingCarList);
        session.setAttribute("shoppingCarSize", shoppingCarList.size());
        session.setAttribute("shoppingCarTotalPrice", shoppingCarTotalPrice);
        session.setAttribute("user", user);
        return "shop/index";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }
}
