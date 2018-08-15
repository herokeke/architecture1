package com.ultrapower.goodsmgr.dao;




import com.ultrapower.common.dao.BaseDAO;

import com.ultrapower.goodsmgr.vo.GoodsModel;
import com.ultrapower.goodsmgr.vo.GoodsQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2018/8/3.
 */

@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel> {

}
