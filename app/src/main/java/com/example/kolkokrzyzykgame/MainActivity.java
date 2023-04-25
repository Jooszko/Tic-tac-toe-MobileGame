package com.example.kolkokrzyzykgame;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btnStartGameAi, btnStartGamePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getIntent().hasExtra(GameWithPlayer.WHOWIN)){
//            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//            alertDialogBuilder.setTitle("Gratulacje wygrywa gracz nr " + getIntent().getStringExtra(GameWithPlayer.WHOWIN));
//            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//
//                }
//            });
//            alertDialogBuilder.show();





        }

        btnStartGameAi = findViewById(R.id.gameWithAi);
        btnStartGamePlayer = findViewById(R.id.gameWithPlayer);

        Intent intentAi = new Intent(MainActivity.this, GameWithAi.class);
        Intent intentPlayer = new Intent(MainActivity.this, GameWithPlayer.class);

        btnStartGameAi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentAi);
            }
        });

        btnStartGamePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentPlayer);
            }
        });



    }
}