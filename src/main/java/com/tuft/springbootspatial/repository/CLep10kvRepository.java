package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.CLep10kv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CLep10kvRepository extends JpaRepository<CLep10kv, Long> {
    Collection<CLep10kv> findByFlag(int flag);
    Collection<CLep10kv> findByRajon(String rajon);
}
