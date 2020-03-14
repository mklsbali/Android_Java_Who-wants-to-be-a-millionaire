package com.example.mythirdapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {

    public static boolean status;

    Button start;
    Button help;
    Button exit;
    Switch sw;
    Intent svc;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        svc=new Intent(this, Sound.class);

        start=(Button)findViewById(R.id.start1);
        help=(Button)findViewById(R.id.help);
        exit=(Button)findViewById(R.id.exit);
        sw=(Switch)findViewById(R.id.switch1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(MainActivity.this, StartActivity.class);
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
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Help.class);
                startActivity(i);
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    status=true;
                    startService(svc);
                }
                else{
                    status=false;
                    stopService(svc);
                }

            }
        });
        sw.setChecked(status);









    }
}
