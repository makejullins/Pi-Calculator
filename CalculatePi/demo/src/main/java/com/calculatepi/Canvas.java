package com.calculatepi;

/** 
 * Acts as a virtual canvas for dart-throwing method.
 * With some TLC the code can be hooked up to a GUI 
 * Inspired by Coding Train's video, he used p5.js I'm 
 * not sure I could do that but that would make app 
 * look better
 */

public class Canvas {

    public final float canvasSize;
    private float[] originCoords;
    public final float inscribedCircleRadius;

    public float getCircleRadius() {
        return canvasSize / 2.0f;
    }

    private float[] calcOriginCoords() {

        originCoords = new float[2];

        for (int i = 0; i < originCoords.length; i++){

            originCoords[i] = canvasSize / 2.0f;
        }
        return originCoords;
    }

    // Class constructor
    public Canvas(float canvasSize) {
        this.canvasSize = canvasSize;
        this.originCoords = calcOriginCoords();
        this.inscribedCircleRadius = getCircleRadius();
    }
    
    public Canvas(int canvasSize) {
        this.canvasSize = canvasSize;
        this.originCoords = calcOriginCoords();
        this.inscribedCircleRadius = getCircleRadius();
    }
}
