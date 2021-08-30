package com.example.hello_world_proj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> colorset = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeText(View view){
//        if(view.getDrawingCacheBackgroundColor() == Color.BLUE) view.setBackgroundColor(Color.RED);
//        else view.setBackgroundColor(Color.BLUE);
        TextView textview = (TextView)findViewById(R.id.textView);
        ConstraintLayout mainConstraintLayout = (ConstraintLayout)findViewById(R.id.main);
        mainConstraintLayout.setBackgroundColor(0xFF40CE93);
        textview.setText("new text");
    }

}