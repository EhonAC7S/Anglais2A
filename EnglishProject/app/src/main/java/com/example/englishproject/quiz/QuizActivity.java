package com.example.englishproject.quiz;
import java.util.ArrayList;
import java.util.Collections;


import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.englishproject.R;
import com.example.englishproject.quiz.dataelement.DbHelper;
import com.example.englishproject.quiz.dataelement.Sentence;

import static com.example.englishproject.quiz.dataelement.DbHelper.NO_MISSPELLING;


public class QuizActivity extends Activity implements View.OnClickListener{

    public static final String IS_THERE_A_MISSPELLING_HERE = "Is there a misspelling here ?";
    // initialisation des variables
    ArrayList<Sentence> sentList;
    ArrayList<Sentence> errorsList;
    int score=0;
    int qid=0;
    Sentence currentQ;
    TextView txtSentence, txtV1;
    Button butNoMisspelling;
    SpannableString ss;

    private class MyClickableSpan extends ClickableSpan{
        MyClickableSpan(){
            super();
        }
        public void onClick(View tv){}
        public void updateDrawState(TextPaint ds){
            ds.setUnderlineText(false);
        }
    }

    MyClickableSpan span1 = new MyClickableSpan() {
        @Override
        public void onClick(View textView) {
            //TextView answer = (TextView)textView;
            Log.d("yourans", "|"+currentQ.getANSWER()+"|"+ss.subSequence(0, currentQ.getPART1().length())+"|");
            // on compare la valeur de l'élément avec la réponse présente dans la liste issue de la BDD
            if(currentQ.getANSWER().equals(ss.subSequence(0, currentQ.getPART1().length()).toString()))
            {
                score++;
                Log.d("score", "Your score"+score);
            } else {
                addError(errorsList,currentQ);
            }
        }
    };

    MyClickableSpan span2 = new MyClickableSpan() {
        @Override
        public void onClick(View textView) {
            //TextView answer = (TextView)textView;
            Log.d("yourans", "|"+currentQ.getANSWER()+"|"+ss.subSequence(currentQ.getPART1().length(), currentQ.getPART1().length()+currentQ.getPART2().length())+"|");
            // on compare la valeur de l'élément avec la réponse présente dans la liste issue de la BDD
            if(currentQ.getANSWER().equals(ss.subSequence(currentQ.getPART1().length(), currentQ.getPART1().length()+currentQ.getPART2().length()).toString()))
            {
                score++;
                Log.d("score", "Your score"+score);
            } else {
                addError(errorsList,currentQ);
            }
        }
    };

    MyClickableSpan span3 = new MyClickableSpan() {
        @Override
        public void onClick(View textView) {
            //TextView answer = (TextView)textView;
            Log.d("yourans", "|"+currentQ.getANSWER()+"|"+ss.subSequence(currentQ.getPART1().length()+currentQ.getPART2().length(), currentQ.getPART1().length()+currentQ.getPART2().length()+currentQ.getPART3().length())+"|");
            // on compare la valeur de l'élément avec la réponse présente dans la liste issue de la BDD
            if(currentQ.getANSWER().equals(ss.subSequence(currentQ.getPART1().length()+currentQ.getPART2().length(), currentQ.getPART1().length()+currentQ.getPART2().length()+currentQ.getPART3().length()).toString()))
            {
                score++;
                Log.d("score", "Your score"+score);
            } else {
                addError(errorsList,currentQ);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state

            sentList = savedInstanceState.getParcelableArrayList("sentList");
            errorsList = savedInstanceState.getParcelableArrayList("errorsList");
            score = savedInstanceState.getInt("score");
            qid = savedInstanceState.getInt("qid")-1;

        } else {

            // initialisation de la BDD à l'aide de DbHelper et récupération de la liste des phrases
            DbHelper db=new DbHelper(this);
            sentList=db.getAllSentences();

            // randomization de la liste
            Collections.shuffle(sentList);

            // on prépare une arraylist pour stocker les erreurs de l'utilisateur
            errorsList = new ArrayList<>();

            // petit message d'encouragement :D
            Toast.makeText(this, "Good luck :D", Toast.LENGTH_LONG).show();

        }


        setContentView(R.layout.activity_quiz);

        // on récupère la 1ère phrase de la liste randomisée
        currentQ=sentList.get(qid);

        // récupération des éléments du layout et changement du texte via setSentenceView()
        txtSentence=(TextView)findViewById(R.id.textView1);
        txtV1=(TextView)findViewById(R.id.textViewSentence1);
        //txtV2=(TextView)findViewById(R.id.textViewSentence2);
        //txtV3=(TextView)findViewById(R.id.textViewSentence3);
        butNoMisspelling=(Button)findViewById(R.id.button1);
        setSentenceView();

        // on attache tous les éléments au même listener : OnClick()
        txtV1.setOnClickListener(this);
        //txtV2.setOnClickListener(this);
        //txtV3.setOnClickListener(this);
        butNoMisspelling.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    // change le texte des éléments présents à l'écran
    private void setSentenceView()
    {

        txtSentence.setText(IS_THERE_A_MISSPELLING_HERE);
        ss = new SpannableString(currentQ.getPART1()+currentQ.getPART2()+currentQ.getPART3());
        ss.setSpan(span1, 0,currentQ.getPART1().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, currentQ.getPART1().length(), currentQ.getPART1().length()+currentQ.getPART2().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span3, currentQ.getPART1().length()+currentQ.getPART2().length(), currentQ.getPART1().length()+currentQ.getPART2().length()+currentQ.getPART3().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtV1.setText(ss);
        txtV1.setMovementMethod(LinkMovementMethod.getInstance()); //A quoi ca sert?? LoL
        //txtV2.setText(currentQ.getPART2());
        //txtV3.setText(currentQ.getPART3());
        qid++;
    }

    // Le fameux OnClickListener de tout le monde
    @Override
    public void onClick(View v) {

        if(v == butNoMisspelling){

            Log.d("yourans", currentQ.getANSWER()+" "+NO_MISSPELLING);
            // on compare la valeur de l'élément avec la réponse présente dans la liste issue de la BDD
            if(currentQ.getANSWER().equals(NO_MISSPELLING))
            {
                score++;
                Log.d("score", "Your score"+score);
            } else {
                addError(errorsList,currentQ);
            }
        }

        // Si 5 questions n'ont pas été posées on load une nouvelle phrase
        if(qid<5){

            currentQ=sentList.get(qid);
            setSentenceView();

        }else{ // on se dirige vers l'activité des résultats du test
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);

            b.putParcelableArrayList("errors", errorsList);

            intent.putExtras(b);

            startActivity(intent);
            finish();
        }
    }

    private void addError(ArrayList<Sentence> list, Sentence sentence) {

        boolean exist = false;
        for (Sentence item : list) {
            if (item.getRULE().equals(sentence.getRULE())) {
                exist = true;
            }
        }

        if (!exist){
            errorsList.add(currentQ);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putParcelableArrayList("sentList", sentList);
        savedInstanceState.putParcelableArrayList("errorsList", errorsList);
        savedInstanceState.putInt("score", score);
        savedInstanceState.putInt("qid", qid);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

}
