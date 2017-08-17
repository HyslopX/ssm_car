package com.sailing.service;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import com.sailing.service.LoginService;
import com.sailing.util.MD5Util;
import com.sailing.util.SendMailUtil;
import com.sailing.util.ServiceException;
import com.sailing.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/14.
 */

@Service("loginService")
public class LoginServiceIml implements LoginService {
    @Resource
    private UserMapper userdao;

    @Override
    public User checkLogin(String username, String password) {
        User user = userdao.selectByUsername(username);
        if (user != null && user.getUpassword().equals(password)) {
            return user;
        } else return null;
    }

    @Override
    public void processRegister(HttpServletRequest request)throws ServiceException, ParseException {
        User user1 = userdao.selectByUsername(request.getParameter("username"));
        if (user1 == null) {
            user1 = userdao.selectByUemail(request.getParameter("uemail"));
            if (user1 == null) {

                User user = new User();
                Random random = new Random();
                int result = random.nextInt(60000) % 30001 + 30000;
                user.setUid(String.valueOf(result));
                user.setUsername(request.getParameter("username"));
                user.setUpassword(MD5Util.encode2hex(request.getParameter("upassword")));
                user.setUemail(request.getParameter("uemail"));
                user.setUphone(request.getParameter("uphone"));
                user.setUregistertime(new Date());
                user.setUvalidatecode(MD5Util.encode2hex(request.getParameter("uemail"))); //将邮箱做MD5加密后用作激活码
                user.setUstatus((byte) 0);
                userdao.insert(user);

                StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
                sb.append("<a href=\"http://localhost:8080/register?action=activate&email=");
                sb.append(user.getUemail());
                sb.append("&validateCode=");
                sb.append(user.getUvalidatecode());
                sb.append("\">http://localhost:8080/register?action=activate&email=");
                sb.append(user.getUemail());
                sb.append("&validateCode=");
                sb.append(user.getUvalidatecode());
                sb.append("</a>");

                //发送邮件
                SendMailUtil.send(user.getUemail(), sb.toString());
                System.out.println("发送邮件");
            }else{
                throw new ServiceException("该邮箱已被使用！");
            }
         }else {
            throw new ServiceException("用户名已存在！");
         }

    }

    public void processActivate(HttpServletRequest request)throws ServiceException, ParseException {
        //数据访问层，通过email获取用户信息
        User user=userdao.selectByUemail(request.getParameter("email"));
        //验证用户是否存在
        if(user!=null) {
            //验证用户激活状态
            if(user.getUstatus()==0) {
                ///没激活
                Date currentTime = new Date();//获取当前时间
                //验证链接是否过期
                //currentTime.before(user.getRegisterTime());
                if(currentTime.before(user.getLastActivateTime())) {
                    //验证激活码是否正确
                    if(request.getParameter("validateCode").equals(user.getUvalidatecode())) {
                        //激活成功， //并更新用户的激活状态，为已激活
                        System.out.println("==sq==="+user.getUstatus());
                        user.setUstatus((byte) 1);//把状态改为激活
                        System.out.println("==sh==="+user.getUstatus());
                        userdao.updateByPrimaryKey(user);
                    } else {
                        throw new ServiceException("激活码不正确");
                    }
                } else { throw new ServiceException("激活码已过期！");
                }
            } else {
                throw new ServiceException("邮箱已激活，请登录！");
            }
        } else {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
        }

    }


}
