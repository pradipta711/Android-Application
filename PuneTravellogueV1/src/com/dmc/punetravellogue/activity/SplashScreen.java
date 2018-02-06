
package com.dmc.punetravellogue.activity;
import com.dmc.punetravellogue.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreen extends Activity {
	private static int SPLASH_TIME_OUT = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
						Intent intent = new Intent(SplashScreen.this, MainActivity.class);
						startActivity(intent);
						finish();
			}
		}, SPLASH_TIME_OUT);
	}

	
	

}
