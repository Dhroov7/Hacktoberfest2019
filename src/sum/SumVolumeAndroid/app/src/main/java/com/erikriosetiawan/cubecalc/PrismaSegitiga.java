package com.erikriosetiawan.cubecalc;

public class PrismaSegitiga {

    private double kelilingSegitiga, height, luasSegitiga, luasAlas;

    public double getKelilingSegitiga() {
        return kelilingSegitiga;
    }

    public void setKelilingSegitiga(double kelilingSegitiga) {
        this.kelilingSegitiga = kelilingSegitiga;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLuasSegitiga() {
        return luasSegitiga;
    }

    public void setLuasSegitiga(double luasSegitiga) {
        this.luasSegitiga = luasSegitiga;
    }

    public double getLuasAlas() {
        return luasAlas;
    }

    public void setLuasAlas(double luasAlas) {
        this.luasAlas = luasAlas;
    }

    public double luas(double kelilingSegitiga, double height, double luasSegitiga) {
        return kelilingSegitiga * height + 2 * luasSegitiga;
    }

    public double volume(double luasAlas, double height) {
        return luasAlas * height;
    }
}
