package com.sailing.web.controller;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import com.sailing.service.UserService;
import com.sailing.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;




@Controller
@RequestMapping("/usercenter")
public class UserController {

    @Resource
    private UserMapper userdao;
    @Resource
    private UserService userService;
    //usercenter页面点击个人信息查看
    @RequestMapping("/userinfo")
    public ModelAndView toUserInfo(HttpSession session,HttpServletRequest request) {
        String action = request.getParameter("action");
        System.out.println("aaaaaaa:"+action);
//        HttpSession session = request.getSession();
        String user_id = (String) session.getAttribute("user");
//        String user_id = "32832";
//        String user_id = (String) session.getAttribute("user");
        System.out.println("wwwW:"+user_id);
        User user = userService.selectByPrimaryKey(user_id);
        if (action.equals("show")) {
            ModelAndView model = userService.showUserInfo(user);
            return model;
        } else {
            user.setUname(request.getParameter("name"));
            user.setUsex(request.getParameter("sex"));
            user.setUage(Integer.parseInt(request.getParameter("age")));
            user.setUphone(request.getParameter("phone"));
//            session.setAttribute("user", user);
            userdao.updateByPrimaryKey(user);
//            return new ModelAndView("/usercenter/userinfo?action=show");
//            return new ModelAndView("redirect:/usercenter/userinfo?action=show");
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("user/usercenter");
            return modelAndView;
        }

    }
    //点击修改密码
    @RequestMapping("/updatepassword")
    public String toUpdatePassword(HttpServletRequest request) {
        String action = request.getParameter("action");
        return "user/updatepsw";
    }
    //确认修改密码
    @RequestMapping("/submitpassword")
    @ResponseBody
    public String UpdatePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String user1 = (String) session.getAttribute("user");
        User user =  userService.selectByPrimaryKey(user1);
        if (!user.getUpassword().equals(MD5Util.encode2hex(request.getParameter("init")))) {
            return "fail";
        } else {
            user.setUpassword(MD5Util.encode2hex(request.getParameter("new")));
            userdao.updateByPrimaryKey(user);
            session.invalidate();
            return "success";
        }
    }
    //用户退出
    @RequestMapping("/out")
    public String userOut(HttpSession session){
        //session清除
        session.invalidate();
        return "login-multi";
    }


}
