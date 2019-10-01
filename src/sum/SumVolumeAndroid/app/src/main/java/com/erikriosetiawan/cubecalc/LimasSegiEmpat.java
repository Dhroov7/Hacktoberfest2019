package com.erikriosetiawan.cubecalc;

public class LimasSegiEmpat {

    private double luasSisiSatu, luasSisiDua, luasSisiTiga, luasSisiEmpat, luasAlas, height;

    public double getLuasSisiSatu() {
        return luasSisiSatu;
    }

    public void setLuasSisiSatu(double luasSisiSatu) {
        this.luasSisiSatu = luasSisiSatu;
    }

    public double getLuasSisiDua() {
        return luasSisiDua;
    }

    public void setLuasSisiDua(double luasSisiDua) {
        this.luasSisiDua = luasSisiDua;
    }

    public double getLuasSisiTiga() {
        return luasSisiTiga;
    }

    public void setLuasSisiTiga(double luasSisiTiga) {
        this.luasSisiTiga = luasSisiTiga;
    }

    public double getLuasSisiEmpat() {
        return luasSisiEmpat;
    }

    public void setLuasSisiEmpat(double luasSisiEmpat) {
        this.luasSisiEmpat = luasSisiEmpat;
    }

    public double getLuasAlas() {
        return luasAlas;
    }

    public void setLuasAlas(double luasAlas) {
        this.luasAlas = luasAlas;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double luas(double luasSisiSatu, double luasSisiDua, double luasSisiTiga, double luasSisiEmpat, double luasAlas) {
        return luasSisiSatu + luasSisiDua + luasSisiTiga + luasSisiEmpat + luasAlas;
    }

    public double volume(double luasAlas, double height) {
        return 1.0 / 3.0 * luasAlas * height;
    }
}
