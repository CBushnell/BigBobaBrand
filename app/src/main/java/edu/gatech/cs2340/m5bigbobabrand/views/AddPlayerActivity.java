package edu.gatech.cs2340.m5bigbobabrand.views;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AddPlayerActivity extends AppCompatActivity {

    public void onCancelPressed(View view) {
        onBackPressed();
    }
}

//Intent intent = new Intent(this, ViewAllStudentsActivity.class);
//            startActivity(intent);