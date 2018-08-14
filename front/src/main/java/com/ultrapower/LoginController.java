package com.ultrapower;

import com.ultrapower.customermgr.service.ICustomerService;
import com.ultrapower.customermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by User on 2018/8/13.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private ICustomerService ics = null;

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(@RequestParam("customerId")String customerId,@RequestParam("pwd")String pwd,HttpServletResponse resonse){

        if(StringUtils.isEmpty(customerId)){
            return "login";
        }

        CustomerModel cm = ics.getByCustomerId(customerId);

        if(cm==null){
            return "login";
        }
        Cookie cookie = new Cookie("Mylogin",cm.getPid()+","+ System.currentTimeMillis());
        resonse.addCookie(cookie);
        return "index";
    }
}
