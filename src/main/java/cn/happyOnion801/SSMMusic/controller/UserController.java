package cn.happyOnion801.SSMMusic.controller;

import cn.happyOnion801.SSMMusic.bean.User;
import cn.happyOnion801.SSMMusic.service.UserService;
import cn.happyOnion801.SSMMusic.utils.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/adminLogin")
    public String adminLogin(Model model, HttpSession session, @RequestParam("userName") String username, String password) {
        ResultEntity resultEntity = userService.adminLogin(username, password);
        if ("登录成功".equals(resultEntity.getMsg())) {
            session.setAttribute("user", resultEntity.getDate());
            return "redirect:/user/toUserManager";
        }
        model.addAttribute("msg", resultEntity.getMsg());
        return "/admin/AdminLogin";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpSession session, @RequestParam(defaultValue = "") String userName, @RequestParam(defaultValue = "") String password) {
        ResultEntity resultEntity = userService.login(userName, password);
        if ("登录成功".equals(resultEntity.getMsg())) {
            session.setAttribute("user", resultEntity.getDate());
            return "redirect:/";
        }
        model.addAttribute("msg", resultEntity.getMsg());
        return "../login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        User user = (User) session.getAttribute("user");
        session.invalidate();
        if (userService.checkUser(user) && user.getType() == 1) {
            return "redirect:/user/toUserManager";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String userName) {
        return userService.hasName(userName) ? "yes" : "no";
    }

    @RequestMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/toUserManager")
    public String toUserManager(Model model, @RequestParam(defaultValue = "1") int pageNO) {
        model.addAttribute("info", userService.showAllUser(pageNO));
        return "/admin/userManager";
    }

    @RequestMapping("/saveUser")
    public String toSaveUser(User user) {
        userService.save(user);
        return "redirect:/user/toUserManager";
    }

    @RequestMapping("/editUser")
    public String editUser(User user) {
        userService.update(user);
        return "redirect:/user/toUserManager";
    }

    @RequestMapping("/delById")
    @ResponseBody
    public String delById(int userId) {
        return userService.deleted(userId) ? "yes" : "no";
    }
}