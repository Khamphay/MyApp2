package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_viewdata extends AppCompatActivity {
    TextView lbID, lbName, lbGender, lbTel;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewdata);

        Bundle data=getIntent().getExtras();

        lbID=findViewById(R.id.lbID);
        lbName=findViewById(R.id.lbName);
        lbGender=findViewById(R.id.lbGender);
        lbTel=findViewById(R.id.lbTel);


        lbID.setText(data.getString("ID"));
        lbName.setText(data.getString("Name"));
        lbGender.setText(data.getString("Gender"));
        lbTel.setText(data.getString("Tel"));
    }
}
