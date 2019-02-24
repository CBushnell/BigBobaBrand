package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.util.HashMap;

public class Universe {
    private HashMap<Coordinates, SolarSystem> gameUniverse;

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
    public HashMap<Coordinates, SolarSystem> getSolarSystem() {
        return this.gameUniverse;
    }

}
