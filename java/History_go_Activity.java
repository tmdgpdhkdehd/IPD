package com.example.ipd;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import android.view.Menu;
import android.widget.ListView;


public class History_go_Activity extends Activity {

    MySQLiteOpenHelper helper;
    SQLiteDatabase db;
    ArrayList<MyBuilding> al = new ArrayList<MyBuilding>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_go);
        helper = new MySQLiteOpenHelper

                (History_go_Activity.this // 현재 화면 context
                        , "build.db" // db file name
                        , null,     // CursorFactory
                        1);         // 버전명



        // 데이터 삽입
//        insert("삼성생명", "역삼동");
        insert("타이레놀 정 500mg", "아세트아미노펜　500mg");

        // 데이터 수정
//        update("삼성생명", "갈삼동");

        // 데이터 삭제
        delete("삼성생명");
        delete("흥국생명");
//        delete("타이레놀 정 500mg");

        // 데이터 조회
        select();

        // 2. adapter 만들기
        MyAdapter adapter = new MyAdapter
                (History_go_Activity.this, // 현재 화면의 context
                        al,             // data
                        R.layout.row); // listview 한줄에 해당하는 row

        // 3. ListView 만들기 (선언, setAdapter)
        ListView lv = (ListView)findViewById(R.id.listView1);
        lv.setAdapter(adapter);
    }


    public void delete(String name) {

        db = helper.getWritableDatabase();
        // 쓸 수 있는 데이터 베이스 객체를 얻어옴
        db.delete("building", "name=?", new String[]{name});
        // 테이블명 , 조건절 , 조건절의 ?에 해당하는인자
    }


    public void update(String name, String address) {

        db = helper.getWritableDatabase();
        // 쓸 수 있는 데이터 베이스 객체를 얻어옴
        ContentValues values = new ContentValues();
        values.put("address", address); // update 할 내용

        //     테이블 명 , update 할 내용
        db.update("building", values,
                "name=?", new String[]{name});
        // 조건절 , 조건절의 ? 에 해당하는 인자값
    }


    public void select() {

        db = helper.getReadableDatabase();
        // 데이터 베이스 객체를 얻어옴. 읽기전용
        Cursor c = db.query("building", null, null, null,
                null, null, null);
        // 조회 해옴
        while (c.moveToNext()) {
            int id = c.getInt(c.getColumnIndex("id"));
            String name =
                    c.getString(c.getColumnIndex("name"));
            String address =
                    c.getString(c.getColumnIndex("address"));

            Log.i("SQLite", "select ok~! : "
                    + "(id:"+id+"), "
                    + "(name:"+name+"), "
                    + "(address:"+address+")");

            // 화면의 TextView 에 결과 보여주기
//            TextView tv = (TextView)findViewById(R.id.tv);
//            tv.append(id+", "+name+", "+address+"\n");

            // 1. 데이터를 만든다
            MyBuilding m = new MyBuilding();
            m.id = id;
            m.name = name;
            m.address = address;
            al.add(m);
        } // while()
    } // select()


    public void insert (String name, String address){

        db = helper.getWritableDatabase();
        // 쓸수 있는 데이터 베이스 객체를 얻어옴
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);

        db.insert("building", null, values);
        // 테이블 명 , 널컬럼핵, 입력할 값 ContentValues
        Log.i("SQLite","insert OK~ : " +
                "(name:"+name+"), (address:"+address+")");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
} // end class MainActivity
