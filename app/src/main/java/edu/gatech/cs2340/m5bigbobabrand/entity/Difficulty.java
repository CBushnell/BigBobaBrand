package edu.gatech.cs2340.m5bigbobabrand.entity;

/**
 * enum for valid difficulties
 */
public enum Difficulty {
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
