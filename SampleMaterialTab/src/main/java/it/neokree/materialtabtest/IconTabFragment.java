package it.neokree.materialtabtest;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

/**
 * Created by x1210x on 2015-05-15.
 */
public class IconTabFragment extends Fragment implements MaterialTabListener {
	private ViewPager pager;
	private ViewPagerAdapter pagerAdapter;
	MaterialTabHost tabHost;
	private Resources res;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_icons, container, false);
		res = this.getResources();
		// init toolbar (old action bar)

		tabHost = (MaterialTabHost) view.findViewById(R.id.tabHost);
		pager = (ViewPager) view.findViewById(R.id.pager);
		// init view pager
		pagerAdapter = new ViewPagerAdapter(getFragmentManager());
		pager.setAdapter(pagerAdapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// when user do a swipe the selected tab change
				tabHost.setSelectedNavigationItem(position);
			}
		});
		// insert all tabs from pagerAdapter data
		for (int i = 0; i < pagerAdapter.getCount(); i++) {
			tabHost.addTab(
					tabHost.newTab()
							.setIcon(getIcon(i))
							.setTabListener(this)
			);
		}
		return view;
	}

	@Override
	public void onTabSelected(MaterialTab tab) {
// when the tab is clicked the pager swipe content to the tab position
		pager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabReselected(MaterialTab tab) {
	}

	@Override
	public void onTabUnselected(MaterialTab tab) {
	}

	private class ViewPagerAdapter extends FragmentStatePagerAdapter {
		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		public Fragment getItem(int num) {
			return new FragmentText();
		}
		@Override
		public int getCount() {
			return 3;
		}
		@Override
		public CharSequence getPageTitle(int position) {
			switch(position) {
				case 0: return "tab 1";
				case 1: return "tab 2";
				case 2: return "tab 3";
				default: return null;
			}
		}
	}
	/*
	* It doesn't matter the color of the icons, but they must have solid colors
	*/
	private Drawable getIcon(int position) {
		switch(position) {
			case 0:
				return res.getDrawable(R.drawable.ic_person_black_24dp);
			case 1:
				return res.getDrawable(R.drawable.ic_group_black_24dp);
			case 2:
				return res.getDrawable(R.drawable.ic_notifications_off_white_24dp);
		}
		return null;
	}
}
