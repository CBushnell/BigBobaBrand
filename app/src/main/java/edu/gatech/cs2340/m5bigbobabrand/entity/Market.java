package edu.gatech.cs2340.m5bigbobabrand.entity;

import edu.gatech.cs2340.m5bigbobabrand.R;

/**
 * @author Chieng Chang
 * @version 1.0
 *
 * Market class that represents a marketplace where players can trade goods
 */
public class Market {
    public static final int NUM_OF_GOODS = 10;
    private Item[] goods;
    private IE event;
    private ResourceLevel cr;
    private SolarSystem planet;

    /**
     * Constructor that creates market
     */
    public Market() {
        goods = new Item[NUM_OF_GOODS];
    }

    private void buyGoods(Item good) {

    }

    private void sellGoods(Item good) {

    }

    private boolean canSell(Item good) {
        if (planet.getTechLevel().getTechLevelNum() < good.getMTLU()) {
            return false;
        }
        return true;
    }

    private boolean canBuy(Item good) {
        if (planet.getTechLevel().getTechLevelNum() < good.getMTLP()) {
            return false;
        }
        return true;
    }
}
