package com.es.android.activity;

import android.os.Bundle;

import com.es.android.R;

public class DisplayActivity extends BaseActivity {

	@Override
    public void onCreate(Bundle inState) {
        super.onCreate(inState);
        setContentView(R.layout.exchange_display_activity);
        initView();
    }
    
    private void initView() {
    	super.hideExtendButton();
    }
}
