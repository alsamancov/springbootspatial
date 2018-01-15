package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.PLep10kvName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PLep10kvNameRepository extends JpaRepository<PLep10kvName, Long> {
    PLep10kvName findByFlag(int flag);
}
