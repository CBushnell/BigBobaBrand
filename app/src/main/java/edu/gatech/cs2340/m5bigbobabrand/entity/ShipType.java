package edu.gatech.cs2340.m5bigbobabrand.entity;

public enum ShipType {
    GNAT("Gnat"), FLEA("Flea"), FIREFlY("Firefly"),
    MOSQUITO("Mosquito"), BUMBLEBEE("Bumblebee"), BEETLE("Beetle"), HORNET("Hornet"),
    GRASSHOPPER("Grasshopper"), TERMIE("Termie"), WASP("Wasp");

    private String rep;

    ShipType(String rep) {
        this.rep = rep;
    }

    public String toString() {
        return rep;
    }

}
