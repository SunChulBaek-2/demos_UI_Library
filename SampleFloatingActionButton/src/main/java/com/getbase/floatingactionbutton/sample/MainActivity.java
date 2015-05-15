package com.getbase.floatingactionbutton.sample;

import com.balysv.materialmenu.MaterialMenuDrawable;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import kr.pe.ssun.mylibrary.BaseActivity;

public class MainActivity extends BaseActivity {
  private MaterialMenuDrawable materialMenu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setToolbarTitle("FloatingActionButton");
    setToolbarIconState(IconState.ARROW);
    setNavigationOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    FragmentManager fm = getFragmentManager();
    fm.beginTransaction()
            .add(R.id.content, new FloatingActionButtonFragment())
            .commit();
  }
}
