package com.example.kolkokrzyzykgame;

import static com.example.kolkokrzyzykgame.GameWithPlayer.WHOWIN;
import static com.example.kolkokrzyzykgame.GameWithPlayer.WHOWINDRAW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameWithAi extends AppCompatActivity {
    private ImageView circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9;
    private ImageView cross1, cross2, cross3, cross4, cross5, cross6, cross7, cross8, cross9;

    private ConstraintLayout box1, box2, box3, box4, box5, box6, box7, box8, box9;

    private Button hardlvl1,hardlvl2, hardlvl3;

    private ConstraintLayout lvlPick;
    private ConstraintLayout gameSpaceContainer;

    private Boolean round = true;
    private Integer[] gameTable = {0,0,0,0,0,0,0,0,0};
    private boolean whoWin;
    private Integer roundCounter = 0;
    private Integer DifficultyLevel = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_with_ai);

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

        hardlvl1 = findViewById(R.id.easyLvl);
        hardlvl2 = findViewById(R.id.midLvl);
        hardlvl3 = findViewById(R.id.hardLvl);

        lvlPick = findViewById(R.id.lvlPick);
        gameSpaceContainer = findViewById(R.id.gameSpaceContainer);


        hardlvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyLevel=1;
                lvlPick.setVisibility(View.GONE);
                gameSpaceContainer.setVisibility(View.VISIBLE);
            }
        });

        hardlvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyLevel=2;
                lvlPick.setVisibility(View.GONE);
                gameSpaceContainer.setVisibility(View.VISIBLE);
            }
        });

        hardlvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DifficultyLevel=3;
                lvlPick.setVisibility(View.GONE);
                gameSpaceContainer.setVisibility(View.VISIBLE);
            }
        });

        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(gameTable[0]==0){
                        cross1.setVisibility(View.VISIBLE);
                        gameTable[0] = 1;

                        if(cheackWin()){
                            winGame();
                        }else {
                            gameTableChange(true);
                            round = !round;
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    botTurn();
                                }
                            }, 1000);

                            box1.setClickable(false);
                        }
                    }

            }
        });

        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[1]==0) {
                    cross2.setVisibility(View.VISIBLE);
                    gameTable[1] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);

                        box2.setClickable(false);
                    }
                }
            }
        });

        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[2]==0) {
                    cross3.setVisibility(View.VISIBLE);
                    gameTable[2] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);
                        box3.setClickable(false);
                    }
                }
            }
        });

        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[3]==0) {
                    cross4.setVisibility(View.VISIBLE);
                    gameTable[3] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);
                        box4.setClickable(false);
                    }
                }
            }
        });

        box5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[4]==0) {
                    cross5.setVisibility(View.VISIBLE);
                    gameTable[4] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);

                        box5.setClickable(false);
                    }
                }
            }
        });

        box6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[5]==0) {
                    cross6.setVisibility(View.VISIBLE);
                    gameTable[5] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);

                        box6.setClickable(false);
                    }
                }
            }
        });

        box7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[6]==0) {
                    cross7.setVisibility(View.VISIBLE);
                    gameTable[6] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);


                        box7.setClickable(false);
                    }
                }
            }
        });

        box8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[7]==0) {
                    cross8.setVisibility(View.VISIBLE);
                    gameTable[7] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);
                        box8.setClickable(false);
                    }
                }
            }
        });

        box9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameTable[8]==0) {
                    cross9.setVisibility(View.VISIBLE);
                    gameTable[8] = 1;
                    if (cheackWin()) {
                        winGame();
                    } else {
                        gameTableChange(true);
                        round = !round;
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            public void run() {
                                botTurn();
                            }
                        }, 1000);

                        box9.setClickable(false);
                    }
                }
            }
        });

    }
    private void gameTableChange(boolean witchNumber){
        if(witchNumber){
            for(int i=0; i<9; i++){
                if(gameTable[i]==0){
                    gameTable[i]=3;
                }
            }
        }else{
            for(int i=0; i<9; i++){
                if(gameTable[i]==3){
                    gameTable[i]=0;
                }
            }
        }

    }

    private void botTurn(){
        Random random = new Random();
        Integer position=0;

        if(DifficultyLevel==1){
            do {
                position = random.nextInt(8);
            }while (gameTable[position]==1 || gameTable[position]==2);
            gameTable[position]=2;

        } else if (DifficultyLevel==2) {
            int temp = random.nextInt(100);
            if(temp>60){
                do {
                    position = random.nextInt(8);
                }while (gameTable[position]==1 || gameTable[position]==2);
                gameTable[position]=2;
            }else{
                if(roundCounter==1 && gameTable[4]==3){
                        gameTable[4]=2;
                        position=4;
                }else if(gameTable[0]==2 && gameTable[1]==2 && gameTable[2]==3){
                    gameTable[2]=2;
                    position=2;
                }else if(gameTable[3]==2 && gameTable[4]==2 && gameTable[5]==3) {
                    gameTable[5] = 2;
                    position=5;
                }else if(gameTable[3]==2 && gameTable[4]==2 && gameTable[5]==3) {
                    gameTable[5] = 2;
                    position=5;
                }else if(gameTable[6]==2 && gameTable[7]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[1]==2 && gameTable[2]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[5]==2 && gameTable[3]==3) {
                    gameTable[3] = 2;
                    position=3;
                }else if(gameTable[7]==2 && gameTable[8]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[0]==2 && gameTable[3]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[1]==2 && gameTable[4]==2 && gameTable[7]==3) {
                    gameTable[7] = 2;
                    position=7;
                }else if(gameTable[2]==2 && gameTable[5]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[3]==2 && gameTable[6]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[7]==2 && gameTable[1]==3) {
                    gameTable[1] = 2;
                    position=1;
                }else if(gameTable[5]==2 && gameTable[8]==2 && gameTable[2]==3) {
                    gameTable[2] = 2;
                    position=2;
                }else if(gameTable[0]==2 && gameTable[2]==2 && gameTable[1]==3) {
                    gameTable[1] = 2;
                    position=1;
                }else if(gameTable[3]==2 && gameTable[5]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[6]==2 && gameTable[8]==2 && gameTable[7]==3) {
                    gameTable[7] = 2;
                    position=7;
                }else if(gameTable[0]==2 && gameTable[8]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[2]==2 && gameTable[6]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[0]==2 && gameTable[4]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[2]==2 && gameTable[4]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[4]==2 && gameTable[8]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[6]==2 && gameTable[2]==3) {
                    gameTable[2] = 2;
                    position = 2;
                }else {
                    if (gameTable[0] == 1 && gameTable[1] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else if (gameTable[3] == 1 && gameTable[4] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[3] == 1 && gameTable[4] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[6] == 1 && gameTable[7] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[1] == 1 && gameTable[2] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[5] == 1 && gameTable[3] == 3) {
                        gameTable[3] = 2;
                        position = 3;
                    } else if (gameTable[7] == 1 && gameTable[8] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[0] == 1 && gameTable[3] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[1] == 1 && gameTable[4] == 1 && gameTable[7] == 3) {
                        gameTable[7] = 2;
                        position = 7;
                    } else if (gameTable[2] == 1 && gameTable[5] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[3] == 1 && gameTable[6] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[7] == 1 && gameTable[1] == 3) {
                        gameTable[1] = 2;
                        position = 1;
                    } else if (gameTable[5] == 1 && gameTable[8] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else if (gameTable[0] == 1 && gameTable[2] == 1 && gameTable[1] == 3) {
                        gameTable[1] = 2;
                        position = 1;
                    } else if (gameTable[3] == 1 && gameTable[5] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[6] == 1 && gameTable[8] == 1 && gameTable[7] == 3) {
                        gameTable[7] = 2;
                        position = 7;
                    }else if (gameTable[0] == 1 && gameTable[6] == 1 && gameTable[3] == 3) {
                            gameTable[3] = 2;
                            position = 3;
                    }else if (gameTable[1] == 1 && gameTable[7] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    }else if (gameTable[2] == 1 && gameTable[8] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[0] == 1 && gameTable[8] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[2] == 1 && gameTable[6] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[0] == 1 && gameTable[4] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[2] == 1 && gameTable[4] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[4] == 1 && gameTable[8] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[6] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else {
                        do {
                            position = random.nextInt(8);
                        } while (gameTable[position] == 1 || gameTable[position] == 2);
                        gameTable[position] = 2;
                    }
                }
            }

        } else if (DifficultyLevel==3) {
            int temp = random.nextInt(100);
            if(temp>95){
                do {
                    position = random.nextInt(8);
                }while (gameTable[position]==1 || gameTable[position]==2);
                gameTable[position]=2;
            }else{

                if(roundCounter==1 && gameTable[4]==3){
                    gameTable[4]=2;
                    position=4;
                }else if(gameTable[0]==2 && gameTable[1]==2 && gameTable[2]==3){
                    gameTable[2]=2;
                    position=2;
                }else if(gameTable[3]==2 && gameTable[4]==2 && gameTable[5]==3) {
                    gameTable[5] = 2;
                    position=5;
                }else if(gameTable[3]==2 && gameTable[4]==2 && gameTable[5]==3) {
                    gameTable[5] = 2;
                    position=5;
                }else if(gameTable[6]==2 && gameTable[7]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[1]==2 && gameTable[2]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[5]==2 && gameTable[3]==3) {
                    gameTable[3] = 2;
                    position=3;
                }else if(gameTable[7]==2 && gameTable[8]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[0]==2 && gameTable[3]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[1]==2 && gameTable[4]==2 && gameTable[7]==3) {
                    gameTable[7] = 2;
                    position=7;
                }else if(gameTable[2]==2 && gameTable[5]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[3]==2 && gameTable[6]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[7]==2 && gameTable[1]==3) {
                    gameTable[1] = 2;
                    position=1;
                }else if(gameTable[5]==2 && gameTable[8]==2 && gameTable[2]==3) {
                    gameTable[2] = 2;
                    position=2;
                }else if(gameTable[0]==2 && gameTable[2]==2 && gameTable[1]==3) {
                    gameTable[1] = 2;
                    position=1;
                }else if(gameTable[3]==2 && gameTable[5]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[6]==2 && gameTable[8]==2 && gameTable[7]==3) {
                    gameTable[7] = 2;
                    position=7;
                }else if(gameTable[0]==2 && gameTable[8]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[2]==2 && gameTable[6]==2 && gameTable[4]==3) {
                    gameTable[4] = 2;
                    position=4;
                }else if(gameTable[0]==2 && gameTable[4]==2 && gameTable[8]==3) {
                    gameTable[8] = 2;
                    position=8;
                }else if(gameTable[2]==2 && gameTable[4]==2 && gameTable[6]==3) {
                    gameTable[6] = 2;
                    position=6;
                }else if(gameTable[4]==2 && gameTable[8]==2 && gameTable[0]==3) {
                    gameTable[0] = 2;
                    position=0;
                }else if(gameTable[4]==2 && gameTable[6]==2 && gameTable[2]==3) {
                    gameTable[2] = 2;
                    position = 2;
                }else {
                    if (gameTable[0] == 1 && gameTable[1] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else if (gameTable[3] == 1 && gameTable[4] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[3] == 1 && gameTable[4] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[6] == 1 && gameTable[7] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[1] == 1 && gameTable[2] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[5] == 1 && gameTable[3] == 3) {
                        gameTable[3] = 2;
                        position = 3;
                    } else if (gameTable[7] == 1 && gameTable[8] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[0] == 1 && gameTable[3] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[1] == 1 && gameTable[4] == 1 && gameTable[7] == 3) {
                        gameTable[7] = 2;
                        position = 7;
                    } else if (gameTable[2] == 1 && gameTable[5] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[3] == 1 && gameTable[6] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[7] == 1 && gameTable[1] == 3) {
                        gameTable[1] = 2;
                        position = 1;
                    } else if (gameTable[5] == 1 && gameTable[8] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else if (gameTable[0] == 1 && gameTable[2] == 1 && gameTable[1] == 3) {
                        gameTable[1] = 2;
                        position = 1;
                    } else if (gameTable[3] == 1 && gameTable[5] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[6] == 1 && gameTable[8] == 1 && gameTable[7] == 3) {
                        gameTable[7] = 2;
                        position = 7;
                    }else if (gameTable[0] == 1 && gameTable[6] == 1 && gameTable[3] == 3) {
                        gameTable[3] = 2;
                        position = 3;
                    }else if (gameTable[1] == 1 && gameTable[7] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    }else if (gameTable[2] == 1 && gameTable[8] == 1 && gameTable[5] == 3) {
                        gameTable[5] = 2;
                        position = 5;
                    } else if (gameTable[0] == 1 && gameTable[8] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[2] == 1 && gameTable[6] == 1 && gameTable[4] == 3) {
                        gameTable[4] = 2;
                        position = 4;
                    } else if (gameTable[0] == 1 && gameTable[4] == 1 && gameTable[8] == 3) {
                        gameTable[8] = 2;
                        position = 8;
                    } else if (gameTable[2] == 1 && gameTable[4] == 1 && gameTable[6] == 3) {
                        gameTable[6] = 2;
                        position = 6;
                    } else if (gameTable[4] == 1 && gameTable[8] == 1 && gameTable[0] == 3) {
                        gameTable[0] = 2;
                        position = 0;
                    } else if (gameTable[4] == 1 && gameTable[6] == 1 && gameTable[2] == 3) {
                        gameTable[2] = 2;
                        position = 2;
                    } else {
                        do {
                            position = random.nextInt(8);
                        } while (gameTable[position] == 1 || gameTable[position] == 2);
                        gameTable[position] = 2;
                    }
                }

            }
        }

        if(position==0){
            circle1.setVisibility(View.VISIBLE);
            box1.setClickable(false);
        }else if (position==1){
            circle2.setVisibility(View.VISIBLE);
            box2.setClickable(false);
        }else if (position==2){
            circle3.setVisibility(View.VISIBLE);
            box3.setClickable(false);
        }else if (position==3){
            circle4.setVisibility(View.VISIBLE);
            box4.setClickable(false);
        }else if (position==4){
            circle5.setVisibility(View.VISIBLE);
            box5.setClickable(false);
        }else if (position==5){
            circle6.setVisibility(View.VISIBLE);
            box6.setClickable(false);
        }else if (position==6){
            circle7.setVisibility(View.VISIBLE);
            box7.setClickable(false);
        }else if (position==7){
            circle8.setVisibility(View.VISIBLE);
            box8.setClickable(false);
        }else if (position==8){
            circle9.setVisibility(View.VISIBLE);
            box9.setClickable(false);
        }

        if(cheackWin()){
            winGame();
        }
        round = !round;
        gameTableChange(false);

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
            Intent intent = new Intent(GameWithAi.this, MainActivity.class);
            intent.putExtra(WHOWINDRAW, true);
            startActivity(intent);
            finish();
            for(int i=0; i<9; i++){
                gameTable[i]=0;
            }
            return false;
        }else{
            return false;
        }
    }

    private void winGame(){
        String whoWinNr = "";
        Intent intent = new Intent(GameWithAi.this, MainActivity.class);
        if (round){
            whoWinNr = getString(R.string.gameAi1);
        }else{
            whoWinNr = getString(R.string.gameAi2);
        }

        intent.putExtra(WHOWIN, whoWinNr);
        startActivity(intent);
        finish();


    }
}