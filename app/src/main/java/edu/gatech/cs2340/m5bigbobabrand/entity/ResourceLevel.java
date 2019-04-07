package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * enum class for Resource Level data
 */
public enum ResourceLevel implements Serializable {

    NOSPECIALRESOURCES(0), MINERALRICH(1), MINERALPOOR(2), DESERT(3),
    LOTSOFWATER(4), RICHSOIL(5), POORSOIL(6), RICHFAUNA(7), LIFELESS(8), WEIRDMUSHROOMS(9),
    LOTSOFHERBS(10), ARTISTIC(11), WARLIKE(12), NEVER(13);

    private final int resourceInt;

    ResourceLevel(int resourceInt) {
        this.resourceInt = resourceInt;
    }

    /**
     * getter method for resource int
     * @return Resource Level's int
     */
    public int getResourceInt() {
        return this.resourceInt;
    }
}
