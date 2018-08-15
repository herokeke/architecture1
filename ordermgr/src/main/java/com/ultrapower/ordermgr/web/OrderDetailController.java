package com.ultrapower.ordermgr.web;

import com.github.pagehelper.PageInfo;
import com.ultrapower.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ultrapower.ordermgr.service.IOrderDetailService;
import com.ultrapower.ordermgr.vo.OrderDetailModel;
import com.ultrapower.ordermgr.vo.OrderDetailQueryModel;

@Controller
@RequestMapping(value="/orderDetail")
public class OrderDetailController {
	@Autowired
	private IOrderDetailService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "orderDetail/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") OrderDetailModel m){
		iservice.create(m);
		return "orderDetail/success";
	}
	@RequestMapping(value="toUpdate/{pid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("pid") int pid){
		OrderDetailModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "orderDetail/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("m") OrderDetailModel m){
		iservice.update(m);
		return "orderDetail/success";
	}
	@RequestMapping(value="toDelete/{pid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("pid") int pid){
		OrderDetailModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "orderDetail/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("pid") int pid){
		iservice.delete(pid);
		return "orderDetail/success";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")OrderDetailWebModel wm,Model model){
		OrderDetailQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new OrderDetailQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (OrderDetailQueryModel) JsonHelper.str2object(s, OrderDetailQueryModel.class);
		}

		qm.getPageHelper().startPage(wm.getPageNum(),5);
		PageInfo<OrderDetailModel> cpageInfo  = iservice.getByConditionPage(qm);
		
		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", cpageInfo);
				
		return "orderDetail/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "orderDetail/query";
	}	
}
