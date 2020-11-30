package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity_intent extends AppCompatActivity {
    String data;
    Button buttonOk, buttonCancel, buttonNextPage;
    EditText txtName, txtSureName, txtTel;
    AlertDialog alertDialog;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intent);

        buttonCancel=findViewById(R.id.buttonCancel);
        buttonOk=findViewById(R.id.buttonOK);
        buttonNextPage=findViewById(R.id.buttonNextPage);
        txtName=findViewById(R.id.txtEdName);
        txtSureName=findViewById(R.id.txtEdSurename);
        txtTel=findViewById(R.id.txtEdTel);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("Name");
        String surename=bundle.getString("Surename");
        String tel=bundle.getString("Tel");

        txtName.setText(name);
        txtSureName.setText(surename);
        txtTel.setText(tel);
//        setData();

        //TODO: Show AlertDialog
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data="First name: "+txtName.getText()+"\nSure name: "+txtSureName.getText()+"\nPhone: "+txtTel.getText();
                builder=new AlertDialog.Builder(activity_intent.this); //TODO: "getApplicationContext()" or use "activity_intent.this"
                alertDialog=builder.create();
                alertDialog.setTitle("show alert dialog");
                alertDialog.setMessage(data);
                alertDialog.show();
            }
        });

        //TODO: Back to home page
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent object=new Intent(activity_intent.this, MainActivity.class);
                startActivity(object);
                finish();
            }
        });

        //TODO: Next page
        buttonNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextpage=new Intent(activity_intent.this, activity_scores.class);
                startActivity(nextpage);
                finish();
            }
        });
    }

    private  void setData(){
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String surename=intent.getStringExtra("Surename");
        String tel=intent.getStringExtra("Tel");
        System.out.println("Name: "+name);
        txtName.setText(name);
        txtSureName.setText(surename);
        txtTel.setText(tel);
    }
}
