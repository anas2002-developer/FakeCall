package com.anas.fakecall2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CallActivity extends AppCompatActivity {

    TextView txtCallername;
    Button btnDecline,btnAccept;


    MediaPlayer mediaPlayer;
    Handler handler;
    Runnable runnable;
    TextView timeText;
    int number;
    String delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        txtCallername=findViewById(R.id.txtCallername);
        btnDecline=findViewById(R.id.btnDecline);
        btnAccept=findViewById(R.id.btnAccept);

        txtCallername.setText(getIntent().getStringExtra("Contactname"));



        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();



        btnDecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                mediaPlayer.stop();
                Intent i = new Intent(CallActivity.this,AcceptActivity.class);
                i.putExtra("Callername",getIntent().getStringExtra("Contactname"));
                startActivity(i);



            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
        finish();
    }
}