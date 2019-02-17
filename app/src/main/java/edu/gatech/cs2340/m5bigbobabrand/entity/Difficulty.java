package edu.gatech.cs2340.m5bigbobabrand.entity;

public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");
    private final String StandingCode;
    private Difficulty(String diffString) {
        this.StandingCode = diffString;
    }
    public String getString() {
        return getString();
    }
}
