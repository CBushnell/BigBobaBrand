package edu.gatech.cs2340.m5bigbobabrand.entity;

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

    /** Player's amount of credit points */
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

        /** individual player skill points cannot be negative */
        if (pilotPts < 0 || traderPts < 0 || engineerPts < 0 || fighterPts < 0) {
            throw new IllegalArgumentException("Skill points are not properly allocated! " +
                    "Individual skill points cannot be negative");
        }

        /** collective player skill points must sum to 16 */
        if (pilotPts + traderPts + engineerPts + fighterPts != 16) {
            throw new IllegalArgumentException("Skill points are not properly allocated! " +
                    "Skill points must sum to 16");
        }
    }

    public String getName() {
        return name;
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


}
