package it.neokree.materialtabtest;

import android.os.Bundle;
import android.view.View;

import kr.pe.ssun.mylibrary.BaseActivity;

/**
 * Created by neokree on 30/12/14.
 */
public class IconTabActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbarTitle("Material Tab");
        setToolbarIconState(IconState.ARROW);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        android.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
                .add(R.id.content, new IconTabFragment())
                .commit();
    }
}