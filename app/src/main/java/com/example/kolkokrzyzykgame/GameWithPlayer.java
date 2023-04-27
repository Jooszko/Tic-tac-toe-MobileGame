package com.example.kolkokrzyzykgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameWithPlayer extends AppCompatActivity {

    public static String WHOWIN = "whowin";
    public static String WHOWINDRAW = "draw";
     private ImageView circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9;
     private ImageView cross1, cross2, cross3, cross4, cross5, cross6, cross7, cross8, cross9;

     private ConstraintLayout box1, box2, box3, box4, box5, box6, box7, box8, box9;

     private Boolean round = true;
     private Integer[] gameTable = {0,0,0,0,0,0,0,0,0};
     private Integer roundCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_player);

        circle1 = findViewById(R.id.circle1);
        circle2 = findViewById(R.id.circle2);
        circle3 = findViewById(R.id.circle3);
        circle4 = findViewById(R.id.circle4);
        circle5 = findViewById(R.id.circle5);
        circle6 = findViewById(R.id.circle6);
        circle7 = findViewById(R.id.circle7);
        circle8 = findViewById(R.id.circle8);
        circle9 = findViewById(R.id.circle9);

        cross1 = findViewById(R.id.cross1);
        cross2 = findViewById(R.id.cross2);
        cross3 = findViewById(R.id.cross3);
        cross4 = findViewById(R.id.cross4);
        cross5 = findViewById(R.id.cross5);
        cross6 = findViewById(R.id.cross6);
        cross7 = findViewById(R.id.cross7);
        cross8 = findViewById(R.id.cross8);
        cross9 = findViewById(R.id.cross9);

        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);
        box5 = findViewById(R.id.box5);
        box6 = findViewById(R.id.box6);
        box7 = findViewById(R.id.box7);
        box8 = findViewById(R.id.box8);
        box9 = findViewById(R.id.box9);



        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[0]==0) {
                    if (round) {
                        cross1.setVisibility(View.VISIBLE);
                        gameTable[0] = 1;
                    } else {
                        circle1.setVisibility(View.VISIBLE);
                        gameTable[0] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[1]==0) {
                    if (round) {
                        cross2.setVisibility(View.VISIBLE);
                        gameTable[1] = 1;
                    } else {
                        circle2.setVisibility(View.VISIBLE);
                        gameTable[1] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[2]==0) {
                    if (round) {
                        cross3.setVisibility(View.VISIBLE);
                        gameTable[2] = 1;
                    } else {
                        circle3.setVisibility(View.VISIBLE);
                        gameTable[2] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[3]==0) {
                    if (round) {
                        cross4.setVisibility(View.VISIBLE);
                        gameTable[3] = 1;
                    } else {
                        circle4.setVisibility(View.VISIBLE);
                        gameTable[3] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[4]==0) {
                    if (round) {
                        cross5.setVisibility(View.VISIBLE);
                        gameTable[4] = 1;
                    } else {
                        circle5.setVisibility(View.VISIBLE);
                        gameTable[4] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[5]==0) {
                    if (round) {
                        cross6.setVisibility(View.VISIBLE);
                        gameTable[5] = 1;
                    } else {
                        circle6.setVisibility(View.VISIBLE);
                        gameTable[5] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[6]==0) {
                    if (round) {
                        cross7.setVisibility(View.VISIBLE);
                        gameTable[6] = 1;
                    } else {
                        circle7.setVisibility(View.VISIBLE);
                        gameTable[6] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[7]==0) {
                    if (round) {
                        cross8.setVisibility(View.VISIBLE);
                        gameTable[7] = 1;
                    } else {
                        circle8.setVisibility(View.VISIBLE);
                        gameTable[7] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gameTable[8]==0) {
                    if (round) {
                        cross9.setVisibility(View.VISIBLE);
                        gameTable[8] = 1;
                    } else {
                        circle9.setVisibility(View.VISIBLE);
                        gameTable[8] = 2;
                    }
                    if(cheackWin()){
                        winGame();
                    }
                    round=!round;
                }
            }
        });

    }

     private boolean cheackWin(){
        roundCounter+=1;

        //horizontal line
         if(gameTable[0]==gameTable[1] && gameTable[0]==gameTable[2] && (gameTable[0]==1 || gameTable[0]==2)){
            return true;
         }else if (gameTable[3]==gameTable[4] && gameTable[3]==gameTable[5] && (gameTable[3]==1 || gameTable[3]==2)){
             return true;
         }else if (gameTable[6]==gameTable[7] && gameTable[6]==gameTable[8] && (gameTable[6]==1 || gameTable[6]==2)){
             return true;
         //vertical line
         }else if (gameTable[0]==gameTable[3] && gameTable[0]==gameTable[6] && (gameTable[0]==1 || gameTable[0]==2)) {
             return true;
         }else if (gameTable[1]==gameTable[4] && gameTable[1]==gameTable[7] && (gameTable[1]==1 || gameTable[1]==2)) {
             return true;
         }else if (gameTable[2]==gameTable[5] && gameTable[2]==gameTable[8] && (gameTable[2]==1 || gameTable[2]==2)) {
             return true;
         //cross line
         }else if (gameTable[0]==gameTable[4] && gameTable[0]==gameTable[8] && (gameTable[0]==1 || gameTable[0]==2)) {
             return true;
         }else if (gameTable[2]==gameTable[4] && gameTable[2]==gameTable[6] && (gameTable[2]==1 || gameTable[2]==2)) {
             return true;
         }else if (roundCounter==9){
             Intent intent = new Intent(GameWithPlayer.this, MainActivity.class);
             intent.putExtra(WHOWINDRAW, true);
             startActivity(intent);
             finish();
         }
         return false;
     }

    private void winGame(){
        String whoWinNr = "";
        Intent intent = new Intent(GameWithPlayer.this, MainActivity.class);
        if (round){
            whoWinNr = getString(R.string.gamePlayer1);
        }else{
            whoWinNr = getString(R.string.gamePlayer2);
        }

        intent.putExtra(WHOWIN, whoWinNr);
        startActivity(intent);
        finish();

    }
}