package edu.gatech.cs2340.m5bigbobabrand.entity;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.m5bigbobabrand.R;

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
     */
    public Market(SolarSystem solarSystem) {
        goods = new HashMap<Item, Integer>();
        Item[] itemArr = Item.values();
        for (Item item : itemArr) {
            Log.d("here", "techLevel: " + solarSystem.getTechLevel().getTechLevelNum() + "mtlp: " + item.getMTLP());
                if (solarSystem.getTechLevel().getTechLevelNum() >= item.getMTLP()) {
                    Log.d("asdf", "adsf");
                    goods.put(item, (int)(Math.random() * 100));
                } else {
                    goods.put(item, 0);
                }
        }
        this.solarSystem = solarSystem;
    }

    public boolean inStock (Item good) {
        if (goods.get(good) > 0) {
            return true;
        }
        return false;
    }

    public void buyGoodFromMarket(Item good) {
        int currAmount = goods.get(good);
        if (currAmount <= 0) {
            throw new IllegalArgumentException("Cannot buy that good, not enough in stock");
        }
        goods.put(good, currAmount - 1);
    }

    public void sellGoodToMarket(Item good) {
        int currAmount = goods.get(good);
        goods.put(good, currAmount + 1);
    }

    public int numberOf(Item good) {
        return goods.get(good);
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
