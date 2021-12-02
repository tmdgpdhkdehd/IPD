package com.example.ipd;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<MyBuilding> al;
    int layout;
    LayoutInflater inf;


    public MyAdapter(Context context, ArrayList<MyBuilding> al, int layout) {

        this.context = context;
        this.al = al;
        this.layout = layout;
        inf = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {

        // TODO Auto-generated method stub
        return al.size();
    }


    @Override
    public Object getItem(int position) {

        // TODO Auto-generated method stub
        return al.get(position);
    }


    @Override
    public long getItemId(int position) {

        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inf.inflate(layout, null);
        }

        TextView tv1 = (TextView) convertView.findViewById(R.id.textView1);
        TextView tv2 = (TextView) convertView.findViewById(R.id.textView2);
        TextView tv3 = (TextView) convertView.findViewById(R.id.textView3);

        MyBuilding b = al.get(position);
        tv1.setText(b.id + "");
        tv2.setText(b.name);
        tv3.setText(b.address);

        return convertView;
    }
}
