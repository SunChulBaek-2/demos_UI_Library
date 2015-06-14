package it.neokree.materialtabtest;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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
public class SwipableTextFragment extends Fragment implements MaterialTabListener {
	MaterialTabHost tabHost;
	ViewPager pager;
	ViewPagerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_text, container, false);
		tabHost = (MaterialTabHost) view.findViewById(R.id.tabHost);
		pager = (ViewPager) view.findViewById(R.id.pager );

		// init view pager
		adapter = new ViewPagerAdapter(getFragmentManager());
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// when user do a swipe the selected tab change
				tabHost.setSelectedNavigationItem(position);

			}
		});

		// insert all tabs from pagerAdapter data
		for (int i = 0; i < adapter.getCount(); i++) {
			tabHost.addTab(
					tabHost.newTab()
							.setText(adapter.getPageTitle(i))
							.setTabListener(this)
			);

		}
		return view;
	}

	@Override
	public void onTabSelected(MaterialTab tab) {
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
			return 16;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Section " + position;
		}

	}
}
