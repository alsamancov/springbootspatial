package com.tuft.springbootspatial.entity;

public class CablePoint10 extends CodeEntity {
    @Override
    public Integer getCode(String[] args) {
        return Integer.parseInt(args[0]);
    }

    @Override
    public String getText(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0; i < args.length; i++){
            stringBuilder.append(args[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getBackPnt(String[] args) {
        return args[2];
    }
}
