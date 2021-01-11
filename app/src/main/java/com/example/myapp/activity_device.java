package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.model.MyDeviceAdaterArray;
import com.example.myapp.model.listitem_arrayadater;

public class activity_device  extends AppCompatActivity {

    Spinner spiner;
    ListView lst;
    MyDeviceAdaterArray adaterArray;
    listitem_arrayadater deviceAdater;
    int index;
    String[] device={"Computer", "Moblie","Camera"};
    int[] img = { R.drawable.computer, R.drawable.moblie, R.drawable.camara };
    int [][] itemImg={
            new int[]{R.drawable.dell_inspirion_14_5000,R.drawable.acer_book,R.drawable.asus_zenbook_14,R.drawable.lenovo},
            new int[]{R.drawable.apple_iphone_12_pro_max,R.drawable.vivo_y12s, R.drawable.oppo_a73_5g,R.drawable.samsung_galaxy_a12,R.drawable.huawei_mate40_pro_plus},
            new int[]{R.drawable.gopro_hero9,R.drawable.nikon_z5, R.drawable.leica_m10_r,R.drawable.canon_eos_r6,R.drawable.canon_eos, R.drawable.fujifilm, R.drawable.nikon_d6}
    };
    String[][][] deviceItem = {
            new String[][] {
                   {
                        "Dell Inspiron 14 5000",
                        "Windows 10 Home 64-bit English",
                        "11th Generation Intel® Core™ i5-1135G7 Processor",
                        "Intel®Iris® Xe Graphics with shared graphics memory",
                        "8 GB,1 x8GB,DDR4,3200 MHz",
                        "512GB M.2 PCIe NVMe Solid State Drive",
                        "14.0-in.touch display",
                        "$ 799.99"
                    },
                    {
                        "Acer Book RS",
                        "Windows 10 Home",
                        "Intel® Core™ i5-1135 G7 processor",
                        "Intel®Iris® Xe Graphics",
                        "14 Full HD (1920 x 1080) 16:9 IPS Touchscreen",
                        "8 GB,LPDDR4X 512 GB SSD",
                        "$ 1,399.99"
                    },
                    {
                        "ASUS ZenBook 14",
                        "Windows 10 Pro", "Up to Corei7 8th Gen Intel® CPU",
                        "Up to 4.6GHz Turbo Boost",
                        "Up to 2 X faster than 7th Gen CPU",
                        "Up to MX250 NVIDIA® GPU", "Up to 16GB memory",
                        "Up to 1TB PCIe®SSD storage",
                        "$1,199.99"
                    },
                    {
                        "Lenovo",
                        "11th Gen Intel® powered business laptop",
                        "Secure & durable",
                        "Enhanced with Dolby Audio™",
                        "$ 694.99"
                    }},
            new String[][] {
                    {
                        "Iphone pro Max 12",
                        "6.7 inches, 1284 x 2778 pixels",
                        "128GB NVMe 6GB RAM",
                        "$ 1,099.00"
                    },
                    {
                        "vivo Y12s",
                        "6.51 inches, 720 x 1600 pixels",
                        "32GB 3GB RAM, 32GB 4GB RAM",
                        "120 EUR"
                    },
                    {
                        "Oppo A73 5G",
                        "6.5 inches, 1080 x 2400 pixels",
                        "128GB 8GB RAM",
                        "300 EUR"
                    },
                    {
                        "Samsung Galaxy A12",
                        "6.5 inches, 720 x 1560 pixels",
                        "128GB 6GB RAM eMMC 5.1",
                        "180 EUR"
                    },
                    {
                        "Huawei Mate 40 Pro+",
                        "6.76 inches, 1344 x 2772 pixels",
                        "256GB 12GB RAM",
                        "$1,599.99"
                    } },

        new String[][] {
            { "GoPro Hero9 Black", "Video 5K, 20MP Photo with SuperPhoto","$ 450.00" },
            { "Nikon Z5", "4K UHD 2160p","$ 1,954.96" },
            { "Leica M10-R","New 40MP full frame color sensor","$ 8,295.00" },
            { "Canon EOS R6","4K UHD 2160p","$ 2,499.00" },
            { "Canon EOS R5","30.3 Megapixel Full frame CMOS","$ 3,899.00" },
            { "Fujifilm Instax Mini 11", "4.24 x 4.77 x 2.65 inches","$ 68.95" },
            { "Nikon D6", "6.30 x 3.62 x 6.42 inches", "$ 6,499.95"},
            {"Sony A6600", "24.3 MP Higth Image Quality","$ 519.995" } } };
    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_device);

        spiner=findViewById(R.id.spDevice);
        lst=findViewById(R.id.lstDevice);

        adaterArray=new MyDeviceAdaterArray(activity_device.this,device, img);
        spiner.setAdapter(adaterArray);

        //TODO: Selected item in spiner
         spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               deviceAdater = new listitem_arrayadater(activity_device.this, deviceItem[position], deviceItem[position], deviceItem[position], itemImg[position]);
               lst.setAdapter(deviceAdater);
               index=position;
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

         //TODO: Selected item in list viewm
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent device_item=new Intent(activity_device.this, activity_device_detail.class);
                device_item.putExtra("image",itemImg[index][position]);
                device_item.putExtra("detail",deviceItem[index][position]);
                startActivity(device_item);
            }
        });
    }
}
