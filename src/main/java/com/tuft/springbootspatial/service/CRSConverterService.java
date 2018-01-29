package com.tuft.springbootspatial.service;


import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "crs")
public class CRSConverterService {
    private List<Zone> zones = new ArrayList<>();

    public List<Zone> getZones() {
        return zones;
    }

    public String getProjection(Geometry geometry){
        Point centroid = geometry.getCentroid();
        String projection = null;
        for(Zone zone: zones){
            if(centroid.getX() > zone.min & centroid.getX() < zone.max) {
                projection = zone.projection;
            }
        }
        return projection;
    }

    public Geometry conversion(Geometry geometry) throws FactoryException, TransformException {
        String projection = getProjection(geometry);
        CoordinateReferenceSystem referenceSystem = CRS.parseWKT(projection);
        MathTransform transform = CRS.findMathTransform(referenceSystem, DefaultGeographicCRS.WGS84, false);
        Geometry newGeometry = JTS.transform(geometry, transform);
        return newGeometry;
    }

    public static class Zone{
        private String name;
        private int min;
        private int max;
        private String projection;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getProjection() {
            return projection;
        }

        public void setProjection(String projection) {
            this.projection = projection;
        }

        @Override
        public String toString() {
            return "Zone{" +
                    "name='" + name + '\'' +
                    ", min=" + min +
                    ", max=" + max +
                    ", projection='" + projection + '\'' +
                    '}';
        }
    }
}
