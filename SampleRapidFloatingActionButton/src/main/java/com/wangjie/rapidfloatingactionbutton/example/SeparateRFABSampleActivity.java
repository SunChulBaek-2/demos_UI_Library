package com.wangjie.rapidfloatingactionbutton.example;

import android.os.Bundle;
import com.wangjie.androidinject.annotation.annotations.base.AILayout;
import com.wangjie.androidinject.annotation.annotations.base.AIView;
import com.wangjie.androidinject.annotation.present.AIActionBarActivity;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonSeparateListener;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/4/15.
 */
public class SeparateRFABSampleActivity extends AIActionBarActivity implements OnRapidFloatingButtonSeparateListener {
    private RapidFloatingActionButton rfab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.separate_rfab_sample);

        rfab = (RapidFloatingActionButton) findViewById(R.id.separate_rfab_sample_rfab);
        rfab.setOnRapidFloatingButtonSeparateListener(this);
    }

    @Override
    public void onRFABClick() {
        showToastMessage("RFAB clicked");
    }
}
