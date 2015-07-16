package com.esyoung.exchangeskill.utils;

import java.net.URLEncoder;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import android.content.Context;
import android.util.Base64;

/**
 *
 * Created by evil4t on 2015/6/10.
 * 用于保存配置文件信息的加密，做urlEncode等处理
 *
 */
public class DesUtil {
	
	private final static String iv = "01234567";

    private final static String DES_CHARSET = "utf-8";  

	private static String secureKey = "";

	public static void init(Context context) {
		secureKey = Security.getSecurity(EsConstant.MD5 + context.getPackageName());
	}
  
    public static String encrypt(String data)throws Exception{
		return encode(getSecureKey(), data);
    }
    
    public static String encrypt(int data)throws Exception{
    	return  encrypt(String.valueOf(data));
    }
    
    public static String encrypt(long data)throws Exception{
    	return encrypt(String.valueOf(data));
    }
    
    public static String encrypt(boolean data)throws Exception{
    	return encrypt(String.valueOf(data));
    }
    
	public static String encrypt(float data) throws Exception {
		return encrypt(String.valueOf(data));
	}

    public static String decrypt(String encrypted)throws Exception{
		return decode(getSecureKey(), encrypted);
    }
    
	private static String getSecureKey() {
		return secureKey;
	}

    /** 
     * 3DES加密 
     * @param secretKey 密钥 
     * @param plainText 普通文本 
     * @return 
     * @throws Exception  
     */  
	public static String encode(String secretKey, String plainText) throws Exception {
		Cipher cipher = getCBCCipher(Cipher.ENCRYPT_MODE, secretKey.getBytes());
		byte[] encryptData = cipher.doFinal(plainText.getBytes(DES_CHARSET));
		return Base64.encodeToString(encryptData, Base64.NO_WRAP);
	}
  
    /** 
     * 3DES解密 
     * @param secretKey   密钥
     * @param encryptText 加密文本 
     * @return 
     * @throws Exception 
     */  
	public static String decode(String secretKey, String encryptText) throws Exception {
		Cipher cipher = getCBCCipher(Cipher.DECRYPT_MODE, secretKey.getBytes());
		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText, Base64.NO_WRAP));
        return new String(decryptData, DES_CHARSET);  
	}

	private static Cipher getCBCCipher(int opmode, byte[] secretKey) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey);
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(opmode, deskey, ips);
		return cipher;
	}
	public static String urlEncode(String plainText) {
		try {
			return URLEncoder.encode(plainText, DES_CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
