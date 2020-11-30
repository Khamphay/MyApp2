package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_scores extends AppCompatActivity {
    Button btsend, btSinglelist,btMultilist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scores);
        btsend=findViewById(R.id.btSend);
        btSinglelist=findViewById(R.id.btSingleList);
        btMultilist=findViewById(R.id.btMultiList);


        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send=new Intent(activity_scores.this, activity_type.class);
                startActivity(send);
            }
        });

        btSinglelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent singleList=new Intent(activity_scores.this, activity_singlelist.class);
                startActivity(singleList);
            }
        });

        btMultilist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent multiList=new Intent(activity_scores.this, activity_multilist.class);
                startActivity(multiList);
            }
        });

    }
}
