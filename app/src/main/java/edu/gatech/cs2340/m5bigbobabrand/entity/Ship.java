package edu.gatech.cs2340.m5bigbobabrand.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Ship class that stores info about ship.
 */
public class Ship implements Serializable {
    private final ShipType t;
    private final Map<Item, Integer> cargo;
    private boolean hasWeapon;

    /**
     * Constructor ship
     * @param t is value from enum shiptype.
     */
    public Ship(ShipType t) {
        this.t = t;
        Item[] itemArr = Item.values();
        cargo = new HashMap<>();
        for (Item item : itemArr) {
            cargo.put(item, 0);
        }
        this.hasWeapon = false;
    }

    /**
     * Default constructor.
     */
    public Ship() {
        this(ShipType.GNAT);
    }

    /**
     *
     * @return whether or not ship has weapon
     */
    public boolean hasWeapon() {
        return this.hasWeapon;
    }

    /**
     *
     * @param status whether to give or remove the weapon from the ship
     */
    public void setWeapon(Boolean status) {
        this.hasWeapon = status;
    }

    /**
     *
     * @return string representation of ship.
     */
    public String toString() {
        return t.toString();
    }

    /**
     *
     * @return the integer representation of max cargo capacity.
     */
    public int getMaxCargo() {
        return t.getCargoCapacity();
    }

    /**
     *
     * @return the cargo on ship.
     */
    public int getCargo() {
        int returnNum = 0;
        Integer[] totalCargoArr = cargo.values().toArray(new Integer[0]);
        for (int i : totalCargoArr) {
            returnNum = returnNum + i;
        }
        return returnNum;
    }

    /**
     *
     * @param item add one good on ship.
     */
    public void receiveGood(Item item) {
        int currNum = cargo.get(item);
        cargo.put(item, currNum + 1);
    }

    /**
     *
     * @param item is item dropped from ship.
     */
    public void loseGood(Item item) {
        int currNum = cargo.get(item);
        cargo.put(item, currNum - 1);
    }

    /**
     *
     * @param item checked
     * @return if ship has item or not.
     */
    public boolean has(Item item) {
        return (cargo.get(item) > 0);
    }

    /**
     *
     * @param item checked
     * @return amount of item being checked.
     */
    public int numberOf(Item item) {
        return cargo.get(item);
    }

}
