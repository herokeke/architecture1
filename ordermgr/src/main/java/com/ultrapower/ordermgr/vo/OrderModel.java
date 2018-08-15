package com.ultrapower.ordermgr.vo;

import com.ultrapower.common.vo.BaseModel;

public class OrderModel extends BaseModel{
	private Integer customerPid;
	private String orderTime;
	private Float totalMoney;
	private Float saveMoney ;
	private Integer state;
	
	public void setCustomerPid(Integer obj){
		this.customerPid = obj;
	}
	public Integer getCustomerPid(){
		return this.customerPid;
	}
	
	public void setOrderTime(String obj){
		this.orderTime = obj;
	}
	public String getOrderTime(){
		return this.orderTime;
	}
	
	public void setTotalMoney(Float obj){
		this.totalMoney = obj;
	}
	public Float getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setSaveMoney (Float obj){
		this.saveMoney  = obj;
	}
	public Float getSaveMoney (){
		return this.saveMoney ;
	}
	
	public void setState(Integer obj){
		this.state = obj;
	}
	public Integer getState(){
		return this.state;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[customerPid=" + this.getCustomerPid() + ",orderTime=" + this.getOrderTime() + ",totalMoney=" + this.getTotalMoney() + ",saveMoney =" + this.getSaveMoney () + ",state=" + this.getState() + ",]";
	}	
}
