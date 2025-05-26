package com.example.dsis11.service;

import com.example.dsis11.domain.CoffeeBean;
import com.example.dsis11.dto.CoffeeBeanDto;
import com.example.dsis11.repository.CoffeeBeanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class CoffeeBeanService {
    private final CoffeeBeanRepository coffeeBeanRepository;

    public CoffeeBeanService(CoffeeBeanRepository coffeeBeanRepository) {
        this.coffeeBeanRepository = coffeeBeanRepository;
    }

    public void saveTenCafeBeansEfficient(){
        List<CoffeeBean> coffeeBeans = new ArrayList<>();

        for(int i = 0 ; i < 10 ; i++){
            String coffeeName = "커피 이름" + i;
            int quantity = 100;
            CoffeeBean coffeeBean = new CoffeeBean(coffeeName, quantity);
            coffeeBeans.add(coffeeBean);
        }
        coffeeBeanRepository.saveAll(coffeeBeans);
    }

    public List<CoffeeBeanDto> getAllCoffeeBeansDto(){
       List<CoffeeBean> coffeeBeans = coffeeBeanRepository.findAll();

        return coffeeBeans.stream()
                    .map(coffeeBean -> new CoffeeBeanDto(coffeeBean.getId(), coffeeBean.getName(), coffeeBean.getQuantity()))
                    .collect(Collectors.toList());
        }


    public void deleteCoffeeBeansEfficient(Long id){
        coffeeBeanRepository.deleteById(id);
    }
}