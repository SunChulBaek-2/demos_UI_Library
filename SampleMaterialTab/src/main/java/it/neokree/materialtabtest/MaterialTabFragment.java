package it.neokree.materialtabtest;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by x1210x on 2015-05-15.
 */
public class MaterialTabFragment extends Fragment implements AdapterView.OnItemClickListener {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_material_tabs, container, false);

		ListView lvListView = (ListView) view.findViewById(R.id.lvListView);

		ArrayList<String> list = new ArrayList<String>();

		list.add("Text Tab");
		list.add("Swipable Text Tabs (more than 3)");
		list.add("Icon Tab");
		list.add("Swipable Icon Tab (more than 5)");

		lvListView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list));
		lvListView.setOnItemClickListener(this);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent;
		switch(position) {
			case 0:
				intent = new Intent(getActivity(), TextTabActivity.class);
				break;
			case 1:
				intent = new Intent(getActivity(), SwipableTextTabActivity.class);
				break;
			case 2:
				intent = new Intent(getActivity(), IconTabActivity.class);
				break;
			case 3:
				intent = new Intent(getActivity(), SwipableIconTabActivity.class);
				break;
			default:
				intent = null;
		}
		startActivity(intent);
	}
}
