package com.example.ipd;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;package com.example.ipd;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

        clearApplicationData();

        helper = new MySQLiteOpenHelper
                (History_go_Activity.this // 현재 화면 context
                        , "build.db" // db file name
                        , null,     // CursorFactory
                        1);         // 버전명
 
//        Context context = getApplicationContext();
        Drawable drawable1 = getResources().getDrawable(R.drawable.tylenol_tab);

//// drawable 타입을 bitmap으로 변경
        Bitmap bitmap1 = ((BitmapDrawable)drawable1).getBitmap();
//
//// bitmap 타입을 drawable로 변경
//        Drawable drawable2 = new BitmapDrawable(bitmap1);

//        bitmapToByteArray(R.drawable.tylenol_tab);

        // 데이터 삭제
//        delete("타이레놀 정 500mg");

        // 데이터 삽입
//        insert("삼성생명", "역삼동");
        insert(bitmap1,"타이레놀 정 500mg", "아세트아미노펜　500mg", "성분");
//        insert("싸이버거  ", "김승혜", "5800원");
//        insert("오세혁  ", "주차의달인", "580ㅁㄴㅇㅁㄴ0원");
//        insert("싸이버거  ", "김승혜", "5800원");
//        insert("싸이버거  ", "김승혜", "5800원");
//        insert("싸이버거  ", "김승혜", "5800원");
//        insert("싸이버거  ", "전승준", "5800원");
//        insert("햄치즈토스트  ", "김승혜", "5800원");
//        insert("싸이버거  ", "김승혜", "5800원");

        // 데이터 수정
//        update("삼성생명", "갈삼동");

        // 데이터 조회
//        select();
//
////         2. adapter 만들기
//        MyAdapter adapter = new MyAdapter
//                (History_go_Activity.this, // 현재 화면의 context
//                        al,             // data
//                        R.layout.row); // listview 한줄에 해당하는 row
//
//        // 3. ListView 만들기 (선언, setAdapter)
//        ListView lv = (ListView)findViewById(R.id.listView1);
//        lv.setAdapter(adapter);
    }


//    public void delete(String name) {
//
//        db = helper.getWritableDatabase();
//        // 쓸 수 있는 데이터 베이스 객체를 얻어옴
//        db.delete("building", "name=?", new String[]{name});
//        // 테이블명 , 조건절 , 조건절의 ?에 해당하는인자
//    }


//    public void update(String name, String address) {
//
//        db = helper.getWritableDatabase();
//        // 쓸 수 있는 데이터 베이스 객체를 얻어옴
//        ContentValues values = new ContentValues();
//        values.put("address", address); // update 할 내용
//
//        //     테이블 명 , update 할 내용
//        db.update("building", values,
//                "name=?", new String[]{name});
//        // 조건절 , 조건절의 ? 에 해당하는 인자값
//    }


//    public void select() {
//
//        db = helper.getReadableDatabase();
//        // 데이터 베이스 객체를 얻어옴. 읽기전용
//        Cursor c = db.query("building", null, null, null,
//                null, null, null);
//        // 조회 해옴
//        while (c.moveToNext()) {
//            Bitmap image = c.getType(c.getColumnIndex("image"));
//            String name =
//                    c.getString(c.getColumnIndex("name"));
//            String address =
//                    c.getString(c.getColumnIndex("address"));
//            String ingredient =
//                    c.getString(c.getColumnIndex("ingredient"));
//
//            Log.i("SQLite", "select ok~! : "
//                    + "(image:"+image+"), "
//                    + "(name:"+name+"), "
//                    + "(address:"+address+"), "
//                    + "(ingredient:"+ingredient+")");
//
//            // 화면의 TextView 에 결과 보여주기
////            TextView tv = (TextView)findViewById(R.id.tv);
////            tv.append(id+", "+name+", "+address+"\n");
//
//            // 1. 데이터를 만든다
//            MyBuilding m = new MyBuilding();
//            m.image = image;
//            m.name = name;
//            m.address = address;
//            m.ingredient = ingredient;
//            al.add(m);
//        } // while()
//    } // select()


    public void insert (Bitmap image, String name, String address, String ingredient){

//        getByteArrayFromDrawable(image);

        db = helper.getWritableDatabase();
        // 쓸수 있는 데이터 베이스 객체를 얻어옴
        ContentValues value = new  ContentValues();
        value.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        value.put("name", name);
        value.put("address", address);
        value.put("ingredient", ingredient);

//        byte[] appIcon = getByteArrayFromDrawable(getIcon());
//        SQLiteStatement p = db.compileStatement("INSERT INTO value values(?)");

        db.insert("building", null, value);
        // 테이블 명 , 널컬럼핵, 입력할 값 ContentValues
        Log.i("SQLite","insert OK~ : " +
                "(image:"+image+"), (name:"+name+"), (address:"+address+"), (ingredient:"+ingredient+")");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 데이터 삭제
    public void clearApplicationData() {
        File cache = getCacheDir();
            try {
        } catch (Exception e) {
        }
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib") && !(s.equals("shared_prefs"))) {
                    deleteDir(new File(appDir, s));
                }
            }
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty or this is a file so delete it
        return dir.delete();
    }


//    // Bitmap을 Byte로 변환
//    public byte[] bitmapToByteArray(Bitmap bitmap) {
//        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
//        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
//        byte[] byteArray = stream.toByteArray() ;
//        return byteArray ;
//    }

    // Byte를 Bitmap으로 변환
    public Bitmap byteArrayToBitmap(byte[] byteArray) {
        Bitmap bitmap = BitmapFactory.decodeByteArray( byteArray, 0,
                byteArray.length ) ;
        return bitmap ;
    }

    public byte[] getByteArrayFromDrawable(Drawable d){
        Bitmap bitmap = ((BitmapDrawable)d).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress( Bitmap.CompressFormat.PNG, 100, stream) ;
        byte[] data = stream.toByteArray();

        return data;
    }

} // end class MainActivity


import java.io.File;
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

        // 데이터 삭제
        delete("타이레놀 정 500mg");

        // 데이터 삽입
//        insert("삼성생명", "역삼동");
        insert("타이레놀 정 500mg", "아세트아미노펜　500mg", "성분");
        insert("싸이버거  ", "김승혜", "5800원");
        insert("오세혁  ", "주차의달인", "580ㅁㄴㅇㅁㄴ0원");
        insert("싸이버거  ", "김승혜", "5800원");
        insert("싸이버거  ", "김승혜", "5800원");
        insert("싸이버거  ", "김승혜", "5800원");
        insert("싸이버거  ", "전승준", "5800원");
        insert("햄치즈토스트  ", "김승혜", "5800원");
        insert("싸이버거  ", "김승혜", "5800원");

        // 데이터 수정
//        update("삼성생명", "갈삼동");

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


//    public void update(String name, String address) {
//
//        db = helper.getWritableDatabase();
//        // 쓸 수 있는 데이터 베이스 객체를 얻어옴
//        ContentValues values = new ContentValues();
//        values.put("address", address); // update 할 내용
//
//        //     테이블 명 , update 할 내용
//        db.update("building", values,
//                "name=?", new String[]{name});
//        // 조건절 , 조건절의 ? 에 해당하는 인자값
//    }


    public void select() {

        db = helper.getReadableDatabase();
        // 데이터 베이스 객체를 얻어옴. 읽기전용
        Cursor c = db.query("building", null, null, null,
                null, null, null);
        // 조회 해옴
        while (c.moveToNext()) {
            String name =
                    c.getString(c.getColumnIndex("name"));
            String address =
                    c.getString(c.getColumnIndex("address"));
            String ingredient =
                    c.getString(c.getColumnIndex("ingredient"));

            Log.i("SQLite", "select ok~! : "
                    + "(name:"+name+"), "
                    + "(address:"+address+"), "
                    + "(ingredient:"+ingredient+")");

            // 화면의 TextView 에 결과 보여주기
//            TextView tv = (TextView)findViewById(R.id.tv);
//            tv.append(id+", "+name+", "+address+"\n");

            // 1. 데이터를 만든다
            MyBuilding m = new MyBuilding();
            m.name = name;
            m.address = address;
            m.ingredient = ingredient;
            al.add(m);
        } // while()
    } // select()


    public void insert (String name, String address, String ingredient){

        db = helper.getWritableDatabase();
        // 쓸수 있는 데이터 베이스 객체를 얻어옴
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("ingredient", ingredient);

        db.insert("building", null, values);
        // 테이블 명 , 널컬럼핵, 입력할 값 ContentValues
        Log.i("SQLite","insert OK~ : " +
                "(name:"+name+"), (address:"+address+"), (ingredient:"+ingredient+")");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
} // end class MainActivity
