package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.AbonLep10kv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonLep10kvRepository extends JpaRepository<AbonLep10kv, Long> {
    AbonLep10kv findByFlag(int flag);
}
