package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_device_detail extends AppCompatActivity {

    ListView list_device_detail;
    ImageView img_device;
    ArrayAdapter adapter;

    String[] info_device;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_device_detail);

        Bundle data=getIntent().getExtras();

        img_device=findViewById(R.id.detail_device_img);
        list_device_detail=findViewById(R.id.list_device_detail);

        img_device.setImageResource(data.getInt("image"));
        info_device=data.getStringArray("detail");

        adapter=new ArrayAdapter(activity_device_detail.this, android.R.layout.simple_list_item_1,info_device);
        list_device_detail.setAdapter(adapter);

    }
}
