package com.example.myapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.model.DatabaseHelper;


public class activity_show_data_of_sqlite extends AppCompatActivity {

    DatabaseHelper databaseHelper=new DatabaseHelper(activity_show_data_of_sqlite.this);
    SQLiteDatabase db;
    ListView list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_data_of_sqlite);
        list=findViewById(R.id.list_Sqlite_Data);

        db=databaseHelper.getReadableDatabase();
        adapter=new ArrayAdapter(activity_show_data_of_sqlite.this, android.R.layout.simple_list_item_1, databaseHelper.findAllName());
       list.setAdapter(adapter);
    }
}
