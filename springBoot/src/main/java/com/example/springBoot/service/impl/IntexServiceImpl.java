package com.example.springBoot.service.impl;

import com.example.springBoot.dao.IndexMapper;
import com.example.springBoot.model.NocvData;
import com.example.springBoot.service.indexService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IntexServiceImpl implements indexService {

    @Resource
    private IndexMapper indexMapper;

    @Override
    public List<NocvData> queryAll() {
        return indexMapper.queryNocvData();
    }
}
