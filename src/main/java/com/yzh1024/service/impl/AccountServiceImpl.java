package com.yzh1024.service.impl;

import com.yzh1024.dao.IAccountDao;
import com.yzh1024.dao.impl.AccountDaoImpl;
import com.yzh1024.factory.BeanFactory;
import com.yzh1024.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    //    private IAccountDao accountDao = new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}

