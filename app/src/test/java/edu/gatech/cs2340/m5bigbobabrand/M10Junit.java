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

/*
Charlie Junits
 */
public class M10Junit {
    private Player player;
    private Market market;
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
        solarSystem = new SolarSystem("name", TechLevel.PREAGRICULTURE, ResourceLevel.NOSPECIALRESOURCES, PoliticalSystem.ANARCHY, coordinates);
        player = new Player("name", 16, 0, 0, 0, Difficulty.EASY, solarSystem);
        market = new Market(solarSystem);
        marketInteractor = new MarketInteractor(player);
        fuelPrice = marketInteractor.getPrice(Item.FUEL);
        numFuel = marketInteractor.marketNumberOf(Item.FUEL);
        credits = player.getCredits();
        cargo = player.getShip().getCargo();
        maxCargo = player.getShip().getMaxCargo();
    }

    @Test
    public void testBuy() {
        int i = 0;
        // trying to max out cargo
        for (; marketInteractor.marketNumberOf(Item.FUEL) > 0 && i < 15; i++) {
            System.out.println(i);
            assertTrue(marketInteractor.buy(Item.FUEL));
            credits -= fuelPrice;
            cargo++;
            numFuel--;
            assertEquals(credits, player.getCredits());
            assertEquals(cargo, player.getCargo());
            assertEquals(numFuel, marketInteractor.marketNumberOf(Item.FUEL));
            assertTrue(cargo <= maxCargo);
            assertTrue(marketInteractor.marketNumberOf(Item.FUEL) >= 0);
            assertTrue(player.getCredits() >= 0);
        }
        if (i == 15) {
            System.out.println("cargo maxed!");
            assertFalse(marketInteractor.buy(Item.FUEL)); // cargo maxed
        } else {
            System.out.println("market maxed out!");
            assertTrue(marketInteractor.marketNumberOf(Item.FUEL) == 0); // market ran out
        }
    }

    @Test
    public void TestBuyNoSuchItem() {
        assertFalse(marketInteractor.buy(Item.NARCOTICS)); // pre-agricultural planet markets do not sell Narcotics
        assertTrue(cargo <= maxCargo);
        assertTrue(marketInteractor.marketNumberOf(Item.NARCOTICS) >= 0);
        assertTrue(player.getCredits() >= 0);
    }

    @Test
    public void TestBuyNoCredits() {
        player.setCredits(0);
        assertFalse(marketInteractor.buy(Item.FUEL));
        assertTrue(cargo <= maxCargo);
        assertTrue(marketInteractor.marketNumberOf(Item.FUEL) >= 0);
        assertTrue(player.getCredits() >= 0);
    }

}
