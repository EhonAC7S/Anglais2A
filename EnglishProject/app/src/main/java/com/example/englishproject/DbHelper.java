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
    private static final String KEY_RULE= "rule"; // règle
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
                +KEY_PART2 +" TEXT, "+KEY_PART3 +" TEXT, "+KEY_RULE +" TEXT)";
        db.execSQL(sql);
        addSentences();
        //db.close();
    }
    private void addSentences()
    {
        Sentence q1=new Sentence("It may be possible", " to reach ", "agreemment.", "agreemment.", "Common Misspellings");
        this.addSentence(q1);
        Sentence q2=new Sentence("Each department must be", " treated in an ", "appropriate way.", "NO MISSPELLING", "Common Misspellings");
        this.addSentence(q2);
        Sentence q3=new Sentence("Can I", " interupt ","you ?"," interupt ", "Common Misspellings");
        this.addSentence(q3);
        Sentence q4=new Sentence("What are the characteristics of successful", " bussiness ", "meetings."," bussiness ", "Common Misspellings");
        this.addSentence(q4);
        Sentence q5=new Sentence("The key to a successful oral"," presentations is to ","keep things simple.","NO MISSPELLING", "Common Misspellings");
        this.addSentence(q5);

        Sentence q1bis=new Sentence("Mr Despres", " accidently ", "scheduled two classes at the same time.", " accidently ", "Common Misspellings");
        this.addSentence(q1bis);
        Sentence q2bis=new Sentence("The letter was returned, as the", " adress ", "was unreadable.", " adress ", "Common Misspellings");
        this.addSentence(q2bis);
        Sentence q3bis=new Sentence("Even though she's ten, she still", " beleive ","in fairies.","  beleive  ", "Common Misspellings");
        this.addSentence(q3bis);
        Sentence q4bis=new Sentence("Uncork the wine and leave it to", " breath ", "for an hour before you serve it."," breath ", "Common Misspellings");
        this.addSentence(q4bis);
        Sentence q5bis=new Sentence("Her strong commitment to women's"," rights made ","her determined to continue.","NO MISSPELLING", "Common Misspellings");
        this.addSentence(q5bis);

        Sentence q1bis2=new Sentence("It's unpractical to", " copywrite ", "clothing designs.", " copywrite ", "Common Misspellings");
        this.addSentence(q1bis2);
        Sentence q2bis2=new Sentence("She got some medicine that helped", " the baby's ", "diarrea.", "diarrea.", "Common Misspellings");
        this.addSentence(q2bis2);
        Sentence q3bis2=new Sentence("Good", " goverment ","needs vigilant citizens.","  goverment  ", "Common Misspellings");
        this.addSentence(q3bis2);
        Sentence q4bis2=new Sentence("The guerrillas constantly", " harrassed ", "the invaders' supply lines."," harrassed ", "Common Misspellings");
        this.addSentence(q4bis2);
        Sentence q5bis2=new Sentence("The new mother hemorrhaged after giving birth"," and stayed ","in the hospital for a week.","NO MISSPELLING", "Common Misspellings");
        this.addSentence(q5bis2);

        Sentence q1bis3=new Sentence("He's enjoying his independence", " now that ", "he's single again.", "NO MISSPELLING", "Common Misspellings");
        this.addSentence(q1bis3);
        Sentence q2bis3=new Sentence("The old church was struck by", " lightening ", "and caught fire.", " lightening ", "Common Misspellings");
        this.addSentence(q2bis3);
        Sentence q3bis3=new Sentence("When he retired he found he didn't", " have any ","pasttimes.","pasttimes.", "Common Misspellings");
        this.addSentence(q3bis3);
        Sentence q4bis3=new Sentence("I find his pronunciation really", " difficult ", "to follow.","NO MISSPELLING", "Common Misspellings");
        this.addSentence(q4bis3);
        Sentence q5bis3=new Sentence("Which would you prefer -"," potato waffles ","or fries?","NO MISSPELLING", "Common Misspellings");
        this.addSentence(q5bis3);


        Sentence q6=new Sentence("Pepsi is not"," dislike ","Coke."," dislike ", "Prefixes");
        this.addSentence(q6);
        Sentence q7=new Sentence("In important ways,"," the two sisters are ","very unlike.","NO MISSPELLING", "Prefixes");
        this.addSentence(q7);
        Sentence q8=new Sentence("Taking things that aren't"," yours is ","unlegal.","unlegal.", "Prefixes");
        this.addSentence(q8);
        Sentence q9=new Sentence("It never pays to be"," inpatient ","with old people."," inpatient ", "Prefixes");
        this.addSentence(q9);
        Sentence q10=new Sentence("I'd love to help you decorate"," but I'm ","horribly impractical.","NO MISSPELLING", "Prefixes");
        this.addSentence(q10);


        Sentence q11=new Sentence("The athlete made an"," extraordinery ","jump."," extraordinery ", "Suffixes");
        this.addSentence(q11);
        Sentence q12=new Sentence("Is this shirt"," availible ","in any other colours ?"," availible ", "Suffixes");
        this.addSentence(q12);
        Sentence q13=new Sentence("Conditioner makes my hair"," more ","manageable.","NO MISSPELLING", "Suffixes");
        this.addSentence(q13);
        Sentence q14=new Sentence("The book includes an"," introductory ","chapter.","NO MISSPELLING", "Suffixes");
        this.addSentence(q14);
        Sentence q15=new Sentence("The government was oppressive,"," and the people lived in ","misary.","misary.", "Suffixes");
        this.addSentence(q15);


        Sentence q16=new Sentence("What did you and your"," partner do for ","Valentines day ?","Valentines day ?", "Apostrophes for possession");
        this.addSentence(q16);
        Sentence q17=new Sentence("On April Fools Day"," it's traditional to play practical ","jokes on people before midday.","On April Fools Day", "Apostrophes for possession");
        this.addSentence(q17);
        Sentence q18=new Sentence("Italy is one of the"," world's great ","wine countries.","NO MISSPELLING", "Apostrophes for possession");
        this.addSentence(q18);
        Sentence q19=new Sentence("November 9th is my"," parent's wedding ","anniversary."," parent's wedding ", "Apostrophes for possession");
        this.addSentence(q19);
        Sentence q20=new Sentence("She's Britain's most"," popular TV ","gardener.","NO MISSPELLING", "Apostrophes for possession");
        this.addSentence(q20);


        Sentence q21=new Sentence("The police carried out a"," thorough ","search of the area.","NO MISSPELLING", "though/thought/thorough/through");
        this.addSentence(q21);
        Sentence q22=new Sentence("Her words kept running"," though ","my mind."," though ", "though/thought/thorough/through");
        this.addSentence(q22);
        Sentence q23=new Sentence("Even though it's small,"," the room ","has a spacious feel.","NO MISSPELLING", "though/thought/thorough/through");
        this.addSentence(q23);
        Sentence q24=new Sentence("He failed his exams"," thought ","not studying enough."," thought ", "though/thought/thorough/through");
        this.addSentence(q24);
        Sentence q25=new Sentence("The boy was"," lost in ","thought.","thought.", "though/thought/thorough/through");
        this.addSentence(q25);

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
        values.put(KEY_RULE, sent.getRULE());
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
        String selectQuery = "SELECT  * FROM " + TABLE_SENTENCE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
