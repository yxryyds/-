package com.example.springBoot.controller;

import com.example.springBoot.model.NocvData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class indexController {

    @Resource
    private com.example.springBoot.service.indexService indexService;

    @RequestMapping("/query")
    @ResponseBody
    public List<NocvData> queryNocvData(){
        return indexService.queryAll();
    }
}
