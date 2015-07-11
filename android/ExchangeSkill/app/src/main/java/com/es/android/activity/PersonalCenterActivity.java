package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;

public class PersonalCenterActivity extends BaseActivity {

	@Override
	public void onCreate(Bundle inState) {
		super.onCreate(inState);
		setContentView(R.layout.exchange_personal_center);
		initView();
	}

	private void initView() {
		super.setTitleViewText(getString(R.string.common_drawer_personalcenter_district));
		super.hideExtendButton();
	}
}
