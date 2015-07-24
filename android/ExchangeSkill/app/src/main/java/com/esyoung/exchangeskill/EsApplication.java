package com.esyoung.exchangeskill;

import android.app.Application;

import com.esyoung.exchangeskill.job.AsyncHttpExecutor;
import com.esyoung.exchangeskill.job.LoginJob;
import com.esyoung.exchangeskill.utils.DesUtil;
import com.esyoung.exchangeskill.utils.EsLog;
import com.esyoung.exchangeskill.utils.SavedState;

public class EsApplication extends Application {

    private static EsApplication singleton = new EsApplication();
    private String appName;
    private int mScreenWidth;
    private SavedState savedState;

    @Override
    public void onCreate() {
        super.onCreate();
        esUtilsInit();

        AsyncHttpExecutor asyncHttpExecutor = new AsyncHttpExecutor();
        LoginJob loginJob = new LoginJob();
        loginJob.setListener(new LoginJob.Listener() {
            //处理http请求回调
            @Override
            public void onResponseSuccess(String message) {
                EsLog.i("Example", message);
            }

            @Override
            public void onResponseFailture(String reason) {
                EsLog.e("Example",reason);
            }
        });
        asyncHttpExecutor.execute(loginJob);

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
