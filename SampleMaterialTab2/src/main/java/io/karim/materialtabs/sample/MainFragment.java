package io.karim.materialtabs.sample;

import android.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import io.karim.MaterialTabs;

/**
 * Created by x1210x on 15. 5. 26..
 */
public class MainFragment extends Fragment {
	MaterialTabs mMaterialTabs;
	ViewPager mViewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_tabs, container, false);

		mMaterialTabs = (MaterialTabs)view.findViewById(R.id.material_tabs);
		mViewPager = (ViewPager)view.findViewById(R.id.view_pager);

		// Apply background tinting to the Android system UI when using KitKat translucent modes.
		SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
		tintManager.setStatusBarTintEnabled(true);

		MainActivityPagerAdapter adapter = new MainActivityPagerAdapter(getFragmentManager());
		mViewPager.setAdapter(adapter);

		mMaterialTabs.setViewPager(mViewPager);

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
		mViewPager.setPageMargin(pageMargin);
		mViewPager.setCurrentItem(0);

		return view;
	}

	public class MainActivityPagerAdapter extends FragmentPagerAdapter implements MaterialTabs.CustomTabProvider {

		private final String[] TITLES = {"Tabs", "Ripple"};

		private final int[] ICONS = {R.drawable.ic_tabs, R.drawable.ic_ripple};

		public MainActivityPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
				case 0:
				default:
					return new TabsSettingsFragment();
				case 1:
					return new RippleSettingsFragment();
			}
		}

		@Override
		public View getCustomTabView(ViewGroup parent, int position) {
			ImageView imageView = new ImageView(getActivity());
			imageView.setImageDrawable(getActivity().getResources().getDrawable(ICONS[position]));
			return imageView;
		}
	}


	public static class MeDialogFragment extends DialogFragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.dialog_me, container, false);
			TextView githubTextView = (TextView) view.findViewById(R.id.github_text_view);
			TextView twitterTextView = (TextView) view.findViewById(R.id.twitter_text_view);

			String link = getString(R.string.github);
			Spannable spannable = new SpannableString(link);
			spannable.setSpan(new URLSpan(getString(R.string.github_link)), 0, link.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			githubTextView.setText(spannable, TextView.BufferType.SPANNABLE);
			githubTextView.setMovementMethod(LinkMovementMethod.getInstance());

			link = getString(R.string.twitter);
			spannable = new SpannableString(link);
			spannable.setSpan(new URLSpan(getString(R.string.twitter_link)), 0, link.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			twitterTextView.setText(spannable, TextView.BufferType.SPANNABLE);
			twitterTextView.setMovementMethod(LinkMovementMethod.getInstance());

			getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			return view;
		}
	}
}
