package edu.gatech.cs2340.m5bigbobabrand.views;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import edu.gatech.cs2340.m5bigbobabrand.Model.GameState;
import edu.gatech.cs2340.m5bigbobabrand.R;
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


}
