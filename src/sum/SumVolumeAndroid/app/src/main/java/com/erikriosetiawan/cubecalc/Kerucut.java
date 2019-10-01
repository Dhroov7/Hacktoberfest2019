package com.erikriosetiawan.cubecalc;

public class Kerucut {

    private double jariJari, sisi, height;

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double luas(double jariJari, double sisi) {
        return Math.PI * jariJari * sisi + Math.PI * Math.pow(jariJari, 2);
    }

    public double volume(double jariJari, double height) {
        return 1.0 / 3.0 * Math.PI * Math.pow(jariJari, 2) * height;
    }
}
