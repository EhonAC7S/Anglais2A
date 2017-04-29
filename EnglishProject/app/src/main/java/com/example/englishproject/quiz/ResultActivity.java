package com.example.englishproject.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.englishproject.R;
import com.example.englishproject.courses.dataelement.DataBaseCourses;
import com.example.englishproject.quiz.dataelement.Sentence;

import java.util.ArrayList;

public class ResultActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);

        //get score and errors
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        ArrayList<Sentence> errors = b.getParcelableArrayList("errors");

        // set a max score / number of questions
        int scoreMax = 5;

        //display score
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        TextView textPrc = (TextView) findViewById(R.id.textScore);
        int score_prc = score*100/scoreMax;
        pb.setProgress(score_prc);
        textPrc.setText(score_prc+"%");


        switch (score)
        {
            case 0: t.setText("...");
                break;
            case 1: t.setText("Do not get discouraged ! DO IT !");
                break;
            case 2: t.setText("A new try maybe ?");
                break;
            case 3: t.setText("Not bad ! It's time to get better ;)");
                break;
            case 4:t.setText("Pretty good ! :D");
                break;
            case 5:t.setText("Who are you ? A spelling wizard ??!");
                break;
        }

        TextView textSuggest = (TextView) findViewById(R.id.textSuggestions);
        String IdTxtView;

        if (score<scoreMax){
            textSuggest.setText("Lessons suggestions :");


            for (int i=1; i<=errors.size();i++){
                IdTxtView = "textError"+i;

                int id = getResources().getIdentifier(IdTxtView,"id", getApplicationContext().getPackageName());
                Log.d("ID :", "the id :"+id);
                TextView tError =(TextView)findViewById(id);
                tError.setText(errors.get(i-1).getRULE().toString());
                tError.setClickable(true);
            }


        } else {
            textSuggest.setText("You are free to read which lessons you want ! :D");
        }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }


    @Override
    public void onClick(View v) {

        TextView txtv = (TextView) v;
        if (DataBaseCourses.COMMON_MISSPELLINGS.equals(txtv.getText().toString())){
            Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
            startActivityForResult(myIntent, 0);
        }

    }
}
