package com.example.ipd;
//DB 연결을 도와주는 클래스

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

        /*
         * sql을 사용하기 위한 제반 클래스
         * SQLiteOpenHelper는 사용에 도움을 주는 클래스이다.
         * 데이터베이스를 생성하거나 업그레이드 하는기능 또는, 오픈하려면 SQLiteOpenHelper 객체를 사용한다.
         * SQLiteOpenHelper 클래스를 상속받아 구현하려면
         *
         *     1) 생성 메소드 : 상위 클래스의 생성 메소드를 호출, Activity 등의 Context 인스턴스와
         *                          데이터베이스의 이름, 커서 팩토리(보통 Null 지정) 등을 지정하고,
         *                          데이터베이스 스키마 버전을 알려주는 숫자값을 넘겨 준다.
         *     2) onCreate() 메소드 : SQLiteDatabase를 넘겨 받으며, 데이블을 생성하고 초기 데이터를
         *                                  추가하기에 적당한 위치이다.
         *     3) onUpgrade() 메소드 : SQLiteDatabase 인스턴스를 넘겨 받으며, 현재 스키마 버전과
         *                                     최신 스키마 버전 번호도 받는다.
         *
         * 위의 세가지 기능을 사용해야한다.
         */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context, String name,
                              CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // TODO Auto-generated method stub
        // 최초 db 생성 작업

        String sql = "create table building" +
                "(id integer primary key autoincrement, " +
                "name text, " +
                "address text);";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // TODO Auto-generated method stub
        String sql = "drop table if exists building;";
        onCreate(db); // table 다시 만들기
    }
}
