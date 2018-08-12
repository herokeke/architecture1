package com.ultrapower.customermgr.web;

import com.github.pagehelper.PageInfo;
import com.ultrapower.customermgr.service.ICustomerService;
import com.ultrapower.customermgr.vo.CustomerQueryModel;
import com.ultrapower.customermgr.vo.CustomerModel;
import com.ultrapower.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.net.SocketTimeoutException;

/**
 * Created by User on 2018/8/10.
 */
@Controller
@RequestMapping(value="/customer")
public class CustomerController {

    @Autowired
    private ICustomerService ics = null;



    @RequestMapping(value="toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "customer/add";
    }

    @RequestMapping(value="add",method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") CustomerModel cm){
        ics.create(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{pid}",method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("pid") int pid){
        CustomerModel cm =  ics.getByPid(pid);
        model.addAttribute("cm",cm);
        return "customer/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String post(@ModelAttribute("cm") CustomerModel cm){
        ics.update(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toDelete/{pid}",method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("pid") int pid){
        CustomerModel cm =  ics.getByPid(pid);
        model.addAttribute("cm",cm);
        return "customer/delete";
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String post(@RequestParam("pid") int pid){
        ics.delete(pid);
        return "customer/success";
    }


    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") CustomerWebModel wm, Model model){
        CustomerQueryModel cqm = null;
        if(StringUtils.isEmpty(cqm) || wm.getQueryJsonStr().trim().length()==0){
            cqm = new CustomerQueryModel();
        }else{
            cqm = (CustomerQueryModel)JsonHelper.str2object(wm.getQueryJsonStr(),CustomerQueryModel.class);
        }
        cqm.getPageHelper().startPage(wm.getPageNum(),5);
        PageInfo<CustomerModel> cpageInfo  = ics.getByConditionPage(cqm);
        model.addAttribute("page",cpageInfo);
        return "customer/list";
    }

    /*
    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String toList(@RequestParam(value = "queryJsonStr",defaultValue = "")String queryJson,@ModelAttribute("page") PageInfo pageInfo, Model model){
        CustomerQueryModel cqm = null;
        if(StringUtils.isEmpty(cqm) || queryJson.trim().length()==0){
            cqm = new CustomerQueryModel();
        }else{
            cqm = (CustomerQueryModel)JsonHelper.str2object(queryJson,CustomerQueryModel.class);
        }
        cqm.getPageHelper().startPage(pageInfo.getPageNum(),5);
        PageInfo<CustomerModel> cpageInfo  = ics.getByConditionPage(cqm);
        model.addAttribute("page",cpageInfo);
        return "customer/list";
    }
    */



}
