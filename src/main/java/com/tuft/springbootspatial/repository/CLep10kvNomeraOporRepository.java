package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.CLep10kvNomeraOpor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLep10kvNomeraOporRepository extends JpaRepository<CLep10kvNomeraOpor, Long> {
}
