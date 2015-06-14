package kr.pe.ssun.mylibrary;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;

/**
 * Created by x1210x on 2015-05-14.
 */
public class BaseActivity extends AppCompatActivity {
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

	private Toolbar mToolbar;
	private MaterialMenuDrawable materialMenu;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		materialMenu = new MaterialMenuDrawable(this,
				getResources().getColor(R.color.lightTextPrimary),
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);

		setupSupportToolbar();
	}

	protected void setToolbarTitle(int id) {
		mToolbar.setTitle(id);
	}

	protected void setToolbarTitle(String title) {
		mToolbar.setTitle(title);
	}

	protected void setMenu(int resId, Toolbar.OnMenuItemClickListener listener) {
		mToolbar.inflateMenu(resId);
		mToolbar.setOnMenuItemClickListener(listener);
	}

	protected void setToolbarIconState(IconState state) {
		materialMenu.setIconState(state.getState());
	}

	protected void setNavigationOnClickListener(View.OnClickListener listener) {
		mToolbar.setNavigationOnClickListener(listener);
	}

	private void setupSupportToolbar() {
		if (mToolbar == null) {
			mToolbar = (Toolbar) findViewById(R.id.toolbar);
		}

		mToolbar.setTitleTextColor(getResources().getColor(R.color.lightTextPrimary));
		mToolbar.setNavigationIcon(materialMenu);
	}

	public void finishProperly() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			finishAfterTransition();
		} else {
			finish();
		}
	}
}
