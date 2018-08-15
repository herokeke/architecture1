package com.ultrapower.storemgr.vo;

import com.ultrapower.common.vo.BaseModel;

public class StoreModel extends BaseModel{
	private Integer goodsPid;
	private Integer storeNum;
	
	public void setGoodsPid(Integer obj){
		this.goodsPid = obj;
	}
	public Integer getGoodsPid(){
		return this.goodsPid;
	}
	
	public void setStoreNum(Integer obj){
		this.storeNum = obj;
	}
	public Integer getStoreNum(){
		return this.storeNum;
	}
	
	
	
	public String toString(){
		return "Model"+this.getClass().getName()+"[goodsPid=" + this.getGoodsPid() + ",storeNum=" + this.getStoreNum() + ",]";
	}	
}
