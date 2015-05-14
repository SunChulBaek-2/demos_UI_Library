package kr.pe.ssun.demos;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;
import java.util.Collections;

import kr.pe.ssun.demos.adapter.MainListAdapter;
import kr.pe.ssun.demos.adapter.MainStaggeredGridAdapter;
import kr.pe.ssun.mylibrary.BaseActivity;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;


public class MainActivity extends BaseActivity {

	private static ArrayList<Library> mLibraries = new ArrayList<>();

	static {
		mLibraries.add(Library.MATERIAL_TAB);
		mLibraries.add(Library.ANDROID_CHIPS);

		Collections.sort(mLibraries, new LibraryNameComparator());
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction()
				.add(R.id.content, new MainFragment())
				.commit();
	}
}
