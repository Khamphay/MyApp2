package com.example.myapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_show_country_detail extends AppCompatActivity {

    private TextView tvCountry, tvCapital, tvPopulation;
    ImageView img_flag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_showcountry_detail);

        Bundle data=getIntent().getExtras();

        img_flag=findViewById(R.id.img_Flag);
        tvCountry=findViewById(R.id.tvCountry);
        tvCapital=findViewById(R.id.tvCapital);
        tvPopulation=findViewById(R.id.tvPopulation);

       img_flag.setImageResource(data.getInt("image"));
       tvCountry.setText(data.getString("country"));
       tvCapital.setText(data.getString("capital"));
       tvPopulation.setText(data.getString("population")+" Million");
    }
}
