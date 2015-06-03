package kr.pe.ssun.demos;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

public class MainActivity extends Activity implements OnClickListener {
	private DrawerLayout mDrawer;
	private RelativeLayout mRlDrawer;
	private android.widget.Toolbar mToolbar;
	private android.support.v7.widget.Toolbar mSupportToolbar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawer = (DrawerLayout)findViewById(R.id.drawer);
		mRlDrawer = (RelativeLayout)findViewById(R.id.rlDrawer);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			mToolbar = (android.widget.Toolbar) findViewById(R.id.toolbar);
			mToolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu);
			mToolbar.setNavigationOnClickListener(this);
			mToolbar.setTitle(R.string.app_name);
		} else {
			mSupportToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
			mSupportToolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu);
			mSupportToolbar.setNavigationOnClickListener(this);
			mSupportToolbar.setTitle(R.string.app_name);
		}

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction()
				.add(R.id.content, new MainFragment())
				.commit();
	}

	@Override
	public void onClick(View v) {
		if (mDrawer.isDrawerOpen(mRlDrawer)) {
			mDrawer.closeDrawer(mRlDrawer);
		} else {
			mDrawer.openDrawer(mRlDrawer);
		}
	}
}
