package com.erikriosetiawan.cubecalc;

public class Balok {

    private double length, width, height;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double luas(double length, double width, double height) {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double volume(double length, double width, double height) {
        return length * width * height;
    }
}
