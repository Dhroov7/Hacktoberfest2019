package com.erikriosetiawan.cubecalc;

public class Tabung {

    private double jariJari, height;

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double luas(double jariJari, double height) {
        return 2 * Math.PI * jariJari * height + 2 * Math.PI * Math.pow(jariJari, 2);
    }

    public double volume(double jariJari, double height) {
        return Math.PI * Math.pow(jariJari, 2) * height;
    }
}