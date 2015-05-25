package kr.pe.ssun.demos;

import android.app.FragmentManager;
import android.os.Bundle;

import kr.pe.ssun.mylibrary.BaseActivity;


public class MainActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setToolbarTitle(R.string.app_name);

		FragmentManager fm = getFragmentManager();
		fm.beginTransaction()
				.add(R.id.content, new MainFragment())
				.commit();
	}
}
