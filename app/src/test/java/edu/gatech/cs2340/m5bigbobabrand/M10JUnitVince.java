package edu.gatech.cs2340.m5bigbobabrand;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.gatech.cs2340.m5bigbobabrand.Model.MarketInteractor;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.Difficulty;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Market;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.PoliticalSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.ResourceLevel;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.TechLevel;


public class M10JUnitVince {
    private Player player;
    private MarketInteractor marketInteractor;
    private SolarSystem solarSystem;
    private Coordinates coordinates;
    private int fuelPrice;
    private int numFuel;
    private int credits;
    private int cargo;
    private int maxCargo;

    @Before
    public void setUp() {
        coordinates = new Coordinates();
        solarSystem = new SolarSystem("name", TechLevel.EARLYINDUSTRIAL, ResourceLevel.NOSPECIALRESOURCES, PoliticalSystem.ANARCHY, coordinates);
        player = new Player("name", 16, 0, 0, 0, Difficulty.EASY, solarSystem);
        marketInteractor = new MarketInteractor(player);
        fuelPrice = marketInteractor.getPrice(Item.FUEL);
        numFuel = marketInteractor.marketNumberOf(Item.FUEL);
        credits = player.getCredits();
        cargo = player.getShip().getCargo();
        maxCargo = player.getShip().getMaxCargo();
    }

    @Test
    public void testSellBasic() {
        int numOf = marketInteractor.marketNumberOf(Item.WATER);
        player.receiveGood(Item.WATER);
        int numWater = player.numberOf(Item.WATER);
        player.setCredits(0);
        assertTrue("selling valid item should return true",
                marketInteractor.sell(Item.WATER));
        assertEquals("player should receive credits equal to water price",
                marketInteractor.getPrice(Item.WATER), player.getCredits());
        assertEquals("Player should lose his water",
                numWater - 1, player.numberOf(Item.WATER));
        assertEquals("Market should have one more item",
                numOf + 1, marketInteractor.marketNumberOf(Item.WATER));
    }


    @Test
    public void testSellUnusuable() {
        int numOf = marketInteractor.marketNumberOf(Item.ROBOTS);
        player.receiveGood(Item.ROBOTS); //EarlyIndustrial can't use robots
        int numRobots = player.numberOf(Item.ROBOTS);
        player.setCredits(0);
        assertFalse("selling should return false",
                marketInteractor.sell(Item.WATER));
        assertEquals("player should not get credits",
                0, player.getCredits());
        assertEquals("market's robot number should not change",
                numOf, marketInteractor.marketNumberOf(Item.ROBOTS));
        assertEquals("player should not lose robot",
                numRobots, player.numberOf(Item.ROBOTS));
    }

    @Test
    public void testNoneOfItem() {
        int numOf = marketInteractor.marketNumberOf(Item.WATER);
        player.setCredits(0);
        while(player.has(Item.WATER)) {
            player.loseGood(Item.WATER);
        }
        int numWater = player.numberOf(Item.WATER);
        player.setCredits(0);
        assertFalse("selling item not possessed should return false",
                marketInteractor.sell(Item.WATER));
        assertEquals("player should not receive credits",
                0, player.getCredits());
        assertEquals("Player's water number should not change",
                numWater, player.numberOf(Item.WATER));
        assertEquals("Market's items should not change",
                numOf, marketInteractor.marketNumberOf(Item.WATER));
    }



}
