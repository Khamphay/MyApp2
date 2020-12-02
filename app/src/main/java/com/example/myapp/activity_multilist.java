package com.example.myapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity_multilist extends AppCompatActivity {

    my_adater myAdater;
    MyArrayAdater myArrayAdater;
    String countries[]={"Brunei Darussalam","Cambodia","Indonesia","Lao PDR", "Malaysia", "Myanmar","Philippines","Singapore","Thailand","Vietnam"};
    String capital[]={"Bandar Seri Begawan","Phnom Penh","Jakarta","Vientiane","Kuala Lumpur","Nay Pyi Taw","Manila","Singapore","Bangkok","Ha Noi"};
    String population[]={"0.447","16.494","266.998","7.163","32.801","53.019","108.307","5.670","67.913","96.801"};
    int []imgFlag={R.drawable.flag_of_brunei, R.drawable.flag_of_cambodia, R.drawable.flag_of_indonesia, R.drawable.flag_of_laos, R.drawable.flag_of_malaysia, R.drawable.flag_of_myanmar,
    R.drawable.flag_of_singapore, R.drawable.flag_of_the_philippines,R.drawable.flag_of_thailand, R.drawable.flag_of_vietnam};

    ListView listView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_multi_listview);

        listView=findViewById(R.id.lstmultiList);

//        myAdater=new my_adater(activity_multilist.this, countries,capital,population);
//        listView.setAdapter(myAdater);

        myArrayAdater=new MyArrayAdater(activity_multilist.this, countries,capital,imgFlag);
        listView.setAdapter(myArrayAdater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Toast.makeText(activity_multilist.this,countries[position].toString(),Toast.LENGTH_SHORT).show();
                Intent detail=new Intent(activity_multilist.this,activity_show_country_detail.class);
                detail.putExtra("image",imgFlag[position]);
                detail.putExtra("country",countries[position]);
                detail.putExtra("capital",capital[position]);
                detail.putExtra("population",population[position]);
                startActivity(detail);
            }
        });
    }
}
