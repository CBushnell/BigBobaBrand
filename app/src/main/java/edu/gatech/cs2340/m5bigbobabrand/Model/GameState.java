package edu.gatech.cs2340.m5bigbobabrand.Model;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;

public class GameState implements Serializable {
    private Universe universe;
    private Player player;
    public static GameState myGame = new GameState();
    public GameState() {
        this.player = null;
        this.universe = null;
    }
    public static void startGame(Universe universe, Player player) {
        myGame.universe = universe;
        myGame.player = player;
    }
    public Universe getUniverse() {
        return this.universe;
    }
    public Player getPlayer() {
        return this.player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setUniverse(Universe universe) {
        this.universe = universe;
    }


}
