package com.example.englishproject;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "quizDB";
    // tasks table name
    private static final String TABLE_SENTENCE = "sentence";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_PART1= "part1"; //option a
    private static final String KEY_PART2= "part2"; //option b
    private static final String KEY_PART3= "part3"; //option c
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SENTENCE);

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_SENTENCE + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ANSWER+ " TEXT, "+KEY_PART1 +" TEXT, "
                +KEY_PART2 +" TEXT, "+KEY_PART3+" TEXT)";
        db.execSQL(sql);
        addSentences();
        //db.close();
    }
    private void addSentences()
    {
        Sentence q1=new Sentence("HP", "IBM", "CISCO", "CISCO");
        this.addSentence(q1);
        Sentence q2=new Sentence("SuSe", "BIOS", "DOS", "BIOS");
        this.addSentence(q2);
        Sentence q3=new Sentence("RAM", "FLASH","Register","Register");
        this.addSentence(q3);
        Sentence q4=new Sentence("Router", "Bridge", "Hub","Router");
        this.addSentence(q4);
        Sentence q5=new Sentence("I am so","happy","to see youuuuuuuu !","NO MISSPELLING");
        this.addSentence(q5);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SENTENCE);
        // Create tables again
        onCreate(db);
    }
    // Adding new sentence
    public void addSentence(Sentence sent) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ANSWER, sent.getANSWER());
        values.put(KEY_PART1, sent.getPART1());
        values.put(KEY_PART2, sent.getPART2());
        values.put(KEY_PART3, sent.getPART3());
        // Inserting Row
        dbase.insert(TABLE_SENTENCE, null, values);
    }
    public List<Sentence> getAllSentences() {
        List<Sentence> sentList = new ArrayList<Sentence>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SENTENCE;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Sentence sent = new Sentence();
                sent.setID(cursor.getInt(0));
                sent.setANSWER(cursor.getString(1));
                sent.setPART1(cursor.getString(2));
                sent.setPART2(cursor.getString(3));
                sent.setPART3(cursor.getString(4));
                sentList.add(sent);
            } while (cursor.moveToNext());
        }
        // return sent list
        return sentList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_SENTENCE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
