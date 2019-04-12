package edu.gatech.cs2340.m5bigbobabrand;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.m5bigbobabrand.Model.TravelInteractor;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

import static org.junit.Assert.assertEquals;

public class CalculateFuelCostsTest {
    public static final int TIMEOUT = 200;
    private SolarSystem initialSystem;
    private SolarSystem finalSystem;
    private TravelInteractor travel;
    private Coordinates coordInit;
    private Coordinates coordFinal;

    @Before
    public void setUp() {
        coordInit = new Coordinates(0 ,0);
        coordFinal = new Coordinates(0 ,0);
        initialSystem = new SolarSystem(coordInit);
        finalSystem = new SolarSystem(coordFinal);
        travel = new TravelInteractor(initialSystem, finalSystem);
    }

    @Test(timeout = TIMEOUT)
    public void testSameCoordinates() {
        coordInit.setX(10);
        coordInit.setY(10);
        coordFinal.setX(10);
        coordFinal.setY(10);
        initialSystem.setCoordinates(coordInit);
        finalSystem.setCoordinates(coordFinal);
        travel = new TravelInteractor(initialSystem, finalSystem);
        int same = travel.calculateFuelCosts();
        assertEquals("fuel cost is wrong when coordinates are the same", 0, same);
    }

    @Test(timeout = TIMEOUT)
    public void testGenericCoordinates() {
        coordInit.setX(110);
        coordInit.setY(100);
        coordFinal.setX(90);
        coordFinal.setY(13);
        initialSystem.setCoordinates(coordInit);
        finalSystem.setCoordinates(coordFinal);
        travel = new TravelInteractor(initialSystem, finalSystem);
        int actualCost = travel.calculateFuelCosts();
        int x = Math.abs(20);
        int y = Math.abs(87);
        int dis = (int) (Math.hypot(x, y) + .5);
        int expectedCost = dis / 10;
        if (expectedCost == 0) {
            expectedCost++;
        }
        assertEquals("fuel cost is wrong with generic coordinates", expectedCost, actualCost);
    }
}
