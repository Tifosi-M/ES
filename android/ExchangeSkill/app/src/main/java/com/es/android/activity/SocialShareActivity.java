package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;

public class SocialShareActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle inState) {
		super.onCreate(inState);
		setContentView(R.layout.exchange_social_activity);
		initView();
	}

	private void initView() {
		super.setTitleViewText(getString(R.string.common_drawer_socialshare_district));
		super.hideExtendButton();
	}
}
