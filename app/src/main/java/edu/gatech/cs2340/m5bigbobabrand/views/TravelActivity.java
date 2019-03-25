package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import edu.gatech.cs2340.m5bigbobabrand.Model.GameState;
import edu.gatech.cs2340.m5bigbobabrand.Model.TravelInteractor;
import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;
import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;


public class TravelActivity extends AppCompatActivity {
    private CircleMenu circleMenu;
    private CircleMenu demoMenu;
    AlertDialog.Builder builder;
    Button planetbutton1;
    Button planetbutton2;
    Button planetbutton3;
    Button planetbutton4;
    Button planetbutton5;
    Button planetbutton6;
    Button planetbutton7;
    Button planetbutton8;
    Button planetbutton9;
    Button planetbutton10;


    private Player player;
    private Universe universe;
    static boolean clicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
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

        this.player = GameState.myGame.getPlayer();
        this.universe = GameState.myGame.getUniverse();
        Log.d("debug", "onCreate: asdfasdf");
        SolarSystem[] solarSystems = this.universe.getUniverse().values().toArray(new SolarSystem[0]);
        setButtonLocations(solarSystems);



    }

    /**
     * sets locations of buttons on the screen based on solar system coordinates
     *
     * @param solarSystems solarSystem of the game
     */
    private void setButtonLocations(SolarSystem[] solarSystems) {
        SolarSystem solarSystem1 = solarSystems[0];
        planetbutton1.setTranslationX(140 + solarSystem1.getCoordinates().getX() * 8);
        planetbutton1.setTranslationY(560 + solarSystem1.getCoordinates().getY() * 8);
        planetbutton1.setText(solarSystem1.getName());

        SolarSystem solarSystem2 = solarSystems[1];
        planetbutton2.setTranslationX(240 + solarSystem2.getCoordinates().getX() * 8);
        planetbutton2.setTranslationY(560 + solarSystem2.getCoordinates().getY() * 8);
        planetbutton2.setText(solarSystem2.getName());

        SolarSystem solarSystem3 = solarSystems[2];
        planetbutton3.setTranslationX(340 + solarSystem3.getCoordinates().getX() * 8);
        planetbutton3.setTranslationY(560 + solarSystem3.getCoordinates().getY() * 8);
        planetbutton3.setText(solarSystem3.getName());

        SolarSystem solarSystem4 = solarSystems[3];
        planetbutton4.setTranslationX(440 + solarSystem4.getCoordinates().getX() * 8);
        planetbutton4.setTranslationY(560 + solarSystem4.getCoordinates().getY() * 8);
        planetbutton4.setText(solarSystem4.getName());

        SolarSystem solarSystem5 = solarSystems[4];
        planetbutton5.setTranslationX(50 + solarSystem5.getCoordinates().getX() * 8);
        planetbutton5.setTranslationY(560 + solarSystem5.getCoordinates().getY() * 8);
        planetbutton5.setText(solarSystem5.getName());

        SolarSystem solarSystem6 = solarSystems[5];
        planetbutton6.setTranslationX(60 + solarSystem6.getCoordinates().getX() * 8);
        planetbutton6.setTranslationY(660 + solarSystem6.getCoordinates().getY() * 8);
        planetbutton6.setText(solarSystem6.getName());

        SolarSystem solarSystem7 = solarSystems[6];
        planetbutton7.setTranslationX(70 + solarSystem7.getCoordinates().getX() * 8);
        planetbutton7.setTranslationY(70 + solarSystem7.getCoordinates().getY() * 8);
        planetbutton7.setText(solarSystem7.getName());

        SolarSystem solarSystem8 = solarSystems[7];
        planetbutton8.setTranslationX(80 + solarSystem8.getCoordinates().getX() * 8);
        planetbutton8.setTranslationY(80 + solarSystem8.getCoordinates().getY() * 8);
        planetbutton8.setText(solarSystem8.getName());

        SolarSystem solarSystem9 = solarSystems[8];
        planetbutton9.setTranslationX(90 + solarSystem9.getCoordinates().getX() * 9);
        planetbutton9.setTranslationY(90 + solarSystem9.getCoordinates().getY() * 9);
        planetbutton9.setText(solarSystem9.getName());

        SolarSystem solarSystem10 = solarSystems[9];
        planetbutton10.setTranslationX(100 + solarSystem10.getCoordinates().getX() * 10);
        planetbutton10.setTranslationY(100 + solarSystem10.getCoordinates().getY() * 10);
        planetbutton10.setText(solarSystem10.getName());

    }

    /**
     * Attempts to travel the player to the specified planet
     *
     * @param planetNum index + 1 in the array of the planet the player is attempting to travel to
     */
    private void travelAttempted(int planetNum) {
        SolarSystem[] solarSystems = this.universe.getUniverse().values().toArray(new SolarSystem[0]);

        //if player's current solarsystem is the button clicked, nothing happens
        if (player.getSolarSystem().equals(solarSystems[planetNum - 1])) {
            Toast.makeText(this, "Currently on this planet", Toast.LENGTH_LONG).show();
            return;
        }


        //calculates fuel costs
        TravelInteractor travelCostCalculator = new TravelInteractor(player.getSolarSystem(),
                solarSystems[planetNum - 1]);

        int fuelCost = travelCostCalculator.calculateFuelCosts();
        String fuelMessage = "Traveling to planet " + solarSystems[planetNum - 1].getName()
                + " will cost " + fuelCost + " fuel";

        int subtracted = 0;

        //subtracts fuel cost from player's fuel, breaks loop if out of fuel
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
            player.setSolarSystem(solarSystems[planetNum - 1]);
            Intent intent = new Intent(TravelActivity.this, MarketActivity.class);
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
        travelAttempted(1);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 2
     *
     * @param view the button clicked
     */
    public void onPlanetButton2Pressed(View view) {
        travelAttempted(2);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 3
     *
     * @param view the button clicked
     */
    public void onPlanetButton3Pressed(View view) {
        travelAttempted(3);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 4
     *
     * @param view the button clicked
     */
    public void onPlanetButton4Pressed(View view) {
        travelAttempted(4);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 5
     *
     * @param view the button clicked
     */
    public void onPlanetButton5Pressed(View view) {
        travelAttempted(5);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 6
     *
     * @param view the button clicked
     */
    public void onPlanetButton6Pressed(View view) {
        travelAttempted(6);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 7
     *
     * @param view the button clicked
     */
    public void onPlanetButton7Pressed(View view) {
        travelAttempted(7);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 8
     *
     * @param view the button clicked
     */
    public void onPlanetButton8Pressed(View view) {
        travelAttempted(8);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 9
     *
     * @param view the button clicked
     */
    public void onPlanetButton9Pressed(View view) {
        travelAttempted(9);
    }
    /**
     * On button press, calls a travel attempt between current planet and planet 10
     *
     * @param view the button clicked
     */
    public void onPlanetButton10Pressed(View view) {
        travelAttempted(10);
    }



}
