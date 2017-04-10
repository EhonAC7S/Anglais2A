package com.example.englishproject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
        bar.setNumStars(5);
        bar.setStepSize(0.5f);
        //get text view
        TextView t=(TextView)findViewById(R.id.textResult);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        //display score
        bar.setRating(score);

        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        int score_prc = score*100/5;
        pb.setProgress(score_prc);


        switch (score)
        {
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
