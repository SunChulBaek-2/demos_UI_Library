package kr.pe.ssun.demos;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.balysv.materialmenu.MaterialMenuDrawable;

import java.util.ArrayList;
import java.util.Collections;

import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_PRESSED_DURATION;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_SCALE;
import static com.balysv.materialmenu.MaterialMenuDrawable.DEFAULT_TRANSFORM_DURATION;


public class MainActivity extends AppCompatActivity {
	private Toolbar toolbar;
	private MaterialMenuDrawable materialMenu;
	private ListView mLvLibraries;

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

		if (getSupportActionBar() != null) {
			getSupportActionBar().hide();
		}
		setupToolbar();

		mLvLibraries = (ListView) findViewById(R.id.lvLibraries);
		mLvLibraries.setAdapter(new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1,
				android.R.id.text1,
				mLibraries));
		mLvLibraries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Library selectedLibrary = mLibraries.get(position);
				Intent i = new Intent(MainActivity.this, selectedLibrary.getClazz());
				startActivity(i);
			}
		});
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
