package com.example.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

public abstract class SingleFragmentActivity extends FragmentActivity {
	private static final String TAG = "Criminalintent";
	protected abstract Fragment createFragment();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			Log.d(TAG, "in SingleFragment");
			fm.beginTransaction()
				.add(R.id.fragmentContainer, fragment)
				.commit();
			//Log.d(TAG, "done");
		}
	
	}
}
