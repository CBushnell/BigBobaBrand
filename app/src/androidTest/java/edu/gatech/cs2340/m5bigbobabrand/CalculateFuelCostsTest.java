package edu.gatech.cs2340.m5bigbobabrand;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.gatech.cs2340.m5bigbobabrand.Model.TravelInteractor;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class CalculateFuelCostsTest {
    public static final int TIMEOUT = 200;
    private SolarSystem initialSystem;
    private SolarSystem finalSystem;
    private TravelInteractor travel;
    private Coordinates coordInit;
    private Coordinates coordFinal;

    @Before
    public void setUp() {
        travel = new TravelInteractor(initialSystem, finalSystem);
        coordInit = new Coordinates(0 ,0);
        coordFinal = new Coordinates(0 ,0);
        initialSystem = new SolarSystem(coordInit);
        finalSystem = new SolarSystem(coordFinal);
    }

    @Test(timeout = TIMEOUT)
    public void testSameCoordinates() {
        coordInit.setX(10);
        coordInit.setY(10);
        coordFinal.setX(10);
        coordFinal.setY(10);
        initialSystem.setCoordinates(coordInit);
        finalSystem.setCoordinates(coordFinal);
        int same = travel.calculateFuelCosts();
        assertEquals("fuel cost is wrong when coordinates are the same", 0, same);
    }

    @Test(timeout = TIMEOUT)
    public void testGenericCoordinates() {
        coordInit.setX(283);
        coordInit.setY(70);
        coordFinal.setX(88);
        coordFinal.setY(9);
        initialSystem.setCoordinates(coordInit);
        finalSystem.setCoordinates(coordFinal);
        int actualCost = travel.calculateFuelCosts();
        int x = Math.abs(283 - 88);
        int y = Math.abs(70 - 9);
        int distance = (int) Math.hypot(x, y);
        int expectedCost = distance / 10;
        assertEquals("fuel cost is wrong with generic coordinates", expectedCost, actualCost);
    }
}
