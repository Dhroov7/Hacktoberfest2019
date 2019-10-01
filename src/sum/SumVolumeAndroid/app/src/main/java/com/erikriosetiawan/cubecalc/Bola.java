package com.erikriosetiawan.cubecalc;

public class Bola {

    private double jariJari;

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    public double luas(double jariJari) {
        return 4 * Math.PI * Math.pow(jariJari, 2);
    }

    public double volume(double jariJari) {
        return 4.0 / 3.0 * Math.PI * Math.pow(jariJari, 3);
    }
}
