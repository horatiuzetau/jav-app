package com.example.myapplication;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class AnuntGrafic extends AppCompatActivity {

    int []imagesUrl={};
    int pretInceput=0;
    int pretCurent=0;
    String descreire;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunt_grafic);

        Intent intent=getIntent();
        Anunt anutn=intent.getParcelableExtra("anuntul");

        imagesUrl=anutn.getImagesUrl();
        pretInceput=anutn.getPretInceput();
        pretCurent=pretInceput;
        descreire=anutn.getDescriere();


        TextView descreireTxt=findViewById(R.id.descriere);
        descreireTxt.setText(descreire);
        ViewPager viewPager=findViewById(R.id.viewPager);
        //viewPager.addView(img,0,1);
        TablouImagini adapter=new TablouImagini(this, imagesUrl);
        viewPager.setAdapter(adapter);
        final TextView timer=findViewById(R.id.timer);
        CountDownTimer timp=new CountDownTimer(600000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                int min=(int)((millisUntilFinished/(1000*60))%60);
                int sec=(int)(millisUntilFinished/1000)%60;
                String text=min+":"+sec;
                timer.setText(text);
            }

            @Override
            public void onFinish() {

            }
        }.start();

        final TextView bani=(TextView) findViewById(R.id.bani);
        final TextView curent=(TextView) findViewById(R.id.curent);
        bani.setText(String.valueOf(this.pretInceput));
        Button pariu=(Button) findViewById(R.id.pariu);
        pariu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(curent.getText().toString())>Integer.parseInt(bani.getText().toString()))
                {
                    bani.setText(curent.getText());
                    pretCurent=Integer.parseInt(curent.getText().toString());
                }

            }
        });


        Button back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AnuntGrafic.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
