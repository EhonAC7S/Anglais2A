package com.example.englishproject.courses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import com.example.englishproject.R;
import com.example.englishproject.courses.dataelement.CourseContents;
import com.example.englishproject.courses.dataelement.DataBaseCourses;

public class CourseDisplayer extends AppCompatActivity {

    public static final String EXEMPLES = "Exemples :";
    private TextView IDOfCourse;
    private TextView TitleOfCourse;
    private TextView DescOfCourse;
    private TextView Exemple0OfCourse;
    private TextView Exemple1OfCourse;
    private TextView Exemple2OfCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_displayer);
        Bundle b = getIntent().getExtras();
        CharSequence LessonID= b.getCharSequence("CourseId");
        DataBaseCourses bd = new DataBaseCourses(this);
        CourseContents course = bd.getCourseContents(LessonID.toString());



        IDOfCourse = (TextView) findViewById(R.id.IDOfCourse);
        SpannableString contentID = new SpannableString(course.getID());
        contentID.setSpan(new UnderlineSpan(), 0, contentID.length(), 0);
        IDOfCourse.setText(contentID);
        TitleOfCourse = (TextView) findViewById(R.id.titleOfCourse);
        DescOfCourse = (TextView) findViewById(R.id.descrOfCourse);
        Exemple0OfCourse = (TextView) findViewById(R.id.exemple0OfCourse);
        Exemple1OfCourse = (TextView) findViewById(R.id.exemple1OfCourse);
        Exemple2OfCourse = (TextView) findViewById(R.id.exemple2OfCourse);
        TitleOfCourse.setText(course.getTitle());
        DescOfCourse.setText(course.getDesc());
        Exemple0OfCourse.setText(EXEMPLES);
        Exemple1OfCourse.setText(course.getExemple1());
        Exemple2OfCourse.setText(course.getExemple2());

    }
}
