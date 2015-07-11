package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;

public class ExchangeAchievementActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exchange_achievement_activity);
		initView();
	}
	
	
	private void initView() {
		super.setTitleViewText(getString(R.string.common_drawer_achievement_district));
		super.hideExtendButton();
	}
}
