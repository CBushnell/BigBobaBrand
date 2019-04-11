package edu.gatech.cs2340.m5bigbobabrand.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;import java.util.Map;

import edu.gatech.cs2340.m5bigbobabrand.Model.TravelInteractor;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Market;

public class buyGoodFromMarketTest {
    public static final int TIMEOUT = 200;
    private SolarSystem system;
    private Market market;
    private Coordinates coordinates;
    private Item item;
    private Map<Item, Integer> goods;




    @Before
    public void setUp() throws Exception {
        coordinates = new Coordinates();
        system = new SolarSystem("tory", TechLevel.PREAGRICULTURE,
                ResourceLevel.WARLIKE, PoliticalSystem.ANARCHY, coordinates);
        market = new Market(system);
        goods = market.getGoods();
    }

    @Test (expected = NullPointerException.class)
    public void testBuyGoodFromMarketException() {
        item = null;
        market.buyGoodFromMarket(item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBuyGoodFromMarketException2() {
        for (Item x : goods.keySet()) {
            if (goods.get(x) <= 0) {
                item = x;
                break;
            }
        }
        market.buyGoodFromMarket(item);
     }



    @Test
    public void testBuyGoodFromMarket() {
        for (Item x : goods.keySet()) {
            if (goods.get(x) > 0) {
                item = x;
                break;
            }
        }
        assertEquals(goods.size(), market.getGoods().size());
        assertEquals(goods.get(item), market.getGoods().get(item));
    }
}