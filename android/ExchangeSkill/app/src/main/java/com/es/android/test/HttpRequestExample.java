package com.es.android.test;

import com.es.android.job.AsyncHttpExecutor;
import com.es.android.job.GetPhoneNumberJob;
import com.es.android.utils.EsLog;

/**
 * Created by Administrator on 2015/6/10.
 * 用一个取号的例子
 */
public class HttpRequestExample {

    public HttpRequestExample() {
        AsyncHttpExecutor asyncHttpExecutor = new AsyncHttpExecutor();
        GetPhoneNumberJob getPhoneNumberJob = new GetPhoneNumberJob();
        getPhoneNumberJob.setListener(new GetPhoneNumberJob.Listener() {

            //处理http请求回调
            @Override
            public void onResponseSuccess(String message) {
                EsLog.i("Example",message);
            }

            @Override
            public void onResponseFailture(String reason) {
                EsLog.e("Example",reason);
            }
        });
        asyncHttpExecutor.execute(getPhoneNumberJob);
    }
}
