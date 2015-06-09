package com.es.android;

import android.app.Application;

import com.es.android.utils.DesUtil;
import com.es.android.utils.SavedState;

public class EsApplication extends Application {

    private SavedState savedState;

    @Override
    public void onCreate() {
        super.onCreate();
        esUtilsInit();
    }

    private void esUtilsInit(){
        DesUtil.init(this);
        savedState = new SavedState(this);
    }

    public SavedState getSavedState() {
        return savedState;
    }
}
