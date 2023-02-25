package com.example.springBoot.dao;

import com.example.springBoot.model.NocvData;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IndexMapper{

    public List<NocvData> queryNocvData();
}
