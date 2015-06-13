package kr.pe.ssun.demos;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

import kr.pe.ssun.demos.adapter.MainAdapter;

public class MainActivity extends Activity {
	private static final int ID_ALL = 999;

	private DrawerLayout mDrawer;
	private ActionBarDrawerToggle mToggle;
	private NavigationView mNavView;
	private Toolbar mToolbar;
	private RecyclerView rvLibraries;

	private MainAdapter mAdapter;
	private int mSelectedIndex = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDrawer = (DrawerLayout)findViewById(R.id.drawer);
		mNavView = (NavigationView)findViewById(R.id.navigation);
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		rvLibraries = (RecyclerView) findViewById(R.id.rvLibraries);

		if (savedInstanceState != null) {
			mSelectedIndex = savedInstanceState.getInt("navSelectedIndex", 0);
		}

		mToggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, 0, 0);
		mDrawer.setDrawerListener(mToggle);

		mNavView.inflateHeaderView(R.layout.header_navigation_view);
		initNavMenu();

		mToolbar.setTitle(R.string.app_name);
		mToolbar.setTitleTextColor(getResources().getColor(R.color.lightTextPrimary));

		if(rvLibraries.getTag() != null) {
			String tag = (String) rvLibraries.getTag();
			Screen.setCurrent(Screen.valueOf(tag.toUpperCase()));
		}

		mAdapter = new MainAdapter();
		if (mSelectedIndex > -1) {
			if (mSelectedIndex == 0) {
				mAdapter.setCategory(null);
			} else {
				mAdapter.setCategory(Category.values()[mSelectedIndex - 1]);
			}
		}

		if(Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			rvLibraries.setLayoutManager(new StaggeredGridLayoutManager(3,
					StaggeredGridLayoutManager.VERTICAL));
			rvLibraries.setAdapter(mAdapter);
		} else {
			rvLibraries.setLayoutManager(new LinearLayoutManager(this));
			rvLibraries.setAdapter(mAdapter);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mToggle.syncState();
	}

	@Override
	protected void onSaveInstanceState (Bundle outState) {
		outState.putInt("navSelectedIndex", mSelectedIndex);
	}

	private void initNavMenu() {
		Menu menu = mNavView.getMenu();
		menu.add(0, ID_ALL, 0, "All");

		Category[] cats = Category.values();
		for (int i=0; i<cats.length; i++) {
			menu.add(0, i, 0, cats[i].getTitle());
		}

		for (int i=0; i<menu.size(); i++) {
			menu.getItem(i).setCheckable(true);
			if (i == mSelectedIndex) {
				menu.getItem(i).setChecked(true);
			}
		}

		mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				Menu menu = mNavView.getMenu();
				for (int i=0; i<menu.size(); i++) {
					MenuItem item = menu.getItem(i);
					item.setChecked(item.getItemId() == menuItem.getItemId());

					if (item.getItemId() == menuItem.getItemId()) {
						mSelectedIndex = i;
					}
				}

				if (menuItem.getItemId() == ID_ALL) {
					mAdapter.setCategory(null);
				} else if (menuItem.getItemId() < Category.values().length) {
					mAdapter.setCategory(Category.values()[mSelectedIndex - 1]);
				}
				mAdapter.notifyDataSetChanged();

				return true;
			}
		});
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
