package com.example.a20230203test1scrollchangeheadview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout topBar = (LinearLayout) findViewById(R.id.topBar);
        ScrollChangeHeadView schv = (ScrollChangeHeadView) findViewById(R.id.schv);

        schv.setTopBar(topBar);

        schv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 100;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @SuppressLint("SetTextI18n")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText("+" + position);
                return tv;
            }
        });

    }
}