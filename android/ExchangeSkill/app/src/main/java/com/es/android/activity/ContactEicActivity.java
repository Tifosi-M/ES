package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;


public class ContactEicActivity extends BaseActivity {
	@Override
    public void onCreate(Bundle inState) {
        super.onCreate(inState);
        setContentView(R.layout.exchange_contactus_activity);
        initView();
    }
    
    private void initView() {
    	super.setTitleViewText(getString(R.string.common_drawer_contactus_district));
    	super.hideExtendButton();
    }
}
