package kr.pe.ssun.demos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import kr.pe.ssun.demos.adapter.MainAdapter;

/**
 * Created by x1210x on 15. 5. 15..
 */
public class MainFragment extends Fragment {
	private RecyclerView rvLibraries;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main, container, false);

		RelativeLayout rlRoot = (RelativeLayout) view.findViewById(R.id.rlRoot);
		if(rlRoot.getTag() != null) {
			String tag = (String) rlRoot.getTag();
			Screen.setCurrent(Screen.valueOf(tag.toUpperCase()));
		}

		rvLibraries = (RecyclerView) view.findViewById(R.id.rvLibraries);
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
