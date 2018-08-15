package com.ultrapower.storemgr.web;

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

import com.ultrapower.storemgr.service.IStoreService;
import com.ultrapower.storemgr.vo.StoreModel;
import com.ultrapower.storemgr.vo.StoreQueryModel;

@Controller
@RequestMapping(value="/store")
public class StoreController {
	@Autowired
	private IStoreService iservice = null;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd(){
		
		return "store/add";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@ModelAttribute("m") StoreModel m){
		iservice.create(m);
		return "store/success";
	}
	@RequestMapping(value="toUpdate/{pid}",method=RequestMethod.GET)
	public String toUpdate(Model model,@PathVariable("pid") int pid){
		StoreModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "store/update";
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String post(@ModelAttribute("m") StoreModel m){
		iservice.update(m);
		return "store/success";
	}
	@RequestMapping(value="toDelete/{pid}",method=RequestMethod.GET)
	public String toDelete(Model model,@PathVariable("pid") int pid){
		StoreModel m = iservice.getByPid(pid);
		model.addAttribute("m", m);
		return "store/delete";
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String post(@RequestParam("pid") int pid){
		iservice.delete(pid);
		return "store/success";
	}
	@RequestMapping(value="toList",method=RequestMethod.GET)
	public String toList(@ModelAttribute("wm")StoreWebModel wm,Model model){
		StoreQueryModel qm = null;
		if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
			qm =  new StoreQueryModel();
		}else{
			String s = wm.getQueryJsonStr();
			s = s.replace("-", "%");
			qm = (StoreQueryModel) JsonHelper.str2object(s, StoreQueryModel.class);
		}

		qm.getPageHelper().startPage(wm.getPageNum(),5);
		PageInfo<StoreModel> cpageInfo  = iservice.getByConditionPage(qm);

		//
		model.addAttribute("wm", wm);
		model.addAttribute("page", cpageInfo);
				
		return "store/list";
	}
	@RequestMapping(value="toQuery",method=RequestMethod.GET)
	public String toQuery(){
		return "store/query";
	}	
}
