package com.ultrapower.cartmgr.vo;

import com.ultrapower.common.vo.BaseModel;

public class CartModel extends BaseModel{
	private Integer customerPid;
	private Integer goodsPid;
	private Integer buyNum;

	public Integer getCustomerPid() {
		return customerPid;
	}

	public void setCustomerPid(Integer customerPid) {
		this.customerPid = customerPid;
	}

	public Integer getGoodsPid() {
		return goodsPid;
	}

	public void setGoodsPid(Integer goodsPid) {
		this.goodsPid = goodsPid;
	}

	public void setBuyNum(Integer obj){
		this.buyNum = obj;
	}
	public Integer getBuyNum(){
		return this.buyNum;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[customerPid=" + this.getCustomerPid() + ",goodsPid=" + this.getGoodsPid() + ",buyNum=" + this.getBuyNum() + ",]";
	}	
}
