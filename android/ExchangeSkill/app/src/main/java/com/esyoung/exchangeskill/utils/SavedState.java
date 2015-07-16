package com.esyoung.exchangeskill.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 *
 * Created by evil4t on 2015/6/10.
 * 用于保存配置文件信息
 *
 */
public class SavedState {
	private static final String TAG = "SavedState";
	private static final String PREF_NAME = "es_preference";
	private final SharedPreferences prefs;
	private final SharedPreferences.Editor editor;
	private final Lock lock = new ReentrantLock();
	
	public SavedState(Context context) {
		this.prefs = context.getSharedPreferences(PREF_NAME, 0);
		this.editor = this.prefs.edit();
	}

	public String getString(final String key, final String defaultValue) {
		String decryptData = getDecryptData(key);
		if (TextUtils.isEmpty(decryptData)) {
			return defaultValue;
		}
		return decryptData;
	}

	public boolean getBoolean(final String key, final boolean defaultValue) {
		String decryptData = getDecryptData(key);
		if (TextUtils.isEmpty(decryptData)) {
			return defaultValue;
		}
		return Boolean.parseBoolean(decryptData);
	}

	public int getInt(final String key, final int defaultValue) {
		String decryptData = getDecryptData(key);
		if (TextUtils.isEmpty(decryptData)) {
			return defaultValue;
		}
		return Integer.parseInt(decryptData);
	}

	public float getFloat(final String key, final float defaultValue) {
		String decryptData = getDecryptData(key);
		if (TextUtils.isEmpty(decryptData)) {
			return defaultValue;
		}
		return Float.parseFloat(decryptData);
	}

	public long getLong(final String key, final long defaultValue) {
		String decryptData = getDecryptData(key);
		if (TextUtils.isEmpty(decryptData)) {
			return defaultValue;
		}
		return Long.parseLong(decryptData);
	}
	
	private String getDecryptData(final String key) {
		String encryptData = this.prefs.getString(key, "");
		if (TextUtils.isEmpty(encryptData)) {
			return null;
		}
		String decryptData;
		try {
			decryptData = DesUtil.decrypt(encryptData);
		} catch (Exception e) {
			EsLog.e(TAG, "Failed to decrypt data with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		return decryptData;
	}


	private boolean save_(final String key, final String value) {
		lock.lock();
		try {
			editor.putString(key, value);
			return editor.commit();
		} finally {
			lock.unlock();
		}
	}
	
	public boolean save(final String key, final String value) {
		String encryptValue = "";
		try {
			encryptValue = DesUtil.encrypt(value);
		} catch (Exception e) {
            EsLog.e(TAG, "Failed to encrypt String with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return save_(key, encryptValue);
	}
	
	
	public boolean save(final String key, final boolean value) {
		String encryptValue = "";
		try {
			encryptValue = DesUtil.encrypt(value);
		} catch (Exception e) {
            EsLog.e(TAG, "Failed to encrypt boolean with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return save_(key, encryptValue);
	}

	public boolean save(final String key, final int value) {
		String encryptValue = "";
		try {
			encryptValue = DesUtil.encrypt(value);
		} catch (Exception e) {
            EsLog.e(TAG, "Failed to encrypt int with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return save_(key, encryptValue);
	}

	public boolean save(final String key, final long value) {
		String encryptValue = "";
		try {
			encryptValue = DesUtil.encrypt(value);
		} catch (Exception e) {
            EsLog.e(TAG, "Failed to encrypt long with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return save_(key, encryptValue);
	}

	public boolean save(final String key, final float value) {
		String encryptValue = "";
		try {
			encryptValue = DesUtil.encrypt(value);
		} catch (Exception e) {
            EsLog.e(TAG, "Failed to encrypt float with key (" + key + "): " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return save_(key, encryptValue);
	}
}
