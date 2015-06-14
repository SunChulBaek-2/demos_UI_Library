package com.wangjie.rapidfloatingactionbutton.example.rfabgroup;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangjie.rapidfloatingactionbutton.example.R;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonGroupListener;
import com.wangjie.rapidfloatingactionbutton.rfabgroup.RapidFloatingActionButtonGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x1210x on 2015-05-15.
 */
public class RFABGroupSampleFragment extends Fragment implements OnRapidFloatingButtonGroupListener {
	private PagerTabStrip pts;
	private ViewPager pager;
	private RapidFloatingActionButtonGroup rfabGroup;

	private List<BaseFragment> fragments = new ArrayList<>();

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rfab_group_sample, container, false);

		pts = (PagerTabStrip) view.findViewById(R.id.rfab_group_sample_pts);
		pager = (ViewPager) view.findViewById(R.id.rfab_group_sample_vp);
		rfabGroup = (RapidFloatingActionButtonGroup) view.findViewById(R.id.rfab_group_sample_rfabg);


		rfabGroup.setOnRapidFloatingButtonGroupListener(this);

		pts.setTabIndicatorColor(Color.RED);
		pts.setTextColor(0xff3f51b5);

		fragments.add(new FragmentA());
		fragments.add(new FragmentB());
		fragments.add(new FragmentC());

		pager.setAdapter(new MyPageAdapter(getFragmentManager()));

		pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				rfabGroup.setSection(position);
			}
		});
		pager.setOffscreenPageLimit(3);
		return view;
	}

	@Override
	public void onRFABGPrepared(RapidFloatingActionButtonGroup rapidFloatingActionButtonGroup) {
		for (BaseFragment fragment : fragments) {
			fragment.onInitialRFAB(rapidFloatingActionButtonGroup.getRFABByIdentificationCode(fragment.getRfabIdentificationCode()));
		}
	}


	class MyPageAdapter extends FragmentStatePagerAdapter {

		public MyPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return fragments.get(position).getTitle();
		}
	}
}
