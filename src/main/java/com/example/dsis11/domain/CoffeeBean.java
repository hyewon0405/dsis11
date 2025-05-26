package com.example.dsis11.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class CoffeeBean{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;

    public CoffeeBean() {

    }
    public CoffeeBean(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}
