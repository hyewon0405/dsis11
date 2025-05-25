package com.example.dsis11.repository;

import com.example.dsis11.domain.CoffeeBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeBeanRepository extends JpaRepository<CoffeeBean,Long> {
}
