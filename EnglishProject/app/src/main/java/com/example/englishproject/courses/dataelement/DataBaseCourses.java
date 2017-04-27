package com.example.englishproject.courses.dataelement;

/**
 * Created by jorda on 27/04/2017.
 */
import java.util.ArrayList;

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

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Courses";
    // tasks table name
    private static final String TABLE_COURSES = "courses";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCR = "descr";
    private static final String KEY_EX1 = "example1";
    private static final String KEY_EX2 ="example2";

    private SQLiteDatabase dbase;
    public DataBaseCourses(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_COURSES + " ( "
                + KEY_ID + " TEXT, " + KEY_TITLE +" TEXT, "
                + KEY_DESCR +" TEXT, "+ KEY_EX1 +" TEXT, "+ KEY_EX2 +" TEXT)";
        db.execSQL(sql);
        addCourses();
        //db.close();
    }
    private void addCourses()
    {
        //Ajouter les contenus des cours ici


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSES);
        // Create tables again
        onCreate(db);
    }
    // Adding new sentence
    public void addCourse(CourseContents sent) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, sent.getTitle());
        values.put(KEY_DESCR, sent.getDesc());
        values.put(KEY_EX1, sent.getExemple1());
        values.put(KEY_EX2, sent.getExemple2());
        values.put(KEY_EX2, sent.getRULE());
        // Inserting Row
        dbase.insert(TABLE_COURSES, null, values);
    }
    public ArrayList<CourseContents> getAllCourses() {
        ArrayList<CourseContents> sentList = new ArrayList<CourseContents>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COURSES;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CourseContents sent = new CourseContents();
                sent.setID(cursor.getString(0));
                sent.setTitle(cursor.getString(1));
                sent.setDesc(cursor.getString(2));
                sent.setExemple1(cursor.getString(3));
                sent.setExemple2(cursor.getString(4));
                sent.setRULE(cursor.getString(5));
                sentList.add(sent);
            } while (cursor.moveToNext());
        }
        // return sent list
        return sentList;
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_COURSES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
