package com.sailing.web.controller;

import com.sailing.service.LoginService;
import com.sailing.util.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


//注册
@Controller
public class RegisterController
{
    @Resource
    private LoginService loginService;
    //注册
    @RequestMapping("/register")
    public String load(HttpServletRequest request) throws ParseException, ServiceException {
        String action = request.getParameter("action");

        if("register".equals(action)) {
            //注册
            loginService.processRegister(request);//发邮箱激活
            //mav.addObject("text","注册成功,等待验证");
            return "verification/register_success";
        }
        else if("activate".equals(action)) {
            //激活
            try {
                loginService.processActivate(request);//调用激活方法
                return "verification/activate_success";
            } catch (ServiceException e) {
                request.setAttribute("message" , e.getMessage());
                return "verification/activate_failure";
            }
        }

        return "/login/login";
    }
}
