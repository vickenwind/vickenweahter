package com.vickenweather.app.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.DownloadManager.Request;

public class ReqAndRes {

	
   
	
	public static void main(String[] args) {
		String httpUrl = "http://apis.baidu.com/apistore/weatherservice/citylist";
		String httpArg = "cityname=%E6%9C%9D%E9%98%B3";
		String jsonResult = request(httpUrl, httpArg);
		System.out.println(jsonResult);
	}

	
	
	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
	        connection.setRequestProperty("apikey",  "dc75ec268ea99293bca3c5e0d4d08b5b");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	
}
