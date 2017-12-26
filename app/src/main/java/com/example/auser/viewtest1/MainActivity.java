package com.example.auser.viewtest1;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.StringJoiner;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {
    TextView tv[]=new TextView[6];
    Button bt[]=new Button[6];
    CheckBox cb[]=new CheckBox[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout linearLayout=new LinearLayout(MainActivity.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

//        StringJoiner sj=new StringJoiner(",","[","]");
//    StringJoiner sj = new StringJoiner(":", "[", "]");
//        sj.add("George").add("Sally").add("Fred");
//        String desiredString = sj.toString();


        for (int i=0;i<tv.length;i++){
            tv[i]=new TextView(this);

            bt[i]=new Button(this);
            bt[i].setText("No=" + i);
            cb[i]=new CheckBox(this);


        }



        //button設定
        bt[0].setTextColor(Color.RED);
        bt[1].setTextColor(Color.BLUE);
        bt[2].setTextColor(Color.YELLOW);

        //TextView設定
        tv[0].setTextColor(Color.BLACK);
        tv[0].setBackgroundColor(Color.RED);
        tv[0].setTextSize(20);

        tv[1].setTextColor(Color.BLUE);
        tv[1].setBackgroundColor(Color.GRAY);
        tv[1].setTextSize(20);
        tv[2].setTextColor(Color.CYAN);
        tv[2].setBackgroundColor(Color.YELLOW);
        tv[2].setTextSize(30);
//        tv[3].setTextColor(Color.DKGRAY);
//        tv[4].setTextColor(Color.BLACK);
//        tv[5].setTextColor(Color.BLACK);

        tv[0].setTypeface(Typeface.create(Typeface.MONOSPACE,Typeface.BOLD));//1.字型Typeface.SERIF2.style
        tv[1].setTypeface(Typeface.create(Typeface.SERIF,Typeface.ITALIC));//1.字型Typeface.SERIF2.style
        tv[2].setTypeface(Typeface.create(Typeface.SERIF,Typeface.NORMAL));//1.字型Typeface.SERIF2.style
//製作checkbox監聽器
        cb[0].setOnCheckedChangeListener(new SampleCheck());
        cb[1].setOnCheckedChangeListener(new SampleCheck());
        cb[2].setOnCheckedChangeListener(new SampleCheck());


        cb[0].setText("牛排500元");
        cb[1].setText("漢堡120元");
        cb[2].setText("汽水 50元");



//        linearLayout.addView(tv[2]);
//        linearLayout.addView(tv[3]);
//        linearLayout.addView(bt[0]);
//        linearLayout.addView(bt[1]);
//        linearLayout.addView(bt[2]);
        linearLayout.addView(cb[0]);
        linearLayout.addView(cb[1]);
        linearLayout.addView(cb[2]);
        linearLayout.addView(tv[0]);
        linearLayout.addView(tv[1]);
    }

    private void showResult(String text,String text1){

        if (text.endsWith(","))
            tv[0].setText(text.substring(0,text.length()-1));
        else
            tv[0].setText(text);

        if (text1.endsWith(","))
            tv[1].setText(text1.substring(0,text1.length()-1));
        else
            tv[1].setText(text1);

    }
    String str="您買了",str1="共計";
    int price1=0;


    private class SampleCheck implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String str2=buttonView.getText().toString().substring(2,5);
                if (isChecked) {
                    str = str + buttonView.getText().toString() + ",";
                    price1=price1+Integer.parseInt(str2.trim());

                } else {
                    price1=price1-Integer.parseInt(str2.trim());
                    str = str.replace(buttonView.getText().toString() + ",", "");
                }
                showResult(str, str1+price1);
            }
    }
}
