package com.ultrapower.customermgr;

import com.github.pagehelper.PageInfo;
import com.ultrapower.customermgr.service.ICustomerService;
import com.ultrapower.customermgr.vo.CustomerQueryModel;
import com.ultrapower.customermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by User on 2018/8/6.
 */


public class Client {


   // private CustomerDAO customerDao;
    private ICustomerService iservice = null;

    public ICustomerService getIservice() {
        return iservice;
    }

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client t = (Client) ctx.getBean("client");
        CustomerModel cm = new CustomerModel();
        cm.setCustomerId("Demo");
        cm.setPwd("123");
        cm.setRegisterTime("111");
        cm.setShowName("Demo");
        cm.setTrueName("系统管理员");
       // t.customerDao.create(cm);
        t.getIservice().create(cm);

        CustomerQueryModel cqm = new CustomerQueryModel();
        cqm.getPageHelper().startPage(1,5);
      //  List<CustomerModel> list = t.customerDao.getByConditionPage(cqm);
        // PageInfo page = new PageInfo<>(list);
        /*
                开启事务Transactional 改 t.iservice 为null值。
                说明，iservice并非原有对象，只是一个代理对象。
         */
        PageInfo<CustomerModel> page = t.getIservice().getByConditionPage(cqm);
        System.out.println(page.getPages()+"页，一共"+page.getTotal()+"条==="+page);


    }

}
