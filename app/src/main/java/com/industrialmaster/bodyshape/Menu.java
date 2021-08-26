package com.industrialmaster.bodyshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button exitbtn = (Button) findViewById(R.id.exitbtn);
        exitbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

    }

    public void MainActivity(View v)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void TimerSelect(View v)
    {
        Intent intent=new Intent(this,Timer.class);
        startActivity(intent);
    }
}