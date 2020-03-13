package com.sakura.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakura.cache.JedisUtil;
import com.sakura.dao.AccountDao;
import com.sakura.entity.Account;
import com.sakura.service.accountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class accountserviceImpl implements accountservice {

    @Autowired
    private AccountDao dao;

    @Autowired
    private JedisUtil.Keys jedisKey;

    @Autowired
    private JedisUtil.Strings jedisStrings;

    @Override
    public Account getAccount(int id) {
        //原来的方法
        return dao.queryAccount(id);
    }

    @Override
    public Account getAccount1(int id) {
        //定义Redis的前缀
        String key = "Account";
        //定义接收的对象
        Account account = null;
        //定义jackson数据转换操作类
        ObjectMapper mapper = new ObjectMapper();
        //判断key是否存在
        if (!jedisKey.exists(key)){
            System.out.println("从mysql中取出.....");
            //如果不存在,则从mysql里面取出相应的数据
            account = dao.queryAccount(id);
            //将相关的实体类集合转换成String,存入redis里面相应的key中
            String jsonString;
            try {
                jsonString = mapper.writeValueAsString(account);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
            jedisStrings.set(key,jsonString);
        }else {
            System.out.println("从Redis中取出......");
            //如果存在,则直接从redis里面取出相应的数据
            String jsonString = jedisStrings.get(key);
            try {
                account = mapper.readValue(jsonString,Account.class);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        return account;
    }

}
