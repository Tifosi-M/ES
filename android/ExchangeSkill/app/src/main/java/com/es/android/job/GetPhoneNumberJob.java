package com.es.android.job;

import org.apache.http.HttpEntity;

import android.text.TextUtils;

import com.es.android.utils.EsConstant;

public class GetPhoneNumberJob extends AsyncHttpJob {

    private static final String TAG = "GetPhoneNumberJob";

    public GetPhoneNumberJob() {
        super(GetPhoneNumberJob.class.getSimpleName());
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
        return EsConstant.GET_PHONENUMBER_URL;
        
    }

    @Override
    public String getMethod() {
        return "GET";
        //return "POST"
    }

    @Override
    public HttpEntity getHttpEntity() {
        return null;

        //如果是post请求，参考下面
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.put("packageName", packageName);
//            jsonObject.put("platform", deviceInfo.getPlatform());
//            jsonObject.put("imei", deviceInfo.getImei());
//            jsonObject.put("appVersion", appInfo.getAppVersion());
//            jsonObject.put("networkType", networkType);
//            jsonObject.put("carrier", carrier);
//            jsonObject.put("actionVersion", authState.getActionVersion());
//            jsonObject.put("deviceName", android.os.Build.MODEL);
//            jsonObject.put("errorCode", Agent.getErrorCode());
//            jsonObject.put("imsi", strImsi);
//            jsonObject.put("phoneNum", phoneNum);
//            EstoLog.d(TAG, "auth request: " + jsonObject.toString());
//            return new StringEntity(jsonObject.toString(), "UTF-8");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
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
