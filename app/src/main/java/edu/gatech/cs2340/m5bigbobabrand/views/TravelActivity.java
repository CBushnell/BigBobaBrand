package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
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
    TextView current_fuel_header;
    TextView current_fuel_text_header;


    private Player player;
    private Universe universe;

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
        planetbutton1.setTranslationX(140 + solarSystem1.getCoordinates().getX() * 8);
        planetbutton1.setTranslationY(560 + solarSystem1.getCoordinates().getY() * 8);
        planetbutton1.setText(solarSystem1.getName());


        SolarSystem solarSystem2 = solarSystems[1];
        planetbutton2.setTranslationX(140 + solarSystem2.getCoordinates().getX() * 8);
        planetbutton2.setTranslationY(560 + solarSystem2.getCoordinates().getY() * 8);
        planetbutton2.setText(solarSystem2.getName());

        SolarSystem solarSystem3 = solarSystems[2];
        planetbutton3.setTranslationX(140 + solarSystem3.getCoordinates().getX() * 8);
        planetbutton3.setTranslationY(560 + solarSystem3.getCoordinates().getY() * 8);
        planetbutton3.setText(solarSystem3.getName());

        SolarSystem solarSystem4 = solarSystems[3];
        planetbutton4.setTranslationX(140 + solarSystem4.getCoordinates().getX() * 8);
        planetbutton4.setTranslationY(560 + solarSystem4.getCoordinates().getY() * 8);
        planetbutton4.setText(solarSystem4.getName());

        SolarSystem solarSystem5 = solarSystems[4];
        planetbutton5.setTranslationX(140 + solarSystem5.getCoordinates().getX() * 8);
        planetbutton5.setTranslationY(560 + solarSystem5.getCoordinates().getY() * 8);
        planetbutton5.setText(solarSystem5.getName());

        SolarSystem solarSystem6 = solarSystems[5];
        planetbutton6.setTranslationX(140 + solarSystem6.getCoordinates().getX() * 8);
        planetbutton6.setTranslationY(560 + solarSystem6.getCoordinates().getY() * 8);
        planetbutton6.setText(solarSystem6.getName());

        SolarSystem solarSystem7 = solarSystems[6];
        planetbutton7.setTranslationX(140 + solarSystem7.getCoordinates().getX() * 8);
        planetbutton7.setTranslationY(560 + solarSystem7.getCoordinates().getY() * 8);
        planetbutton7.setText(solarSystem7.getName());

        SolarSystem solarSystem8 = solarSystems[7];
        planetbutton8.setTranslationX(140 + solarSystem8.getCoordinates().getX() * 8);
        planetbutton8.setTranslationY(560 + solarSystem8.getCoordinates().getY() * 8);
        planetbutton8.setText(solarSystem8.getName());

        SolarSystem solarSystem9 = solarSystems[8];
        planetbutton9.setTranslationX(140 + solarSystem9.getCoordinates().getX() * 9);
        planetbutton9.setTranslationY(560 + solarSystem9.getCoordinates().getY() * 9);
        planetbutton9.setText(solarSystem9.getName());

        SolarSystem solarSystem10 = solarSystems[9];
        planetbutton10.setTranslationX(140 + solarSystem10.getCoordinates().getX() * 10);
        planetbutton10.setTranslationY(560 + solarSystem10.getCoordinates().getY() * 10);
        planetbutton10.setText(solarSystem10.getName());

        if (solarSystem1.equals(player.getSolarSystem())) {
            planetbutton1.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem2.equals(player.getSolarSystem())) {
            planetbutton2.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem3.equals(player.getSolarSystem())) {
            planetbutton3.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem4.equals(player.getSolarSystem())) {
            planetbutton4.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem5.equals(player.getSolarSystem())) {
            planetbutton5.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem6.equals(player.getSolarSystem())) {
            planetbutton6.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem7.equals(player.getSolarSystem())) {
            planetbutton7.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem8.equals(player.getSolarSystem())) {
            planetbutton8.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem9.equals(player.getSolarSystem())) {
            planetbutton9.setTextColor(Color.rgb(218,165,32));
        } else if (solarSystem10.equals(player.getSolarSystem())) {
            planetbutton10.setTextColor(Color.rgb(218,165,32));
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



}
