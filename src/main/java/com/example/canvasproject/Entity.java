package com.example.canvasproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class Entity {

    private double x;
    private double y;
    private double w;
    private double h;
    private Paint c;

    public Entity(double x, double y, double w, double h, Paint c) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
    }

    public double getW() {
        return w;
    }

    public double getH() {
        return h;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(c);
        gc.fillOval(x, y, w, h);
    }
}
