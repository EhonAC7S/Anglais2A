package com.example.englishproject.courses;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Toast;

import com.example.englishproject.R;
import com.example.englishproject.courses.dataelement.CourseContents;
import com.example.englishproject.courses.dataelement.DataBaseCourses;
import com.example.englishproject.menu.MainActivity;

public class CourseDisplayer extends AppCompatActivity {

    public static final String EXEMPLES = "Examples :";
    public static final String COURSE_ID = "CourseId";
    private DataBaseCourses bd;
    private CharSequence LessonID;
    CourseContents course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_displayer);
        if (savedInstanceState != null) {
            LessonID = savedInstanceState.getCharSequence(COURSE_ID);
        }
        else {
            Bundle b = getIntent().getExtras();
            LessonID = b.getCharSequence(COURSE_ID);
        }
        bd = new DataBaseCourses(this);
        course = bd.getCourseContents(LessonID.toString());
        initialize();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) { //Ce qu'il y a à sauver en cas de rotation
        savedInstanceState.putCharSequence(COURSE_ID,LessonID);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, MainActivity.LANDSCAPE, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_course_displayer);
            initialize();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, MainActivity.PORTRAIT, Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_course_displayer);
            initialize();
        }
    }

    private void initialize() {
        // Local var
        TextView IDOfCourse;
        TextView TitleOfCourse;
        TextView DescOfCourse;
        TextView Exemple0OfCourse;
        TextView Exemple1OfCourse;
        TextView Exemple2OfCourse;
        // Some text format and affectation
        IDOfCourse = (TextView) findViewById(R.id.IDOfCourse);
        SpannableString contentID = new SpannableString(course.getRULE());
        contentID.setSpan(new UnderlineSpan(), 0, contentID.length(), 0);
        IDOfCourse.setText(contentID);
        TitleOfCourse = (TextView) findViewById(R.id.titleOfCourse);
        DescOfCourse = (TextView) findViewById(R.id.descrOfCourse);
        Exemple0OfCourse = (TextView) findViewById(R.id.exemple0OfCourse);
        Exemple1OfCourse = (TextView) findViewById(R.id.exemple1OfCourse);
        Exemple2OfCourse = (TextView) findViewById(R.id.exemple2OfCourse);
        TitleOfCourse.setText(DataBaseCourses.LINEJUMP + DataBaseCourses.LINEJUMP + course.getTitle());
        DescOfCourse.setText(course.getDesc());
        DescOfCourse.setMovementMethod(new ScrollingMovementMethod());
        Exemple1OfCourse.setText(course.getExemple1());
        Exemple2OfCourse.setText(course.getExemple2());
        if (!course.getExemple1().equals("")) {
            Exemple0OfCourse.setText(EXEMPLES);
        } else {
            Exemple0OfCourse.setText("");
            Exemple0OfCourse.setVisibility(View.INVISIBLE);
            Exemple1OfCourse.setVisibility(View.INVISIBLE);
            Exemple2OfCourse.setVisibility(View.INVISIBLE);
        }
    }
}
