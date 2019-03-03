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
}
