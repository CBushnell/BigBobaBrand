package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.gatech.cs2340.m5bigbobabrand.Model.GameState;
import edu.gatech.cs2340.m5bigbobabrand.Model.TravelInteractor;
import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;


/**
 * Map that displays all planets and allows to travel to location.
 */
public class TravelActivity extends AppCompatActivity {
    private Button planetbutton1;
    private Button planetbutton2;
    private Button planetbutton3;
    private Button planetbutton4;
    private Button planetbutton5;
    private Button planetbutton6;
    private Button planetbutton7;
    private Button planetbutton8;
    private Button planetbutton9;
    private Button planetbutton10;
    private TextView current_fuel_header;
    private TextView current_fuel_text_header;
    private MediaPlayer mediaPlayer;


    private Player player;
    private Universe universe;

    private final int CHANCE_RAND = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        mediaPlayer = MediaPlayer.create(TravelActivity.this, R.raw.partymonster);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        planetbutton1 = findViewById(R.id.planetbutton1);
        planetbutton2 = findViewById(R.id.planetbutton2);
        planetbutton3 = findViewById(R.id.planetbutton3);
        planetbutton4 = findViewById(R.id.planetbutton4);
        planetbutton5 = findViewById(R.id.planetbutton5);
        planetbutton6 = findViewById(R.id.planetbutton6);
        planetbutton7 = findViewById(R.id.planetbutton7);
        planetbutton8 = findViewById(R.id.planetbutton8);
        planetbutton9 = findViewById(R.id.planetbutton9);
        planetbutton10 = findViewById(R.id.planetbutton10);
        current_fuel_header = findViewById(R.id.current_fuel_header);
        current_fuel_text_header = findViewById(R.id.current_fuel_text_header);

        this.player = GameState.myGame.getPlayer();
        this.universe = GameState.myGame.getUniverse();
        Log.d("debug", "onCreate: asdfasdf");
        SolarSystem[] solarSystems = this.universe.getUniverse().values().toArray(new SolarSystem[0]);
        setButtonLocations(solarSystems);

        current_fuel_text_header.setText(Integer.toString(player.numberOf(Item.FUEL)));



    }

    /**
     * sets locations of buttons on the screen based on solar system coordinates
     *
     * @param solarSystems solarSystem of the game
     */
    private void setButtonLocations(SolarSystem[] solarSystems) {
        SolarSystem solarSystem1 = solarSystems[0];
        final int offsetX = 140;
        final int offsetY = 560;
        final int createSpread = 8;
        planetbutton1.setTranslationX(offsetX + (solarSystem1.getX() * createSpread));
        planetbutton1.setTranslationY(offsetY + (solarSystem1.getY() * createSpread));
        planetbutton1.setText(solarSystem1.getName());


        SolarSystem solarSystem2 = solarSystems[1];
        planetbutton2.setTranslationX(offsetX + (solarSystem2.getX() * createSpread));
        planetbutton2.setTranslationY((offsetY + (solarSystem2.getY()) * createSpread));
        planetbutton2.setText(solarSystem2.getName());

        SolarSystem solarSystem3 = solarSystems[2];
        planetbutton3.setTranslationX(offsetX + (solarSystem3.getX() * createSpread));
        planetbutton3.setTranslationY(offsetY + (solarSystem3.getY() * createSpread));
        planetbutton3.setText(solarSystem3.getName());

        SolarSystem solarSystem4 = solarSystems[3];
        planetbutton4.setTranslationX(offsetX + (solarSystem4.getX() * createSpread));
        planetbutton4.setTranslationY(offsetY + (solarSystem4.getY() * createSpread));
        planetbutton4.setText(solarSystem4.getName());

        SolarSystem solarSystem5 = solarSystems[4];
        planetbutton5.setTranslationX(offsetX + (solarSystem5.getX() * createSpread));
        planetbutton5.setTranslationY(offsetY + (solarSystem5.getY() * createSpread));
        planetbutton5.setText(solarSystem5.getName());

        SolarSystem solarSystem6 = solarSystems[5];
        planetbutton6.setTranslationX(offsetX + (solarSystem6.getX() * createSpread));
        planetbutton6.setTranslationY(offsetY + (solarSystem6.getY() * createSpread));
        planetbutton6.setText(solarSystem6.getName());

        SolarSystem solarSystem7 = solarSystems[6];
        planetbutton7.setTranslationX(offsetX + (solarSystem7.getX() * createSpread));
        planetbutton7.setTranslationY(offsetY + (solarSystem7.getY() * createSpread));
        planetbutton7.setText(solarSystem7.getName());

        SolarSystem solarSystem8 = solarSystems[7];
        planetbutton8.setTranslationX(offsetX + (solarSystem8.getX() * createSpread));
        planetbutton8.setTranslationY(offsetY + (solarSystem8.getY() * createSpread));
        planetbutton8.setText(solarSystem8.getName());

        SolarSystem solarSystem9 = solarSystems[8];
        planetbutton9.setTranslationX(offsetX + (solarSystem9.getX() * createSpread));
        planetbutton9.setTranslationY(offsetY + (solarSystem9.getY() * createSpread));
        planetbutton9.setText(solarSystem9.getName());

        SolarSystem solarSystem10 = solarSystems[9];
        planetbutton10.setTranslationX(offsetX + (solarSystem10.getX() * createSpread));
        planetbutton10.setTranslationY(offsetY + (solarSystem10.getY() * createSpread));
        planetbutton10.setText(solarSystem10.getName());
        final int BUTTONR = 218;
        final int BUTTONG = 165;
        final int BUTTONB = 32;
        if (solarSystem1.equals(player.getSolarSystem())) {
            planetbutton1.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem2.equals(player.getSolarSystem())) {
            planetbutton2.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem3.equals(player.getSolarSystem())) {
            planetbutton3.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem4.equals(player.getSolarSystem())) {
            planetbutton4.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem5.equals(player.getSolarSystem())) {
            planetbutton5.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem6.equals(player.getSolarSystem())) {
            planetbutton6.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem7.equals(player.getSolarSystem())) {
            planetbutton7.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem8.equals(player.getSolarSystem())) {
            planetbutton8.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem9.equals(player.getSolarSystem())) {
            planetbutton9.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        } else if (solarSystem10.equals(player.getSolarSystem())) {
            planetbutton10.setTextColor(Color.rgb(BUTTONR, BUTTONG, BUTTONB));
        }

    }

    /**
     * creates an alert dialog displaying fuel cost and asking if user wishes to travel
     * if yes selected, the travel is attempted. Cannot be in attempt method due to asynchronous
     * nature of dialogs
     *
     * @param planetNum index + 1 in the array of the planet the player is attempting to travel to
     */
    private void askForTravel(int planetNum) {
        final int num = planetNum;
        SolarSystem[] solarSystems = this.universe.getUniverse()
                .values().toArray(new SolarSystem[0]);
        TravelInteractor travelCostCalculator = new TravelInteractor(player.getSolarSystem(),
                solarSystems[planetNum - 1]);
        int fuelCost = travelCostCalculator.calculateFuelCosts();

        String fuelMessage = "Traveling to planet " + solarSystems[planetNum - 1].getName()
                + " will cost " + fuelCost + " fuel";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Travel");
        builder.setMessage(fuelMessage);
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                travelAttempted(num);
            }
        });

        builder.setNegativeButton("Cancel", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Attempts to travel the player to the specified planet
     *
     * @param planetNum index + 1 in the array of the planet the player is attempting to travel to
     */
    private void travelAttempted(int planetNum) {
        SolarSystem[] solarSystems = this.universe.getUniverse()
                .values().toArray(new SolarSystem[0]);


        //if player's current solarsystem is the button clicked, nothing happens
        if (player.getSolarSystem().equals(solarSystems[planetNum - 1])) {
            Toast.makeText(this, "Currently on this planet", Toast.LENGTH_LONG).show();
            onBackPressed();
        }


        //calculates fuel costs
        TravelInteractor travelCostCalculator = new TravelInteractor(player.getSolarSystem(),
                solarSystems[planetNum - 1]);
        int fuelCost = travelCostCalculator.calculateFuelCosts();

        //subtracts fuel cost from player's fuel, breaks loop if out of fuel
        int subtracted = 0;

        while (subtracted < fuelCost) {
            if (player.has(Item.FUEL)) {
                player.loseGood(Item.FUEL);
                subtracted++;
            } else {
                break;
            }
        }

        //if player had enough fuel, travel is performed,
        // otherwise player remains on planet and receives his fuel back
        if (subtracted == fuelCost) {
            Intent intent = new Intent(TravelActivity.this, MarketActivity.class);
            player.setSolarSystem(solarSystems[planetNum - 1]);
            int randomChance = (int)(Math.random() * 100) + 1;
            if (randomChance < CHANCE_RAND) {
                int credits = player.getCredits();
                intent.putExtra("RANDOM", true);
                if (credits > 100) {
                    credits = credits - 100;
                } else {
                    credits = 0;
                }
                player.setCredits(credits);
            } else {
                intent.putExtra("RANDOM", false);
            }
            mediaPlayer.release();
            mediaPlayer = null;
            this.startActivity(intent);
        } else {
            while (subtracted > 0) {
                player.receiveGood(Item.FUEL);
                subtracted--;
            }
            Toast.makeText(this, "Not Enough fuel to travel to "
                    + solarSystems[planetNum - 1].getName(), Toast.LENGTH_LONG).show();
        }

    }

    /**
     * On button press, calls a travel attempt between current planet and planet 1
     *
     * @param view the button clicked
     */
    public void onPlanetButton1Pressed(View view) {
        askForTravel(1);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 2
     *
     * @param view the button clicked
     */
    public void onPlanetButton2Pressed(View view) {
        askForTravel(2);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 3
     *
     * @param view the button clicked
     */
    public void onPlanetButton3Pressed(View view) {
        askForTravel(3);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 4
     *
     * @param view the button clicked
     */
    public void onPlanetButton4Pressed(View view) {
        askForTravel(4);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 5
     *
     * @param view the button clicked
     */
    public void onPlanetButton5Pressed(View view) {
        askForTravel(5);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 6
     *
     * @param view the button clicked
     */
    public void onPlanetButton6Pressed(View view) {
        askForTravel(6);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 7
     *
     * @param view the button clicked
     */
    public void onPlanetButton7Pressed(View view) {
        askForTravel(7);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 8
     *
     * @param view the button clicked
     */
    public void onPlanetButton8Pressed(View view) {
        askForTravel(8);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 9
     *
     * @param view the button clicked
     */
    public void onPlanetButton9Pressed(View view) {
        askForTravel(9);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 10
     *
     * @param view the button clicked
     */
    public void onPlanetButton10Pressed(View view) {
        askForTravel(10);
    }

    /**
     * On save press, saves game
     *
     * @param view the button clicked
     */
    public void onSavePressed(View view) {
        try{
            FileOutputStream fos = getApplicationContext().openFileOutput("player1.data", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(player);
            os.writeObject(universe);
            Log.d("save", "save complete");
            os.close();
            fos.close();
        }catch (Exception e){
            Log.d("Save", "Failed to save - \n" + e.toString());
        }
    }

    /**
     * When load button is pressed.
     * @param view is the button pressed.
     */
    public void onLoadPressed(View view){
        try{
            FileInputStream fis = getApplicationContext().openFileInput("player1.data");
            ObjectInputStream is = new ObjectInputStream(fis);
            Player currPlayer = (Player) is.readObject();
            Universe currUniverse = (Universe) is.readObject();
            is.close();
            fis.close();
            GameState.startGame(currUniverse, currPlayer);
            Intent intent = new Intent(TravelActivity.this, MarketActivity.class);
            this.startActivity(intent);
        }catch (Exception e){
            Log.e("broke", "broke");
        }
    }




}
