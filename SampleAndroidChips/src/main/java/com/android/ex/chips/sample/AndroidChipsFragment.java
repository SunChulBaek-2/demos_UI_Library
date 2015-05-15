package com.android.ex.chips.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

import com.android.ex.chips.BaseRecipientAdapter;
import com.android.ex.chips.RecipientEditTextView;
import com.android.ex.chips.recipientchip.DrawableRecipientChip;

/**
 * Created by x1210x on 2015-05-15.
 */
public class AndroidChipsFragment extends Fragment {
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_android_chips, container, false);

		final RecipientEditTextView phoneRetv =
				(RecipientEditTextView) view.findViewById(R.id.phone_retv);
		phoneRetv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		BaseRecipientAdapter adapter = new BaseRecipientAdapter(BaseRecipientAdapter.QUERY_TYPE_PHONE, getActivity());
		adapter.setShowMobileOnly(true);
		phoneRetv.setAdapter(adapter);
		phoneRetv.dismissDropDownOnItemSelected(true);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				DrawableRecipientChip[] chips = phoneRetv.getSortedRecipients();
				for (DrawableRecipientChip chip : chips) {
					Log.v("DrawableChip", chip.getEntry().getDisplayName() + " " + chip.getEntry().getDestination());
				}
			}
		}, 5000);

		final ImageButton showAll = (ImageButton) view.findViewById(R.id.show_all);
		showAll.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				phoneRetv.showAllContacts();
			}
		});
		return view;
	}
}
