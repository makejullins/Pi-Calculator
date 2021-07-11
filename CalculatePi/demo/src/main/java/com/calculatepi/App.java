package com.calculatepi;

import java.util.Random;

public final class App {

    public static void main(String[] args) {
        // Local Dependency
        piMath piMath = new piMath();

        // Other Dependencies
        Random r = new Random();

        // Canvas instantiation
        Canvas c = new Canvas(3);

        double expirementalPi = piMath.calculatePi(10000000, c, r);

        System.out.println("Expiremental:      " + expirementalPi +
                         "\nError Percentage:  " + Math.abs(piMath.testAccuracyPi(expirementalPi)));
    }
}