package com.example.myapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String data, gender;
    String [] age={"18", "19", "20", "21", "22", "23", "24", "25","26"};
    ArrayAdapter adapter;
    Spinner spinnerAge;
    Button loginButton, registerButton, buttonNext, buttonRgOk, buttonRgCancel,buttonCaculator;
    AlertDialog.Builder builder;
    EditText txtID, txtName, txtSuename, txtTel, txtRgName, txtRgSureName, txtRgTel;
    RadioButton radioButtonMale, radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Set values to spiner
        spinnerAge=findViewById(R.id.spinerAge);
        //TODO: "getApplicationContext()" or can use MainActivity.this
        adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, age);
        spinnerAge.setAdapter(adapter);

        txtID=findViewById(R.id.txtId);
        txtName=findViewById(R.id.txtName);
        txtSuename=findViewById(R.id.txtSureName);
        txtTel=findViewById(R.id.txtTel);
        radioButtonMale=findViewById(R.id.rdbMale);
        radioButtonFemale=findViewById(R.id.rdbFemale);

        loginButton= findViewById(R.id.buttonLogin);
        //TODO: Toast makeText dialog
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                builder=new AlertDialog.Builder(MainActivity.this);
//                AlertDialog alert=builder.create();
//                alert.setTitle("Message Dialog");
//                alert.setMessage(txtID.getText().toString());
//                alert.show();
                if(radioButtonMale.isChecked()){
                    gender=radioButtonMale.getText().toString();
                }else {
                    gender=radioButtonFemale.getText().toString();
                }
                data="ID: "+txtID.getText()+"\nName: "+txtName.getText()+"\nSurename: "+txtSuename.getText()+"\nGender: "+gender+"\nAge: "+"\nTel: "+txtTel.getText();
                Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
            }
        });

        registerButton=findViewById(R.id.buttonRegister);
        //TODO: Custom alert dialog
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflaterPage=LayoutInflater.from(MainActivity.this);
                //TODO: Load the layout 'layout_in_flater' set to view
                View view=layoutInflaterPage.inflate(R.layout.layout_in_flater, null);
                dialog.setView(view);
                dialog.show();

                txtRgName=view.findViewById(R.id.txtRgName);
                txtRgSureName=view.findViewById(R.id.txtRgSurename);
                txtRgTel=view.findViewById(R.id.txtRgTel);
                buttonRgOk=view.findViewById(R.id.buttonRgOKAlert);
                buttonRgOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String values="Name: "+txtRgName.getText()+"\nSure name: "+txtRgSureName.getText()+"\nTel: "+txtRgTel.getText();
                        Toast.makeText(MainActivity.this, values, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        buttonNext=findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Open on 'MainActivity' and go to 'activity_edit' or call the next page
                Intent object=new Intent(MainActivity.this, activity_intent.class);
                object.putExtra("Name", txtName.getText().toString());
                object.putExtra("Surename", txtSuename.getText().toString());
                object.putExtra("Tel", txtTel.getText().toString());
                startActivity(object);
                finish(); //TODO: Close this page
            }
        });

        buttonCaculator=findViewById(R.id.buttonCacilator);
        buttonCaculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Open on 'MainActivity' and go to 'activity_edit' or call the next page
                Intent object=new Intent(MainActivity.this, activity_caculator.class);
                startActivity(object);
                finish(); //TODO: Close this page
            }
        });
    }
}