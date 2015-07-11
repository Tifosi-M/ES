package com.es.android.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.es.android.R;
public class SystemConfigureActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.exchange_system_configure_activity);
		
		initViews();
	}

	private void initViews() {
		TextView title = super.getTitleView();
		title.setText(R.string.common_drawer_systemsetting_district);
		super.hideExtendButton();
	}
}
