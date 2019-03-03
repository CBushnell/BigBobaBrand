package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

public class Player implements Serializable {

    /** Player's name */
    private String name;

    /** Player's ship*/
    private Ship ship;

    /** Player's amount of pilot skill points */
    private int pilotPts;

    /** Player's difficulty */
    private Difficulty difficulty;

    /** Player's amount of trader skill points */
    private int traderPts;

    /** Player's amount of engineer skill points */
    private int engineerPts;

    /** Player's amount of fighter skill points */
    private int fighterPts;

    /** Player's amount of credit points */
    private int credits;

    /** SolarSystem player is in */
    private SolarSystem solarSystem;



    /** Default starting amount of credits for a player */
    private final int STARTINGCREDITS = 1000;

    public Player() {
        this("placeholder", 0, 0 ,0, 0, Difficulty.EASY, null);
    }



    public Player(String name, int pilotPts, int traderPts, int engineerPts, int fighterPts,
                  Difficulty difficulty, SolarSystem solarSystem) {
        this.name = name;
        this.pilotPts = pilotPts;
        this.traderPts = traderPts;
        this.engineerPts = engineerPts;
        this.fighterPts = fighterPts;
        credits = STARTINGCREDITS;
        this.ship = new Ship();
        this.difficulty = difficulty;
        this.solarSystem = solarSystem;
    }

    public String getName() {
        return name;
    }

    /** collective player skill points must sum to 16 and cannot be negative*/
    public boolean verifySum() {
        return (pilotPts + traderPts + engineerPts + fighterPts == 16)
                && (pilotPts >= 0 || traderPts >= 0 || engineerPts >= 0 || fighterPts >= 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPilotPts() {
        return pilotPts;
    }

    public void setPilotPts(int pilotPts) {
        this.pilotPts = pilotPts;
    }

    public int getTraderPts() {
        return traderPts;
    }

    public void setTraderPts(int traderPts) {
        this.traderPts = traderPts;
    }

    public int getEngineerPts() {
        return engineerPts;
    }

    public void setEngineerPts(int engineerPts) {
        this.engineerPts = engineerPts;
    }

    public int getFighterPts() {
        return fighterPts;
    }

    public void setFighterPts(int fighterPts) {
        this.fighterPts = fighterPts;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Difficulty diff) {
        this.difficulty = diff;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    public SolarSystem getSolarSystem() {
        return this.solarSystem;
    }

    public int getCargo() {
        return this.ship.getCargo();
    }

    public int getMaxCargo() {
        return this.ship.getMaxCargo();
    }

    public void receiveGood(Item good) {
        this.ship.receiveGood(good);
    }

    public void loseGood(Item good) {
        this.ship.loseGood(good);
    }

    public boolean has(Item good) {
        return ship.has(good);
    }

    public int numberOf(Item good) {
        return ship.numberOf(good);
    }


}
