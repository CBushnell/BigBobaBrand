package edu.gatech.cs2340.m5bigbobabrand.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.m5bigbobabrand.Model.GameState;
import edu.gatech.cs2340.m5bigbobabrand.Model.MarketInteractor;
import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Item;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;
import edu.gatech.cs2340.m5bigbobabrand.entity.SolarSystem;

/**
 * @author One of us
 * @version 1
 *
 * Handles the screen presentation of the market and its interactions with the player
 */
public class MarketActivity extends AppCompatActivity {
    private Player player;
    private TextView water_price_header;
    private TextView water_store_header;
    private TextView water_ship_header;
    private TextView furs_price_header;
    private TextView furs_store_header;
    private TextView furs_ship_header;
    private TextView food_price_header;
    private TextView food_store_header;
    private TextView food_ship_header;
    private TextView ore_price_header;
    private TextView ore_store_header;
    private TextView ore_ship_header;
    private TextView games_price_header;
    private TextView games_store_header;
    private TextView games_ship_header;
    private TextView firearms_price_header;
    private TextView firearms_store_header;
    private TextView firearms_ship_header;
    private TextView medicine_price_header;
    private TextView medicine_store_header;
    private TextView medicine_ship_header;
    private TextView machines_price_header;
    private TextView machines_store_header;
    private TextView machines_ship_header;
    private TextView narcotics_price_header;
    private TextView narcotics_store_header;
    private TextView narcotics_ship_header;
    private TextView robots_price_header;
    private TextView robots_store_header;
    private TextView robots_ship_header;
    private TextView fuel_price_header;
    private TextView fuel_store_header;
    private TextView fuel_ship_header;



    private TextView credits_header;
    private TextView curr_cargo_header;
    private TextView max_cargo_header;
    private TextView current_fuel_number;
    private MarketInteractor marketInteractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        this.player = GameState.myGame.getPlayer();
        SolarSystem solarSystem = player.getSolarSystem();
        Bundle extras = this.getIntent().getExtras();
        if (extras != null) {
            boolean randomEventHappened = extras.getBoolean("RANDOM");
            if (randomEventHappened) {
                Toast.makeText(this, "Your ship "
                        + "was yeeted and you lost credits", Toast.LENGTH_LONG).show();
            }
        }
        this.marketInteractor = new MarketInteractor(this.player);
        credits_header = findViewById(R.id.credits_header);
        credits_header.setText(Integer.toString(player.getCredits()));
        TextView ie_header = findViewById(R.id.ie_header);
        ie_header.setText(marketInteractor.getIe().getIEName());
        TextView tech_level_header = findViewById(R.id.tech_level_header);
        tech_level_header.setText(solarSystem.getTechLevel().getTechLevelName());
        TextView planet_header = findViewById(R.id.planet_header);
        planet_header.setText(solarSystem.getName());
        curr_cargo_header = findViewById(R.id.total_cargo_header);
        max_cargo_header = findViewById(R.id.max_cargo_header);
        TextView current_fuel_header = findViewById(R.id.current_fuel);
        current_fuel_number = findViewById(R.id.current_fuel_number);
        current_fuel_number.setText(Integer.toString(player.numberOf(Item.FUEL)));
        updateCargo();

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
        fuel_price_header = findViewById(R.id.fuel_price_header);
        fuel_store_header = findViewById(R.id.fuel_store_header);
        fuel_ship_header = findViewById(R.id.fuel_ship_header);
        fuelSetUp();
    }

    /**
     * Updates cargo
     */
    private void updateCargo() {
        curr_cargo_header.setText(Integer.toString(player.getCargo()));
        max_cargo_header.setText(Integer.toString(player.getMaxCargo()));
        current_fuel_number.setText(Integer.toString(player.numberOf(Item.FUEL)));
    }

    /**
     * Handles buying of water
     * @param view the current view
     */
    public void onBuyWaterPressed(View view) {
        Log.d("Press", "buy water pressed");
        if(this.marketInteractor.buy(Item.WATER)) {
            water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
            water_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.WATER)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.WATER) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.WATER) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.WATER)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of water
     * @param view the current view
     */
    public void onSellWaterPressed(View view) {
        Log.d("Press", "sell water pressed");
        if (this.marketInteractor.sell(Item.WATER)) {
            water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
            water_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.WATER)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.WATER)) {
            Toast.makeText(this, "You don't have any water to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.WATER) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of furs
     * @param view the current view
     */
    public void onBuyFursPressed(View view) {
        Log.d("Press", "buy furs pressed");
        if(this.marketInteractor.buy(Item.FURS)) {
            furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
            furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.FURS)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.FURS) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.FURS) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of furs
     * @param view the current view
     */
    public void onSellFursPressed(View view) {
        Log.d("Press", "sell furs pressed");
        if(this.marketInteractor.sell(Item.FURS)) {
            furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
            furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.FURS)) {
            Toast.makeText(this, "You don't have any fur to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.FURS) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of food
     * @param view the current view
     */
    public void onBuyFoodPressed(View view) {
        Log.d("Press", "buy food pressed");
        if(this.marketInteractor.buy(Item.FOOD)) {
            food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
            food_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.FOOD)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.FOOD)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.FOOD) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.FOOD) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of food
     * @param view the current view
     */
    public void onSellFoodPressed(View view) {
        Log.d("Press", "sell food pressed");
        if(this.marketInteractor.sell(Item.FOOD)) {
            food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
            food_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FOOD)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.has(Item.FOOD)) {
            Toast.makeText(this, "You don't have any food to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.FOOD) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of ore
     * @param view the current view
     */
    public void onBuyOrePressed(View view) {
        Log.d("Press", "buy ore pressed");
        if(this.marketInteractor.buy(Item.ORE)) {
            ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
            ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.ORE)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.ORE) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.ORE) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of ore
     * @param view the current view
     */
    public void onSellOrePressed(View view) {
        Log.d("Press", "sell ore pressed");
        if(this.marketInteractor.sell(Item.ORE)) {
            ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
            ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.has(Item.ORE)) {
            Toast.makeText(this, "You don't have any ore to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.ORE) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of games
     * @param view the current view
     */
    public void onBuyGamesPressed(View view) {
        Log.d("Press", "buy games pressed");
        if(this.marketInteractor.buy(Item.GAMES)) {
            games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
            games_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.GAMES)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.GAMES)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.GAMES) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.GAMES) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of games
     * @param view the current view
     */
    public void onSellGamesPressed(View view) {
        Log.d("Press", "sell games pressed");
        if(this.marketInteractor.sell(Item.GAMES)) {
            games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
            games_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.GAMES)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.has(Item.GAMES)) {
            Toast.makeText(this, "You don't have any games to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.GAMES) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of firearms
     * @param view the current view
     */
    public void onBuyFirearmsPressed(View view) {
        Log.d("Press", "buy firearms pressed");
        if(this.marketInteractor.buy(Item.FIREARMS)) {
            firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
            firearms_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.FIREARMS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.FIREARMS)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.FIREARMS) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.FIREARMS) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of firearms
     * @param view the current view
     */
    public void onSellFirearmsPressed(View view) {
        Log.d("Press", "sell firearms pressed");
        if(this.marketInteractor.sell(Item.FIREARMS)) {
            firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
            firearms_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.FIREARMS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.has(Item.FIREARMS)) {
            Toast.makeText(this, "You don't have any firearms to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.FIREARMS) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of medicine
     * @param view the current view
     */
    public void onBuyMedicinePressed(View view) {
        Log.d("Press", "buy medicine pressed");
        if(this.marketInteractor.buy(Item.MEDICINE)) {
            medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
            medicine_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.MEDICINE)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.MEDICINE)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.MEDICINE) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.MEDICINE) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of meds
     * @param view the current view
     */
    public void onSellMedicinePressed(View view) {
        Log.d("Press", "sell medicine pressed");
        if(this.marketInteractor.sell(Item.MEDICINE)) {
            medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
            medicine_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.MEDICINE)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.MEDICINE)) {
            Toast.makeText(this, "You don't have any medicine to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.MEDICINE) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of machines
     * @param view the current view
     */
    public void onBuyMachinesPressed(View view) {
        Log.d("Press", "buy machines pressed");
        if(this.marketInteractor.buy(Item.MACHINES)) {
            machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
            machines_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.MACHINES)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.MACHINES)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.MACHINES) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.MACHINES) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of machines
     * @param view the current view
     */
    public void onSellMachinesPressed(View view) {
        Log.d("Press", "sell machines pressed");
        if(this.marketInteractor.sell(Item.MACHINES)) {
            machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
            machines_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.MACHINES)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.MACHINES)) {
            Toast.makeText(this, "You don't have any machines to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.MACHINES) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of narcotics
     * @param view the current view
     */
    public void onBuyNarcoticsPressed(View view) {
        Log.d("Press", "buy narcotics pressed");
        if(this.marketInteractor.buy(Item.NARCOTICS)) {
            narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
            narcotics_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.NARCOTICS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.NARCOTICS)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.NARCOTICS) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.NARCOTICS) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of narcotics
     * @param view the current view
     */
    public void onSellNarcoticsPressed(View view) {
        Log.d("Press", "sell narcotics pressed");
        if(this.marketInteractor.sell(Item.NARCOTICS)) {
            narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
            narcotics_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.NARCOTICS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.NARCOTICS)) {
            Toast.makeText(this, "You don't have any narcotics to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.NARCOTICS) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of robots
     * @param view the current view
     */
    public void onBuyRobotsPressed(View view) {
        Log.d("Press", "buy robots pressed");
        if(this.marketInteractor.buy(Item.ROBOTS)) {
            robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
            robots_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.ROBOTS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.ROBOTS)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.ROBOTS) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.ROBOTS) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of robots
     * @param view the current view
     */
    public void onSellRobotsPressed(View view) {
        Log.d("Press", "sell robots pressed");
        if(this.marketInteractor.sell(Item.ROBOTS)) {
            robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
            robots_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.ROBOTS)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.ROBOTS)) {
            Toast.makeText(this, "You don't have any robots to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.ROBOTS) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles buying of fuel
     * @param view the current view
     */
    public void onBuyFuelPressed(View view) {
        Log.d("Press", "buy fuel pressed");
        if(this.marketInteractor.buy(Item.FUEL)) {
            fuel_ship_header.setText(Integer.toString(player.numberOf(Item.FUEL)));
            fuel_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FUEL)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (player.getCargo() >= player.getMaxCargo()) {
            Toast.makeText(this, "Ship cargo is already full!",
                    Toast.LENGTH_LONG).show();
        } else if ((this.marketInteractor.getPrice(Item.FUEL) <= 0)
                || (this.marketInteractor.marketNumberOf(Item.FUEL) <= 0)) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        } else if (player.getCredits() < this.marketInteractor.getPrice(Item.FUEL)) {
            Toast.makeText(this, "You do not have enough credits!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Handles selling of fuel
     * @param view the current view
     */
    public void onSellFuelPressed(View view) {
        Log.d("Press", "sell fuel pressed");
        if(this.marketInteractor.sell(Item.FUEL)) {
            fuel_ship_header.setText(Integer.toString(player.numberOf(Item.FUEL)));
            fuel_store_header.setText(Integer.toString(
                    marketInteractor.marketNumberOf(Item.FUEL)));
            credits_header.setText(Integer.toString(player.getCredits()));
            updateCargo();
        } else if (!player.getShip().has(Item.FUEL)) {
            Toast.makeText(this, "You don't have any fuel to sell!",
                    Toast.LENGTH_LONG).show();
        } else if (this.marketInteractor.getPrice(Item.FUEL) < 0) {
            Toast.makeText(this, "Item unavailable in this market!",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Sets screen presentation of water
     */
    private void waterSetUp() {
        if (marketInteractor.getPrice(Item.WATER) == -1 ) {
            water_price_header.setText("X");
        } else {
            water_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.WATER)));
        }
        water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
        water_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.WATER)));
    }

    /**
     * Sets screen presentation of furs
     */
    private void fursSetUp() {
        if (marketInteractor.getPrice(Item.FURS) == -1 ) {
            furs_price_header.setText("X");
        } else {
            furs_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FURS)));
        }
        furs_ship_header.setText(Integer.toString(player.numberOf(Item.FURS)));
        furs_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FURS)));
    }

    /**
     * Sets screen presentation of food
     */
    private void foodSetUp() {
        if (marketInteractor.getPrice(Item.FOOD) == -1 ) {
            food_price_header.setText("X");
        } else {
            food_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FOOD)));
        }
        food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
        food_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FOOD)));
    }

    /**
     * Sets up ore presentation
     */
    @SuppressLint("SetTextI18n")
    private void oreSetUp() {
        if (marketInteractor.getPrice(Item.ORE) == -1 ) {
            ore_price_header.setText("X");
        } else {
            ore_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.ORE)));
        }
        ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
        ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
    }

    /**
     * Sets screen presentation of games
     */
    private void gamesSetUp() {
        if (marketInteractor.getPrice(Item.GAMES) == -1 ) {
            games_price_header.setText("X");
        } else {
            games_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.GAMES)));
        }
        games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
        games_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.GAMES)));
    }

    /**
     * Sets screen presentation of firearms
     */
    private void firearmsSetUp() {
        if (marketInteractor.getPrice(Item.FIREARMS) == -1 ) {
            firearms_price_header.setText("X");
        } else {
            firearms_price_header.setText(Integer.toString(
                    marketInteractor.getPrice(Item.FIREARMS)));
        }
        firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
        firearms_store_header.setText(Integer.toString(
                marketInteractor.marketNumberOf(Item.FIREARMS)));
    }

    /**
     * Sets screen presentation of medicine
     */
    private void medicineSetUp() {
        if (marketInteractor.getPrice(Item.MEDICINE) == -1 ) {
            medicine_price_header.setText("X");
        } else {
            medicine_price_header.setText(Integer.toString(
                    marketInteractor.getPrice(Item.MEDICINE)));
        }
        medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
        medicine_store_header.setText(Integer.toString(
                marketInteractor.marketNumberOf(Item.MEDICINE)));
    }

    /**
     * Sets screen presentation of machines
     */
    private void machinesSetUp() {
        if (marketInteractor.getPrice(Item.MACHINES) == -1 ) {
            machines_price_header.setText("X");
        } else {
            machines_price_header.setText(Integer.toString(
                    marketInteractor.getPrice(Item.MACHINES)));
        }
        machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
        machines_store_header.setText(Integer.toString(
                marketInteractor.marketNumberOf(Item.MACHINES)));
    }

    /**
     * Sets screen presentation of narcotics
     */
    private void narcoticsSetUp() {
        if (marketInteractor.getPrice(Item.NARCOTICS) == -1 ) {
            narcotics_price_header.setText("X");
        } else {
            narcotics_price_header.setText(Integer.toString(
                    marketInteractor.getPrice(Item.NARCOTICS)));
        }
        narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
        narcotics_store_header.setText(Integer.toString(
                marketInteractor.marketNumberOf(Item.NARCOTICS)));
    }

    /**
     * Sets screen presentation of fuel
     */
    private void fuelSetUp() {
        if (marketInteractor.getPrice(Item.FUEL) == -1 ) {
            fuel_price_header.setText("X");
        } else {
            fuel_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.FUEL)));
        }
        fuel_ship_header.setText(Integer.toString(player.numberOf(Item.FUEL)));
        fuel_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FUEL)));
    }

    /**
     * Sets screen presentation of robots
     */
    private void robotsSetUp() {
        if (marketInteractor.getPrice(Item.ROBOTS) == -1 ) {
            robots_price_header.setText("X");
        } else {
            robots_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.ROBOTS)));
        }
        robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
        robots_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ROBOTS)));
    }

    /**
     * Switches intent to TravelActivity
     * @param view the current view
     */
    public void onTravelPressed(View view) {
        Intent intent = new Intent(MarketActivity.this, TravelActivity.class);
        this.startActivity(intent);
    }

}
