package com.tuft.springbootspatial.service;

import com.vividsolutions.jts.geom.*;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoordinateTransformService {
    private static GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);

    @Autowired
    CRSConverterService crsConverterService;

    public Point getPoint(double latitude, double longitude) throws FactoryException, TransformException {
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory(null);
        Coordinate coordinate = new Coordinate(longitude, latitude);
        Point point = geometryFactory.createPoint(coordinate);
        Geometry conversionGeometry = crsConverterService.conversion(point);
        return (Point) conversionGeometry;
    }

    public LineString getLineString(double latitude, double longitude) throws FactoryException, TransformException {
        double longitude1 = longitude - 0.1259;
        double latitude1 = latitude - 0.1259;
        double longitude2 = longitude + 0.1259;
        double latitude2 = latitude + 0.1259;
        Coordinate[] points = {new Coordinate(longitude1, latitude1), new Coordinate(longitude2, latitude1), new Coordinate(longitude2, latitude2), new Coordinate(longitude1, latitude2), new Coordinate(longitude1, latitude1)};
        LineString lineString = geometryFactory.createLineString(points);
        LineString conversionLine = (LineString) crsConverterService.conversion(lineString);
        return conversionLine;
    }
}
