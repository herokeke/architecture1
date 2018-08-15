package com.ultrapower.ordermgr.dao;

import org.springframework.stereotype.Repository;
import com.ultrapower.common.dao.BaseDAO;

import com.ultrapower.ordermgr.vo.OrderDetailModel;
import com.ultrapower.ordermgr.vo.OrderDetailQueryModel;

@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel>{
	
}
