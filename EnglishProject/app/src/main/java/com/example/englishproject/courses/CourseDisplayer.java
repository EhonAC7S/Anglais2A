package com.example.englishproject.courses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import com.example.englishproject.R;
import com.example.englishproject.courses.dataelement.CourseContents;
import com.example.englishproject.courses.dataelement.DataBaseCourses;

public class CourseDisplayer extends AppCompatActivity {

    public static final String EXEMPLES = "Examples :";
    public static final String COURSE_ID = "CourseId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_displayer);
        Bundle b = getIntent().getExtras();
        CharSequence LessonID= b.getCharSequence(COURSE_ID);

        DataBaseCourses bd = new DataBaseCourses(this);
        CourseContents course = bd.getCourseContents(LessonID.toString());
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
