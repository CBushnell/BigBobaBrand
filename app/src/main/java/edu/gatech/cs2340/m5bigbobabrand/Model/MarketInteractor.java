package edu.gatech.cs2340.m5bigbobabrand.Model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.m5bigbobabrand.entity.IE;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Market;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.PoliticalSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

/**
 * Interfaces between a market and a player
 */
public class MarketInteractor {
    private final Market market;
    private final Player player;
    private final IE ie;
    private final Map<Item, Integer> prices;
    private boolean police;

    private final int POLICE_CHANCE = 99;

    /**
     * creates a MarketInteractor between player
     * and current planet the player is on
     * @param player to create market interactor for
     */
    public MarketInteractor(Player player) {
        SolarSystem playerSolarsystem = player.getSolarSystem();
        this.market = new Market(playerSolarsystem);
        this.player = player;
        this.ie = calcIE();
        prices = new HashMap<>();
        Item[] itemArr = Item.values();
        for (Item item : itemArr) {
            SolarSystem solarSystem = playerSolarsystem;
            if(solarSystem.getTechLevelNum() >= item.getMTLP()) {
                prices.put(item, calcPrice(item));
            } else {
                prices.put(item, null);
            }
        }
        this.police = calcPolice();
    }

    /**
     *
     * @param item to calc price of
     * @return price calculated
     */
    private int calcPrice(Item item) {
        // 0 if heads, 1 if tails
        int coinFlip = (int) ((Math.random() * 2));
        if (coinFlip == 0) {
            coinFlip = -1;
        }
        int multiplierValue = (int) (Math.random() * (item.getVar() + 1));
        final double DIV = 100.0;
        double multiplierEquationValue = multiplierValue/DIV;
        SolarSystem solarSystem = player.getSolarSystem();
        int price = item.getBasePrice()
                + (item.getIPL() * (solarSystem.getTechLevelNum() - item.getMTLP()))
                + ((int)(coinFlip * item.getBasePrice() * multiplierEquationValue));
        if (item.getCat() == this.ie) {
            price = price * 2;
        }

        return Math.abs(price);
    }

    private boolean calcPolice() {
        SolarSystem playerSolarsystem = player.getSolarSystem();
        if (playerSolarsystem.getPoliticalSystem().equals(PoliticalSystem.DICTATORSHIP)
                || playerSolarsystem.getPoliticalSystem().equals(PoliticalSystem.FASCIST_STATE)
                || playerSolarsystem.getPoliticalSystem().equals(PoliticalSystem.MILITARY_STATE)
                || playerSolarsystem.getPoliticalSystem().equals(PoliticalSystem.COMMUNIST_STATE)) {
            if ((Math.random() * 100) + 1 < POLICE_CHANCE) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private IE calcIE() {
        int ieInt = (int)(Math.random() * 100) + 1;
        IE[] ieArr =IE.values();
        for (IE currIE : ieArr) {
            if(currIE.getIEnum() == ieInt) {
                return currIE;
            }
        }
        return IE.NONE;
    }

    /**
     * buys item from market
     * @param item item to buy
     * @return whether buy was successful
     */
    public boolean buy(Item item) {
        if (prices.get(item) == null) {
            return false;
        }
        if (player.getCargo() >= player.getMaxCargo()) {
            return false;
        }
        if (player.getCredits() < prices.get(item)) {
            return false;
        }
        int price = prices.get(item);
        try {
            int currCredits = player.getCredits();
            market.buyGoodFromMarket(item);
            player.setCredits(currCredits - price);
            player.receiveGood(item);
            return true;
        } catch (Exception e) {
            Log.d("Error", e.getMessage());
            return false;
        }

    }

    /**
     * sells item to market and gives player credit
     * @param item to sell
     * @return whether selling was successful
     */
    public boolean sell (Item item) {
        SolarSystem solarSystem = player.getSolarSystem();
        if (item.getMTLU() > solarSystem.getTechLevelNum()) {
            return false;
        }
        if (player.has(item)) {
            int currCredits = player.getCredits();
            int price = prices.get(item);
            if (item.equals(Item.NARCOTICS) && this.police == true) {
                player.loseGood(Item.NARCOTICS);
                return false;
            }
            player.loseGood(item);
            player.setCredits(currCredits + price);
            market.sellGoodToMarket(item);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param item to calc the price of
     * @return the price of given item
     */
    public int getPrice (Item item) {
        if (prices.get(item) == null) {
            return -1;
        }
        return prices.get(item);
    }

    /**
     *
     * @param item to find stock in market
     * @return number of given item market has
     */
    public int marketNumberOf (Item item) {
        return this.market.numberOf(item);
    }

    /**
     *
     * @return the IE for the current planet
     */
    public IE getIe() {
        return this.ie;
    }

    /**
     *
     * @return if this has police
     */
    public boolean getPolice() {
        return this.police;
    }



}
