package com.ultrapower.customermgr.dao;

import com.ultrapower.common.dao.BaseDAO;
import com.ultrapower.customermgr.vo.CustomerQueryModel;
import com.ultrapower.customermgr.vo.CustomerModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2018/8/3.
 */

@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel> {

}
