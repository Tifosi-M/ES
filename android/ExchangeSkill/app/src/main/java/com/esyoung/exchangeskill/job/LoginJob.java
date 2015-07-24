package com.esyoung.exchangeskill.job;

import android.text.TextUtils;

import com.esyoung.exchangeskill.http.RequestParams;
import com.esyoung.exchangeskill.utils.EsConstant;
import com.esyoung.exchangeskill.utils.EsLog;

import org.apache.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenzw on 2015/7/23.
 */
public class LoginJob extends AsyncHttpJob {

    private static final String TAG = "LoginJob";

    public LoginJob() {
        super(LoginJob.class.getSimpleName());
    }

    public interface Listener {
        public void onResponseSuccess(String message);

        public void onResponseFailture(String reason);
    }

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public String getRequestUrl() {
        return EsConstant.LOGIN_URL;

    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public RequestParams getHttpRequestParams() {
        RequestParams params = new RequestParams();
        params.put("username", "admin"); // 设置请求的参数名和参数值
        params.put("password", "admin");// 设置请求的参数名和参数
        EsLog.d(TAG, "Log report content: " + params.toString());
        return params;
    }

    @Override
    protected void onResponseSuccess(String response) {
        System.out.println("human readable response: " + response.trim());

        if (this.listener != null) {
            if (TextUtils.isEmpty(response.trim())) {
                this.listener.onResponseFailture(response);
            } else {
                this.listener.onResponseSuccess(response.trim());
            }
        }
    }

    @Override
    protected void onResponseFailture(String errorMsg) {
        if (listener != null) {
            listener.onResponseFailture(errorMsg);
        }
    }
}
