package com.wangjie.rapidfloatingactionbutton.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.rapidfloatingactionbutton.example.rfabgroup.RFABGroupSampleActivity;

public class MainActivity extends AIActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapid_floating_action_button);

        Button button1 = (Button) findViewById(R.id.activity_main_separate_rfab_sample_btn);
        Button button2 = (Button) findViewById(R.id.activity_main_label_list_sample_btn);
        Button button3 = (Button) findViewById(R.id.activity_main_rfab_group_btn);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_main_label_list_sample_btn) {
            startActivity(new Intent(context, LabelListSampleActivity.class));
        } else if (v.getId() == R.id.activity_main_separate_rfab_sample_btn) {
            startActivity(new Intent(context, SeparateRFABSampleActivity.class));
        } else if (v.getId() == R.id.activity_main_rfab_group_btn) {
            startActivity(new Intent(context, RFABGroupSampleActivity.class));
        }
    }
}
