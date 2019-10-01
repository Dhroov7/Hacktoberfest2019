package com.erikriosetiawan.cubecalc;

public class Kubus {

    private double rusuk;

    public double getRusuk() {
        return rusuk;
    }

    public void setRusuk(double rusuk) {
        this.rusuk = rusuk;
    }

    public double luas(double rusuk) {
        return 6 * Math.pow(rusuk, 2);
    }

    public double volume(double rusuk) {
        return Math.pow(rusuk, 3);
    }
}
