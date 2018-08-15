package com.ultrapower.cartmgr.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ultrapower.common.service.BaseService;

import com.ultrapower.cartmgr.dao.CartDAO;
import com.ultrapower.cartmgr.vo.CartModel;
import com.ultrapower.cartmgr.vo.CartQueryModel;

@Service
@Transactional
public class CartService extends BaseService<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	public void setDao(CartDAO dao) {
		this.dao = dao;
		super.setDao(dao);
	}
	
}