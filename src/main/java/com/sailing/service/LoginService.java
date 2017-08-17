package com.sailing.service;



import com.sailing.entity.User;
import com.sailing.util.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public interface LoginService
{
    public User checkLogin(String username, String password);

    public void processRegister(HttpServletRequest request) throws ServiceException, ParseException;

    public void processActivate(HttpServletRequest request) throws ServiceException, ParseException;

}
