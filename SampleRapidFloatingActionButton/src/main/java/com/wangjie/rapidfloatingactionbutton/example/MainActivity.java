package com.wangjie.rapidfloatingactionbutton.example;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.wangjie.rapidfloatingactionbutton.example.rfabgroup.RFABGroupSampleActivity;

import kr.pe.ssun.mylibrary.BaseActivity;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private MaterialMenuDrawable materialMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapid_floating_action_button);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button button1 = (Button) findViewById(R.id.activity_main_separate_rfab_sample_btn);
        Button button2 = (Button) findViewById(R.id.activity_main_label_list_sample_btn);
        Button button3 = (Button) findViewById(R.id.activity_main_rfab_group_btn);

        materialMenu = new MaterialMenuDrawable(this,
                Color.WHITE,
                MaterialMenuDrawable.Stroke.THIN,
                DEFAULT_SCALE,
                DEFAULT_TRANSFORM_DURATION,
                DEFAULT_PRESSED_DURATION);
        materialMenu.setIconState(MaterialMenuDrawable.IconState.ARROW);
        toolbar.setNavigationIcon(materialMenu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar.setTitle("FloatingActionButton2");
        toolbar.setTitleTextColor(Color.WHITE);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.activity_main_label_list_sample_btn) {
            startActivity(new Intent(this, LabelListSampleActivity.class));
        } else if (v.getId() == R.id.activity_main_separate_rfab_sample_btn) {
            startActivity(new Intent(this, SeparateRFABSampleActivity.class));
        } else if (v.getId() == R.id.activity_main_rfab_group_btn) {
            startActivity(new Intent(this, RFABGroupSampleActivity.class));
        }
    }
}
