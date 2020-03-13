package com.sakura.web;

import com.sakura.entity.Account;
import com.sakura.service.accountservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private accountservice service;
    @ResponseBody
    @RequestMapping(value = "/showaccount",method = RequestMethod.GET)
    public Map<String,Object> show(){
        HashMap<String,Object> modelMap = new HashMap<>();
        Account account = service.getAccount(3);
        if (account!=null){
            modelMap.put("success",true);
            modelMap.put("account",account);
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","error message");
        }
        return modelMap;
    }
}
