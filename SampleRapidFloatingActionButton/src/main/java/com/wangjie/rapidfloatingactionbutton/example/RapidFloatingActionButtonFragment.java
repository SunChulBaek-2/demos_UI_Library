package com.wangjie.rapidfloatingactionbutton.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wangjie.rapidfloatingactionbutton.example.rfabgroup.RFABGroupSampleActivity;

/**
 * Created by x1210x on 2015-05-15.
 */
public class RapidFloatingActionButtonFragment extends Fragment implements View.OnClickListener {
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rapid_floating_action_button, container, false);
		Button button1 = (Button) view.findViewById(R.id.activity_main_separate_rfab_sample_btn);
		Button button2 = (Button) view.findViewById(R.id.activity_main_label_list_sample_btn);
		Button button3 = (Button) view.findViewById(R.id.activity_main_rfab_group_btn);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		return view;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.activity_main_label_list_sample_btn) {
			startActivity(new Intent(getActivity(), LabelListSampleActivity.class));
		} else if (v.getId() == R.id.activity_main_separate_rfab_sample_btn) {
			startActivity(new Intent(getActivity(), SeparateRFABSampleActivity.class));
		} else if (v.getId() == R.id.activity_main_rfab_group_btn) {
			startActivity(new Intent(getActivity(), RFABGroupSampleActivity.class));
		}
	}
}
