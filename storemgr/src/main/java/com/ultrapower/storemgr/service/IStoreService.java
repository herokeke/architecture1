package com.ultrapower.storemgr.service;


import com.ultrapower.common.service.IBaseService;

import com.ultrapower.storemgr.vo.StoreModel;
import com.ultrapower.storemgr.vo.StoreQueryModel;

public interface IStoreService extends IBaseService<StoreModel,StoreQueryModel>{
	public StoreModel getByGoodsPid(int goodsPid);
}

