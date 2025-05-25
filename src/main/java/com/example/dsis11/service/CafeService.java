package com.example.dsis11.service;

import com.example.dsis11.domain.CafeBean;
import com.example.dsis11.repository.CafeBeanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class CafeService {
    private final CafeBeanRepository cafeBeanRepository;
    public CafeService(CafeBeanRepository cafeBeanRepository) {
        this.cafeBeanRepository = cafeBeanRepository;
    }

    public void saveTenCafeBeansEfficient(){
        List<CafeBean> cafeBeans = new ArrayList<>();

        for(int i=0;i<10;i++){
            String coffeeName = "커피 이름" + i;
            int quantity = 100;
            CafeBean cafeBean = new CafeBean(coffeeName, quantity);
            cafeBeans.add(cafeBean);
        }
        cafeBeanRepository.saveAll(cafeBeans);
    }
}
