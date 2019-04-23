package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import edu.gatech.cs2340.m5bigbobabrand.Model.GameState;
import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.Difficulty;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.Ship;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;


/**
 * Takes care of the view of the main activities in the game
 */
public class PirateActivity extends AppCompatActivity {
    String pirateChoice;
    Player player;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(PirateActivity.this, R.raw.will);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        setContentView(R.layout.activity_pirate);
        int rNum = (int) (Math.random() * 3);
        if (rNum == 0)  {
            pirateChoice = "ROCK";
        } else if (rNum == 1) {
            pirateChoice = "PAPER";
        } else if (rNum == 2) {
            pirateChoice = "SCISSORS";
        }
        Log.d("piratechoice", pirateChoice);
        this.player = GameState.myGame.getPlayer();
    }

    /**
     * On button press, selects rock
     *
     * @param view the button clicked
     */
    public void onRockPressed(View view) {
        if (pirateChoice.equals("ROCK")) {
            this.tie();
        } else if (pirateChoice.equals("PAPER")) {
            this.lose();
        } else if (pirateChoice.equals("SCISSORS")) {
            this.win();
        }
    }

    /**
     * On button press, selects paper
     *
     * @param view the button clicked
     */
    public void onPaperPressed(View view) {
        if (pirateChoice.equals("ROCK")) {
            this.win();
        } else if (pirateChoice.equals("PAPER")) {
            this.tie();
        } else if (pirateChoice.equals("SCISSORS")) {
            this.lose();
        }
    }
    /**
     * On button press, selects scissors
     *
     * @param view the button clicked
     */
    public void onScissorsPressed(View view) {
        if (pirateChoice.equals("ROCK")) {
            this.lose();
        } else if (pirateChoice.equals("PAPER")) {
            this.win();
        } else if (pirateChoice.equals("SCISSORS")) {
            this.tie();
        }
    }

    /**
     * deals with loss encounter
     */
    private void lose() {
        Intent intent = new Intent(PirateActivity.this, MarketActivity.class);
        int credits = player.getCredits();
        intent.putExtra("RANDOM", 1);
        if (credits > 100) {
            credits = credits - 100;
        } else {
            credits = 0;
        }
        player.setCredits(credits);
        mediaPlayer.release();
        mediaPlayer = null;
        this.startActivity(intent);
    }

    /**
     * deals with won encounter
     */
    private void win() {
        Intent intent = new Intent(PirateActivity.this, MarketActivity.class);
        int credits = player.getCredits();
        intent.putExtra("RANDOM", 2);
        credits = credits + 100;
        player.setCredits(credits);
        mediaPlayer.release();
        mediaPlayer = null;
        this.startActivity(intent);
    }

    /**
     * deals with tie encounter
     */
    private void tie() {
        Intent intent = new Intent(PirateActivity.this, MarketActivity.class);
        intent.putExtra("RANDOM", 3);
        mediaPlayer.release();
        mediaPlayer = null;
        this.startActivity(intent);
    }
}
