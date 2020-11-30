package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_type extends AppCompatActivity {
    Button btOk, btCancel;
    EditText txtId, txtName, txtTel;
    RadioButton rbMale, rbFeMale;
    String gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_typedata);
        txtId=findViewById(R.id.txtScID);
        txtName=findViewById(R.id.txtScName);
        txtTel=findViewById(R.id.txtSctel);
        rbFeMale=findViewById(R.id.rdscFale);
        rbMale=findViewById(R.id.rdscMale);

        btOk=findViewById(R.id.btScOK);
        btCancel=findViewById(R.id.btScCancel);

        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbMale.isChecked()==true){
                    gender=rbMale.getText().toString();
                }else {
                    gender=rbFeMale.getText().toString();
                }

                Intent  ov=new Intent(activity_type.this, activity_viewdata.class);
                ov.putExtra("ID", txtId.getText().toString());
                ov.putExtra("Name", txtName.getText().toString());
                ov.putExtra("Gender", gender);
                ov.putExtra("Tel", txtTel.getText().toString());

                startActivity(ov);
            }
        });

    }
}
