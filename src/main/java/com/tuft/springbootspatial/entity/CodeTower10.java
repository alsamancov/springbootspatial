package com.tuft.springbootspatial.entity;

public class CodeTower10 extends CodeEntity {
    @Override
    public Integer getCode(String[] args) {
        return 41;
    }

    @Override
    public String getText(String[] args) {
        return args[1];
    }

    @Override
    public String getBackPnt(String[] args) {
        return args[2];
    }
}
