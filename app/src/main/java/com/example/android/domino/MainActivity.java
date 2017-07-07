package com.example.android.domino;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int weQuantity = 0;
    int weQuantityOne = 0;
    int weQuantityDozen = 0;

    int theyQuantity = 0;
    int theyQuantityOne = 0;
    int theyQuantityDozen = 0;

    int weGameWin = 0;
    int theyGameWin = 0;

    int add = 0;
    int i = 0;
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;

    String message = "0:0";
    String weScore = "0";
    String theyScore = "0";
    String plusScore = "0";

    private RadioGroup radioGroupWeOne;
    private RadioGroup radioGroupWeDozen;
    private RadioGroup radioGroupTheyOne;
    private RadioGroup radioGroupTheyDozen;

    final RadioButton[] radiobuttonWeDozen = new RadioButton[10];
    final RadioButton[] radiobuttonWeOne = new RadioButton[10];
    final RadioButton[] radiobuttonTheyDozen = new RadioButton[10];
    final RadioButton[] radiobuttonTheyOne = new RadioButton[10];

    TextView[] addition = new TextView[10];


    private MediaPlayer mediaPlayer;

    //Key to save

    static final String WE_SCORE_KEY = "weScoreKey";
    static final int WE_SCORE_DEFAULT = 0;

    static final String THEY_SCORE_KEY = "theyScoreKey";
    static final int THEY_SCORE_DEFAULT =0;

    static final String WE_GAME_SCORE_KEY = "weGameScoreKey";
    static final int WE_GAME_SCORE_DEFAULT = 0;

    static final String THEY_GAME_SCORE_KEY = "theyGameScoreKey";
    static final int THEY_GAME_SCORE_DEFAULT = 0;

    static final String ADD_KEY ="addKey";
    static final int ADD_DEFAULT = 0;




    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("Main activity", "onRestoreInstanceState is Started");
        weQuantity = savedInstanceState.getInt(WE_SCORE_KEY);
        //weQuantity = 25;
        Log.i("weScore resored", Integer.toString(weQuantity));
        displayForWe(weQuantity);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Main activity", "on create is Started");




        radiobuttonWeDozen[0] = (RadioButton) findViewById(R.id.weDozen0);
        radiobuttonWeDozen[1] = (RadioButton) findViewById(R.id.weDozen1);
        radiobuttonWeDozen[2] = (RadioButton) findViewById(R.id.weDozen2);
        radiobuttonWeDozen[3] = (RadioButton) findViewById(R.id.weDozen3);
        radiobuttonWeDozen[4] = (RadioButton) findViewById(R.id.weDozen4);
        radiobuttonWeDozen[5] = (RadioButton) findViewById(R.id.weDozen5);
        radiobuttonWeDozen[6] = (RadioButton) findViewById(R.id.weDozen6);
        radiobuttonWeDozen[7] = (RadioButton) findViewById(R.id.weDozen7);
        radiobuttonWeDozen[8] = (RadioButton) findViewById(R.id.weDozen8);
        radiobuttonWeDozen[9] = (RadioButton) findViewById(R.id.weDozen9);



        radiobuttonWeOne[0] = (RadioButton) findViewById(R.id.weOne0);
        radiobuttonWeOne[1] = (RadioButton) findViewById(R.id.weOne1);
        radiobuttonWeOne[2] = (RadioButton) findViewById(R.id.weOne2);
        radiobuttonWeOne[3] = (RadioButton) findViewById(R.id.weOne3);
        radiobuttonWeOne[4] = (RadioButton) findViewById(R.id.weOne4);
        radiobuttonWeOne[5] = (RadioButton) findViewById(R.id.weOne5);
        radiobuttonWeOne[6] = (RadioButton) findViewById(R.id.weOne6);
        radiobuttonWeOne[7] = (RadioButton) findViewById(R.id.weOne7);
        radiobuttonWeOne[8] = (RadioButton) findViewById(R.id.weOne8);
        radiobuttonWeOne[9] = (RadioButton) findViewById(R.id.weOne9);




        radiobuttonTheyDozen[0] = (RadioButton) findViewById(R.id.theyDozen0);
        radiobuttonTheyDozen[1] = (RadioButton) findViewById(R.id.theyDozen1);
        radiobuttonTheyDozen[2] = (RadioButton) findViewById(R.id.theyDozen2);
        radiobuttonTheyDozen[3] = (RadioButton) findViewById(R.id.theyDozen3);
        radiobuttonTheyDozen[4] = (RadioButton) findViewById(R.id.theyDozen4);
        radiobuttonTheyDozen[5] = (RadioButton) findViewById(R.id.theyDozen5);
        radiobuttonTheyDozen[6] = (RadioButton) findViewById(R.id.theyDozen6);
        radiobuttonTheyDozen[7] = (RadioButton) findViewById(R.id.theyDozen7);
        radiobuttonTheyDozen[8] = (RadioButton) findViewById(R.id.theyDozen8);
        radiobuttonTheyDozen[9] = (RadioButton) findViewById(R.id.theyDozen9);



        radiobuttonTheyOne[0] = (RadioButton) findViewById(R.id.theyOne0);
        radiobuttonTheyOne[1] = (RadioButton) findViewById(R.id.theyOne1);
        radiobuttonTheyOne[2] = (RadioButton) findViewById(R.id.theyOne2);
        radiobuttonTheyOne[3] = (RadioButton) findViewById(R.id.theyOne3);
        radiobuttonTheyOne[4] = (RadioButton) findViewById(R.id.theyOne4);
        radiobuttonTheyOne[5] = (RadioButton) findViewById(R.id.theyOne5);
        radiobuttonTheyOne[6] = (RadioButton) findViewById(R.id.theyOne6);
        radiobuttonTheyOne[7] = (RadioButton) findViewById(R.id.theyOne7);
        radiobuttonTheyOne[8] = (RadioButton) findViewById(R.id.theyOne8);
        radiobuttonTheyOne[9] = (RadioButton) findViewById(R.id.theyOne9);




        addition[0] = (TextView) findViewById(R.id.zero);
        addition[1] = (TextView) findViewById(R.id.one);
        addition[2] = (TextView) findViewById(R.id.two);
        addition[3] = (TextView) findViewById(R.id.three);
        addition[4] = (TextView) findViewById(R.id.fore);
        addition[5] = (TextView) findViewById(R.id.five);
        addition[6] = (TextView) findViewById(R.id.six);
        addition[7] = (TextView) findViewById(R.id.seven);
        addition[8] = (TextView) findViewById(R.id.eight);
        addition[9] = (TextView) findViewById(R.id.nine);

        radioGroupWeOne = (RadioGroup) findViewById(R.id.radioGroupWeOne);
        //radioGroupWeOne.clearCheck();

        radioGroupWeDozen = (RadioGroup) findViewById(R.id.radioGroupWeDozen);
        //radioGroupWeDozen.clearCheck();

        radioGroupTheyDozen = (RadioGroup) findViewById(R.id.radioGroupTheyDozen);
        //radioGroupTheyDozen.clearCheck();

        radioGroupTheyOne = (RadioGroup) findViewById(R.id.radioGroupTheyOne);
        //radioGroupTheyOne.clearCheck();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        radiobuttonWeDozen[0].setChecked(true);
        radiobuttonWeOne[0].setChecked(true);
        radiobuttonTheyDozen[0].setChecked(true);
        radiobuttonTheyOne[0].setChecked(true);

        //restore data

        weQuantity = sharedPreferences.getInt(WE_SCORE_KEY,WE_SCORE_DEFAULT);
        displayScoreForWe(radiobuttonWeDozen,radiobuttonWeOne);

        theyQuantity = sharedPreferences.getInt(THEY_SCORE_KEY, THEY_SCORE_DEFAULT);
        displayScoreForThey(radiobuttonTheyDozen,radiobuttonTheyOne);

        add = sharedPreferences.getInt(ADD_KEY,ADD_DEFAULT);
        displayAdd(add);

        weGameWin = sharedPreferences.getInt(WE_GAME_SCORE_KEY, WE_GAME_SCORE_DEFAULT);
        message = weGameWin + " : " + theyGameWin;
        displayOveralScore(message);

        theyGameWin = sharedPreferences.getInt(THEY_GAME_SCORE_KEY, THEY_GAME_SCORE_DEFAULT);
        message = weGameWin + " : " + theyGameWin;
        displayOveralScore(message);








        ///Start new game
        Button newGame = (Button) findViewById(R.id.newGame);
        newGame.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                weGameWin = 0;
                theyGameWin = 0;
                message = weGameWin + " : " + theyGameWin;
                displayOveralScore(message);

                weQuantityDozen = 0;
                weQuantityOne = 0;
                weQuantity = 0;


                displayForWe(weQuantity);

                theyQuantityDozen = 0;
                theyQuantityOne = 0;
                theyQuantity = 0;

                displayForThey(theyQuantity);

                radiobuttonWeDozen[0].setChecked(true);
                radiobuttonWeOne[0].setChecked(true);
                radiobuttonTheyDozen[0].setChecked(true);
                radiobuttonTheyOne[0].setChecked(true);



                add=0;
                displayAdd(add);

            }

        });

        Button weWin = (Button) findViewById(R.id.weWin);
        weWin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick (View view){
                weWin();
            }
        }
        );

        Button theyWin = (Button) findViewById(R.id.theyWin);
        theyWin.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick (View view){
                theyWin();
            }
        });


        //Set team name


        TextView firstTeamNameTextView = (TextView) findViewById(R.id.we);
        String firstTeamName = sharedPreferences.getString(
                getString(R.string.settings_1st_team_key),
                getString(R.string.sedtings_1st_team_default)
        );
        firstTeamNameTextView.setText(firstTeamName);

        TextView secondTeamNameTextView = (TextView) findViewById(R.id.they);
        String secondTeamName = sharedPreferences.getString(
                getString(R.string.settings_2nd_team_key),
                getString(R.string.settings_2nd_team_default)
        );
        secondTeamNameTextView.setText(secondTeamName);

        /// add score


        while (i < 10) {

            addition[i].setOnClickListener(new TextView.OnClickListener() {
                int x = i;

                @Override
                public void onClick(View view) {
                    int add = x;
                    add = AddScore(add);
                    displayAdd(add);
                    saveAdd(add);
                }
            });
            i++;
        }


/// Add score to WE




        TextView we = (TextView) findViewById(R.id.we);
        we.setOnClickListener(new TextView.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      weQuantity = weQuantity + add;
                                      if (weQuantity < 100) {
                                          displayForWe(weQuantity);
                                          //weQuantityDozen
                                          double dozen = weQuantity / 10;
                                          weQuantityDozen = 10 * (int) Math.floor(dozen);

                                          //weQantityOne
                                          weQuantityOne = weQuantity % 10;

                                          radiobuttonWeDozen[(weQuantityDozen / 10)].setChecked(true);
                                          radiobuttonWeOne[weQuantityOne].setChecked(true);

                                      } else if (weQuantity == 100) {
                                          displayForWe(weQuantity);

                                          weQuantityDozen = 0;
                                          weQuantityOne = 0;

                                          radiobuttonWeDozen[(weQuantityDozen / 10)].setChecked(true);
                                          radiobuttonWeOne[weQuantityOne].setChecked(true);

                                      } else if (weQuantity > 100) {
                                          theyWin();
                                      }

                                      add = 0;
                                      displayAdd(add);

                                  }
                              }
        );




        /// Add score to WE


        TextView they = (TextView) findViewById(R.id.they);
        they.setOnClickListener(new TextView.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {

                                      theyQuantity = theyQuantity + add;
                                      if (theyQuantity < 100) {
                                          displayForThey(theyQuantity);
                                          //weQuantityDozen
                                          double dozen = theyQuantity / 10;
                                          theyQuantityDozen = 10 * (int) Math.floor(dozen);

                                          //weQantityOne
                                          theyQuantityOne = theyQuantity % 10;

                                          radiobuttonTheyDozen[(theyQuantityDozen / 10)].setChecked(true);
                                          radiobuttonTheyOne[theyQuantityOne].setChecked(true);

                                      } else if (theyQuantity == 100) {
                                          displayForThey(theyQuantity);

                                          theyQuantityDozen = 0;
                                          theyQuantityOne = 0;

                                          radiobuttonTheyDozen[(theyQuantityDozen / 10)].setChecked(true);
                                          radiobuttonTheyOne[theyQuantityOne].setChecked(true);

                                      } else if (theyQuantity > 100) {
                                          weWin();
                                      }

                                      add = 0;
                                      displayAdd(add);

                                  }
                              }
        );




        a = 0;
        while (a < 10) {

            radiobuttonWeDozen[a].setOnClickListener(new RadioButton.OnClickListener() {
                int x = a;

                @Override
                public void onClick(View view) {
                    weQuantityDozen = 10*x;
                    WeDozen(weQuantityDozen);
                }
            });
            a++;
        }

        b = 0;
        while (b < 10) {

            radiobuttonWeOne[b].setOnClickListener(new RadioButton.OnClickListener() {
                int x = b;

                @Override
                public void onClick(View view) {
                    weQuantityOne = x;
                    WeOne(weQuantityOne);
                }
            });
            b++;
        }

        c = 0;
        while (c < 10) {

            radiobuttonTheyDozen[c].setOnClickListener(new RadioButton.OnClickListener() {
                int x = c;

                @Override
                public void onClick(View view) {
                    theyQuantityDozen = 10*x;
                    TheyDozen(theyQuantityDozen);
                }
            });
            c++;
        }


        while (d < 10) {

            radiobuttonTheyOne[d].setOnClickListener(new RadioButton.OnClickListener() {
                int x = d;

                @Override
                public void onClick(View view) {
                    theyQuantityOne = x;
                    TheyOne(theyQuantityOne);
                }
            });
            d++;
        }

    }





    public void displayScoreForWe (RadioButton[] radiobuttonWeDozen,RadioButton[] radiobuttonWeOne){

        if (weQuantity < 100) {
            displayForWe(weQuantity);
            //weQuantityDozen
            double dozen = weQuantity / 10;
            weQuantityDozen = 10 * (int) Math.floor(dozen);

            //weQantityOne
            weQuantityOne = weQuantity % 10;

            radiobuttonWeDozen[(weQuantityDozen / 10)].setChecked(true);
            radiobuttonWeOne[weQuantityOne].setChecked(true);

        } else if (weQuantity == 100) {
            displayForWe(weQuantity);

            weQuantityDozen = 0;
            weQuantityOne = 0;

            radiobuttonWeDozen[(weQuantityDozen / 10)].setChecked(true);
            radiobuttonWeOne[weQuantityOne].setChecked(true);

        } else if (weQuantity > 100) {
            theyWin();
        }
    }

    public void displayScoreForThey (RadioButton[] radiobuttonTheyDozen, RadioButton[] radiobuttonTheyOne) {
        if (theyQuantity < 100) {
            displayForThey(theyQuantity);
            //weQuantityDozen
            double dozen = theyQuantity / 10;
            theyQuantityDozen = 10 * (int) Math.floor(dozen);

            //weQantityOne
            theyQuantityOne = theyQuantity % 10;

            radiobuttonTheyDozen[(theyQuantityDozen / 10)].setChecked(true);
            radiobuttonTheyOne[theyQuantityOne].setChecked(true);

        } else if (theyQuantity == 100) {
            displayForThey(theyQuantity);

            theyQuantityDozen = 0;
            theyQuantityOne = 0;

            radiobuttonTheyDozen[(theyQuantityDozen / 10)].setChecked(true);
            radiobuttonTheyOne[theyQuantityOne].setChecked(true);

        } else if (theyQuantity > 100) {
            weWin();
        }


    }




    public int saveAdd(int add) {
        return add;
    }


    public int AddScore(int plus) {
        if (add == 0) {
            add = plus;
        } else if (add < 10) {
            add = add * 10 + plus;
        } else if (add >= 10)
            add = 0;
        return add;
    }

    public void displayAdd(int add) {
        TextView plusView = (TextView) findViewById(R.id.plus);
        if (add == 0) {
            plusScore = "";
            plusView.setText(plusScore);
        } else {
            plusScore = add + "";
            plusView.setText(plusScore);
        }
    }

    // ******** WE **********

    // WE dozen score
/*
    public void Add_1X_We(View view) {
        weQuantityDozen = 10;
        weQuantity = weQuantityDozen + weQuantityOne;
        displayForWe(weQuantity);
    }

    public void Add_2X_We(View view) {
        weQuantityDozen = 20;
        WeDozen(weQuantityDozen);
    }

    public void Add_3X_We(View view) {
        weQuantityDozen = 30;
        WeDozen(weQuantityDozen);
    }

    public void Add_4X_We(View view) {
        weQuantityDozen = 40;
        WeDozen(weQuantityDozen);
    }

    public void Add_5X_We(View view) {
        weQuantityDozen = 50;
        WeDozen(weQuantityDozen);
    }

    public void Add_6X_We(View view) {
        weQuantityDozen = 60;
        WeDozen(weQuantityDozen);
    }

    public void Add_7X_We(View view) {
        weQuantityDozen = 70;
        WeDozen(weQuantityDozen);
    }

    public void Add_8X_We(View view) {
        weQuantityDozen = 80;
        WeDozen(weQuantityDozen);
    }

    public void Add_9X_We(View view) {
        weQuantityDozen = 90;
        WeDozen(weQuantityDozen);
    }

    public void Add_0X_We(View view) {
        weQuantityDozen = 0;
        WeDozen(weQuantityDozen);
    }


    // We one score

    public void Add_X1_We(View view) {
        weQuantityOne = 1;
        weQuantity = weQuantityDozen + weQuantityOne;
        displayForWe(weQuantity);
    }

    public void Add_X2_We(View view) {
        weQuantityOne = 2;
        WeOne(weQuantityOne);
    }

    public void Add_X3_We(View view) {
        weQuantityOne = 3;
        WeOne(weQuantityOne);
    }

    public void Add_X4_We(View view) {
        weQuantityOne = 4;
        WeOne(weQuantityOne);
    }

    public void Add_X5_We(View view) {
        weQuantityOne = 5;
        WeOne(weQuantityOne);
    }

    public void Add_X6_We(View view) {
        weQuantityOne = 6;
        WeOne(weQuantityOne);
    }

    public void Add_X7_We(View view) {
        weQuantityOne = 7;
        WeOne(weQuantityOne);
    }

    public void Add_X8_We(View view) {
        weQuantityOne = 8;
        WeOne(weQuantityOne);
    }

    public void Add_X9_We(View view) {
        weQuantityOne = 9;
        WeOne(weQuantityOne);
    }

    public void Add_X0_We(View view) {
        weQuantityOne = 0;
        WeOne(weQuantityOne);
    }
*/
    // We one  method

    public void WeOne(int weQuantityOne) {
        weQuantity = weQuantityDozen + weQuantityOne;
        displayForWe(weQuantity);
    }
    //We Dozen method


    public void WeDozen(int weQuantityDozen) {
        weQuantity = weQuantityDozen + weQuantityOne;
        displayForWe(weQuantity);
    }

    //Display We score


    public void displayForWe(int weQuantity) {
        TextView scoreView = (TextView) findViewById(R.id.we_score);
        String weQuantityString = weQuantity + "";
        scoreView.setText(weQuantityString);
    }


    // ******** THEY **********

    /// They One method
/*
    public void Add_X1_They(View view) {
        theyQuantityOne = 1;
        TheyOne(theyQuantityOne);
    }

    public void Add_X2_They(View view) {
        theyQuantityOne = 2;
        TheyOne(theyQuantityOne);
    }

    public void Add_X3_They(View view) {
        theyQuantityOne = 3;
        TheyOne(theyQuantityOne);
    }

    public void Add_X4_They(View view) {
        theyQuantityOne = 4;
        TheyOne(theyQuantityOne);
    }

    public void Add_X5_They(View view) {
        theyQuantityOne = 5;
        TheyOne(theyQuantityOne);
    }

    public void Add_X6_They(View view) {
        theyQuantityOne = 6;
        TheyOne(theyQuantityOne);
    }

    public void Add_X7_They(View view) {
        theyQuantityOne = 7;
        TheyOne(theyQuantityOne);
    }

    public void Add_X8_They(View view) {
        theyQuantityOne = 8;
        TheyOne(theyQuantityOne);
    }

    public void Add_X9_They(View view) {
        theyQuantityOne = 9;
        TheyOne(theyQuantityOne);
    }

    public void Add_X0_They(View view) {
        theyQuantityOne = 0;
        TheyOne(theyQuantityOne);
    }




// they dozen

    public void Add_1X_They(View view) {
        theyQuantityDozen = 10;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_2X_They(View view) {
        theyQuantityDozen = 20;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_3X_They(View view) {
        theyQuantityDozen = 30;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_4X_They(View view) {
        theyQuantityDozen = 40;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_5X_They(View view) {
        theyQuantityDozen = 50;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_6X_They(View view) {
        theyQuantityDozen = 60;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_7X_They(View view) {
        theyQuantityDozen = 70;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_8X_They(View view) {
        theyQuantityDozen = 80;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_9X_They(View view) {
        theyQuantityDozen = 90;
        TheyDozen(theyQuantityDozen);
    }

    public void Add_0X_They(View view) {
        theyQuantityDozen = 0;
        TheyDozen(theyQuantityDozen);
    }
    */

    // they Dozen method
    public void TheyDozen(int theyQuantityDozen) {
        theyQuantity = theyQuantityDozen + theyQuantityOne;
        displayForThey(theyQuantity);
    }


    // they One method
    public void TheyOne(int theyQuantityOne) {
        theyQuantity = theyQuantityDozen + theyQuantityOne;
        displayForThey(theyQuantity);
    }

    public void displayForThey(int theyQuantity) {
        TextView scoreView = (TextView) findViewById(R.id.they_score);
        String theyQuantityString = theyQuantity +"";
        scoreView.setText(theyQuantityString);
    }


//// overal sore


    ///Score ckear mrthod

    public void ScoreClear() {
        weQuantityDozen = 0;
        weQuantityOne = 0;
        weQuantity = 0;
        theyQuantityDozen = 0;
        theyQuantityOne = 0;
        theyQuantity = 0;
    }

    // We win button

    public void weWin() {

        ScoreClear();

        displayForWe(weQuantity);

        displayForThey(theyQuantity);

        radiobuttonWeDozen[0].setChecked(true);
        radiobuttonWeOne[0].setChecked(true);
        radiobuttonTheyDozen[0].setChecked(true);
        radiobuttonTheyOne[0].setChecked(true);

        //ScoreClear(int);

        weGameWin = weGameWin + 1;
        message = weGameWin + " : " + theyGameWin;

        displayOveralScore(message);

        add=0;
        displayAdd(add);

        // pop-up

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.team1win,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        // text.setText("The quantity should be more then 1");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        soundGameOver();

    }

    // They win button

    public void theyWin() {

        ScoreClear();

        displayForWe(weQuantity);

        displayForThey(theyQuantity);

        radiobuttonWeDozen[0].setChecked(true);
        radiobuttonWeOne[0].setChecked(true);
        radiobuttonTheyDozen[0].setChecked(true);
        radiobuttonTheyOne[0].setChecked(true);

        //ScoreClear(int);

        theyGameWin = theyGameWin + 1;
        message = weGameWin + " : " + theyGameWin;

        displayOveralScore(message);

        add=0;
        displayAdd(add);

        // pop-up

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.team2win,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        // text.setText("The quantity should be more then 1");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

        soundGameOver();

    }


    private void displayOveralScore(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.overal_score_text_view);
        priceTextView.setText(message);
    }




//Sound effect

    private void soundGameOver (){
        mediaPlayer = MediaPlayer.create(this,R.raw.gameover);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // save instance
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        pref.edit().putInt(WE_SCORE_KEY,weQuantity).commit();
        pref.edit().putInt(THEY_SCORE_KEY,theyQuantity).commit();
        pref.edit().putInt(WE_GAME_SCORE_KEY,weGameWin).commit();
        pref.edit().putInt(THEY_GAME_SCORE_KEY,theyGameWin).commit();
        pref.edit().putInt(ADD_KEY,add).commit();

        Log.i("weScore saved as", Integer.toString(weQuantity));
       //
    }


}
