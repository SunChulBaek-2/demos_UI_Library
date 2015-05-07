package com.getbase.floatingactionbutton.sample;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

public class MainActivity extends Activity {
  private MaterialMenuDrawable materialMenu;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fab);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

    toolbar.setTitle("FloatingActionButton");
    toolbar.setTitleTextColor(Color.WHITE);

    findViewById(R.id.pink_icon).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
      }
    });

    FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);
    button.setSize(FloatingActionButton.SIZE_MINI);
    button.setColorNormalResId(R.color.pink);
    button.setColorPressedResId(R.color.pink_pressed);
    button.setIcon(R.drawable.ic_fab_star);
    button.setStrokeVisible(false);

    final View actionB = findViewById(R.id.action_b);

    FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
    actionC.setTitle("Hide/Show Action above");
    actionC.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
      }
    });
    ((FloatingActionsMenu) findViewById(R.id.multiple_actions)).addButton(actionC);

    final FloatingActionButton removeAction = (FloatingActionButton) findViewById(R.id.button_remove);
    removeAction.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
      }
    });

    ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
    drawable.getPaint().setColor(getResources().getColor(R.color.white));
    ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);

    final FloatingActionButton actionA = (FloatingActionButton) findViewById(R.id.action_a);
    actionA.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        actionA.setTitle("Action A clicked");
      }
    });

    // Test that FAMs containing FABs with visibility GONE do not cause crashes
    findViewById(R.id.button_gone).setVisibility(View.GONE);
  }
}
