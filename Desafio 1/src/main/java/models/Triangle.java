package main.java.models;

public class Triangle extends RegularPolygon {

    public Triangle(double sizeSide) {
        super(sizeSide);
    }

    @Override
    public void setArea(double sizeSide) {

        double aux = (Math.pow(sizeSide, 2) * Math.sqrt(3))/4;

        super.setArea(aux);
    }

    @Override
    public String toString()
    {
        return "Triângulo de lado " + getSizeSide() +" cm e área " + String.format("%.2f",getArea()) + " cm²";
    }
}
