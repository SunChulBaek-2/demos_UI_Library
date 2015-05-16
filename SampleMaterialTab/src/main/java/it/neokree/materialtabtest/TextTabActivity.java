package it.neokree.materialtabtest;

import android.os.Bundle;
import android.view.View;

import kr.pe.ssun.mylibrary.BaseActivity;

public class TextTabActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Material Tab");
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishProperly();
            }
        });

        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new TextTabFragment())
                .commit();
    }
}
