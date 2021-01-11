package com.example.myapp.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class my_adater extends ArrayAdapter<String>{

    String []str1;
    String []str2;
    String []str3;
    String []imgPath;

    Drawable drawableImg;
    Context context;

      public  my_adater(Context context, String []str1, String []str2, String []str3){
          super(context, R.layout.custom_multi_listview_item);
          this.context=context;
          this.str1=str1;
          this.str2=str2;
          this.str3=str3;
//          this.imgPath=imgPath;
      }

      @Override
      public  int getCount(){
          return  str1.length;
      }

    @NonNull
    @Override
    public View getView(int position, @Nullable View vw, @NonNull ViewGroup parent) {
          ControlTextView controlTextView=new ControlTextView();
          if(vw==null){
              LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              vw=inflater.inflate(R.layout.custom_multi_listview_item,parent,false);

//              controlTextView.imgFalg=vw.findViewById(R.id.imgFlag);
              controlTextView.tvw1=vw.findViewById(R.id.txtVItem1);
              controlTextView.tvw2=vw.findViewById(R.id.txtVItem2);
              controlTextView.tvw3=vw.findViewById(R.id.txtVItem3);

              vw.setTag(controlTextView);
          }else {
              controlTextView=(ControlTextView) vw.getTag();
          }

//        LoadImage loadImage=new LoadImage( controlTextView.imgFalg);
//        loadImage.execute("D:/My Photo/Annotation 2020-05-22 171657.png");

//        File file=new File("D:/My Photo/Annotation 2020-05-22 171657.png");
//        Bitmap bitmap=BitmapFactory.decodeFile(file.getAbsolutePath());

//        Drawable drawable=Drawable.createFromPath("../res/Flag_Asean_Contry/llag_of_laos.jpg");
//
//
//          controlTextView.imgFalg.setImageDrawable(drawable);
          controlTextView.tvw1.setText(str1[position]);
          controlTextView.tvw2.setText(str2[position]);
          controlTextView.tvw3.setText(str3[position]);

          return vw;
    }

    static  class  ControlTextView{
          TextView tvw1;
          TextView tvw2;
          TextView tvw3;
//          ImageView imgFalg;
    }

    class LoadImage extends AsyncTask<String, Void,Bitmap>{
          ImageView vwimg;

        public LoadImage(ImageView vwimg) {
            this.vwimg = vwimg;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap=null;
            try {
                InputStream stream=new URL(strings[0]).openStream();
                bitmap=BitmapFactory.decodeStream(stream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            vwimg.setImageBitmap(bitmap);
        }
    }
}
