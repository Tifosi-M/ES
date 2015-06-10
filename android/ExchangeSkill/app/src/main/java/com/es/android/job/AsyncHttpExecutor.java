package com.es.android.job;

import java.io.UnsupportedEncodingException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import android.os.Looper;
import android.text.TextUtils;

import com.es.android.http.AsyncHttpClient;
import com.es.android.http.AsyncHttpResponseHandler;
import com.es.android.utils.EsLog;

public class AsyncHttpExecutor {

	private static final String TAG = "AsyncHttpExecutor";

	private final AsyncHttpClient httpClient;

	public AsyncHttpExecutor() {
		httpClient = new AsyncHttpClient();
		httpClient.setEnableRedirects(true, true, true);
	}

	public void execute(AsyncHttpJob job) {
		if (job == null) {
			throw new IllegalArgumentException("task can not be null");
		}
		if (!isValid(job)) {
			EsLog.e(TAG, "invalid job, can not execute");
			return;
		}
		if (job.getMethod().equals("POST")) {
			post(job.getRequestUrl(), job.getHttpEntity(),
					new MyHttpResponseHandler(job));
		} else {
			get(job.getRequestUrl(), new MyHttpResponseHandler(job));
		}
	}

	private boolean isValid(AsyncHttpJob job) {
		if (TextUtils.isEmpty(job.getRequestUrl())) {
			EsLog.e(TAG, "invalid job request url");
			return false;
		}
		if (TextUtils.isEmpty(job.getMethod())) {
			EsLog.e(TAG, "invalid job method");
			return false;
		}
		return true;
	}

	public void post(String url, HttpEntity entity,
			AsyncHttpResponseHandler responseHandler) {
		httpClient.post(null, url, entity, null, responseHandler);
	}
	
	public void get(String url, AsyncHttpResponseHandler responseHandlers) {
		httpClient.get(url, responseHandlers);
	}

	private class MyHttpResponseHandler extends AsyncHttpResponseHandler {
		private final AsyncHttpJob job;

		public MyHttpResponseHandler(AsyncHttpJob job) {
			super(Looper.getMainLooper());
			this.job = job;
		}

		@Override
		public void onSuccess(int statusCode, Header[] headers,
				byte[] responseBody) {
			try {
				String response = responseBody == null ? null : new String(
						responseBody, getCharset());
				job.onResponseSuccess(response);
			} catch (UnsupportedEncodingException e) {
				EsLog.e(TAG, "unsupported encodeing", e);
			}

		}

		@Override
		public void onFailure(int statusCode, Header[] headers,
				byte[] responseBody, Throwable error) {
			if (statusCode != 0) {
				EsLog.e(TAG, "statusCode: " + statusCode);
			}
			if (responseBody != null) {
				EsLog.e(TAG, "responseBody: " + new String(responseBody));
			}
			if (error != null) {
				EsLog.e(TAG, "error", error);
			}
			this.job.onResponseFailture("NETWORK_ERROR");
		}
		
	}
}
