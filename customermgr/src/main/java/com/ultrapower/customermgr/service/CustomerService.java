package com.ultrapower.customermgr.service;

import com.ultrapower.common.service.BaseService;
import com.ultrapower.customermgr.dao.CustomerDAO;
import com.ultrapower.customermgr.vo.CustomerQueryModel;
import com.ultrapower.customermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by User on 2018/8/8.
 */
@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel,CustomerQueryModel> implements ICustomerService{

    private CustomerDAO dao = null;

    @Autowired
    public void setDao(CustomerDAO dao) {
        this.dao = dao;
        super.setDao(dao);
    }
}
