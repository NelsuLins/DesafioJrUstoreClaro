package main.java.models;

public class Triangle extends RegularPolygon {

    public Triangle(double sizeSide) {
        super(sizeSide);
    }

    @Override
    public void setArea(double sizeSide) {

        double aux = (Math.pow(2, sizeSide) * Math.sqrt(3))/4;

        super.setArea(aux);
    }

    @Override
    public String toString() {
        return "Triângulo de lado " + getSizeSide() +" cm e área " + getArea() + " cm²";
    }
}
