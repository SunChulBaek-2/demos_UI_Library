package de.hdodenhof.circleimageview.sample;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import kr.pe.ssun.mylibrary.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("CircleImageView");
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishProperly();
            }
        });

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new CircleImageViewFragment())
                .commit();
    }
}
