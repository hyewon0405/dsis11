package com.example.dsis11.controller;

import com.example.dsis11.service.CoffeeBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cafe")
public class CoffeeBeanController {
    private final CoffeeBeanService coffeeBeanService;

    @Autowired
    public CoffeeBeanController(CoffeeBeanService coffeeBeanService) {
        this.coffeeBeanService = coffeeBeanService;
    }

    @PostMapping("/create")
    public String createCafeBean(){
        coffeeBeanService.saveTenCafeBeansEfficient();
        return "10개의 카페 데이터가 생성되었습니다.";
    }
}
