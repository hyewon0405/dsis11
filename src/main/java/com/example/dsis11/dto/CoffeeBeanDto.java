package com.example.dsis11.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CoffeeBeanDto {
    private Long id;
    private String name;
    private int quantity;
}
