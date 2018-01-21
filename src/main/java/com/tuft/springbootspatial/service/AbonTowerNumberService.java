package com.tuft.springbootspatial.service;

import com.tuft.springbootspatial.entity.AbonLep10kvNomeraOpor;
import com.tuft.springbootspatial.entity.TextDataKeeper;
import com.tuft.springbootspatial.repository.AbonLep10kvNomeraOporRepository;
import com.vividsolutions.jts.geom.Point;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbonTowerNumberService extends EntityService{

    @Autowired
    CoordinateTransformService coordinateTransformService;

    @Autowired
    AbonLep10kvNomeraOporRepository abonLep10kvNomeraOporRepository;

    @Override
    public void save(TextDataKeeper keeper) throws FactoryException, TransformException {
        Point point = coordinateTransformService.getPoint(keeper.getLatitude(), keeper.getLongitude());
        AbonLep10kvNomeraOpor nomeraOpor = new AbonLep10kvNomeraOpor(keeper.getText(), keeper.getSilrada(), keeper.getRajon(), point, 3);
        abonLep10kvNomeraOporRepository.save(nomeraOpor);
    }

    @Override
    public void move() {

    }
}
