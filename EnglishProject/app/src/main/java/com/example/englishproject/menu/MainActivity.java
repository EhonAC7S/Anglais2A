package com.example.englishproject.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.englishproject.QuizActivity;
import com.example.englishproject.R;

public class MainActivity extends AppCompatActivity  {



    Button quizz;
    Button course;
    Button param;
    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        course = (Button) findViewById(R.id.Course);
        quizz = (Button)findViewById(R.id.Training);
        param = (Button)findViewById(R.id.Option);
        quit = (Button) findViewById(R.id.Exit);
        course.setText("Course");
        quizz.setText("Quiz");
        param.setText("Options");
        quit.setText("Quit");
        //Rend les boutons cliquables
        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), QuizActivity.class);
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
