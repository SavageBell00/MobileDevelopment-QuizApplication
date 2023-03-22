package com.example.mobi_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private TextView resultsTxtView;
    private Button btnHome;

    private String resultsMessage;
    private int correctScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        setUpAndLinkBtns();

        getResultsIntent();

        scoreMessage(correctScore);

        resultsTxtView.setText(resultsMessage);


    }

    public View.OnClickListener btnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           goBackToMainIntentProcess();
        }
    };

    public void setUpAndLinkBtns(){

        // linking resource tags to the code objects
        // Buttons
        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(btnClickListener);

        resultsTxtView = findViewById(R.id.resultsTxtView);

    }

    public void getResultsIntent(){

        Intent i = getIntent();
        correctScore = i.getIntExtra("finalScore", 0);

    }

    public void goBackToMainIntentProcess(){

        Intent i = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void scoreMessage(int score){
        if(score >= 8){
            resultsMessage = "You're a wizard Harry! \n You scored " + score + " out of 10!";
        } else if (score >= 5) {
            resultsMessage = "You have wizarding potential! \n You scored " + score + " out of 10!";
        } else {
            resultsMessage = "You're a Muggle! \n You scored " + score + " out of 10!";
        }
    }
}