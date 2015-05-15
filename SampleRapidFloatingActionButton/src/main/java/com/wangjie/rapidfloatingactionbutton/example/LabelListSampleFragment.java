package com.wangjie.rapidfloatingactionbutton.example;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangjie.androidbucket.utils.ABTextUtil;
import com.wangjie.androidbucket.utils.imageprocess.ABShape;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionHelper;
import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionLayout;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RFACLabelItem;
import com.wangjie.rapidfloatingactionbutton.contentimpl.labellist.RapidFloatingActionContentLabelList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x1210x on 2015-05-15.
 */
public class LabelListSampleFragment extends Fragment implements RapidFloatingActionContentLabelList.OnRapidFloatingActionContentListener {
	private RapidFloatingActionLayout rfaLayout;
	private RapidFloatingActionButton rfaButton;
	private RapidFloatingActionHelper rfabHelper;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.label_list_sample, container, false);

		rfaLayout = (RapidFloatingActionLayout) view.findViewById(R.id.label_list_sample_rfal);
		rfaButton = (RapidFloatingActionButton) view.findViewById(R.id.label_list_sample_rfab);

		RapidFloatingActionContentLabelList rfaContent = new RapidFloatingActionContentLabelList(getActivity());
		rfaContent.setOnRapidFloatingActionContentListener(this);
		List<RFACLabelItem> items = new ArrayList<>();
		items.add(new RFACLabelItem<Integer>()
						.setLabel("Github: wangjiegulu")
						.setResId(R.mipmap.ico_test_d)
						.setIconNormalColor(0xffd84315)
						.setIconPressedColor(0xffbf360c)
						.setWrapper(0)
		);
		items.add(new RFACLabelItem<Integer>()
						.setLabel("tiantian.china.2@gmail.com")
						.setResId(R.mipmap.ico_test_c)
						.setIconNormalColor(0xff4e342e)
						.setIconPressedColor(0xff3e2723)
						.setLabelColor(Color.WHITE)
						.setLabelSizeSp(14)
						.setLabelBackgroundDrawable(ABShape.generateCornerShapeDrawable(0xaa000000, ABTextUtil.dip2px(getActivity(), 4)))
						.setWrapper(1)
		);
		items.add(new RFACLabelItem<Integer>()
						.setLabel("WangJie")
						.setResId(R.mipmap.ico_test_b)
						.setIconNormalColor(0xff056f00)
						.setIconPressedColor(0xff0d5302)
						.setLabelColor(0xff056f00)
						.setWrapper(2)
		);
		items.add(new RFACLabelItem<Integer>()
						.setLabel("Compose")
						.setResId(R.mipmap.ico_test_a)
						.setIconNormalColor(0xff283593)
						.setIconPressedColor(0xff1a237e)
						.setLabelColor(0xff283593)
						.setWrapper(3)
		);
		rfaContent
				.setItems(items)
				.setIconShadowRadius(ABTextUtil.dip2px(getActivity(), 5))
				.setIconShadowColor(0xff888888)
				.setIconShadowDy(ABTextUtil.dip2px(getActivity(), 5))
		;

		rfabHelper = new RapidFloatingActionHelper(
				getActivity(),
				rfaLayout,
				rfaButton,
				rfaContent
		).build();

		return view;
	}

	@Override
	public void onRFACItemLabelClick(int position, RFACLabelItem item) {
		Toast.makeText(getActivity(), "clicked label: " + position, Toast.LENGTH_SHORT).show();
		rfabHelper.toggleContent();
	}

	@Override
	public void onRFACItemIconClick(int position, RFACLabelItem item) {
		Toast.makeText(getActivity(), "clicked icon: " + position, Toast.LENGTH_SHORT).show();
		rfabHelper.toggleContent();
	}
}
