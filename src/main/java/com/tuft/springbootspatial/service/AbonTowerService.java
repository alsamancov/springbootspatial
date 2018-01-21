package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.AbonLep10kvNomeraOpor;
import com.tuft.springbootspatial.entity.AbonLep10kvOpory;
import com.tuft.springbootspatial.entity.TextDataKeeper;
import com.tuft.springbootspatial.repository.AbonLep10kvNomeraOporRepository;
import com.tuft.springbootspatial.repository.AbonLep10kvOporyRepository;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbonTowerService extends EntityService {

    @Autowired
    AbonTowerNumberService abonTowerNumberService;

    @Autowired
    AbonLep10kvOporyRepository abonLep10kvOporyRepository;

    @Autowired
    CoordinateTransformService coordinateTransformService;

    @Override
    public void save(TextDataKeeper keeper) throws FactoryException, TransformException {
        LineString lineString = coordinateTransformService.getLineString(keeper.getLatitude(), keeper.getLongitude());
        double length = lineString.getLength();
        AbonLep10kvOpory tower = new AbonLep10kvOpory(keeper.getSilrada(), keeper.getRajon(), length, lineString, keeper.getText(), 3);
        abonLep10kvOporyRepository.save(tower);
        abonTowerNumberService.save(keeper);
    }

    @Override
    public void move() {

    }
}
