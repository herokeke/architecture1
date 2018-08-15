package com.ultrapower.ordermgr.service;


import com.ultrapower.common.service.IBaseService;

import com.ultrapower.ordermgr.vo.OrderModel;
import com.ultrapower.ordermgr.vo.OrderQueryModel;

public interface IOrderService extends IBaseService<OrderModel,OrderQueryModel>{
	public void order(int customerPid);
}

