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
    MarketInteractor marketInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        this.player = (Player) getIntent().getSerializableExtra("PLAYER");
        this.marketInteractor = new MarketInteractor(this.player);
        credits_header = findViewById(R.id.credits_header);
        credits_header.setText(Integer.toString(player.getCredits()));

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

    public void onBuyFoodPressed(View view) {
        Log.d("Press", "buy food pressed");
        if(this.marketInteractor.buy(Item.FOOD)) {
            food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
            food_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FOOD)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellFoodPressed(View view) {
        Log.d("Press", "sell food pressed");
        if(this.marketInteractor.sell(Item.FOOD)) {
            food_ship_header.setText(Integer.toString(player.numberOf(Item.FOOD)));
            food_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FOOD)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onBuyOrePressed(View view) {
        Log.d("Press", "buy ore pressed");
        if(this.marketInteractor.buy(Item.ORE)) {
            ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
            ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellOrePressed(View view) {
        Log.d("Press", "sell ore pressed");
        if(this.marketInteractor.sell(Item.ORE)) {
            ore_ship_header.setText(Integer.toString(player.numberOf(Item.ORE)));
            ore_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ORE)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onBuyGamesPressed(View view) {
        Log.d("Press", "buy games pressed");
        if(this.marketInteractor.buy(Item.GAMES)) {
            games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
            games_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.GAMES)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellGamesPressed(View view) {
        Log.d("Press", "sell games pressed");
        if(this.marketInteractor.sell(Item.GAMES)) {
            games_ship_header.setText(Integer.toString(player.numberOf(Item.GAMES)));
            games_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.GAMES)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onBuyFirearmsPressed(View view) {
        Log.d("Press", "buy firearms pressed");
        if(this.marketInteractor.buy(Item.FIREARMS)) {
            firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
            firearms_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FIREARMS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellFirearmsPressed(View view) {
        Log.d("Press", "sell firearms pressed");
        if(this.marketInteractor.sell(Item.FIREARMS)) {
            firearms_ship_header.setText(Integer.toString(player.numberOf(Item.FIREARMS)));
            firearms_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.FIREARMS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }

    public void onBuyMedicinePressed(View view) {
        Log.d("Press", "buy medicine pressed");
        if(this.marketInteractor.buy(Item.MEDICINE)) {
            medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
            medicine_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MEDICINE)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellMedicinePressed(View view) {
        Log.d("Press", "sell medicine pressed");
        if(this.marketInteractor.sell(Item.MEDICINE)) {
            medicine_ship_header.setText(Integer.toString(player.numberOf(Item.MEDICINE)));
            medicine_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MEDICINE)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }

    public void onBuyMachinesPressed(View view) {
        Log.d("Press", "buy machines pressed");
        if(this.marketInteractor.buy(Item.MACHINES)) {
            machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
            machines_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MACHINES)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellMachinesPressed(View view) {
        Log.d("Press", "sell machines pressed");
        if(this.marketInteractor.sell(Item.MACHINES)) {
            machines_ship_header.setText(Integer.toString(player.numberOf(Item.MACHINES)));
            machines_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.MACHINES)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }

    public void onBuyNarcoticsPressed(View view) {
        Log.d("Press", "buy narcotics pressed");
        if(this.marketInteractor.buy(Item.NARCOTICS)) {
            narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
            narcotics_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.NARCOTICS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellNarcoticsPressed(View view) {
        Log.d("Press", "sell narcotics pressed");
        if(this.marketInteractor.sell(Item.NARCOTICS)) {
            narcotics_ship_header.setText(Integer.toString(player.numberOf(Item.NARCOTICS)));
            narcotics_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.NARCOTICS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }

    public void onBuyRobotsPressed(View view) {
        Log.d("Press", "buy robots pressed");
        if(this.marketInteractor.buy(Item.ROBOTS)) {
            robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
            robots_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ROBOTS)));
            credits_header.setText(Integer.toString(player.getCredits()));
        }
    }
    public void onSellRobotsPressed(View view) {
        Log.d("Press", "sell robots pressed");
        if(this.marketInteractor.sell(Item.ROBOTS)) {
            robots_ship_header.setText(Integer.toString(player.numberOf(Item.ROBOTS)));
            robots_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.ROBOTS)));
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
