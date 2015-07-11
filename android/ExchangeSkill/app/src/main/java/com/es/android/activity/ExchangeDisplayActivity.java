package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;

public class ExchangeDisplayActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exchange_district_activity);
		initView();
		
	}
	
	private void initView() {
		super.setTitleViewText(getString(R.string.common_drawer_exchange_district));
		super.hideExtendButton();
	}
}
