package com.browser.Speed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.browser.Speed.R;
import com.browser.Speed.preference.PreferenceManager;

public abstract class ThemableSettingsActivity extends AppCompatActivity {

	private boolean mDark;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mDark = PreferenceManager.getInstance().getUseDarkTheme();

		// set the theme
		if (mDark) {
			setTheme(R.style.Theme_SettingsTheme_Dark);
		}
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (PreferenceManager.getInstance().getUseDarkTheme() != mDark) {
			restart();
		}
	}

	protected void restart() {
		final Bundle outState = new Bundle();
		onSaveInstanceState(outState);
		final Intent intent = new Intent(this, getClass());
		finish();
		overridePendingTransition(0, 0);
		startActivity(intent);
	}
}
