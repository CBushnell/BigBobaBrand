package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * all possible ship types in game.
 */
public enum ShipType implements Serializable {
    GNAT("Gnat", 15),
    FLEA("Flea", 18),
    FIREFlY("Firefly", 20),
    MOSQUITO("Mosquito", 30),
    BUMBLEBEE("Bumblebee", 40),
    BEETLE("Beetle", 50),
    HORNET("Hornet", 45),
    GRASSHOPPER("Grasshopper", 50),
    TERMITE("Termite", 40),
    WASP("Wasp", 30);

    private final String rep;
    private final int cargoCapacity;

    ShipType(String rep, int cargoCapacity) {
        this.rep = rep;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {
        return this.rep;
    }

    /**
     *
     * @return capacity of cargo.
     */
    public int getCargoCapacity() {
        return this.cargoCapacity;
    }

}
