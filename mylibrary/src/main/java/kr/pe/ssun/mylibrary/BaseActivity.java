package kr.pe.ssun.mylibrary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

/**
 * Created by x1210x on 2015-05-14.
 */
public class BaseActivity extends Activity {
	protected AppCompatDelegate mDelegate;

	private android.widget.Toolbar mToolbar;
	private android.support.v7.widget.Toolbar mSupportToolbar;
	private MaterialMenuDrawable materialMenu;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		materialMenu = new MaterialMenuDrawable(this,
				Color.WHITE,
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			setupToolbar();
			mToolbar.setTitle(R.string.app_name);
		} else {
			setupSupportToolbar();
			mSupportToolbar.setTitle(R.string.app_name);
		}
	}

	@TargetApi(21)
	private void setupToolbar() {
		if (mToolbar == null) {
			mToolbar = (android.widget.Toolbar) findViewById(R.id.toolbar);
		}

		mToolbar.setNavigationIcon(materialMenu);
		mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		mToolbar.setTitleTextColor(Color.WHITE);

		setActionBar(mToolbar);
	}

	private void setupSupportToolbar() {
		if (mSupportToolbar == null) {
			mSupportToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
		}

		mSupportToolbar.setNavigationIcon(materialMenu);
		mSupportToolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		mSupportToolbar.setTitleTextColor(Color.WHITE);
	}
}
