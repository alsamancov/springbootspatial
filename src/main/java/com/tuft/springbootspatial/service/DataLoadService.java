package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.UserUuid;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Service
public abstract class DataLoadService {
    public abstract UserUuid loadData(Path path, UUID uuid) throws IOException, FactoryException, TransformException;
}
