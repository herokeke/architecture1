package com.ultrapower;

import com.github.pagehelper.PageInfo;
import com.ultrapower.cartmgr.service.ICartService;
import com.ultrapower.cartmgr.vo.CartModel;
import com.ultrapower.cartmgr.vo.CartQueryModel;
import com.ultrapower.goodsmgr.service.IGoodsService;
import com.ultrapower.goodsmgr.vo.GoodsModel;
import com.ultrapower.goodsmgr.vo.GoodsQueryModel;
import com.ultrapower.ordermgr.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 2018/8/14.
 */


@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IGoodsService igs = null;

   // @Autowired(required = false)
     @Autowired
    private ICartService ics = null;

    @Autowired
    private IOrderService ios = null;



    @RequestMapping(value="/toIndex",method= RequestMethod.GET)
    public String toIndex(Model model){
        GoodsQueryModel gqm = new GoodsQueryModel();

        PageInfo<GoodsModel> page = igs.getByConditionPage(gqm);

        model.addAttribute("page",page);


        return "index";
    }

    @RequestMapping(value="/toGoodsDesc/{goodsPid}",method=RequestMethod.GET)
    public String toGoodsDesc(Model model,@PathVariable("goodsPid")int goodsPid){
        GoodsModel gm = igs.getByPid(goodsPid);

        model.addAttribute("m",gm);
        return "goods/desc";
    }

    @RequestMapping(value="/addToCart/{goodsPid}",method=RequestMethod.GET)
    public String addToCart(Model model,@PathVariable("goodsPid")int goodsPid,@CookieValue("myLogin")String myLogin){
        int CustomerPid = Integer.parseInt( myLogin.split(",")[0]);

        CartModel cm = new CartModel();
        cm.setBuyNum(1);
        cm.setCustomerPid(CustomerPid);
        cm.setGoodsPid(goodsPid);

        ics.create(cm);
        ///////////////////////////
        CartQueryModel cqm = new CartQueryModel();
        //cqm.getPage().setPageShow(1000);
        cqm.setCustomerPid(CustomerPid);


        PageInfo<CartModel>  page = ics.getByConditionPage(cqm);

        model.addAttribute("page",page);

        return "cart/myCart";
    }

    @RequestMapping(value="/toCart",method=RequestMethod.GET)
    public String toCart(Model model,@CookieValue("myLogin")String myLogin){

        int customerPid = Integer.parseInt( myLogin.split(",")[0]);

        CartQueryModel cqm = new CartQueryModel();

       // cqm.setcustomerPid(customerPid);

        PageInfo<CartModel>  page = ics.getByConditionPage(cqm);

        model.addAttribute("page",page);

        return "cart/myCart";
    }

    @RequestMapping(value="/order",method=RequestMethod.GET)
    public String order(){//@CookieValue("MyLogin")String myLogin){
        //1:查出这个人购物车所有的信息
        int customerPid = 1;//Integer.parseInt( myLogin.split(",")[0]);

        ios.order(customerPid);

        return "success";
    }
}
