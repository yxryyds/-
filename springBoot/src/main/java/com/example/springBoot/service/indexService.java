package com.example.springBoot.service;

import com.example.springBoot.model.NocvData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface indexService {
    public List<NocvData> queryAll();
}
