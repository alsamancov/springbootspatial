package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.TextDataKeeper;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.stereotype.Component;

@Component
public abstract class EntityService {
    public abstract void save(TextDataKeeper keeper) throws FactoryException, TransformException;
    public abstract void move();
}
