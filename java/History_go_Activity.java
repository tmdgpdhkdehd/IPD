package com.example.ipd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class History_go_Activity extends Activity {
    List<String> list;
    ListView listView;
    EditText editSearch;        // 검색어를 입력할 Input 창
    ArrayList<String> arraylist;
    SearchAdapter adapter;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_go);
        editSearch = findViewById(R.id.history_EditText);
        listView = this.findViewById(R.id.history_listView);

        list = new ArrayList<>();

        list.add("Uusa");
        list.add("VitaminC 1000");
        list.add("B-Max Gold");
        list.add("Tylenol");

        arraylist = new ArrayList<>();
        arraylist.addAll(list);


        adapter = new SearchAdapter(list, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(getApplicationContext(), Uusa_Activity.class);
                    startActivity(intent);
                } else if(position == 1){
                    Intent intent = new Intent(getApplicationContext(), Vitamin_Activity.class);
                    startActivity(intent);
                } else if(position == 2){
                    Intent intent = new Intent(getApplicationContext(), Gold_Activity.class);
                    startActivity(intent);
                } else if(position == 3){
                    Intent intent = new Intent(getApplicationContext(), Tylenol_Activity.class);
                    startActivity(intent);
                }

            }
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = editSearch.getText().toString();
                search(text);
            }
        });
    }


    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist 의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true 를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }
}
