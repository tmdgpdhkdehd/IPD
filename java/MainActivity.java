package com.example.ipd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        clearApplicationData();

        Button search_go_btn = (Button) findViewById(R.id.search_go_btn);
        Button history_go_btn = (Button) findViewById(R.id.history_go_btn);
        Button alarm_go_btn = (Button) findViewById(R.id.alarm_go_btn);
        Button schedule_go_btn = (Button) findViewById(R.id.schedule_go_btn);
        Button record_go_btn = (Button) findViewById(R.id.record_go_btn);

        search_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View search_go_btn) {
                Intent intent = new Intent(getApplicationContext(), Search_go_Activity.class);
                startActivityForResult(intent,1);
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

        schedule_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View alarm_go_btn) {
                Intent intent = new Intent(getApplicationContext(), Schedule_go_Activity.class);
                startActivity(intent);
            }
        });

        record_go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View alarm_go_btn) {
                Intent intent = new Intent(getApplicationContext(), Record_go_Activity.class);
                startActivity(intent);
            }
        });
    }

    // 데이터 삭제
//    public void clearApplicationData() {
//        File cache = getCacheDir();
//        try {
//        } catch (Exception e) {
//        }
//        File appDir = new File(cache.getParent());
//        if (appDir.exists()) {
//            String[] children = appDir.list();
//            for (String s : children) {
//                if (!s.equals("lib") && !(s.equals("shared_prefs"))) {
//                    deleteDir(new File(appDir, s));
//                }
//            }
//        }
//    }
//
//    public static boolean deleteDir(File dir) {
//        if (dir != null && dir.isDirectory()) {
//            String[] children = dir.list();
//            for (int i = 0; i < children.length; i++) {
//                boolean success = deleteDir(new File(dir, children[i]));
//                if (!success) {
//                    return false;
//                }
//            }
//        }
//        // The directory is now empty or this is a file so delete it
//        return dir.delete();
//    }
}
