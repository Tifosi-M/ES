package com.es.android.activity;

import android.os.Bundle;

import com.es.android.EsApplication;
import com.es.android.R;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGTH = 2000; // 延时5秒

	private SharedPreferences preferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.start_activity);
		EsApplication.getInstance().setAppName(getString(R.string.app_name));
		
		if(!checkWhetherFirstStart()){
			showMainActivity();
		}
	}

	private void showMainActivity() {
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this,DisplayActivity.class);
				SplashActivity.this.startActivity(mainIntent); // 启动MainActivity
				SplashActivity.this.finish(); // 结束SplashActivity
			}
		}, SPLASH_DISPLAY_LENGTH);
	}

	private boolean checkWhetherFirstStart() {
		boolean isFirstStart = false;
		// 读取SharedPreferences中需要的数据
		preferences = getSharedPreferences("count", 0);
		int count = preferences.getInt("count", 0);

		// 判断程序与第几次运行,如果是第一次运行则跳转到引导页面
//		if (count == 0) {
//			LoadDemoDataAsync loadtask = new LoadDemoDataAsync();
//			loadtask.execute();
//			showDialog(PROGRESS_DIALOG);
//			isFirstStart = true;
//		}
		Editor editor = preferences.edit();
		editor.putInt("count", ++count);
		editor.commit();
		return isFirstStart;
	}

	private static final int PROGRESS_DIALOG = 1;

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case PROGRESS_DIALOG:
			ProgressDialog progressDialog = ProgressDialog.show(this, "","演示数据加载中...", true, true);
			progressDialog.setCancelable(false);
			return progressDialog;
		default:
			return null;
		}
	}
}