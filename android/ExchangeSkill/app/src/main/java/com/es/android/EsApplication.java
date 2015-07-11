package com.es.android;

import android.app.Application;

import com.es.android.utils.DesUtil;
import com.es.android.utils.SavedState;

public class EsApplication extends Application {

    private static EsApplication singleton = new EsApplication();
    private String appName;
    private int mScreenWidth;
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

    public static EsApplication getInstance() {
        return singleton;
    }

    public int getScreenWidth() {
        return mScreenWidth;
    }

    public void setScreenWidth(int mScreenWidth) {
        this.mScreenWidth = mScreenWidth;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public SavedState getSavedState() {
        return savedState;
    }
}
