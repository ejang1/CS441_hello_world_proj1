package com.example.hello_world_proj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

import java.util.Map;
import java.util.Random;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    Map<Integer,String> colorset;
    File colorinfo; //= new File("CS441_hello_world_proj1\\colorInfo\\colornames.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonPress(View view){
//        if(view.getDrawingCacheBackgroundColor() == Color.BLUE) view.setBackgroundColor(Color.RED);
//        else view.setBackgroundColor(Color.BLUE);
        Random random = new Random();
        int randNum = random.nextInt(2628595);
        changeBackgroundColor(randNum);
        updateColorInfo(randNum);
        updateColorName(randNum);

        TextView textview = (TextView)findViewById(R.id.colorNameTag);
        textview.setText("new text");
    }
    public void changeBackgroundColor(int index){
        ConstraintLayout mainConstraintLayout = (ConstraintLayout)findViewById(R.id.main);
        mainConstraintLayout.setBackgroundColor(0xFF40CE93);
    }
    public void updateColorInfo(int index){
        TextView colorHexInfo = (TextView)findViewById(R.id.colorNameTag);

    }
    public void updateColorName(int index){}
}