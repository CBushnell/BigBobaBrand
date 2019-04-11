package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

/**
 * Essentially a wrapper class for market and solar system.
 */
public class Universe implements Serializable {
    private final Map<Coordinates, SolarSystem> gameUniverse;

    /**
     * constructor for universe.
     */
    public Universe() {
        this.gameUniverse = new HashMap<>();
    }

    /**
     *
     * @param solarSystem the solar system to add
     * @return whether or not the solar system was added
     */
    public boolean addSolarSystem(SolarSystem solarSystem) {
        Coordinates currCoordinates = solarSystem.getCoordinates();
        if (gameUniverse.containsKey(currCoordinates)) {
            return false;
        }
        gameUniverse.put(currCoordinates, solarSystem);
        return true;
    }

    /**
     *
     * @return the current universe's solar systems
     */
    public Map<Coordinates, SolarSystem> getUniverse() {
        return this.gameUniverse;
    }

    /**
     *
     * @return size of universe.
     */
    public int size() {
        return this.gameUniverse.size();
    }

}