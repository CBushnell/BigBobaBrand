package edu.gatech.cs2340.m5bigbobabrand;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.PoliticalSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.ResourceLevel;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.TechLevel;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class M10TestAddSolarSystem {

    private Universe universe;

    @Before
    public void setUp() {
        universe = new Universe();
    }

    @Test
    public void testEmptyUniverse() {
        Coordinates coordinates = new Coordinates();
        SolarSystem solarSystem = new SolarSystem("yeet", TechLevel.HITECH,
                ResourceLevel.LOTSOFHERBS, PoliticalSystem.ANARCHY, coordinates);
        boolean result = universe.addSolarSystem(solarSystem);
        assertTrue("The solar system was not added to the universe",
                result);
        assertEquals("The solar system was not added to the universe", 1, universe.size());
    }

    @Test
    public void testAddNonEmptyUniverse() {
        Coordinates coordinates1 = new Coordinates(0,0);
        Coordinates coordinates2 = new Coordinates(100,100);
        SolarSystem solarSystem1 = new SolarSystem("yeet", TechLevel.HITECH,
                ResourceLevel.LOTSOFHERBS, PoliticalSystem.ANARCHY, coordinates1);
        SolarSystem solarSystem2 = new SolarSystem("yeet", TechLevel.HITECH,
                ResourceLevel.LOTSOFHERBS, PoliticalSystem.ANARCHY, coordinates2);
        boolean result1 = universe.addSolarSystem(solarSystem1);
        assertTrue("The first solar system was not added to the universe",
                result1);
        assertEquals("The first solar system was not added to the universe", 1, universe.size());
        boolean result2 = universe.addSolarSystem(solarSystem2);
        assertTrue("The second solar system was not added to the universe",
                result2);
        assertEquals("The second solar system was not added to the universe", 2, universe.size());
    }

    @Test
    public void testAddSameCoordinates() {
        Coordinates coordinates = new Coordinates(0,0);
        SolarSystem solarSystem1 = new SolarSystem("yeet", TechLevel.HITECH,
                ResourceLevel.LOTSOFHERBS, PoliticalSystem.ANARCHY, coordinates);
        SolarSystem solarSystem2 = new SolarSystem("yote", TechLevel.HITECH,
                ResourceLevel.LOTSOFHERBS, PoliticalSystem.ANARCHY, coordinates);
        boolean result1 = universe.addSolarSystem(solarSystem1);
        assertTrue("The first solar system was not added to the universe",
                result1);
        assertEquals("The first solar system was not added to the universe", 1, universe.size());
        boolean result2 = universe.addSolarSystem(solarSystem2);
        assertFalse("The second solar system was added to the same coordinates as the first",
                result2);
        assertEquals("The first solar system was not added to the universe", 1, universe.size());
    }

}
