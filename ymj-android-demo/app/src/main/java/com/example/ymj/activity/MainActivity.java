
package com.example.ymj.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.valueanimatordemo.R;
import com.example.ymj.adapter.MainAdapter;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
    private ListView mLv;
    private List<Data> data = new ArrayList<Data>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mLv = (ListView)findViewById(R.id.list);
        Data item = new Data();
        item.data = "valueAnimator-Demo";
        item.dateType = DataType.VADEMO;
        data.add(item);
        Data item1 = new Data();
        item1.data = "indexableListV";
        item1.dateType = DataType.INDEXABLE_LISTVIEW;
        data.add(item1);
        MainAdapter adpter = new MainAdapter(this, data);
        mLv.setAdapter(adpter);
        
        mLv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (data.get(position).dateType) {
                        case VADEMO:
                            startActivity(new Intent(MainActivity.this, AnimatorActivity.class));
                            break;
                        case INDEXABLE_LISTVIEW:
                            startActivity(new Intent(MainActivity.this, IndexableListActivity.class));
                            break;
                        default:
                            break;
                    }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private enum DataType{
        VADEMO, INDEXABLE_LISTVIEW;
    }
    
    public class Data{
        public String data;
        public DataType dateType;
    }
}
