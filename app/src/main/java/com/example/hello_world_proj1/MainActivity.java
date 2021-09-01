package com.example.hello_world_proj1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> colorset;
    File colorinfo; //= new File("CS441_hello_world_proj1\\colorInfo\\colornames.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorset = new ArrayList<String>();
        if(colorset.isEmpty()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("colornames.txt")));
                String st;
                while ((st = br.readLine()) != null) {
                    String colorCodeAndName = st.substring(0, st.lastIndexOf(","));
                    colorset.add(colorCodeAndName);
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void buttonPress(View view){
//        if(view.getDrawingCacheBackgroundColor() == Color.BLUE) view.setBackgroundColor(Color.RED);
//        else view.setBackgroundColor(Color.BLUE);
        Random random = new Random();
        int randNum = random.nextInt(2628595);
        changeBackgroundColor(randNum);
        updateColorInfo(randNum);
        updateColorName(randNum);
    }
    public void changeBackgroundColor(int index){
        ConstraintLayout mainConstraintLayout = (ConstraintLayout)findViewById(R.id.main);
        mainConstraintLayout.setBackgroundColor(0xFF000000 + Integer.parseInt(colorset.get(index).substring(0,6),16));
//        System.out.println(Integer.toHexString(0xFF000000 + Integer.parseInt(colorset.get(index).substring(0,6),16)));
    }
    public void updateColorInfo(int index){
        TextView colorHexInfo = (TextView)findViewById(R.id.colorNameTag);
        colorHexInfo.setText("0XFF" + colorset.get(index).substring(0,6));
    }
    public void updateColorName(int index){
        Button button = (Button)findViewById(R.id.button1);
        button.setText(colorset.get(index).substring(7));
    }

    public int stringToHex(String hexcode){
        int value = 0;

        return value;
    }
}