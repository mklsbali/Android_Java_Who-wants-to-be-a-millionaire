package com.example.mythirdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class StartActivity extends AppCompatActivity {
    public int nrOfQuestions=4;
    Question q1, q2, q3, q4;
    int currentID=0;
    int q_id=0;
    int selected=0;
    Button a1, a2, a3, a4, check, menu;
    TextView q_p, q;
    Toast myToast;
    ArrayList<Question>questions=new ArrayList<Question>();
    ArrayList<Integer>q_as=new ArrayList<Integer>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.start);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        a4 = (Button) findViewById(R.id.a4);
        a1.setBackgroundColor(getResources().getColor(R.color.gray));
        a2.setBackgroundColor(getResources().getColor(R.color.gray));
        a3.setBackgroundColor(getResources().getColor(R.color.gray));
        a4.setBackgroundColor(getResources().getColor(R.color.gray));
        check = (Button) findViewById(R.id.ch_ansv_go_next);
        menu = (Button) findViewById(R.id.menu);

        q_p = (TextView) findViewById(R.id.q_p);
        q = (TextView) findViewById(R.id.q);


        /**Questions*/
        //1.
        String q1_q_p="First question for 100 000 $";
        String q1_q="Who is the author of the Harry Potter series?";
        String q1_a1=" A: Joanne Kathleen Rowling";
        String q1_a2=" B: Robert Ervin Howard";
        String q1_a3=" C: Charles Dickens";
        String q1_a4=" D: Barack Obama";
        Integer q1_c_a=1;
        q_as.add(q1_c_a);
        q1=new Question(q_id++, q1_q_p,q1_q, q1_a1,q1_a2,q1_a3,q1_a4);
        questions.add(q1);

        String q2_q_p="Second question for 200 000 $";
        String q2_q="Which of the following is a formula for a Pythagorean theorem??";
        String q2_a1=" A: a^2 - b^2 = c^2";
        String q2_a2=" B: a^2 + b^2 = c^2";
        String q2_a3=" C: a^2 + b^2 + c^2 = 0";
        String q2_a4=" D: (a+b)^2 = c^2";
        Integer q2_c_a=2;
        q_as.add(q2_c_a);
        q2=new Question(q_id++, q2_q_p,q2_q, q2_a1,q2_a2,q2_a3,q2_a4);
        questions.add(q2);

        String q3_q_p="Third question for 500 000 $";
        String q3_q="In which year did World War II end in Europe?";
        String q3_a1=" A: 1944";
        String q3_a2=" B: 1946";
        String q3_a3=" C: 1943";
        String q3_a4=" D: 1945";
        Integer q3_c_a=4;
        q_as.add(q3_c_a);
        q3=new Question(q_id++, q3_q_p,q3_q, q3_a1,q3_a2,q3_a3,q3_a4);
        questions.add(q3);

        String q4_q_p="Fourth question for 1 000 000 $";
        String q4_q="What is that? It has 4 legs, table but not chair.";
        String q4_a1=" A: Chair";
        String q4_a2=" B: Table";
        String q4_a3=" C: Goat";
        String q4_a4=" D: A table has 3 legs";
        Integer q4_c_a=2;
        q_as.add(q4_c_a);
        q4=new Question(q_id++, q4_q_p,q4_q, q4_a1,q4_a2,q4_a3,q4_a4);
        questions.add(q4);


        /**\Questions*/
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setBackgroundColor(getResources().getColor(R.color.g));
                a2.setBackgroundColor(getResources().getColor(R.color.gray));
                a3.setBackgroundColor(getResources().getColor(R.color.gray));
                a4.setBackgroundColor(getResources().getColor(R.color.gray));
                selected = 1;
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setBackgroundColor(getResources().getColor(R.color.gray));
                a2.setBackgroundColor(getResources().getColor(R.color.g));
                a3.setBackgroundColor(getResources().getColor(R.color.gray));
                a4.setBackgroundColor(getResources().getColor(R.color.gray));
                selected = 2;
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setBackgroundColor(getResources().getColor(R.color.gray));
                a2.setBackgroundColor(getResources().getColor(R.color.gray));
                a3.setBackgroundColor(getResources().getColor(R.color.g));
                a4.setBackgroundColor(getResources().getColor(R.color.gray));
                selected = 3;
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setBackgroundColor(getResources().getColor(R.color.gray));
                a2.setBackgroundColor(getResources().getColor(R.color.gray));
                a3.setBackgroundColor(getResources().getColor(R.color.gray));
                a4.setBackgroundColor(getResources().getColor(R.color.g));
                selected = 4;
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selected==q_as.get(currentID))
                {

                    nextQuestion();
                    myToast= Toast.makeText(getApplicationContext(),"Correct answer", Toast.LENGTH_LONG);
                    myToast.show();
                }
                else if (selected==0){
                    myToast= Toast.makeText(getApplicationContext(),"No answer selected", Toast.LENGTH_LONG);
                    myToast.show();
                }
                else
                {
                    myToast= Toast.makeText(getApplicationContext(),"Incorrect answer", Toast.LENGTH_LONG);
                    myToast.show();
                    WinLose.status=false;
                    Intent i=new Intent(StartActivity.this, WinLose.class);
                    startActivity(i);
                }

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void nextQuestion()
    {
        a1.setBackgroundColor(getResources().getColor(R.color.gray));
        a2.setBackgroundColor(getResources().getColor(R.color.gray));
        a3.setBackgroundColor(getResources().getColor(R.color.gray));
        a4.setBackgroundColor(getResources().getColor(R.color.gray));
        selected=0;
        currentID++;
        if (currentID==nrOfQuestions){
            WinLose.status=true;
            Intent i=new Intent(StartActivity.this, WinLose.class);
            startActivity(i);
            return;
        }
        Question current=questions.get(currentID);
        String q_pp=current.getQ_price();
        String qq=current.getQuestion();
        String aa1=current.getA1();
        String aa2=current.getA2();
        String aa3=current.getA3();
        String aa4=current.getA4();
        q_p.setText(q_pp);
        q.setText(qq);
        a1.setText(aa1);
        a2.setText(aa2);
        a3.setText(aa3);
        a4.setText(aa4);

    }

}
