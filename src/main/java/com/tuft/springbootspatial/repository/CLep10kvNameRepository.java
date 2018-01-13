package com.tuft.springbootspatial.repository;

import com.tuft.springbootspatial.entity.CLep10kvName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CLep10kvNameRepository extends JpaRepository<CLep10kvName, Long> {
}
