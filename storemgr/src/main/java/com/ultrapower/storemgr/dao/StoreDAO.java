package com.ultrapower.storemgr.dao;

import org.springframework.stereotype.Repository;
import com.ultrapower.common.dao.BaseDAO;

import com.ultrapower.storemgr.vo.StoreModel;
import com.ultrapower.storemgr.vo.StoreQueryModel;

@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel>{
	public StoreModel getByGoodsPid(int goodsPid);
}
