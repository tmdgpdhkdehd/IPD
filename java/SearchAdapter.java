package com.example.ipd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/**
 * Created by Administrator on 2017-08-07.
 */

public class SearchAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public SearchAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.row,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.textView1);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));

        ImageView imageView = (ImageView)convertView.findViewById(R.id.ImageView1);
        // 리스트뷰의 아이템에 이미지를 변경한다.
        if("Uusa".equals(list.get(position)))
            imageView.setImageResource(R.drawable.uusa_image);
        else if("VitaminC 1000".equals(list.get(position)))
            imageView.setImageResource(R.drawable.vitamin_image);
        else if("B-Max Gold".equals(list.get(position)))
            imageView.setImageResource(R.drawable.gold_image);
        else if("Tylenol".equals(list.get(position)))
            imageView.setImageResource(R.drawable.tylenol_image);
        TextView textView = (TextView)convertView.findViewById(R.id.textView1);
        textView.setText(list.get(position));
        final String text = list.get(position);

        return convertView;
    }

    class ViewHolder{
        public TextView label;
    }

}
