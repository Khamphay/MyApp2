package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_singlelist extends AppCompatActivity {
    ListView list;
    String []data={"Hello","Khamphay","uweyier","iuwewyworipoeprti", "auyegfrwpoop"};
    ArrayAdapter adapter;
    EditText text;
    Button bt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_single_listview);
        list=(ListView) findViewById(R.id.list);
        bt=findViewById(R.id.txtsc);
        text=findViewById(R.id.tt);

        //TODO: Defluat list view item
//        adapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, data);
        //TODO: Custom list view item
        adapter = new ArrayAdapter<String>(getApplicationContext(),  R.layout.custom_sigle_listview_item, data);
        list.setAdapter(adapter);

//      TODO: set event to lisit item
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str=data[position].toString();
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
            }
        });
    }
}
