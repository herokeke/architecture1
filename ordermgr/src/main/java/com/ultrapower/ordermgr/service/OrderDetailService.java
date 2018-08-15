package com.ultrapower.ordermgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultrapower.common.service.BaseService;

import com.ultrapower.ordermgr.dao.OrderDetailDAO;
import com.ultrapower.ordermgr.vo.OrderDetailModel;
import com.ultrapower.ordermgr.vo.OrderDetailQueryModel;

@Service
@Transactional
public class OrderDetailService extends BaseService<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDao(dao);
	}
	
}