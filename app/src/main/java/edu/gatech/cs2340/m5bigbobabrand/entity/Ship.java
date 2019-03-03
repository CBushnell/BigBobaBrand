package edu.gatech.cs2340.m5bigbobabrand.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Ship implements Serializable {
    private ShipType t;
    private Map<Item, Integer> cargo;
    public Ship(ShipType t) {
        this.t = t;
        Item[] itemArr = Item.values();
        cargo = new HashMap<Item, Integer>();
        for (Item item : itemArr) {
            cargo.put(item, 0);
        }
    }
    public Ship() {
        this(ShipType.GNAT);
    }

    public String toString() {
        return t.toString();
    }

    public int getMaxCargo() {
        return t.getCargoCapacity();
    }

    public int getCargo() {
        int returnNum = 0;
        Integer[] totalCargoArr = cargo.values().toArray(new Integer[0]);
        for (int i : totalCargoArr) {
            returnNum = returnNum + i;
        }
        return returnNum;
    }

    public void receiveGood(Item item) {
        int currNum = cargo.get(item);
        cargo.put(item, currNum + 1);
    }

    public void loseGood(Item item) {
        int currNum = cargo.get(item);
        cargo.put(item, currNum - 1);
    }

    public boolean has(Item item) {
        if (cargo.get(item) > 0) {
            return true;
        }
        return false;
    }

    public int numberOf(Item item) {
        return cargo.get(item);
    }

}
