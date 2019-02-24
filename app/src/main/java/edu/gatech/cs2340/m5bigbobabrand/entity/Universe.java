package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.util.HashMap;
import java.util.Map;

public class Universe {
    private Map<Coordinates, SolarSystem> gameUniverse;
    public Universe() {
        this.gameUniverse = new HashMap<Coordinates, SolarSystem>();
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
    public int size() {
        return this.gameUniverse.size();
    }

}
