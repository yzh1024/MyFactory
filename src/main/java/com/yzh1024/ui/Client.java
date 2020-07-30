package com.yzh1024.ui;
import com.yzh1024.dao.impl.AccountDaoImpl;
import com.yzh1024.factory.BeanFactory;
import com.yzh1024.service.IAccountService;
import com.yzh1024.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            as.saveAccount();
    }
}
