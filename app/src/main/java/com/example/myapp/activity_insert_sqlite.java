package com.example.myapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.model.DatabaseHelper;

import java.util.ArrayList;

public class activity_insert_sqlite extends AppCompatActivity {

    DatabaseHelper databaseHelper=new DatabaseHelper(activity_insert_sqlite.this);
    SQLiteDatabase db;

    EditText txtName, txtSurname, txtTel,txtSearch;
    TextView tvID;
    Spinner spnAge;
    Button btSave, btUpdate, btDelete,btSearch, btShow;
    ArrayAdapter adapter;
    ArrayList list;
    String age[]={"18","19","20","21","22","23","24","25"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loyout_insert_sqlite);

        tvID=findViewById(R.id.tv_id);
        txtName=findViewById(R.id.txt_name);
        txtSurname=findViewById(R.id.txt_surname);
        txtTel=findViewById(R.id.txt_tel);
        txtSearch=findViewById(R.id.txt_search);
        spnAge=findViewById(R.id.spn_age);
        btSave=findViewById(R.id.bt_save);
        btUpdate=findViewById(R.id.bt_Edit);
        btDelete=findViewById(R.id.bt_delete);
        btSearch=findViewById(R.id.bt_search);
        btShow=findViewById(R.id.bt_showData);

        db=databaseHelper.getWritableDatabase(); //Todo: use for create table in method 'onCreate' at class 'DatabaseHelper'

        adapter=new ArrayAdapter(activity_insert_sqlite.this, android.R.layout.simple_list_item_1,age);
        spnAge.setAdapter(adapter);

        //Show all
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_insert_sqlite.this,activity_show_data_of_sqlite.class));
            }
        });

        //Todo: Save data
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=txtName.getText().toString();
                String surname=txtSurname.getText().toString();
                int age=Integer.parseInt(spnAge.getSelectedItem().toString());
                String tel=txtTel.getText().toString();
              long save= databaseHelper.saveData(name ,surname ,age ,tel);
              if(save>-1){
                  Toast.makeText(activity_insert_sqlite.this, "Save data completed: "+save,Toast.LENGTH_SHORT).show();
                  clearData();
              }else {
                  Toast.makeText(activity_insert_sqlite.this, "Save data failed",Toast.LENGTH_SHORT).show();
              }
            }
        });

        //Todo: Update data
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int update=databaseHelper.updateData(Integer.parseInt(tvID.getText().toString()), txtName.getText().toString(), txtSurname.getText().toString(), Integer.parseInt(spnAge.getSelectedItem().toString()), txtTel.getText().toString());
                if(update>-1){
                    Toast.makeText(activity_insert_sqlite.this, "Edit data completed",Toast.LENGTH_SHORT).show();
                    clearData();
                }else {
                    Toast.makeText(activity_insert_sqlite.this, "Edit data failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Todo: Delete data
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int delete=databaseHelper.deleteData(Integer.parseInt(tvID.getText().toString()));
                if(delete>-1){
                    Toast.makeText(activity_insert_sqlite.this, "Delete data completed",Toast.LENGTH_SHORT).show();
                    clearData();
                }else {
                    Toast.makeText(activity_insert_sqlite.this, "Delete data failed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Todo: Show data by name
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data[]=databaseHelper.findByName(txtSearch.getText().toString());
                if(data!=null){
                    tvID.setText(data[0]);
                    txtName.setText(data[1]);
                    txtSurname.setText(data[2]);
                    //age
                    txtTel.setText(data[4]);
                }else {
                    Toast.makeText(activity_insert_sqlite.this, "No data to show",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public  void clearData(){
        tvID.setText("");
        txtName.setText("");
        txtSurname.setText("");
        txtTel.setText("");
        txtSearch.requestFocus();
        txtSearch.selectAll();
    }
}
