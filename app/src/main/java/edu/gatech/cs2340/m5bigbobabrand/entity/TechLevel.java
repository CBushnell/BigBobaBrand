package edu.gatech.cs2340.m5bigbobabrand.entity;

public enum TechLevel {
    PREAGRICULTURE("PRE-AGRICULTURE", 0),
    AGRICULTURE("AGRICULTURE", 1),
    MEDIEVAL("MEDIEVAL", 2),
    RENAISSANCE("RENAISSANCE", 3),
    EARLYINDUSTRIAL("EARLY-INDUSTRIAL", 4),
    INDUSTRIAL("INDUSTRIAL", 5),
    POSTINDUSTRIAL("POST-INDUSTRIAL", 6),
    HITECH("HI-TECH", 7);

    private final String name;
    private final int num;

    private TechLevel(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }
}
