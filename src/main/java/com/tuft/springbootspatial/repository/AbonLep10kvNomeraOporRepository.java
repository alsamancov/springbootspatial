package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.AbonLep10kvNomeraOpor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonLep10kvNomeraOporRepository extends JpaRepository<AbonLep10kvNomeraOpor, Long> {
    AbonLep10kvNomeraOpor findByFlag(int flag);
}
