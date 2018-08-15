package com.ultrapower.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.ultrapower.common.dao.BaseDAO;

import com.ultrapower.ordermgr.vo.OrderModel;
import com.ultrapower.ordermgr.vo.OrderQueryModel;

@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel>{
	
}
