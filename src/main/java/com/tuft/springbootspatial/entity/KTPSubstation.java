package com.tuft.springbootspatial.entity;

public class KTPSubstation extends CodeEntity {
    @Override
    public Integer getCode(String[] args) {
        return Integer.parseInt(args[0]);
    }

    @Override
    public String getText(String[] args) {
        return "КТП-" +  args[1];
    }

    @Override
    public String getBackPnt(String[] args) {
        return args[2];
    }
}
