package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_device  extends AppCompatActivity {

    Spinner spiner;
    ListView lst;
    String[] device={"Computer", "Moblie","Camera"};
    int []img={R.drawable.computer,R.drawable.moblie, R.drawable.camara};
    MyDeviceAdaterArray adaterArray;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_device);

        spiner=findViewById(R.id.spDevice);
        lst=findViewById(R.id.lstDevice);

        adaterArray=new MyDeviceAdaterArray(activity_device.this,device, img);
        spiner.setAdapter(adaterArray);

    }
}
