package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.CLep10kv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLep10kvRepository extends JpaRepository<CLep10kv, Long> {
    CLep10kv findByFlag(int flag);
}
