package edu.gatech.cs2340.m5bigbobabrand.Model;

import java.io.Serializable;

import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;

/**
 * Stores games state in between activities.
 */
public final class GameState implements Serializable {
    private Universe universe;
    private Player player;
    public static GameState myGame = new GameState();

    /**
     * Constructor for game state.
     */
    private GameState() {
        this.player = null;
        this.universe = null;
    }

    /**
     * first GameState construction when person starts game.
     * @param universe is universe generated.
     * @param player is player playing.
     */
    public static void startGame(Universe universe, Player player) {
        myGame.universe = universe;
        myGame.player = player;
    }

    /**
     *
     * @return universe
     */
    public Universe getUniverse() {
        return this.universe;
    }

    /**
     *
     * @return player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     *
     * @param player is setting new player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * @param universe is setting new universe.
     */
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }


}
