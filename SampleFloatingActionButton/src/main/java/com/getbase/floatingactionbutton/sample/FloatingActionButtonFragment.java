package com.getbase.floatingactionbutton.sample;

import android.support.v4.app.Fragment;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by x1210x on 2015-05-15.
 */
public class FloatingActionButtonFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_fab, container, false);

		view.findViewById(R.id.pink_icon).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
			}
		});

		FloatingActionButton button = (FloatingActionButton) view.findViewById(R.id.setter);
		button.setSize(FloatingActionButton.SIZE_MINI);
		button.setColorNormalResId(R.color.pink);
		button.setColorPressedResId(R.color.pink_pressed);
		button.setIcon(R.drawable.ic_fab_star);
		button.setStrokeVisible(false);

		final View actionB = view.findViewById(R.id.action_b);

		FloatingActionButton actionC = new FloatingActionButton(getActivity());
		actionC.setTitle("Hide/Show Action above");
		actionC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
			}
		});
		((FloatingActionsMenu) view.findViewById(R.id.multiple_actions)).addButton(actionC);

		final FloatingActionButton removeAction = (FloatingActionButton) view.findViewById(R.id.button_remove);
		removeAction.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((FloatingActionsMenu) view.findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
			}
		});

		ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
		drawable.getPaint().setColor(getResources().getColor(R.color.white));
		((FloatingActionButton) view.findViewById(R.id.setter_drawable)).setIconDrawable(drawable);

		final FloatingActionButton actionA = (FloatingActionButton) view.findViewById(R.id.action_a);
		actionA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				actionA.setTitle("Action A clicked");
			}
		});

		// Test that FAMs containing FABs with visibility GONE do not cause crashes
		view.findViewById(R.id.button_gone).setVisibility(View.GONE);
		return view;
	}
}
