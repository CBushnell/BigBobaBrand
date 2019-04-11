package edu.gatech.cs2340.m5bigbobabrand.entity;


import java.util.HashMap;
import java.util.Map;


/**
 * @author Chieng Chang
 * @version 1.0
 *
 * Market class that represents a marketplace where players can trade goods
 */
public class Market {
    public static final int NUM_OF_GOODS = 10;
    private Map<Item, Integer> goods;
    private SolarSystem solarSystem;

    /**
     * Constructor that creates market
     * @param solarSystem is current solarSystem.
     */
    public Market(SolarSystem solarSystem) {
        goods = new HashMap<>();
        Item[] itemArr = Item.values();
        for (Item item : itemArr) {
                if (solarSystem.getTechLevel().getTechLevelNum() >= item.getMTLP()) {
                    goods.put(item, (int)(Math.random() * 100));
                } else {
                    goods.put(item, 0);
                }
        }
        this.solarSystem = solarSystem;
    }

    /**
     *
     * @param good is good being checked
     * @return if it is in stock
     */
    public boolean inStock (Item good) {
        return goods.get(good) > 0;
    }

    /**
     * buy good
     * @param good is good being bought
     */
    public void buyGoodFromMarket(Item good) {
        int currAmount = goods.get(good);
        if (currAmount <= 0) {
            throw new IllegalArgumentException("Cannot buy that good, not enough in stock");
        }
        goods.put(good, currAmount - 1);
    }

    /**
     * check if you can sell good
     * @param good is good being bought
     */
    public void sellGoodToMarket(Item good) {
        int currAmount = goods.get(good);
        goods.put(good, currAmount + 1);
    }

    /**
     *
     * @param good being checked
     * @return stock of good
     */
    public int numberOf(Item good) {
        return goods.get(good);
    }

    /**
     *
     * @return map of goods
     */
    public Map<Item, Integer> getGoods() {
        return goods;
    }
    /*
    private boolean canSell(Item good) {
        if (solarSystem.getTechLevel().getTechLevelNum() < good.getMTLU()) {
            return false;
        }
        return true;
    }

    private boolean canBuy(Item good) {
        if (solarSystem.getTechLevel().getTechLevelNum() < good.getMTLP()) {
            return false;
        }
        return true;
    }
    */
}
