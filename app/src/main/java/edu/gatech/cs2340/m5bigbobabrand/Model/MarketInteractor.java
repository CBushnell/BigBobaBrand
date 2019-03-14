package edu.gatech.cs2340.m5bigbobabrand.Model;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.cs2340.m5bigbobabrand.entity.IE;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Market;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;

public class MarketInteractor {
    Market market;
    Player player;
    IE ie;
    Map<Item, Integer> prices;

    public MarketInteractor(Player player) {
        this.market = new Market(player.getSolarSystem());
        this.player = player;
        this.ie = calcIE();
        prices = new HashMap<Item, Integer>();
        Item[] itemArr = Item.values();
        for (Item item : itemArr) {
            if(player.getSolarSystem().getTechLevel().getTechLevelNum() >= item.getMTLP()) {
                prices.put(item, calcPrice(item));
            } else {
                prices.put(item, null);
            }
        }
    }

    private int calcPrice(Item item) {
        // 0 if heads, 1 if tails
        int coinFlip = (int) ((Math.random() * 2));
        if (coinFlip == 0) {
            coinFlip = -1;
        }
        int multiplierValue = (int) (Math.random() * (item.getVar() + 1));
        double multiplierEquationValue = multiplierValue/100.0;
        int price = item.getBasePrice()
                + (item.getIPL() * (player.getSolarSystem().getTechLevel().getTechLevelNum() - item.getMTLP()))
                + ((int)(coinFlip * item.getBasePrice() * multiplierEquationValue));
        if (item.getCat() == this.ie) {
            price = price * 2;
        }

        return Math.abs(price);
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

    public boolean sell (Item item) {
        if (item.getMTLU() > player.getSolarSystem().getTechLevel().getTechLevelNum()) {
            return false;
        }
        if (player.has(item)) {
            int currCredits = player.getCredits();
            int price = prices.get(item);
            player.loseGood(item);
            player.setCredits(currCredits + price);
            market.sellGoodToMarket(item);
            return true;
        } else {
            return false;
        }
    }

    public int getPrice (Item item) {
        if (prices.get(item) == null) {
            return -1;
        }
        return prices.get(item);
    }

    public int marketNumberOf (Item item) {
        return this.market.numberOf(item);
    }

    public IE getIe() {
        return this.ie;
    }



}
