package edu.gatech.cs2340.m5bigbobabrand.entity;

import java.io.Serializable;

/**
 * enum for valid difficulties
 */
public enum Difficulty implements Serializable {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");
    private final String difficultyString;
    private Difficulty(String diffString) {
        this.difficultyString = diffString;
    }

    /**
     *
     * @return string representation for given difficulty
     */
    public String getString() {
        return this.difficultyString;
    }
}
