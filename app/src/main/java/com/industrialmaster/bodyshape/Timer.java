package com.industrialmaster.bodyshape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    NumberPicker n1,n2;
    TextView tv;
    Handler handler;

    int m=0;
    int s=0;

    int y=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //  tv=findViewById(R.id.count);

        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);

        n1.setMinValue(0);
        n1.setMaxValue(59);
        n2.setMinValue(0);
        n2.setMaxValue(59);

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                //tv.setText(""+y);
                // if(y==9)
                //last session code
                n1.setValue(m);
                n2.setValue(s);
                if(m==0 && s==0)
                {
                    Intent intent=new Intent(Timer.this,Menu.class);
                    startActivity(intent);
                }


            }
        };
    }

    public void start(View view)
    {
        //1st method- this will not work for older versions and also this is not the complete work if code
       /* for(int i=0;i<10;i++)
       try {
            Thread.sleep(1000);
            tv.setText(""+i);
         }
        catch(Exception e){


        }*/

        //2nd method-this will work for all the versions and it s the complete work of code

      /*
       Runnable r=new Runnable() {
           @Override
           public void run() {
               for(int i=0;i<100;i++)
               try {
                   Thread.sleep(1000);
                  // tv.setText(""+i);
                    final int x=i;
                   Runnable r2=new Runnable() {
                       @Override
                       public void run()
                       {
                           tv.setText(""+x);
                       }
                   };
                   runOnUiThread(r2);
               }
               catch(Exception e){


               }

           }
       };
       Thread t =new Thread(r);
       t.start();*/



        //Handler code
        Runnable r=new Runnable() {
            @Override
            public void run() {

                int total=(n1.getValue()*60)+n2.getValue();
                //for(int i=0;i<5;i++)
                for(int i=total;i>=0;i--)
                    try {
                        Thread.sleep(1000);
                        // y=i;

                        m=i/60;
                        s=i%60;

                        handler.sendEmptyMessage(0);
                    }
                    catch(Exception e){


                    }
            }
        };

        Thread t =new Thread(r);
        t.start();



        //Asyn Task(Asynchronous Task)

    }



}