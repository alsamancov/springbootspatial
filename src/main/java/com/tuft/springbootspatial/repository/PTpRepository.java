package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.PTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PTpRepository extends JpaRepository<PTp, Long> {
    PTp findByFlag(int flag);
}
