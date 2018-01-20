package com.tuft.springbootspatial.service;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoordinateTransformService {

    @Autowired
    CRSConverterService crsConverterService;

    public Point getPoint(double latitude, double longitude) throws FactoryException, TransformException {
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
        Coordinate coordinate = new Coordinate(longitude, latitude);
        Point point = geometryFactory.createPoint(coordinate);
        Geometry conversionGeometry = crsConverterService.conversion(point);
        return (Point) conversionGeometry;
    }
}
