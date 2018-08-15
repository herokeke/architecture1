package com.ultrapower.ordermgr.vo;

import com.ultrapower.common.vo.BaseModel;

public class OrderDetailModel extends BaseModel{
	private Integer orderPid;
	private Integer goodsPid;
	private Integer orderNum;
	private Float price;
	private Float money;
	private Float saveMoney;
	
	public void setOrderPid(Integer obj){
		this.orderPid = obj;
	}
	public Integer getOrderPid(){
		return this.orderPid;
	}
	
	public void setGoodsPid(Integer obj){
		this.goodsPid = obj;
	}
	public Integer getGoodsPid(){
		return this.goodsPid;
	}
	
	public void setOrderNum(Integer obj){
		this.orderNum = obj;
	}
	public Integer getOrderNum(){
		return this.orderNum;
	}
	
	public void setPrice(Float obj){
		this.price = obj;
	}
	public Float getPrice(){
		return this.price;
	}
	
	public void setMoney(Float obj){
		this.money = obj;
	}
	public Float getMoney(){
		return this.money;
	}
	
	public void setSaveMoney(Float obj){
		this.saveMoney = obj;
	}
	public Float getSaveMoney(){
		return this.saveMoney;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[orderPid=" + this.getOrderPid() + ",goodsPid=" + this.getGoodsPid() + ",orderNum=" + this.getOrderNum() + ",price=" + this.getPrice() + ",money=" + this.getMoney() + ",saveMoney=" + this.getSaveMoney() + ",]";
	}	
}
