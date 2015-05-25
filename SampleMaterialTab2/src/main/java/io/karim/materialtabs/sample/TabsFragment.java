package io.karim.materialtabs.sample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

import io.karim.MaterialTabs;
import io.karim.Utils;

/**
 * Created by x1210x on 15. 5. 26..
 */
public class TabsFragment extends Fragment {
	Toolbar mToolbar;
	MaterialTabs mMaterialTabs;
	ViewPager mViewPager;

	private String mExportableString;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_tabs, container, false);

		mMaterialTabs = (MaterialTabs) view.findViewById(R.id.material_tabs);
		mViewPager = (ViewPager) view.findViewById(R.id.view_pager);

		// Apply background tinting to the Android system UI when using KitKat translucent modes.
		SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
		tintManager.setStatusBarTintEnabled(true);

		int numberOfTabs = 3;
		if (getActivity().getIntent() != null && getActivity().getIntent().getExtras() != null) {
			numberOfTabs = getActivity().getIntent().getExtras().getInt(TabsSettingsFragment.NUMBER_OF_TABS);
		}

		SamplePagerAdapter adapter = new SamplePagerAdapter(getFragmentManager(), numberOfTabs);
		mViewPager.setAdapter(adapter);

		mMaterialTabs.setViewPager(mViewPager);

		applyParametersFromIntentExtras();

		final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
		mViewPager.setPageMargin(pageMargin);

		return view;
	}

	private void applyParametersFromIntentExtras() {
		Intent intent = getActivity().getIntent();
		if (intent != null) {
			Bundle extras = intent.getExtras();
			if (extras != null) {
				Resources resources = getResources();

				int showToolbar = extras.getBoolean(TabsSettingsFragment.SHOW_TOOLBAR) ? View.VISIBLE : View.GONE;
				int indicatorColor = resources.getColor(extras.getInt(TabsSettingsFragment.INDICATOR_COLOR));
				int underlineColor = resources.getColor(extras.getInt(TabsSettingsFragment.UNDERLINE_COLOR));
				int indicatorHeightDp = extras.getInt(TabsSettingsFragment.INDICATOR_HEIGHT);
				int underlineHeightDp = extras.getInt(TabsSettingsFragment.UNDERLINE_HEIGHT);
				int tabPaddingDp = extras.getInt(TabsSettingsFragment.TAB_PADDING);

				mToolbar.setVisibility(showToolbar);

				mMaterialTabs.setIndicatorColor(indicatorColor);
				mMaterialTabs.setUnderlineColor(underlineColor);
				mMaterialTabs.setIndicatorHeight(Utils.dpToPx(resources, indicatorHeightDp));
				mMaterialTabs.setUnderlineHeight(Utils.dpToPx(resources, underlineHeightDp));
				mMaterialTabs.setTabPaddingLeftRight(Utils.dpToPx(resources, tabPaddingDp));

				boolean paddingMiddle = extras.getBoolean(TabsSettingsFragment.PADDING_MIDDLE);
				boolean sameWeightTabs = extras.getBoolean(TabsSettingsFragment.SAME_WEIGHT_TABS);
				boolean textAllCaps = extras.getBoolean(TabsSettingsFragment.TEXT_ALL_CAPS);

				mMaterialTabs.setPaddingMiddle(paddingMiddle);
				mMaterialTabs.setSameWeightTabs(sameWeightTabs);
				mMaterialTabs.setAllCaps(textAllCaps);

				int toolbarColor = resources.getColor(extras.getInt(TabsSettingsFragment.TOOLBAR_BACKGROUND));
				int tabBackgroundColor = resources.getColor(extras.getInt(TabsSettingsFragment.TAB_BACKGROUND));
				mToolbar.setBackgroundColor(toolbarColor);
				mMaterialTabs.setBackgroundColor(tabBackgroundColor);

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					Window window = getActivity().getWindow();
					window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
					window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
					window.setStatusBarColor(Color.argb(Color.alpha(toolbarColor), Color.red(toolbarColor) / 2, Color.green(toolbarColor) / 2,
							Color.blue(toolbarColor) / 2));
				}

				int textColorSelected = resources.getColor(extras.getInt(TabsSettingsFragment.TEXT_COLOR_SELECTED));
				int textColorUnselected = resources.getColor(extras.getInt(TabsSettingsFragment.TEXT_COLOR_UNSELECTED));
				int tabStyleSelected = extras.getInt(TabsSettingsFragment.TEXT_STYLE_SELECTED);
				int tabStyleUnselected = extras.getInt(TabsSettingsFragment.TEXT_STYLE_UNSELECTED);

				mMaterialTabs.setTextColorSelected(textColorSelected);
				mMaterialTabs.setTextColorUnselected(textColorUnselected);

				mMaterialTabs.setTabTypefaceSelectedStyle(tabStyleSelected);
				mMaterialTabs.setTabTypefaceUnselectedStyle(tabStyleUnselected);

				int rippleDuration = extras.getInt(RippleSettingsFragment.RIPPLE_DURATION);
				float rippleAlphaFloat = extras.getFloat(RippleSettingsFragment.RIPPLE_ALPHA_FLOAT);
				int rippleColor = resources.getColor(extras.getInt(RippleSettingsFragment.RIPPLE_COLOR));
				boolean rippleDelayClick = extras.getBoolean(RippleSettingsFragment.RIPPLE_DELAY_CLICK);
				float rippleDiameterDp = extras.getFloat(RippleSettingsFragment.RIPPLE_DIAMETER);
				int rippleFadeDuration = extras.getInt(RippleSettingsFragment.RIPPLE_FADE_DURATION);
				int rippleHighlightColor = resources.getColor(extras.getInt(RippleSettingsFragment.RIPPLE_HIGHLIGHT_COLOR));
				boolean rippleOverlay = extras.getBoolean(RippleSettingsFragment.RIPPLE_OVERLAY);
				boolean ripplePersistent = extras.getBoolean(RippleSettingsFragment.RIPPLE_PERSISTENT);
				int rippleRoundedCornusRadiusDp = extras.getInt(RippleSettingsFragment.RIPPLE_ROUNDED_CORNERS_RADIUS);

				mMaterialTabs.setRippleDuration(rippleDuration);
				mMaterialTabs.setRippleAlphaFloat(rippleAlphaFloat);
				mMaterialTabs.setRippleColor(rippleColor);
				mMaterialTabs.setRippleDelayClick(rippleDelayClick);
				mMaterialTabs.setRippleDiameterDp(rippleDiameterDp);
				mMaterialTabs.setRippleFadeDuration(rippleFadeDuration);
				mMaterialTabs.setRippleHighlightColor(rippleHighlightColor);
				mMaterialTabs.setRippleInAdapter(false);
				mMaterialTabs.setRippleOverlay(rippleOverlay);
				mMaterialTabs.setRipplePersistent(ripplePersistent);
				mMaterialTabs.setRippleRoundedCornersDp(rippleRoundedCornusRadiusDp);

				mExportableString = createExportableText(showToolbar, indicatorColor, underlineColor, indicatorHeightDp, underlineHeightDp,
						tabPaddingDp, paddingMiddle, sameWeightTabs, textAllCaps, toolbarColor, tabBackgroundColor, textColorSelected,
						textColorUnselected, tabStyleSelected, tabStyleUnselected, rippleDuration, rippleAlphaFloat, rippleColor, rippleDelayClick,
						rippleDiameterDp, rippleFadeDuration, rippleHighlightColor, rippleOverlay, ripplePersistent, rippleRoundedCornusRadiusDp);
			}
		}
	}

	private String createExportableText(int showToolbar, int indicatorColor, int underlineColor, int indicatorHeightDp, int underlineHeightDp,
										int tabPaddingDp, boolean paddingMiddle, boolean sameWeightTabs, boolean textAllCaps, int toolbarColor, int tabBackgroundColor,
										int textColorSelected, int textColorUnselected, int tabStyleSelected, int tabStyleUnselected, int rippleDuration, float rippleAlphaFloat,
										int rippleColor, boolean rippleDelayClick, float rippleDiameterDp, int rippleFadeDuration, int rippleHighlightColor,
										boolean rippleOverlay, boolean ripplePersistent, int rippleRoundedCornusRadiusDp) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<io.karim.MaterialTabs\n")
				.append("        android:id=\"@+id/material_tabs\"\n")
				.append("        android:layout_width=\"match_parent\"\n")
				.append("        android:layout_height=\"48dp\"\n")
				.append("        android:background=\"?attr/colorPrimary\"\n")
				.append("        app:mtIndicatorColor=\"")
				.append("#")
				.append(Integer.toHexString(indicatorColor))
				.append("\"\n")
				.append("        app:mtUnderlineColor=\"")
				.append("#")
				.append(Integer.toHexString(underlineColor))
				.append("\"\n")
				.append("        app:mtUnderlineHeight=\"")
				.append(underlineHeightDp)
				.append("dp\"\n")
				.append("        app:mtIndicatorHeight=\"")
				.append(indicatorHeightDp)
				.append("dp\"\n")
				.append("        app:mtTabPaddingLeftRight=\"")
				.append(tabPaddingDp)
				.append("dp\"\n")
				.append("        app:mtSameWeightTabs=\"")
				.append(sameWeightTabs)
				.append("\"\n")
				.append("        app:mtTextAllCaps=\"")
				.append(textAllCaps)
				.append("\"\n")
				.append("        app:mtPaddingMiddle=\"")
				.append(paddingMiddle)
				.append("\"\n")
				.append("        app:mtTextColorSelected=\"")
				.append("#")
				.append(Integer.toHexString(textColorSelected))
				.append("\"\n")
				.append("        android:textColor=\"")
				.append("#")
				.append(Integer.toHexString(textColorUnselected))
				.append("\"\n")
				.append("        app:mtTextUnselectedStyle=\"")
				.append(getStyleFromStyleInt(tabStyleUnselected))
				.append("\"\n")
				.append("        app:mtTextSelectedStyle=\"")
				.append(getStyleFromStyleInt(tabStyleSelected))
				.append("\"\n")
				.append("        app:mtMrlRippleColor=\"")
				.append("#")
				.append(Integer.toHexString(rippleColor))
				.append("\"\n")
				.append("        app:mtMrlRippleHighlightColor=\"")
				.append("#")
				.append(Integer.toHexString(rippleHighlightColor))
				.append("\"\n")
				.append("        app:mtMrlRippleDiameter=\"")
				.append(rippleDiameterDp)
				.append("dp\"\n")
				.append("        app:mtMrlRippleOverlay=\"")
				.append(rippleOverlay)
				.append("\"\n")
				.append("        app:mtMrlRippleAlpha=\"")
				.append(rippleAlphaFloat)
				.append("\"\n")
				.append("        app:mtMrlRippleDuration=\"")
				.append(rippleDuration)
				.append("\"\n")
				.append("        app:mtMrlRippleFadeDuration=\"")
				.append(rippleFadeDuration)
				.append("\"\n")
				.append("        app:mtMrlRippleDelayClick=\"")
				.append(rippleDelayClick)
				.append("\"\n")
				.append("        app:mtMrlRipplePersistent=\"")
				.append(ripplePersistent)
				.append("\"\n")
				.append("        app:mtMrlRippleInAdapter=\"")
				.append("false")
				.append("\"\n")
				.append("        app:mtMrlRippleRoundedCorners=\"")
				.append(rippleRoundedCornusRadiusDp)
				.append("dp\"\n/>");
		return stringBuilder.toString();
	}

	private String getStyleFromStyleInt(int styleInt) {
		switch (styleInt) {
			case Typeface.BOLD:
			default:
				return "bold";
			case Typeface.ITALIC:
				return "italic";
			case Typeface.NORMAL:
				return "normal";
		}
	}

	public class SamplePagerAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = {"ITEM ONE", "ITEM TWO", "ITEM THREE", "ITEM FOUR", "ITEM FIVE", "ITEM SIX", "ITEM SEVEN", "ITEM EIGHT",
				"ITEM NINE", "ITEM TEN", "ITEM ELEVEN"};

		private final ArrayList<String> mTitles;

		public SamplePagerAdapter(FragmentManager fm, int numberOfTabs) {
			super(fm);
			mTitles = new ArrayList<>();
			for (int i = 0; i < numberOfTabs; i++) {
				mTitles.add(TITLES[i]);
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitles.get(position);
		}

		@Override
		public int getCount() {
			return mTitles.size();
		}

		@Override
		public Fragment getItem(int position) {
			return SampleFragment.newInstance(position);
		}
	}
}
