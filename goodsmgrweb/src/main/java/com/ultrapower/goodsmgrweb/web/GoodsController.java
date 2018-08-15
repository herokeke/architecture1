package com.ultrapower.goodsmgrweb.web;

import com.github.pagehelper.PageInfo;
import com.ultrapower.goodsmgr.service.IGoodsService;
import com.ultrapower.goodsmgr.vo.GoodsModel;
import com.ultrapower.goodsmgr.vo.GoodsQueryModel;
import com.ultrapower.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


/**
 * Created by User on 2018/8/10.
 */
@Controller
@RequestMapping(value="/goods")
public class GoodsController {

    @Autowired
    private IGoodsService igs = null;



    @RequestMapping(value="toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "goods/add";
    }

    @RequestMapping(value="add",method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") GoodsModel cm){
        igs.create(cm);
        return "goods/success";
    }

    @RequestMapping(value = "toUpdate/{pid}",method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("pid") int pid){
        GoodsModel cm =  igs.getByPid(pid);
        model.addAttribute("cm",cm);
        return "goods/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String post(@ModelAttribute("cm") GoodsModel cm){
        igs.update(cm);
        return "goods/success";
    }

    @RequestMapping(value = "toDelete/{pid}",method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("pid") int pid){
        GoodsModel cm =  igs.getByPid(pid);
        model.addAttribute("cm",cm);
        return "goods/delete";
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String post(@RequestParam("pid") int pid){
        igs.delete(pid);
        return "goods/success";
    }


    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String toList(@ModelAttribute("wm") GoodsWebModel wm, Model model){
        GoodsQueryModel cqm = null;
        if(StringUtils.isEmpty(igs) || wm.getQueryJsonStr().trim().length()==0){
            cqm = new GoodsQueryModel();
        }else{
            cqm = (GoodsQueryModel) JsonHelper.str2object(wm.getQueryJsonStr(),GoodsQueryModel.class);
        }
        cqm.getPageHelper().startPage(wm.getPageNum(),5);
        PageInfo<GoodsModel> cpageInfo  = igs.getByConditionPage(cqm);
        model.addAttribute("page",cpageInfo);
        return "goods/list";
    }

    /*
    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String toList(@RequestParam(value = "queryJsonStr",defaultValue = "")String queryJson,@ModelAttribute("page") PageInfo pageInfo, Model model){
        goodsQueryModel cqm = null;
        if(StringUtils.isEmpty(cqm) || queryJson.trim().length()==0){
            cqm = new goodsQueryModel();
        }else{
            cqm = (goodsQueryModel)JsonHelper.str2object(queryJson,goodsQueryModel.class);
        }
        cqm.getPageHelper().startPage(pageInfo.getPageNum(),5);
        PageInfo<goodsModel> cpageInfo  = ics.getByConditionPage(cqm);
        model.addAttribute("page",cpageInfo);
        return "goods/list";
    }
    */



}
