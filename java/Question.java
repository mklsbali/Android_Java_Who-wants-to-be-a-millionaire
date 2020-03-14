package com.example.mythirdapplication;

import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Question {
    private int id;
    private String a1, a2, a3, a4;
    private String q_price;
    private String question;

    public Question(int id, String  q_price, String question, String a1, String a2, String a3, String a4){
        this.id=id;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
        this.a4=a4;
        this.question=question;
        this.q_price=q_price;

    }
    public String getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }
    public String getA4() {
        return a4;
    }

    public String getQ_price(){
        return  q_price;
    }
    public String getQuestion(){
        return question;
    }
    public int getId(){return id;}


}

