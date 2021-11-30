package com.example.ipd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search_go_btn = (Button) findViewById(R.id.search_go_btn);
        Button history_go_btn = (Button) findViewById(R.id.history_go_btn);
        Button alarm_go_btn = (Button) findViewById(R.id.alarm_go_btn);

        search_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View search_go_btn) {
                Intent intent = new Intent(getApplicationContext(), Search_go_Activity.class);
                startActivity(intent);
            }
        });

        history_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View history_go_btn) {
                Intent intent = new Intent(getApplicationContext(), History_go_Activity.class);
                startActivity(intent);
            }
        });

        alarm_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View alarm_go_btn) {
                Intent intent = new Intent(getApplicationContext(), Alarm_go_Activity.class);
                startActivity(intent);
            }
        });
    }
}
