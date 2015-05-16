package com.wangjie.rapidfloatingactionbutton.example.rfabgroup;

import android.os.Bundle;
import android.view.View;

import com.wangjie.rapidfloatingactionbutton.example.R;

import kr.pe.ssun.mylibrary.BaseActivity;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 5/4/15.
 */
public class RFABGroupSampleActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("RFAB Group Sample");
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishProperly();
            }
        });

        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new RFABGroupSampleFragment())
                .commit();
    }
}
