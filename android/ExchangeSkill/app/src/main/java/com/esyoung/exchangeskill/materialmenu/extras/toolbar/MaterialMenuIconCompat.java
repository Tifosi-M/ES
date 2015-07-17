package com.esyoung.exchangeskill.materialmenu.extras.toolbar;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.esyoung.exchangeskill.materialmenu.MaterialMenuBase;
import com.esyoung.exchangeskill.materialmenu.MaterialMenuDrawable;

public class MaterialMenuIconCompat extends MaterialMenuBase {

    public MaterialMenuIconCompat(ActionBarActivity activity, int color, MaterialMenuDrawable.Stroke stroke) {
        super(activity, color, stroke);
    }

    public MaterialMenuIconCompat(ActionBarActivity activity, int color, MaterialMenuDrawable.Stroke stroke, int transformDuration) {
        super(activity, color, stroke, transformDuration);
    }

    public MaterialMenuIconCompat(ActionBarActivity activity, int color, MaterialMenuDrawable.Stroke stroke, int transformDuration, int pressedDuration) {
        super(activity, color, stroke, transformDuration, pressedDuration);
    }

    @Override
    protected View getActionBarHomeView(Activity activity) {
        return null;
    }

    @Override
    protected View getActionBarUpView(Activity activity) {
        return null;
    }

    @Override
    protected boolean providesActionBar() {
        return false;
    }

    @Override
    protected void setActionBarSettings(Activity activity) {
        ActionBar actionBar = ((ActionBarActivity) activity).getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(getDrawable());
    }
}