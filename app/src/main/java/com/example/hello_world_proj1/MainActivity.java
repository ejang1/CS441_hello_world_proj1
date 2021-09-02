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
    //declare for later use
    //colorset is a list of color information - colorcode,colorname
    //file to load the colornames.txt file from assets
    ArrayList<String> colorset;
    File colorinfo; //= new File("CS441_hello_world_proj1\\colorInfo\\colornames.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //when start the app, load the color information from colornames.txt in assets
        //extract colorcode and name from file and add into colorset
        colorset = new ArrayList<String>();
        //check the colorset is empty. If colorset is not empty and contain the color info,
        //do not need to reread the file.
        //Since there are over 2500,000 colors, takes around 1 min to load the color information
        if(colorset.isEmpty()) {
            //file read have to cover with try/catch blocks
            try {
                //oepn the file using getAssets() method and open the file into te br
                BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("colornames.txt")));
                //string buffer
                String st;
                //set the format of the colorcode and colorname
                //save information into list
                while ((st = br.readLine()) != null) {
                    String colorCodeAndName = st.substring(0, st.lastIndexOf(","));
                    colorset.add(colorCodeAndName);
                }
                //after read all colors, close the file
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Give function to button press
    //When button pressed, background color change, give Color code, give color name
    //Color change according to the random number
    public void buttonPress(View view){
//        if(view.getDrawingCacheBackgroundColor() == Color.BLUE) view.setBackgroundColor(Color.RED);
//        else view.setBackgroundColor(Color.BLUE);
        //Set random number
        //There are 2628595 kinds of colors
        Random random = new Random();
        int randNum = random.nextInt(2628595);
        //Call function to change background color
        changeBackgroundColor(randNum);
        //Call function to change the colorcode in textview
        updateColorInfo(randNum);
        //Call function to change the colorname in button
        updateColorName(randNum);
    }
    //Change the background color according to the index input
    //colorset[index] color will be set as the background color
    public void changeBackgroundColor(int index){
        //Call the ConstraintLayout by id 'main'
        ConstraintLayout mainConstraintLayout = (ConstraintLayout)findViewById(R.id.main);
        //Color code is format of hexcode in String
        //Front 0xFF part is transparent
        mainConstraintLayout.setBackgroundColor(0xFF000000 + Integer.parseInt(colorset.get(index).substring(0,6),16));
//        System.out.println(Integer.toHexString(0xFF000000 + Integer.parseInt(colorset.get(index).substring(0,6),16)));
    }

    //Change the colorcode in textview according to the index input
    //colorset[index] color code will be show up in the textview
    public void updateColorInfo(int index){
        //Call the textview with id 'colorNameTag'
        TextView colorHexInfo = (TextView)findViewById(R.id.colorNameTag);
        //Change the colorcode
        colorHexInfo.setText("0XFF" + colorset.get(index).substring(0,6));
    }
    //Change the colorname in button according to the index input
    //colorset[index] color name will be show up in the button
    public void updateColorName(int index){
        //call the button with id 'button1'
        Button button = (Button)findViewById(R.id.button1);
        //Change the colorname
        button.setText(colorset.get(index).substring(7));
    }
}