package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * @author Charlie Comeau
 * @version 1.0
 *
 * A tech level enum class for holding valid options for a planet's tech level
 */
public enum TechLevel implements Serializable {
    PREAGRICULTURE("PRE-AGRICULTURE", 0),
    AGRICULTURE("AGRICULTURE", 1),
    MEDIEVAL("MEDIEVAL", 2),
    RENAISSANCE("RENAISSANCE", 3),
    EARLYINDUSTRIAL("EARLY-INDUSTRIAL", 4),
    INDUSTRIAL("INDUSTRIAL", 5),
    POSTINDUSTRIAL("POST-INDUSTRIAL", 6),
    HITECH("HI-TECH", 7);

    private final String techLevelName;
    private final int techLevelNum;

    TechLevel(String techLevelName, int techLevelNum) {
        this.techLevelName = techLevelName;
        this.techLevelNum = techLevelNum;
    }

    /**
     * getter method for name variable
     * @return name of tech level enum
     */
    public String getTechLevelName() {
        return techLevelName;
    }

    /**
     * getter method for tech level num
     * @return num of assigned tech level
     */
    public int getTechLevelNum() {
        return techLevelNum;
    }
}
