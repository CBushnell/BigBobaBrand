package edu.gatech.cs2340.m5bigbobabrand.Model;

import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

/**
 * Traveling between solar systems (an initial and final location)
 */
public class TravelInteractor {
    private final SolarSystem initialSystem;
    private final SolarSystem finalSystem;

    /**
     * Constructor for TravelInteractor
     * @param initialSystem the solar system that the player is initially at
     * @param finalSystem the solar system that the player want to travel to
     */
    public TravelInteractor(SolarSystem initialSystem, SolarSystem finalSystem) {
        this.initialSystem = initialSystem;
        this.finalSystem = finalSystem;
    }

    /**
     * Calculates fuel costs needed to travel from one coordinates to another
     * @return fuel costs
     */
    public int calculateFuelCosts() {
        Coordinates a = initialSystem.getCoordinates();
        Coordinates b = finalSystem.getCoordinates();
        if (a.equals(b)) {
            return 0;
        }
        final double ROUNDOFF = .5;
        int distance = (int) (Math.sqrt(Math.pow(a.getX() - b.getX(), 2)
                + Math.pow(a.getY() - b.getY(), 2)) + ROUNDOFF);
        int fuelCost = (distance / 10); //will add fuel efficiency per ship;
        if (fuelCost == 0) {
            fuelCost += 1;
        }
        return fuelCost;
    }

}
