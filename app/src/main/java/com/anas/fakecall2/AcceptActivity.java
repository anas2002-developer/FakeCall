package com.anas.fakecall2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AcceptActivity extends AppCompatActivity {

    TextView callee;
    TextView txtCalltime;
    Button btnEnd;

    Handler handler;
    Runnable runnable;
    int number=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept);

        txtCalltime=findViewById(R.id.txtCalltime);
        btnEnd=findViewById(R.id.btnEnd);
        callee=findViewById(R.id.callee);

        callee.setText(getIntent().getStringExtra("Callername"));

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (number < 10) {
                    txtCalltime.setText( "00:0" + number);
                } else if (number > 10 && number < 60) {
                    txtCalltime.setText( "00:" + number);
                } else if (number > 59 && number % 60 < 10) {
                    int second = number / 60;
                    txtCalltime.setText( second+":0" + number % 60);
                } else {
                    int second = number / 60;
                    txtCalltime.setText( second+":" + number % 60);
                }
                number++;
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);

    }
}