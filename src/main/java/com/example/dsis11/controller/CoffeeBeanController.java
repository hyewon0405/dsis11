package com.example.dsis11.controller;

import com.example.dsis11.domain.CoffeeBean;
import com.example.dsis11.service.CoffeeBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffee")
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

    @GetMapping("/list")
    public List<CoffeeBean> getCoffeeBeanList(){
        return coffeeBeanService.getAllCoffeeBeans();
    }
}
