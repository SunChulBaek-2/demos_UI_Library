package com.wangjie.rapidfloatingactionbutton.example;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import kr.pe.ssun.mylibrary.BaseActivity;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/4/15.
 */
public class SeparateRFABSampleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Separate RFAB Sample");
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishProperly();
            }
        });

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new SeperateRFASampleFragment())
                .commit();
    }
}
