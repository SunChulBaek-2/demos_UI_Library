package kr.pe.ssun.mylibrary;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.util.TypedValue;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

/**
 * Created by x1210x on 2015-05-14.
 */
public class BaseActivity extends Activity {
	public enum IconState {
		ARROW(MaterialMenuDrawable.IconState.ARROW),
		BURGER(MaterialMenuDrawable.IconState.BURGER),
		CHECK(MaterialMenuDrawable.IconState.CHECK);

		MaterialMenuDrawable.IconState mState;

		IconState(MaterialMenuDrawable.IconState state) {
			mState = state;
		}

		public MaterialMenuDrawable.IconState getState() {
			return mState;
		}
	}

	protected AppCompatDelegate mDelegate;

	private android.widget.Toolbar mToolbar;
	private android.support.v7.widget.Toolbar mSupportToolbar;
	private MaterialMenuDrawable materialMenu;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		int color = Color.BLACK;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			TypedValue a = new TypedValue();
			getTheme().resolveAttribute(android.R.attr.textColorPrimary, a, true);
			color = a.data;
		}

		materialMenu = new MaterialMenuDrawable(this,
				color,
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			setupToolbar();
		} else {
			setupSupportToolbar();
		}
	}

	protected void setToolbarTitle(int id) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mToolbar.setTitle(id);
		} else {
			mSupportToolbar.setTitle(id);
		}
	}

	protected void setToolbarTitle(String title) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mToolbar.setTitle(title);
		} else {
			mSupportToolbar.setTitle(title);
		}
	}

	protected void setToolbarIconState(IconState state) {
		materialMenu.setIconState(state.getState());
	}

	protected void setNavigationOnClickListener(View.OnClickListener listener) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mToolbar.setNavigationOnClickListener(listener);
		} else {
			mSupportToolbar.setNavigationOnClickListener(listener);
		}
	}

	@TargetApi(21)
	private void setupToolbar() {
		if (mToolbar == null) {
			mToolbar = (android.widget.Toolbar) findViewById(R.id.toolbar);
		}

		mToolbar.setNavigationIcon(materialMenu);
	}

	private void setupSupportToolbar() {
		if (mSupportToolbar == null) {
			mSupportToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
		}

		mSupportToolbar.setNavigationIcon(materialMenu);
	}

	public void finishProperly() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			finishAfterTransition();
		} else {
			finish();
		}
	}
}
