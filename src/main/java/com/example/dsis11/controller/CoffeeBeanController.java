package com.example.dsis11.controller;

import com.example.dsis11.domain.CoffeeBean;
import com.example.dsis11.dto.CoffeeBeanDto;
import com.example.dsis11.repository.CoffeeBeanRepository;
import com.example.dsis11.service.CoffeeBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeBeanController {
    private final CoffeeBeanService coffeeBeanService;
    private final CoffeeBeanRepository coffeeBeanRepository;

    @Autowired
    public CoffeeBeanController(CoffeeBeanService coffeeBeanService, CoffeeBeanRepository coffeeBeanRepository) {
        this.coffeeBeanService = coffeeBeanService;
        this.coffeeBeanRepository = coffeeBeanRepository;
    }

    @PostMapping("/create")
    public String createCafeBean(){
        coffeeBeanService.saveTenCafeBeansEfficient();
        return "10개의 카페 데이터가 생성되었습니다.";
    }

    @GetMapping("/list")
    public ResponseEntity<List<CoffeeBeanDto>> getAllCoffeeBeansDto(){
        List<CoffeeBeanDto> coffeeBeanDto = coffeeBeanService.getAllCoffeeBeansDto();

        if(coffeeBeanDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(coffeeBeanDto, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCoffeeBeanById(@PathVariable Long id){
        if(coffeeBeanRepository.existsById(id)){
            coffeeBeanRepository.deleteById(id);
            return new ResponseEntity<>("커피 데이터가 삭제되었습니다.",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("해당 ID의 커피 데이터를 찾을 수 없습니다.",HttpStatus.NOT_FOUND);
        }
    }
}
