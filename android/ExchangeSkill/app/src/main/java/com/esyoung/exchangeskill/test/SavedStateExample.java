package com.esyoung.exchangeskill.test;

import android.content.Context;

import com.esyoung.exchangeskill.EsApplication;
import com.esyoung.exchangeskill.utils.EsLog;
import com.esyoung.exchangeskill.utils.SavedState;

/**
 * Created by evil4t on 2015/6/10.
 */
public class SavedStateExample {

    private SavedState savedState;

    public SavedStateExample(Context context) {
        EsApplication esApplication = ((EsApplication)context.getApplicationContext());
        savedState = esApplication.getSavedState();
    }

    public void doSave() {
        savedState.save("key",1);
        savedState.save("key2","2");
        savedState.save("key3",true);
    }

    public void doGetSaveValue() {
        EsLog.i("example",savedState.getInt("key", -1) + "");
        EsLog.i("example",savedState.getString("key2", ""));
        EsLog.i("example",savedState.getBoolean("key3", false) + "");
    }
}
