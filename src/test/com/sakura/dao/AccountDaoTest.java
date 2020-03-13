package com.sakura.dao;

import com.sakura.BaseTest;
import com.sakura.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDaoTest extends BaseTest {
    @Autowired
    private AccountDao dao;

    @Test
    public void testinsert(){
        Account account = new Account();
        account.setName("zhan3");
        account.setMoney(1000.0);
        int effecedNum = dao.insertAccount(account);
        System.out.println(effecedNum);
        System.out.println(account.getId());

    }

    @Test
    public void testquery(){
        Account account = dao.queryAccount(3);
        System.out.println(account.toString());
    }
}
