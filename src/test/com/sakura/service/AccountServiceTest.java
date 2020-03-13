package com.sakura.service;

import com.sakura.BaseTest;
import com.sakura.entity.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceTest extends BaseTest {
    @Autowired
    private accountservice accountservice;
    @Test
    public void queryAccountTest(){
        Account account = accountservice.getAccount1(3);
        System.out.println(account.toString());
    }
}
