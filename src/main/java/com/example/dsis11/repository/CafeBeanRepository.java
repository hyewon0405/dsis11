package com.example.dsis11.repository;

import com.example.dsis11.domain.CafeBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeBeanRepository extends JpaRepository<CafeBean,Long> {
}
