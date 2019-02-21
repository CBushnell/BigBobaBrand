package edu.gatech.cs2340.m5bigbobabrand.entity;

public class Ship {
    private ShipType t;
    public Ship(ShipType t) {
        this.t = t;
    }
    public Ship() {
        this(ShipType.GNAT);
    }

    public String toString() {
        return t.toString();
    }
}
