package edu.gatech.cs2340.m5bigbobabrand.Model;

import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;

public class GameState {
    private Universe universe;
    private Player player;
    public GameState() {
        this.universe = null;
        this.player = null;
    }
    public void startGame(Universe universe, Player player) {
        this.universe = universe;
        this.player = player;
    }
}
