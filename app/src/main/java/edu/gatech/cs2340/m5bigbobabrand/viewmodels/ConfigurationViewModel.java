package edu.gatech.cs2340.m5bigbobabrand.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.m5bigbobabrand.entity.Universe;
import edu.gatech.cs2340.m5bigbobabrand.entity.Player;

public class ConfigurationViewModel extends AndroidViewModel {
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }
    /**
    public setGameState(Universe universe, Player player) {
        GameState(universe, player);
    }
     **/
}
