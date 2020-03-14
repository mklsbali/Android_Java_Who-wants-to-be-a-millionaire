package com.example.mythirdapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WinLose extends AppCompatActivity {
    public static boolean status;
    TextView tv;
    Button menu;
    Button exit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.win_lose);
        tv=(TextView)findViewById(R.id.win_lose_text);
        menu=(Button)findViewById(R.id.win_lose_menu);
        exit=(Button)findViewById(R.id.win_lose_exit);
        findViewById(R.id.mainID).getBackground().setAlpha(120);
        if (status==false)
            tv.setText("You lost! The win is 0 $");
        else
            tv.setText("Congratulations! You won 1-000-000 $.");
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(WinLose.this, MainActivity.class);
                startActivity(i);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
                System.exit(0);
            }
        });

    }


}
