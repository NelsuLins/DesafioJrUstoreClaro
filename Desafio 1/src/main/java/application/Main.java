package main.java.application;

import main.java.controllers.RegularPolygonController;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----Calculador de areas-----");
        RegularPolygonController.getInstance().initialMenu();
    }
}
