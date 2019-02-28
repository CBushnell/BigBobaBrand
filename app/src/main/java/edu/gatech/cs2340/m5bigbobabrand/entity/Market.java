package edu.gatech.cs2340.m5bigbobabrand.entity;

public class Market {
    public static final int NUM_OF_GOODS = 10;
    private Item[] goods;
    private IE event;
    private boolean canSell;
    private boolean canBuy;

    public Market() {
        goods = new Item[NUM_OF_GOODS];
    }

    private void buyGoods(Item good) {

    }

    private void sellGoods(Item good) {

    }
}
