package com.sakura.dao;

import com.sakura.entity.Account;


public interface AccountDao {
    int insertAccount(Account account);
    Account queryAccount(int id);
}
