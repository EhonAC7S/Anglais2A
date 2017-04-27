package com.example.englishproject.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.englishproject.R;
import com.example.englishproject.database.BdCourses;
import com.example.englishproject.database.DataElement.CoursesContents;

import java.util.ArrayList;

public class CoursActivity extends AppCompatActivity {

    private ArrayList<CoursesContents> listeDesCours;
    //private ArrayList<CoursesContents> listeDesCoursAffichés;
    private int nbOfCoursDisplayed = 6; //Au nombre de 6 actuellement dans le layout
    private Button cours1;
    private Button cours2;
    private Button cours3;
    private Button cours4;
    private Button cours5;
    private Button cours6;
    private Button nextPage;
    private Button previousPage;

 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        BdCourses bd = new BdCourses(this);
        listeDesCours = bd.getAllCourses();
        int coursNumber = listeDesCours.size();
        int begin = 0;

    }

    public boolean canGoNext(int begin, int courseNumber) {
        if (begin+nbOfCoursDisplayed < courseNumber) {
            return true;
        } else return false;
    }
    public boolean canGoPrevious(int begin) {
        if (begin>=nbOfCoursDisplayed) {
            return true;
        } else return false;
    }
}
