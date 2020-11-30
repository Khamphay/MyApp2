package com.example.myapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class activity_caculator extends AppCompatActivity {

    Button  btCal , btExit, btP, btR, btK, btH;
    EditText txtSum, txtFs, txtSc;
    int x,y, sum;
    DecimalFormat form=new DecimalFormat("#,##0.00");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_caculator);


        btCal=findViewById(R.id.btCal);
        txtSum=findViewById(R.id.txtSum);
        btExit=findViewById(R.id.btExit);
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(activity_caculator.this);
                 View view= getLayoutInflater().inflate(R.layout.layout_input,null);
                 builder.create();
                 builder.setView(view);
                 builder.show();

                 txtFs=view.findViewById(R.id.txtFsNum);
                 txtSc=view.findViewById(R.id.txtScNum);
                btP=view.findViewById(R.id.btP);
                btR=view.findViewById(R.id.btR);
                btK=view.findViewById(R.id.btK);
                btH=view.findViewById(R.id.btH);

                btP.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x=Integer.parseInt(txtFs.getText().toString());
                        y=Integer.parseInt(txtSc.getText().toString());
                        txtSum.setText(txtFs.getText()+"+"+ txtSc.getText()+"="+form.format(sum=x+y));
                    }
                });
                btR.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x=Integer.parseInt(txtFs.getText().toString());
                        y=Integer.parseInt(txtSc.getText().toString());
                        txtSum.setText(txtFs.getText()+"-"+ txtSc.getText()+"="+form.format(sum=x-y));
                    }
                });
                btK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x=Integer.parseInt(txtFs.getText().toString());
                        y=Integer.parseInt(txtSc.getText().toString());
                        txtSum.setText(txtFs.getText()+"*"+ txtSc.getText()+"="+form.format(sum=x*y));
                    }
                });
                btH.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       double dx=Double.parseDouble(txtFs.getText().toString());
                       double dy=Double.parseDouble(txtSc.getText().toString());
                        if(dy==0) {
                            Toast.makeText(getApplicationContext(), "Don't divisible whit zero",Toast.LENGTH_LONG).show();
                        }else{
                               double dsum=dx/dy;
                            txtSum.setText(txtFs.getText()+"/"+ txtSc.getText()+"="+form.format(dsum));
                            }
                    }
                });
            }
        });
    }
}
