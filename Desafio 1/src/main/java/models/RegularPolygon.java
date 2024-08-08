package main.java.models;

public abstract class RegularPolygon {

    private double sizeSide = 0;
    private double area = 0;

    public RegularPolygon(double sizeSide)
    {
        this.sizeSide = sizeSide;
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
