package main.java.controllers;

import main.java.models.RegularPolygon;
import main.java.models.Square;
import main.java.models.Triangle;

import java.util.ArrayList;
import java.util.Scanner;

public class RegularPolygonController {

    private static RegularPolygonController instance;

    private final ArrayList<RegularPolygon> regularPolygons = new ArrayList<>();
    Scanner auxScan = new Scanner(System.in);

    public static RegularPolygonController getInstance() {

        if (instance == null)
        {
            instance = new RegularPolygonController();
        }
        return instance;
    }

    public void initialMenu()
    {
        int sizeValue;
        boolean validValue;

        System.out.println("Informe o valor de lados (3 - Triangulo, 4 - Quadrado):");

        do
        {
            validValue = true;

            try
            {
                sizeValue = Integer.parseInt(auxScan.nextLine());

                if (sizeValue != 3 && sizeValue != 4)
                {
                    System.out.println("Valor nao esta entre as escolhas! Informe um valor (3 - Triangulo, 4 - Quadrado):");
                    validValue = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor Invalido! Informe um valor inteiro (3 - Triangulo, 4 - Quadrado):");
                validValue = false;
                sizeValue = -1;
            }
        } while (!validValue);

        if (sizeValue == 3)
        {
            insertTriangle();
        }
        else
        {
            insertSquare();
        }
    }

    public void insertTriangle()
    {
        double auxSizeSide;
        boolean validValue;

        System.out.println("Informe o valor o tamanho do lado do Triangulo:");

        do
        {
            validValue = true;

            try
            {
                auxSizeSide = Double.parseDouble(auxScan.nextLine());

                if (auxSizeSide <= 0)
                {
                    System.out.println("O valor precisa ser maior que 0! Informe um valor:");
                    validValue = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor Invalido! Informe um numero:");
                validValue = false;
                auxSizeSide = -1;
            }
        } while (!validValue);

        Triangle auxTriangle = new Triangle(auxSizeSide);
        auxTriangle.setArea(auxSizeSide);
        regularPolygons.add(auxTriangle);

        newPolygon();
    }

    public void insertSquare()
    {
        double auxSizeSide;
        boolean validValue;

        System.out.println("Informe o valor o tamanho do lado do Quadrado:");

        do
        {
            validValue = true;

            try
            {
                auxSizeSide = Double.parseDouble(auxScan.nextLine());

                if (auxSizeSide <= 0)
                {
                    System.out.println("O valor precisa ser maior que 0! Informe um valor:");
                    validValue = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor Invalido! Informe um valor:");
                validValue = false;
                auxSizeSide = -1;
            }
        } while (!validValue);

        Square auxSquare = new Square(auxSizeSide);
        auxSquare.setArea(auxSizeSide);
        regularPolygons.add(auxSquare);

        newPolygon();
    }

    public void newPolygon()
    {
        int value;
        boolean validValue;

        System.out.println("1 - Inserir novo poligono");
        System.out.println("2 - Calcular as areas");

        do
        {
            validValue = true;

            try
            {
                value = Integer.parseInt(auxScan.nextLine());

                if (value != 1 && value != 2)
                {
                    System.out.println("Valor nao esta entre as escolhas! Informe um valor");
                    System.out.println("1 - Inserir novo poligono");
                    System.out.println("2 - Calcular as areas");

                    validValue = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Valor Invalido!");
                System.out.println("1 - Inserir novo poligono");
                System.out.println("2 - Calcular as areas");

                validValue = false;
                value = -1;
            }
        } while (!validValue);

        if (value == 1)
        {
            initialMenu();
        }
        else
        {
            totalAreas();
        }
    }

    public void totalAreas()
    {
        double auxTotalArea = 0;
        System.out.println("--------------------------------");

        for (RegularPolygon aux : regularPolygons) {
            System.out.println(aux);
            auxTotalArea += aux.getArea();
        }

        System.out.println("\nÁrea total " + String.format("%.2f",auxTotalArea) + " cm²");
        System.out.println("--------------------------------");

    }
}
