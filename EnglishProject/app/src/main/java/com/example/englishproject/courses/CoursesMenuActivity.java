package com.example.englishproject.courses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.englishproject.R;
import com.example.englishproject.courses.dataelement.DataBaseCourses;
import com.example.englishproject.courses.dataelement.CourseContents;


import java.util.ArrayList;

public class CoursesMenuActivity extends AppCompatActivity implements View.OnClickListener{
    // Quelques Strings important qu'on utilise
    public static final String NEXT = "Next";
    public static final String PREVIOUS = "Previous";
    // Les cours qu'on a dans la DataBase
    private ArrayList<CourseContents> listeDesCours;
    //Au nombre de 6 actuellement dans le layout
    private int nbOfCoursDisplayed = 6;
    //Les var des boutons quoi
    private Button cours1;
    private Button cours2;
    private Button cours3;
    private Button cours4;
    private Button cours5;
    private Button cours6;
    private Button nextPage;
    private Button previousPage;

    int coursNumber; // listeDesCours.size()
    int begin; //Où pointe actuellement le premier élement de la liste affichée

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
        //On lie les boutons du xml aux var de la classe Java
        cours1 = (Button) findViewById(R.id.Course1);
        cours2 = (Button) findViewById(R.id.Course2);
        cours3 = (Button) findViewById(R.id.Course3);
        cours4 = (Button) findViewById(R.id.Course4);
        cours5 = (Button) findViewById(R.id.Course5);
        cours6 = (Button) findViewById(R.id.Course6);
        nextPage = (Button) findViewById(R.id.nextBouton);
        previousPage = (Button) findViewById(R.id.previousButton);
        //On set le text des boutons Next et Previous
        nextPage.setText(NEXT);
        previousPage.setText(PREVIOUS);
        // Comportement particulier pour les boutons Next et Previous
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canGoNext()) {
                    begin = begin + 6; // On pointe 6 Cours en avant
                    actuButton();
                }
            }
        });
        previousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canGoPrevious()) {
                    begin = begin - 6; //On pointe 6 Cours en arrière
                    actuButton();
                }
            }
        });
        //Initialisation des boutons classiques
        cours1.setOnClickListener(this);
        cours2.setOnClickListener(this);
        cours3.setOnClickListener(this);
        cours4.setOnClickListener(this);
        cours5.setOnClickListener(this);
        cours6.setOnClickListener(this);

        DataBaseCourses bd = new DataBaseCourses(this);
        listeDesCours = bd.getAllCourses();
        coursNumber = listeDesCours.size()-1; //Indice du dernier Cours
        begin = 0;
        this.actuButton(); //Affiche les boutons en fonction du nombre que l'on peut afficher avec un contenu

    }

    private boolean canGoNext() {
        if (begin+nbOfCoursDisplayed<=coursNumber) { //Cas du bouton next
            return true;
        } else {
            return false;
        }
    }

    private boolean canGoPrevious() {
        if (begin>=nbOfCoursDisplayed) { // Cas du bouton previous
            return true;
        } else {
            return false;
        }
    }

    public void actuButton() { //A partir de l'état du curseur begin, on va chercher les elements de la liste 'listeDesCours' disponible pour les afficher
        if (begin<=coursNumber) {
            cours1.setVisibility(View.VISIBLE);
            cours1.setText(listeDesCours.get(begin).getID());
        } else {
            cours1.setVisibility(View.INVISIBLE); //On cache le bouton si on ne trouve pas de cours à afficher
        }
        if (begin+1<=coursNumber) {
            cours2.setVisibility(View.VISIBLE);
            cours2.setText(listeDesCours.get(begin+1).getID());
        } else {
            cours2.setVisibility(View.INVISIBLE);
        }
        if (begin+2<=coursNumber) {
            cours3.setVisibility(View.VISIBLE);
            cours3.setText(listeDesCours.get(begin+2).getID());
        } else {
            cours1.setVisibility(View.INVISIBLE);
        }
        if (begin+3<=coursNumber) {
            cours4.setVisibility(View.VISIBLE);
            cours4.setText(listeDesCours.get(begin+3).getID());
        } else {
            cours4.setVisibility(View.INVISIBLE);
        }
        if (begin+4<=coursNumber) {
            cours5.setVisibility(View.VISIBLE);
            cours5.setText(listeDesCours.get(begin+4).getID());
        } else {
            cours5.setVisibility(View.INVISIBLE);
        }
        if (begin+5<=coursNumber) {
            cours6.setVisibility(View.VISIBLE);
            cours6.setText(listeDesCours.get(begin+5).getID());
        } else {
            cours6.setVisibility(View.INVISIBLE);
        }
        if (begin+nbOfCoursDisplayed<=coursNumber) { //Cas du bouton next
            nextPage.setVisibility(View.VISIBLE);
            nextPage.setText(NEXT);
        } else {
            nextPage.setVisibility(View.INVISIBLE);
        }if (begin>=nbOfCoursDisplayed) { // Cas du bouton previous
            previousPage.setVisibility(View.VISIBLE);
            cours6.setText(PREVIOUS);
        } else {
            cours6.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        //Intent intent = new Intent(CoursesMenuActivity.this, ResultActivity.class);
        Bundle b = new Bundle();
        //b.putInt("score", score);

        //b.putParcelableArrayList("errors", errorsList);

        //intent.putExtras(b);

        //startActivity(intent);
    }
}
