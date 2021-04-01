package com.wkk.controller.admin;

import com.github.pagehelper.PageInfo;
import com.wkk.pojo.BO.UserInfo;
import com.wkk.pojo.DO.UserInfoDO;
import com.wkk.service.UserService;
import com.wkk.utils.MD5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author wkk
 * @date 2021/3/31 23:07
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Resource
    UserService userService;

    @RequestMapping("/user/list")
    public String listAllUser(Model model){
        PageInfo<UserInfo> pageInfo = userService.pageUser(1,5);
        List<UserInfo> userList = pageInfo.getList();
        pageInfo.setPageNum(1);
        model.addAttribute("userList", userList);
        model.addAttribute("page", pageInfo);
        return "admin/user/user-list";
    }

    @RequestMapping("/user/edit/{account}")
    public String editUser(@PathVariable("account") Integer userAccount, Model model){
        UserInfo userInfo = userService.findByAccount(userAccount);
        model.addAttribute("user", userInfo);
        return "admin/user/user-edit";
    }

    @RequestMapping("/user/update")
    public String updateUser(UserInfoDO user){
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setId(user.getId());
        userInfoDO.setUserName(user.getUserName());
        userInfoDO.setAccount(user.getAccount());
        userInfoDO.setGender(user.getGender());
        userInfoDO.setStatus(user.getStatus());
        userInfoDO.setAddress(user.getAddress());
        userInfoDO.setSalt(user.getSalt());
        userInfoDO.setPhone(user.getPhone());
        userInfoDO.setPassword(MD5.encodeByMD5(user.getPassword()+user.getSalt()));
        userService.update(userInfoDO);
        return "forward:/admin/user/list";
    }

    @RequestMapping("/user/add")
    public String addUser(UserInfoDO userInfo){
        String password = userInfo.getPassword();
        Random random = new Random();
        int salt = random.nextInt(10);
        userInfo.setStatus(0);
        userInfo.setGender(1);
        userInfo.setSalt(salt);
        userInfo.setPassword(MD5.encodeByMD5(password+salt));
        userService.insert(userInfo);
        return "forward:/admin/user/list";
    }
    @RequestMapping("/user/delete/{account}")
    public String deleteUser(@PathVariable("account") Integer userAccount){
        userService.deleteByAccount(userAccount);
        return "forward:/admin/user/list";
    }

    @RequestMapping("/user/freeze/{account}")
    public String freezeUser(@PathVariable("account") Integer userAccount){
        userService.freezeByAccount(userAccount);
        return "forward:/admin/user/list";
    }

    @RequestMapping("/user/unfreeze/{account}")
    public String unfreezeUser(@PathVariable("account") Integer userAccount){
        userService.unFreezeByAccount(userAccount);
        return "forward:/admin/user/list";
    }

    @RequestMapping("/user/page/{pagenum}")
    public String pageWords(@PathVariable("pagenum")Integer pageNum, Model model){
        if(pageNum <= 0){
            return "forward:/admin/user/list";
        }
        PageInfo<UserInfo> pageInfo = userService.pageUser(pageNum,5);
        List<UserInfo> userList = pageInfo.getList();
        pageInfo.setPageNum(pageNum);
        if(userList == null || userList.size() == 5){
            pageInfo = userService.pageUser(pageNum-1,5);
            pageInfo.setPageNum(pageNum-1);
            userList = pageInfo.getList();
        }
        model.addAttribute("userList", userList);
        model.addAttribute("page", pageInfo);
        return "admin/user/user-list";
    }

    @RequestMapping("/user/insert")
    public String toInsertPage(){
        return "admin/user/user-add";
    }
}
