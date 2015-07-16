package com.esyoung.exchangeskill.test;

import com.esyoung.exchangeskill.job.AsyncHttpExecutor;
import com.esyoung.exchangeskill.job.GetPhoneNumberJob;
import com.esyoung.exchangeskill.utils.EsLog;

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
