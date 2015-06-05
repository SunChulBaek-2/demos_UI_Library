package kr.pe.ssun.demos;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import kr.pe.ssun.demos.adapter.MainAdapter;

public class MainActivity extends Activity {
	private DrawerLayout mDrawer;
	private NavigationView mNavView;
	private Toolbar mToolbar;
	private RecyclerView rvLibraries;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawer = (DrawerLayout)findViewById(R.id.drawer);
		mNavView = (NavigationView)findViewById(R.id.navigation);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		rvLibraries = (RecyclerView) findViewById(R.id.rvLibraries);

		mNavView.inflateHeaderView(R.layout.header_navigation_view);

		mToolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu);
		mToolbar.setNavigationOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mDrawer.isDrawerOpen(mNavView)) {
					mDrawer.closeDrawer(mNavView);
				} else {
					mDrawer.openDrawer(mNavView);
				}
			}
		});
		mToolbar.setTitle(R.string.app_name);
		mToolbar.setTitleTextColor(getResources().getColor(R.color.lightTextPrimary));

		if(rvLibraries.getTag() != null) {
			String tag = (String) rvLibraries.getTag();
			Screen.setCurrent(Screen.valueOf(tag.toUpperCase()));
		}

		if(Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			rvLibraries.setLayoutManager(new StaggeredGridLayoutManager(3,
					StaggeredGridLayoutManager.VERTICAL));
			rvLibraries.setAdapter(new MainAdapter());
		} else {
			rvLibraries.setLayoutManager(new LinearLayoutManager(this));
			rvLibraries.setAdapter(new MainAdapter());
		}
	}

	@Override
	public void onBackPressed() {
		if (mDrawer.isDrawerOpen(mNavView)) {
			mDrawer.closeDrawer(mNavView);
		} else {
			finish();
		}
	}
}
