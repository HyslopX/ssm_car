package com.sailing.util;


import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CheckLoginFilter implements Filter
{
    @Autowired
    UserMapper userMapper;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        String user_id ="";
                user_id=(String)session.getAttribute("user");
//        User user = userMapper.selectByPrimaryKey(user_id);
        if(user_id=="" || user_id == null){
            System.out.println("qwer!!!");
            response.sendRedirect("/login/login");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
