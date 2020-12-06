package com.example.myapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.R;

public class listitem_arrayadater extends ArrayAdapter<String> {
    String [][] item_name;
    String[][]item_os;
    String [][]item_price;
    int [] item_img;

    Context context;

    public listitem_arrayadater(@NonNull Context context, String[][] item_name, String[][] item_os, String [][]item_price, int[] item_img) {
        super(context, R.layout.list_devives_item);
        this.item_name = item_name;
        this.item_os = item_os;
        this.item_price = item_price;
        this.item_img = item_img;
        this.context=context;
    }

    @Override
    public int getCount() {
        return item_img.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View vw, @NonNull ViewGroup parent) {
        ListContent list=new ListContent();
        if(vw==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vw=inflater.inflate(R.layout.list_devives_item,parent,false);

            list.itemName=vw.findViewById(R.id.item_name);
            list.itemOS=vw.findViewById(R.id.item_os);
            list.itemPrice=vw.findViewById(R.id.item_price);
            list.itemImg=vw.findViewById(R.id.dv_item_img);

            vw.setTag(list);
        }else {
            list= (ListContent) vw.getTag();
        }

        list.itemName.setText(item_name[position][0]);
        list.itemOS.setText(item_os[position][1]);
        list.itemPrice.setText(item_price[position][2]);
        list.itemImg.setImageResource(item_img[position]);

        return vw;
    }

    static class ListContent{
        TextView itemName, itemOS,itemPrice;
        ImageView itemImg;
    }
}
