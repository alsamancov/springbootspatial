package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.PTpName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PTpNameRepository extends JpaRepository<PTpName, Long> {
    PTpName findByFlag(int flag);
}
