package com.wangjie.rapidfloatingactionbutton.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wangjie.rapidfloatingactionbutton.RapidFloatingActionButton;
import com.wangjie.rapidfloatingactionbutton.listener.OnRapidFloatingButtonSeparateListener;

/**
 * Created by x1210x on 2015-05-15.
 */
public class SeperateRFASampleFragment extends Fragment implements OnRapidFloatingButtonSeparateListener {
	private RapidFloatingActionButton rfab;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.separate_rfab_sample, container, false);

		rfab = (RapidFloatingActionButton) view.findViewById(R.id.separate_rfab_sample_rfab);
		rfab.setOnRapidFloatingButtonSeparateListener(this);

		return view;
	}

	@Override
	public void onRFABClick() {
		Toast.makeText(getActivity(), "RFAB clicked", Toast.LENGTH_SHORT).show();
	}
}
