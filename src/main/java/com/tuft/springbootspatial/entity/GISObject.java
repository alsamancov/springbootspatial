package com.tuft.springbootspatial.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class GISObject {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "SILRADA")
    private String silrada;
    @Column(name = "RAJON")
    private String rajon;

    public GISObject() {
    }

    public GISObject(String text, String silrada, String rajon) {
        this.text = text;
        this.silrada = silrada;
        this.rajon = rajon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSilrada() {
        return silrada;
    }

    public void setSilrada(String silrada) {
        this.silrada = silrada;
    }

    public String getRajon() {
        return rajon;
    }

    public void setRajon(String rajon) {
        this.rajon = rajon;
    }
}
