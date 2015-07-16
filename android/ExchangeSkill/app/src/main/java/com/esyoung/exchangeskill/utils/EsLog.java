package com.esyoung.exchangeskill.utils;

import android.util.Log;

/**
 *
 * Created by evil4t on 2015/6/10.
 * 用于打印日志
 *
 */

public class EsLog {
	
	private EsLog() {

	}

	/**
	 * 调试日志
	 * 
	 * @param tag
	 *            标签
	 * @param msg
	 *            信息
	 */
	public static void d(String tag, String msg) {
		if (EsConstant.DEBUG) {
			Log.d(esTag(tag), msg);
		} else {
			return;
		}
	}

	/**
	 * 错误日志
	 * 
	 * @param tag
	 *            标签
	 * @param msg
	 *            错误信息
	 */
	public static void e(String tag, String msg) {
		if (EsConstant.DEBUG) {
			Log.e(esTag(tag), msg);
		} else {
			return;
		}
	}

	public static void e(String tag, String msg, Throwable t) {
		if (EsConstant.DEBUG) {
			Log.e(esTag(tag), msg, t);
		}
	}

	/**
	 * 信息日志
	 * 
	 * @param tag
	 *            标签
	 * @param text
	 *            信息
	 */
	public static void i(String tag, String text) {
		if (EsConstant.DEBUG) {
			Log.i(esTag(tag), text);
		} else {
			return;
		}
	}

	/**
	 * 警告日志
	 * 
	 * @param tag
	 *            标签
	 * @param text
	 *            信息
	 */
	public static void w(String tag, String text) {
		if (EsConstant.DEBUG) {
			Log.w(esTag(tag), text);
		}
	}

	public static void w(String tag, String text, Throwable t) {
		if (EsConstant.DEBUG) {
			Log.w(esTag(tag), text, t);
		}
	}

	/**
	 * 打印异常调用堆栈
	 * 
	 * @param e
	 *            Exception
	 * @param tag
	 */
	public static void getStackTraceString(Exception e, String tag) {
		if (EsConstant.DEBUG) {
			Log.e(null, e.toString());
			for (StackTraceElement ste : e.getStackTrace()) {
				Log.e(esTag(tag), ste.toString());
			}
		}
	}

	private static String esTag(String tag) {
		return "ES." + tag;
	}
}
