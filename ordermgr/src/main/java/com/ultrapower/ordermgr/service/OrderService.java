package com.ultrapower.ordermgr.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultrapower.common.service.BaseService;
import com.ultrapower.ordermgr.dao.OrderDAO;
import com.ultrapower.ordermgr.vo.OrderModel;
import com.ultrapower.ordermgr.vo.OrderQueryModel;

@Service
@Transactional
public class OrderService extends BaseService<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;

	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	public void order(int customerPid) {



	}
	
}