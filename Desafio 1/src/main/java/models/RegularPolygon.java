package main.java.models;

import java.io.Serializable;

public abstract class RegularPolygon implements Serializable {

    private int id = 0;
    private double sizeSide;
    private double area = 0;

    public RegularPolygon(double sizeSide)
    {
        this.sizeSide = sizeSide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSizeSide() {
        return sizeSide;
    }

    public void setSizeSide(double sizeSide) {
        this.sizeSide = sizeSide;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
