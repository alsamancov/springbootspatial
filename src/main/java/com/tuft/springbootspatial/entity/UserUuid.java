package com.tuft.springbootspatial.entity;

import java.util.UUID;

public class UserUuid {
    private UUID uuid;
    private int point;
    private int line;
    private int substation;
    private int tower;

    public UserUuid() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getSubstation() {
        return substation;
    }

    public void setSubstation(int substation) {
        this.substation = substation;
    }

    public int getTower() {
        return tower;
    }

    public void setTower(int tower) {
        this.tower = tower;
    }
}
