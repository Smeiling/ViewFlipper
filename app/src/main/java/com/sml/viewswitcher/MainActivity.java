package com.sml.viewswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private AutoTextFlipper autoTextFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = findViewById(R.id.flipper);

        String[] strs = {"ABCDEFGHIJKLMN", "SMLSMLSMLSMLSMLSML", "1234567890", "abcdefghijklmn", "SmeilingSmeiling"};
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(this);
            textView.setText(strs[i]);
            flipper.addView(textView);
        }

        List<String> stringList = new ArrayList<String>();
        stringList.add("aaaaaaaaaa");
        stringList.add("bbbbbbbbbb");
        stringList.add("cccccccccc");
        stringList.add("dddddddddd");
        stringList.add("eeeeeeeeee");
        autoTextFlipper = findViewById(R.id.auto_flipper);
        autoTextFlipper.setItems(stringList);
    }
}
