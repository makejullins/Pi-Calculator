package com.calculatepi;

import java.util.Random;

/*
 *  File for storing actual equations and formulas for pi computation
 *  Not the actual execution, thats for Canvas.java
 */

public class piMath {

    int squareCount = 0;
    int circleCount = 0;

    public double[] randomCoords(double canvasX, double canvasY, Random rand) {
        // Random class in params so it doesn't need to
        // reinstantiate every call
        // Is there a shortcut to assign values at array instantiation?
        double[] randomCoords = new double[2];

        randomCoords[0] = canvasX * rand.nextDouble();
        randomCoords[1] = canvasY * rand.nextDouble();

        return randomCoords;
    }

    public double[] randomCoords(Canvas canvas, Random rand) {
        double[] randomCoords = new double[2];

        randomCoords[0] = canvas.canvasSize * rand.nextDouble();
        randomCoords[1] = canvas.canvasSize * rand.nextDouble();

        return randomCoords;
    }

    // calculateHypotenuse method + some useful overloads

    public double calculateHypotenuse(double xLength, double yLength) {

        return Math.sqrt(xLength * xLength + yLength * yLength);
    }

    public double calculateHypotenuse(double[] coords) {
        try {
            return Math.sqrt(coords[0] * coords[0] + coords[1] * coords[1]);
        } catch (ArrayIndexOutOfBoundsException x) {
            System.err.println("Array out of bounds \nThis should never happen");
        }

        return -1;
    }

    public double calculateOffCenterHypotenuse(double xLength, double yLength, double origin) {
        // Canvas is square, so origin is the same for both x and y
        double adjustedX = xLength - origin;
        double adjustedY = yLength - origin;

        return Math.sqrt(adjustedX * adjustedX + adjustedY * adjustedY);
    }

    public double calculateOffCenterHypotenuse(double[] coords, double origin) {

        // Canvas is square, so origin is the same for both x and y

        try {
            double adjustedX = coords[0] - origin;
            double adjustedY = coords[1] - origin;

            return Math.sqrt(adjustedX * adjustedX + adjustedY * adjustedY);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array out of bounds \nThis should never happen");
        }

        return -1;
    }

    public double calculateOffCenterHypotenuse(double[] coords, Canvas canvas) {

        // Canvas is square, so origin is the same for both x and y

        double origin = canvas.canvasSize / 2.0f;

        try {
            double adjustedX = coords[0] - origin;
            double adjustedY = coords[1] - origin;

            return Math.sqrt(adjustedX * adjustedX + adjustedY * adjustedY);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array out of bounds \nThis should never happen");
        }

        return -1;
    }

    // compareHypotenuse + useful overloads

    public boolean compareHypotenuse(double hypotenuse, double circleRadius ){
        // If hypotenuse is less than or equal to inscribedCircleRadius
        // Returns true, else returns false
        return hypotenuse <= circleRadius;  
    }

    boolean compareHypotenuse(double hypotenuse, Canvas canvas) {
        // If hypotenuse is less than or equal to inscribedCircleRadius
        // Returns true, else returns false
        return hypotenuse <= canvas.inscribedCircleRadius;
    }

    void throwDart (double[] coords, Canvas canvas) {
        double hypotenuse = calculateOffCenterHypotenuse(coords, canvas);

        // Technically redundant but adds clarity
        if(compareHypotenuse(hypotenuse, canvas)) {
            squareCount++;
            circleCount++;
        } else {
            squareCount++;
        }
    }

    public double calculatePi(int darts, Canvas c, Random r){
        
        for(int i = 0; i < darts; i++) {

            double[] dartCoords = randomCoords(c, r);
            throwDart(dartCoords, c);        
        }

        return 4 * (float) circleCount / squareCount;
    }

    public double testAccuracyPi(double expirementalValue) {
        return (expirementalValue - Math.PI) / Math.PI * 100;
    }
}