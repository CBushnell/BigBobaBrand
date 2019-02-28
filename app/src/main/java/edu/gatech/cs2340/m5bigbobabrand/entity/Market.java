package edu.gatech.cs2340.m5bigbobabrand.entity;

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
    private CR cr;
    private boolean canSell;
    private boolean canBuy;

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
}
