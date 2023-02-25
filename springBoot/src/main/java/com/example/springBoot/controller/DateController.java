package com.example.springBoot.controller;

import com.example.springBoot.dao.UserDao;
import com.example.springBoot.model.DataUser;
import com.example.springBoot.utils.QAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DateController {

    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/testDate")
    public DataUser getDate(@RequestBody DataUser dateDto){
        userDao.insertDataUser(dateDto);
//        System.out.println(dateDto);
//        return  userDao.getByUsernameDataUser(dateDto.getUsername());
        return dateDto;
    }

    @PostMapping("/ask")
    protected String askForPython(@RequestBody Map<String, String> map){
        String question = map.get("question");
        return (String) QAUtil.answer(question);
    }
}
