package com.ultrapower.cartmgr.dao;

import org.springframework.stereotype.Repository;
import com.ultrapower.common.dao.BaseDAO;

import com.ultrapower.cartmgr.vo.CartModel;
import com.ultrapower.cartmgr.vo.CartQueryModel;

@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel>{
	
}
