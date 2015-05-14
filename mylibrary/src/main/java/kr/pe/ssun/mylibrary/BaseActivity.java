package kr.pe.ssun.mylibrary;

import android.app.Activity;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;

/**
 * Created by x1210x on 2015-05-14.
 */
public class BaseActivity extends Activity implements AppCompatCallback {
	protected AppCompatDelegate mDelegate;

	/**
	 * @return The {@link AppCompatDelegate} being used by this Activity.
	 */
	public AppCompatDelegate getDelegate() {
		if (mDelegate == null) {
			mDelegate = AppCompatDelegate.create(this, this);
		}
		return mDelegate;
	}

	@Override
	public void onSupportActionModeStarted(ActionMode mode) {

	}

	@Override
	public void onSupportActionModeFinished(ActionMode mode) {

	}
}
