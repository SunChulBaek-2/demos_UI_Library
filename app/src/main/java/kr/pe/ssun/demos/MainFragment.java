package kr.pe.ssun.demos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.pe.ssun.demos.adapter.MainAdapter;

/**
 * Created by x1210x on 15. 5. 15..
 */
public class MainFragment extends Fragment {
	private RecyclerView rvLibraries;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.recycler_view_main, container, false);

		rvLibraries = (RecyclerView) view.findViewById(R.id.rvLibraries);
		if(rvLibraries.getTag() != null) {
			String tag = (String) rvLibraries.getTag();
			Screen.setCurrent(Screen.valueOf(tag.toUpperCase()));
		}

		if(Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			rvLibraries.setLayoutManager(new StaggeredGridLayoutManager(3,
					StaggeredGridLayoutManager.VERTICAL));
			rvLibraries.setAdapter(new MainAdapter());
		} else {
			rvLibraries.setLayoutManager(new LinearLayoutManager(getActivity()));
			rvLibraries.setAdapter(new MainAdapter());
		}
		return view;
	}
}
