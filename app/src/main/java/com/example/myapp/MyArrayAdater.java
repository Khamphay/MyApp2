package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MyArrayAdater extends ArrayAdapter<String> {

    String []str1;
    String []str2;
    int []imgPath;
    Context context;

    public  MyArrayAdater(Context context, String []str1, String []str2, int []imgPath){
        super(context,R.layout.listview_item_flag);
        this.context=context;
        this.str1=str1;
        this.str2=str2;
        this.imgPath=imgPath;
    }

    @Override
    public  int getCount(){
        return  str1.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View vw, @NonNull ViewGroup parent) {
        MyArrayAdater.ControlList controlTextView=new MyArrayAdater.ControlList();
        if(vw==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vw=inflater.inflate(R.layout.listview_item_flag,parent,false);

            controlTextView.imgFalg=vw.findViewById(R.id.imgItemFlag);
            controlTextView.tvw1=vw.findViewById(R.id.txtVItemCountry);
            controlTextView.tvw2=vw.findViewById(R.id.txtVItemCapital);

            vw.setTag(controlTextView);
        }else {
            controlTextView=(MyArrayAdater.ControlList) vw.getTag();
        }


        controlTextView.imgFalg.setImageResource(imgPath[position]);
        controlTextView.tvw1.setText(str1[position]);
        controlTextView.tvw2.setText(str2[position]);

        return vw;
    }

    static  class  ControlList{
        TextView tvw1;
        TextView tvw2;
        ImageView imgFalg;
    }
}
