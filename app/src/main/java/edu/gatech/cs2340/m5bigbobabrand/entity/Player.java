package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * Singleton class for player.
 */
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

    /** max number of skill points for player. */
    private final int MAXDIFFICULTY = 16;


    /**
     * Chaining constructor
     */
    public Player() {
        this("placeholder", 0, 0 ,0, 0, Difficulty.EASY, null);
    }


    /**
     * constructor for player
     * @param name is name of Player.
     * @param pilotPts is skill points allocated to player pilot skill.
     * @param traderPts is skill points allocated to trader pilot skill.
     * @param engineerPts is skill points allocated to engineer pilot skill.
     * @param fighterPts is skill points allocated to fighter pilot skill.
     * @param difficulty is difficulty enum.
     * @param solarSystem is solar system generated that player is currently on.
     */
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

    /**
     * Getter for player name.
     * @return name of player.
     */
    public String getName() {
        return name;
    }

    /** @return collective player skill points must sum to 16 and cannot be negative*/
    public boolean verifySum() {
        return ((pilotPts + traderPts + engineerPts + fighterPts) == MAXDIFFICULTY)
                && ((pilotPts >= 0) || (traderPts >= 0) || (engineerPts >= 0) || (fighterPts >= 0));
    }

    /**
     * Setter for player Name.
     * @param name is new name for player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for player pilot points.
     * @return pilot points for player.
     */
    public int getPilotPts() {
        return pilotPts;
    }

    /**
     *
     * @param pilotPts is new amount of pilot points for player.
     */
    public void setPilotPts(int pilotPts) {
        this.pilotPts = pilotPts;
    }

    /**
     *
     * @return trader Points for player.
     */
    public int getTraderPts() {
        return traderPts;
    }

    /**
     *
     * @param traderPts is the new amount of trader points.
     */
    public void setTraderPts(int traderPts) {
        this.traderPts = traderPts;
    }

    /**
     *
     * @return amount of engineer points for player.
     */
    public int getEngineerPts() {
        return engineerPts;
    }

    /**
     *
     * @param engineerPts is new amount of engineer points for player.
     */
    public void setEngineerPts(int engineerPts) {
        this.engineerPts = engineerPts;
    }

    /**
     *
     * @return fighterPoints for player.
     */
    public int getFighterPts() {
        return fighterPts;
    }

    /**
     *
     * @param fighterPts is new amount of fighter Points for player.
     */
    public void setFighterPts(int fighterPts) {
        this.fighterPts = fighterPts;
    }

    /**
     *
     * @return amount of credits player has.
     */
    public int getCredits() {
        return credits;
    }

    /**
     *
     * @param credits is new amount of credits player has.
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     *
     * @return Difficulty for player.
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     *
     * @param diff is new difficulty for player.
     */
    public void setDifficulty(Difficulty diff) {
        this.difficulty = diff;
    }

    /**
     *
     * @return player's ship type.
     */
    public Ship getShip() {
        return ship;
    }

    /**
     *
     * @param ship is new ship type for player.
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     *
     * @param solarSystem is new solar system for player.
     */
    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }

    /**
     *
     * @return current solar system of player.
     */
    public SolarSystem getSolarSystem() {
        return this.solarSystem;
    }

    /**
     *
     * @return player's ship cargo.
     */
    public int getCargo() {
        return this.ship.getCargo();
    }

    /**
     *
     * @return max cargo capacity of ship.
     */
    public int getMaxCargo() {
        return this.ship.getMaxCargo();
    }

    /**
     *
     * @param good is new good received and put onto ship.
     */
    public void receiveGood(Item good) {
        this.ship.receiveGood(good);
    }

    /**
     *
     * @param good is good lost and removed from ship.
     */
    public void loseGood(Item good) {
        this.ship.loseGood(good);
    }

    /**
     * Checker if ship has a good
     * @param good is good being searched for.
     * @return if ship has it or not.
     */
    public boolean has(Item good) {
        return ship.has(good);
    }

    /**
     * Return how many goods of certain type are in ship.
     * @param good is good being searched for.
     * @return number of goods in ship.
     */
    public int numberOf(Item good) {
        return ship.numberOf(good);
    }


}
