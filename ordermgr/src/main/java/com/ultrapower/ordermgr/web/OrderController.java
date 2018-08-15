package com.ultrapower.ordermgr.web;

import com.github.pagehelper.PageInfo;
import com.ultrapower.ordermgr.vo.OrderDetailModel;
import com.ultrapower.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ultrapower.ordermgr.service.IOrderService;
import com.ultrapower.ordermgr.vo.OrderModel;
import com.ultrapower.ordermgr.vo.OrderQueryModel;
@Controller
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private IOrderService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "order/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") OrderModel m){
		iservice.create(m);
		return "order/success";
	}
	@RequestMapping(value="toUpdate/{pid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("pid") int pid){
		OrderModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "order/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("m") OrderModel m){
		iservice.update(m);
		return "order/success";
	}
	@RequestMapping(value="toDelete/{pid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("pid") int pid){
		OrderModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "order/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("pid") int pid){
		iservice.delete(pid);
		return "order/success";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")OrderWebModel wm,Model model){
		OrderQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new OrderQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (OrderQueryModel) JsonHelper.str2object(s, OrderQueryModel.class);
		}

		qm.getPageHelper().startPage(wm.getPageNum(),5);
		PageInfo<OrderModel> cpageInfo  = iservice.getByConditionPage(qm);
		

		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", cpageInfo);
				
		return "order/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "order/query";
	}	
}
