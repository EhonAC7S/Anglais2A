package com.example.englishproject.courses.dataelement;

/**
 * Created by jorda on 27/04/2017.
 */
import java.util.ArrayList;
import java.util.Collections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseCourses extends SQLiteOpenHelper{
    //Ici on met les constantes des noms de nos Cours
    public static final String COMMON_MISSPELLINGS = "Common Misspellings";
    public static final String SUFFIXES = "Suffixes";
    public static final String APOSTROPHES_FOR_POSSESSION = "Apostrophes for possession";
    public static final String THOUGH_THOUGHT_THOROUGH_THROUGH = "though/thought/thorough/through";
    public static final String PREFIXES = "Prefixes";
    public static final String ACTIVE_VOICE = "Active Voice";
    public static final String CONJUNCTIONS = "Conjunctions";
    public static final String COMMA = "Comma";
    public static final String SEMICOLON = "Semicolon";
    public static final String SIMPLE_PRESENT = "Simple Present";
    public static final String PRESENT_PROGRESSIVE = "Present Progressive";
    public static final String ED_RULE = "-ed rule";
    public static final String PRESENT_PERFECT = "Present Perfect";
    public static final String PRESENT_PERFECT_PROG = "Present Perfect Progressive";
    public static final String PAST_PERFECT = "Past Perfect";
    public static final String FORMING_PLURALS = "Forming Plural";
    public static final String THEIR_THERE_THEYRE = "Their/There/They re";


    private static final String SELECT_FROM = "SELECT * FROM ";

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Courses";

    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCR = "descr";
    private static final String KEY_EX1 = "example1";
    private static final String KEY_RULE = "rule";
    private static final String KEY_EX2 ="example2";
    public static final String TEXT = " TEXT, ";

    private SQLiteDatabase dbase;
    public DataBaseCourses(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        System.out.println("On est dans le OnCreate()");

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        String sql = "CREATE TABLE IF NOT EXISTS " + DATABASE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_RULE + TEXT +KEY_TITLE + TEXT
                + KEY_DESCR +TEXT+ KEY_EX1 +TEXT+ KEY_EX2 +" TEXT)";
        db.execSQL(sql);
        addCourses();
        //db.close();
    }
    private void addCourses()
    {
        //Ajouter les contenus des cours ici
        addCourse(new CourseContents(THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(ACTIVE_VOICE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(CONJUNCTIONS,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(PRESENT_PERFECT_PROG,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(PRESENT_PERFECT,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(ED_RULE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(PRESENT_PROGRESSIVE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));
        addCourse(new CourseContents(SIMPLE_PRESENT,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE,THEIR_THERE_THEYRE));


    }

    public CourseContents getCourseContents(String rule) {
        String selectQuery = "SELECT * FROM " + DATABASE_NAME + " WHERE "+ KEY_RULE +" = '" + rule + "'";
        System.out.println(selectQuery);
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        System.out.println(cursor.getCount());
        // Ici on peut combler un manque d'optimisation puisque la RULE est enfait l'ID qui se retrouve
        // dédoublé dans la BD mais pas dans la classe CourseContents
        System.out.println(cursor.moveToFirst());
        CourseContents course = new CourseContents();
        course.setRULE(cursor.getString(1));
        //System.out.println(cursor.getString(1));
        course.setTitle(cursor.getString(2));
        course.setDesc(cursor.getString(3));
        course.setExemple1(cursor.getString(4));
        course.setExemple2(cursor.getString(5));
        return course;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        // Create tables again
        onCreate(db);
    }
    // Adding new sentence
    public void addCourse(CourseContents sent) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RULE, sent.getRULE());
        values.put(KEY_TITLE, sent.getTitle());
        values.put(KEY_DESCR, sent.getDesc());
        values.put(KEY_EX1, sent.getExemple1());
        values.put(KEY_EX2, sent.getExemple2());
        // Inserting Row
        dbase.insert(DATABASE_NAME, null, values);
    }
    public ArrayList<CourseContents> getAllCourses() {
        ArrayList<CourseContents> sentList = new ArrayList<CourseContents>();
        // Select All Query
        String selectQuery = SELECT_FROM + DATABASE_NAME;
        dbase=this.getReadableDatabase();
        //System.out.println(selectQuery);

        Cursor cursor = dbase.rawQuery(selectQuery, null);
        //System.out.println(cursor.getString(0));

        //System.out.println(cursor.moveToFirst());
        //System.out.println("nb colonnes :" +cursor.getColumnCount());
        //System.out.println("Curseur bien placé? :" +cursor.move(-1000));
        //System.out.println("nb lignes :" +cursor.getCount());
        //System.out.println(dbase.getPath());


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                CourseContents course = new CourseContents();
                course.setRULE(cursor.getString(1));
                //System.out.println(cursor.getString(1));
                course.setTitle(cursor.getString(2));
                course.setDesc(cursor.getString(3));
                course.setExemple1(cursor.getString(4));
                course.setExemple2(cursor.getString(5));
                sentList.add(course);
            } while (cursor.moveToNext());
        } else System.out.println("La requete elle pue");

        return sentList;
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = SELECT_FROM + DATABASE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
