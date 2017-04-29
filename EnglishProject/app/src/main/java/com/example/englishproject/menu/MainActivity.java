package com.example.englishproject.menu;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.englishproject.QuizActivity;
import com.example.englishproject.R;
import com.example.englishproject.courses.CoursesMenuActivity;

public class MainActivity extends AppCompatActivity  {

    public static final String COURSE = "Course";
    public static final String QUIZ = "Quiz";
    public static final String OPTIONS = "Options";
    public static final String QUIT = "Quit";
    public static final String LANDSCAPE = "landscape";
    public static final String PORTRAIT = "portrait";
    Button quiz;
    Button course;
    Button param;
    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, LANDSCAPE, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            initialize();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, PORTRAIT, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            initialize();
        }
    }

    private void initialize() {
        course = (Button) findViewById(R.id.Course);
        quiz = (Button)findViewById(R.id.Training);
        param = (Button)findViewById(R.id.Option);
        quit = (Button) findViewById(R.id.Exit);
        course.setText(COURSE);
        quiz.setText(QUIZ);
        param.setText(OPTIONS);
        quit.setText(QUIT);
        //Rend les boutons cliquables
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), CoursesMenuActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        param.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

}
