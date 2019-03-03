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
    TextView credits_header;
    MarketInteractor marketInteractor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        water_price_header = findViewById(R.id.water_price_header);
        water_store_header = findViewById(R.id.water_store_header);
        water_ship_header = findViewById(R.id.water_ship_header);
        credits_header = findViewById(R.id.credits_header);
        /*
        THIS WILL ALL HAVE TO BE MOVED TO THE VIEWMODEL BUT I DON'T KNOW HOW AND I'M VERY TIRED
         */
        this.player = new Player();
        player.setSolarSystem(new SolarSystem(new Coordinates()));
        //this.player = (Player) getIntent().getSerializableExtra("PLAYER");
        this.marketInteractor = new MarketInteractor(this.player);

        //getPrice method returns -1 if you cannot buy from this planet
        if (marketInteractor.getPrice(Item.WATER) == -1 ) {
            water_price_header.setText("CANNOT BUY");
        } else {


            water_price_header.setText(Integer.toString(marketInteractor.getPrice(Item.WATER)));
        }

        water_ship_header.setText(Integer.toString(player.numberOf(Item.WATER)));
        water_store_header.setText(Integer.toString(marketInteractor.marketNumberOf(Item.WATER)));
        credits_header.setText(Integer.toString(player.getCredits()));

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
}
