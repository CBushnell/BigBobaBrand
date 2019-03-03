package edu.gatech.cs2340.m5bigbobabrand.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.m5bigbobabrand.Model.MarketInteractor;
import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Coordinates;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

public class MarketActivity extends AppCompatActivity {
    private Player player;
    TextView water_price_header;
    TextView water_store_header;
    TextView water_ship_header;
    TextView furs_price_header;
    TextView furs_store_header;
    TextView furs_ship_header;
    TextView food_price_header;
    TextView food_store_header;
    TextView food_ship_header;
    TextView ore_price_header;
    TextView ore_store_header;
    TextView ore_ship_header;
    TextView games_price_header;
    TextView games_store_header;
    TextView games_ship_header;
    TextView firearms_price_header;
    TextView firearms_store_header;
    TextView firearms_ship_header;
    TextView medicine_price_header;
    TextView medicine_store_header;
    TextView medicine_ship_header;
    TextView machines_price_header;
    TextView machines_store_header;
    TextView machines_ship_header;
    TextView narcotics_price_header;
    TextView narcotics_store_header;
    TextView narcotics_ship_header;
    TextView robots_price_header;
    TextView robots_store_header;
    TextView robots_ship_header;



    TextView credits_header;
    TextView ie_header;
    TextView tech_level_header;
    TextView planet_header;
    TextView curr_cargo_header;
    TextView max_cargo_header;
    MarketInteractor marketInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        this.player = (Player) getIntent().getSerializableExtra("PLAYER");
        this.marketInteractor = new MarketInteractor(this.player);
        credits_header = findViewById(R.id.credits_header);
        credits_header.setText(Integer.toString(player.getCredits()));
        ie_header = findViewById(R.id.ie_header);
        ie_header.setText(marketInteractor.getIe().getIEName());
        tech_level_header = findViewById(R.id.tech_level_header);
        tech_level_header.setText(player.getSolarSystem().getTechLevel().getTechLevelName());
        planet_header = findViewById(R.id.planet_header);
        planet_header.setText(player.getSolarSystem().getName());
        curr_cargo_header = findViewById(R.id.total_cargo_header);
        curr_cargo_header.setText(Integer.toString(player.getCargo()));
        max_cargo_header = findViewById(R.id.max_cargo_header);
        curr_cargo_header.setText(Integer.toString(player.getMaxCargo()));


        water_price_header = findViewById(R.id.water_price_header);
        water_store_header = findViewById(R.id.water_store_header);
        water_ship_header = findViewById(R.id.water_ship_header);
        waterSetUp();
        furs_price_header = findViewById(R.id.furs_price_header);
        furs_store_header = findViewById(R.id.furs_store_header);
        furs_ship_header = findViewById(R.id.furs_ship_header);
        fursSetUp();
        food_price_header = findViewById(R.id.food_price_header);
        food_store_header = findViewById(R.id.food_store_header);
        food_ship_header = findViewById(R.id.food_ship_header);
        foodSetUp();
        ore_price_header = findViewById(R.id.ore_price_header);
        ore_store_header = findViewById(R.id.ore_store_header);
        ore_ship_header = findViewById(R.id.ore_ship_header);
        oreSetUp();
        games_price_header = findViewById(R.id.games_price_header);
        games_store_header = findViewById(R.id.games_store_header);
        games_ship_header = findViewById(R.id.games_ship_header);
        gamesSetUp();
        firearms_price_header = findViewById(R.id.firearms_price_header);
        firearms_store_header = findViewById(R.id.firearms_store_header);
        firearms_ship_header = findViewById(R.id.firearms_ship_header);
        firearmsSetUp();
        medicine_price_header = findViewById(R.id.medicine_price_header);
        medicine_store_header = findViewById(R.id.medicine_store_header);
        medicine_ship_header = findViewById(R.id.medicine_ship_header);
        medicineSetUp();
        machines_price_header = findViewById(R.id.machines_price_header);
        machines_store_header = findViewById(R.id.machines_store_header);
        machines_ship_header = findViewById(R.id.machines_ship_header);
        machinesSetUp();
        narcotics_price_header = findViewById(R.id.narcotics_price_header);
        narcotics_store_header = findViewById(R.id.narcotics_store_header);
        narcotics_ship_header = findViewById(R.id.narcotics_ship_header);
        narcoticsSetUp();
        robots_price_header = findViewById(R.id.robots_price_header);
        robots_store_header = findViewById(R.id.robots_store_header);
        robots_ship_header = findViewById(R.id.robots_ship_header);
        robotsSetUp();



    }
    public void onBuyWaterPressed(View view) {
        Log.d("Press", "buy water pressed");
        if(this.marketInteractor.buy(Item.WATER)) {
            water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
            water_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.WATER)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellWaterPressed(View view) {
        Log.d("Press", "sell water pressed");
        if(this.marketInteractor.sell(Item.WATER)) {
            water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
            water_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.WATER)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }

    public void onBuyFursPressed(View view) {
        Log.d("Press", "buy furs pressed");
        if(this.marketInteractor.buy(Item.FURS)) {
            furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
            furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellFursPressed(View view) {
        Log.d("Press", "sell furs pressed");
        if(this.marketInteractor.sell(Item.FURS)) {
            furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
            furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    private void waterSetUp() {
        if (marketInteractor.getPrice(Item.WATER) == -1 ) {
            water_price_header.setText("X");
        } else {
            water_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.WATER)));
        }
        water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
        water_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.WATER)));
    }

    private void fursSetUp() {
        if (marketInteractor.getPrice(Item.FURS) == -1 ) {
            furs_price_header.setText("X");
        } else {
            furs_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FURS)));
        }
        furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
        furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
    }

    private void foodSetUp() {
        if (marketInteractor.getPrice(Item.FOOD) == -1 ) {
            food_price_header.setText("X");
        } else {
            food_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FOOD)));
        }
        food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
        food_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FOOD)));
    }

    private void oreSetUp() {
        if (marketInteractor.getPrice(Item.ORE) == -1 ) {
            ore_price_header.setText("X");
        } else {
            ore_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.ORE)));
        }
        ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
        ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
    }

    private void gamesSetUp() {
        if (marketInteractor.getPrice(Item.GAMES) == -1 ) {
            games_price_header.setText("X");
        } else {
            games_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.GAMES)));
        }
        games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
        games_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.GAMES)));
    }

    private void firearmsSetUp() {
        if (marketInteractor.getPrice(Item.FIREARMS) == -1 ) {
            firearms_price_header.setText("X");
        } else {
            firearms_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FIREARMS)));
        }
        firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
        firearms_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FIREARMS)));
    }

    private void medicineSetUp() {
        if (marketInteractor.getPrice(Item.MEDICINE) == -1 ) {
            medicine_price_header.setText("X");
        } else {
            medicine_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.MEDICINE)));
        }
        medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
        medicine_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MEDICINE)));
    }

    private void machinesSetUp() {
        if (marketInteractor.getPrice(Item.MACHINES) == -1 ) {
            machines_price_header.setText("X");
        } else {
            machines_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.MACHINES)));
        }
        machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
        machines_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MACHINES)));
    }

    private void narcoticsSetUp() {
        if (marketInteractor.getPrice(Item.NARCOTICS) == -1 ) {
            narcotics_price_header.setText("X");
        } else {
            narcotics_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.NARCOTICS)));
        }
        narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
        narcotics_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.NARCOTICS)));
    }

    private void robotsSetUp() {
        if (marketInteractor.getPrice(Item.ROBOTS) == -1 ) {
            robots_price_header.setText("X");
        } else {
            robots_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.ROBOTS)));
        }
        robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
        robots_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ROBOTS)));
    }

}
