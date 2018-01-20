package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.TextDataKeeper;
import org.springframework.stereotype.Component;

@Component
public abstract class EntityService {
    public abstract void save(TextDataKeeper keeper);
    public abstract void move();
}
