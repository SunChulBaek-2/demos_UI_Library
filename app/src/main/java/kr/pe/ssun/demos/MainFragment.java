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

import kr.pe.ssun.demos.adapter.MainListAdapter;
import kr.pe.ssun.demos.adapter.MainStaggeredGridAdapter;

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
			rvLibraries.setLayoutManager(new StaggeredGridLayoutManager(2,
					StaggeredGridLayoutManager.VERTICAL));
			rvLibraries.setAdapter(new MainStaggeredGridAdapter());
		} else {
			rvLibraries.setLayoutManager(new LinearLayoutManager(getActivity()));
			rvLibraries.setAdapter(new MainListAdapter());
		}
		return view;
	}
}
