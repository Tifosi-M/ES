
package com.esyoung.exchangeskill.job;

import com.esyoung.exchangeskill.http.AsyncHttpResponseHandler;
import com.esyoung.exchangeskill.utils.EsLog;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.json.JSONArray;

public abstract class AsyncHttpJob {
	private static final String TAG = "AsyncHttpTask";

	private final String name;

	public AsyncHttpJob(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	protected abstract String getRequestUrl();

	protected abstract String getMethod();

	protected abstract HttpEntity getHttpEntity();

	protected abstract void onResponseSuccess(String response);

	protected abstract void onResponseFailture(String errorMsg);

	public AsyncHttpResponseHandler getResponseHandler() {
		return new MyResponseHandler();
	}

	private class MyResponseHandler extends AsyncHttpResponseHandler {
		@Override
		public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
			try {
				String response = responseBody == null ? null : new String(responseBody,
						getCharset());
				onResponseSuccess(response);
			} catch (UnsupportedEncodingException e) {
				EsLog.e(TAG, "unsupported encodeing");
				e.printStackTrace();
			}
		}

		@Override
		public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
			EsLog.e(TAG, "statusCode: " + statusCode);
			EsLog.e(TAG, "headers: " + (headers != null ? headers.length : 0));
			EsLog.e(TAG, "responseBody: "
					+ (responseBody != null ? new String(responseBody) : ""));
			EsLog.e(TAG, "error: " + error.getMessage());
			onResponseFailture(error.getMessage());
		}
	}

	protected JSONArray toJSONArray(List<String> values) {
		JSONArray array = new JSONArray();
		for (String val : values) {
			try {
				array.put(val);
			} catch (Exception e) {
				EsLog.e(TAG, "toJSONArray error: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return array;
	}
}
