package edu.gatech.cs2340.m5bigbobabrand.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import edu.gatech.cs2340.m5bigbobabrand.R;
import edu.gatech.cs2340.m5bigbobabrand.entity.Difficulty;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;

public class MainActivity extends AppCompatActivity {


    /**
     * UI Items
     */
    private Spinner difficultySpinner;
    private EditText nameField;
    private EditText pilotField;
    private EditText fighterField;
    private EditText traderField;
    private EditText engineerField;



    /**
     *Data for player being edited
     *
     */
    private Player player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nameField = findViewById(R.id.player_name_input);
        pilotField = findViewById(R.id.pilot_field);
        fighterField = findViewById(R.id.fighter_field);
        traderField = findViewById(R.id.trader_field);
        engineerField = findViewById(R.id.engineer_field);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        Difficulty[] difficultyList = Difficulty.values();
        String[] difficultyStrings = new String[difficultyList.length];
        for (int i = 0; i < difficultyStrings.length; i++) {
            difficultyStrings[i] = difficultyList[i].getString();
        }
        ArrayAdapter<String> difficultyArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, difficultyStrings);
        difficultyArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(difficultyArrayAdapter);
        /* Check for student being passed in */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**
     * Button handler for the add new student button
     *
     * @param view the button that was pressed
     */
    public void onCreatePressed(View view) {
        Log.d("Edit", "Create Player Pressed");
        this.player = new Player();
        player.setName(nameField.getText().toString());
        String chosenDiffString = (String) difficultySpinner.getSelectedItem();
        Difficulty[] difficultyList = Difficulty.values();
        for (Difficulty d: difficultyList) {
            if(chosenDiffString.equals(d.getString())) {
                player.setDifficulty(d);
                break;
            }
        }
        player.setEngineerPts(Integer.parseInt(engineerField.getText().toString()));
        player.setFighterPts(Integer.parseInt(fighterField.getText().toString()));
        player.setPilotPts(Integer.parseInt(pilotField.getText().toString()));
        player.setTraderPts(Integer.parseInt(traderField.getText().toString()));
        if(!player.verifySum()) {
            throw new IllegalArgumentException("INPUTS WRONG");
        }

        Log.d("Edit", "Name:" + player.getName() + "\nPilot Points: "
                + player.getPilotPts() + "\nFighter Points: " + player.getFighterPts()
                +  "\nTrader Points: " + player.getTraderPts() +
                "\nEngineer Points: " + player.getEngineerPts()
                + "\n Difficulty: " + player.getDifficulty().getString());

        finish();
    }
}
