package kr.pe.ssun.demos;

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
	private Toolbar toolbar;
	private MaterialMenuDrawable materialMenu;
	private RecyclerView rvLibraries;

	private static ArrayList<Library> mLibraries = new ArrayList<>();

	static {
		mLibraries.add(Library.MATERIAL_TAB);
		mLibraries.add(Library.ANDROID_CHIPS);

		Collections.sort(mLibraries, new LibraryNameComparator());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		RelativeLayout view = (RelativeLayout) findViewById(R.id.rlRoot);
		if(view.getTag() != null) {
			String tag = (String) view.getTag();
			Screen.setCurrent(Screen.valueOf(tag.toUpperCase()));
		}

		setupToolbar();

		rvLibraries = (RecyclerView) findViewById(R.id.rvLibraries);
		if(Screen.getCurrent().equals(Screen.LARGE_LAND)) {
			rvLibraries.setLayoutManager(new StaggeredGridLayoutManager(2,
					StaggeredGridLayoutManager.VERTICAL));
			rvLibraries.setAdapter(new MainStaggeredGridAdapter());
		} else {
			rvLibraries.setLayoutManager(new LinearLayoutManager(this));
			rvLibraries.setAdapter(new MainListAdapter());
		}
	}

	private void setupToolbar() {
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		materialMenu = new MaterialMenuDrawable(this,
				Color.WHITE,
				MaterialMenuDrawable.Stroke.THIN,
				DEFAULT_SCALE,
				DEFAULT_TRANSFORM_DURATION,
				DEFAULT_PRESSED_DURATION);
		toolbar.setNavigationIcon(materialMenu);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
		toolbar.setTitle(R.string.app_name);
		toolbar.setTitleTextColor(Color.WHITE);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
