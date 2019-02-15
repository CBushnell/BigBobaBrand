package edu.gatech.cs2340.m5bigbobabrand.model;

public class Player {

    /** Player's name */
    private String name;

    /** Player's amount of pilot skill points */
    private int pilotPts;

    /** Player's amount of trader skill points */
    private int traderPts;

    /** Player's amount of engineer skill points */
    private int engineerPts;

    /** Player's amount of fighter skill points */
    private int fighterPts;

    /** Player's amount of credit skill points */
    private int credits;

    /** Default starting amount of credits for a player */
    private final int startingCredits = 1000;

    public Player(String name, int pilotPts, int traderPts, int engineerPts, int fighterPts) {
        this.name = name;
        this.pilotPts = pilotPts;
        this.traderPts = traderPts;
        this.engineerPts = engineerPts;
        this.fighterPts = fighterPts;
        credits = startingCredits;
    }



}
