package com.example.ymj.adapter;

import java.util.List;
import java.util.zip.Inflater;

import com.example.valueanimatordemo.R;
import com.example.ymj.activity.MainActivity.Data;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainAdapter extends ArrayAdapter<Data>{
    private List<Data> mData;
    private Activity mContext;
    
    public MainAdapter(Activity context, List<Data> objects){
        super(context, R.string.no_data, objects);
        mData = objects;
        mContext = context;
    }
    
    private class ViewHolder{
        public TextView tv;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mContext.getLayoutInflater().inflate(R.layout.main_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tv = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.tv.setText(mData.get(position).data);
        return convertView;
    }

}
