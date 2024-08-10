package main.java.models;

public class Square extends RegularPolygon {

    public Square(double sizeSide) {
        super(sizeSide);
    }

    @Override
    public void setArea(double sizeSide) {

        double aux = Math.pow(sizeSide, 2);

        super.setArea(aux);
    }

    @Override
    public String toString() {
        return "Quadrado de lado " + getSizeSide() +" cm e área " + getArea() + " cm²";
    }
}
