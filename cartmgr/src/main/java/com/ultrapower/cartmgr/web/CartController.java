package com.ultrapower.cartmgr.web;

import com.github.pagehelper.PageInfo;
import com.ultrapower.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ultrapower.cartmgr.service.ICartService;
import com.ultrapower.cartmgr.vo.CartModel;
import com.ultrapower.cartmgr.vo.CartQueryModel;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	@Autowired
	private ICartService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "cart/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") CartModel m){
		iservice.create(m);
		return "cart/success";
	}
	@RequestMapping(value="toUpdate/{pid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("pid") int pid){
		CartModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "cart/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("m") CartModel m){
		iservice.update(m);
		return "cart/success";
	}
	@RequestMapping(value="toDelete/{pid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("pid") int pid){
		CartModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "cart/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("pid") int pid){
		iservice.delete(pid);
		return "cart/success";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")CartWebModel wm,Model model){
		CartQueryModel cqm = null;
		if(StringUtils.isEmpty(cqm) || wm.getQueryJsonStr().trim().length()==0){
			cqm = new CartQueryModel();
		}else{
			cqm = (CartQueryModel) JsonHelper.str2object(wm.getQueryJsonStr(),CartQueryModel.class);
		}
		cqm.getPageHelper().startPage(wm.getPageNum(),5);
		PageInfo<CartModel> cpageInfo  = iservice.getByConditionPage(cqm);
		model.addAttribute("page",cpageInfo);
		return "customer/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "cart/query";
	}	
}
