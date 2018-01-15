package com.tuft.springbootspatial.repository;


import com.tuft.springbootspatial.entity.AbonLep10kvName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonLep10kvNameRepository extends JpaRepository<AbonLep10kvName, Long> {
    AbonLep10kvName findByFlag(int flag);
}
