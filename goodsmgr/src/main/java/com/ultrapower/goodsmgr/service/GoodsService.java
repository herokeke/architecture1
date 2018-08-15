package com.ultrapower.goodsmgr.service;



import com.ultrapower.common.service.BaseService;
import com.ultrapower.goodsmgr.dao.GoodsDAO;
import com.ultrapower.goodsmgr.vo.GoodsModel;
import com.ultrapower.goodsmgr.vo.GoodsQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 2018/8/8.
 */
@Service
@Transactional
public class GoodsService extends BaseService<GoodsModel,GoodsQueryModel> implements IGoodsService {

    private GoodsDAO dao = null;

    @Autowired
    public void setDao(GoodsDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }
}
