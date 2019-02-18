package edu.gatech.cs2340.m5bigbobabrand.entity;

public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");
    private final String difficultyString;
    private Difficulty(String diffString) {
        this.difficultyString = diffString;
    }
    public String getString() {
        return this.difficultyString;
    }
}
