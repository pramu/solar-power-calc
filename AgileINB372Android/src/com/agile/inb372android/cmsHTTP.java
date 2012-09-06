package com.agile.inb372android;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class cmsHTTP {

	public cmsHTTP(Activity act) {
		this.act = act;
	}
	public String mimeType = "text/html";
	public String encoding = "UTF-8";
	public int REGISTRATION_TIMEOUT = 10 * 1000;
	public String TAG = "cmsHTTP";
	public Activity act;
	public String noData = "죄송합니다.\n네트웍 장애가 있습니다.\n다시 시도해주세요.";
	public String result = null;
	public static HashMap<String, String> GETHM;
	//public static String newResult;
	

	public void sendGet(String url) {

		HttpResponse resp;

		HttpGet httpGet = new HttpGet(url);

		HttpClient httpClient = new DefaultHttpClient();
		HttpParams tmpparms = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(tmpparms,
				REGISTRATION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(tmpparms, REGISTRATION_TIMEOUT);
		ConnManagerParams.setTimeout(tmpparms, REGISTRATION_TIMEOUT);

		try {
			resp = httpClient.execute(httpGet);
			if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				if (Log.isLoggable(TAG, Log.VERBOSE))
					Log.v(TAG, "Successful authentication");
				HttpEntity respEntity = resp.getEntity();
				if (respEntity != null) {
					InputStream instream = respEntity.getContent();
					result = convertStreamToString(instream);
					instream.close();
				}
			} else {
				if (Log.isLoggable(TAG, Log.VERBOSE))
					Log.v(TAG, "Error Process" + resp.getStatusLine());
			}
		} catch (final IOException e) {
			if (Log.isLoggable(TAG, Log.VERBOSE))
				Log.v(TAG, "IOException when getting authtoken", e);
		} finally {
			if (Log.isLoggable(TAG, Log.VERBOSE))
				Log.v(TAG, "completing");
		}

		if (result == null) {
			Toast.makeText(act, noData, Toast.LENGTH_SHORT).show();
		}

		
		xml2HashMap(result, "UTF-8");
	
	}

	public String convertStreamToString(InputStream is) {

		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, encoding), 8);
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	 HashMap<String, String> xml2HashMap(String tmpData, String encoding) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("count", "0");
			try {
				DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
				DocumentBuilder docB = docBF.newDocumentBuilder();
				InputStream is = new ByteArrayInputStream(tmpData.getBytes(encoding));
				Document doc = docB.parse(is);
				Element lists = doc.getDocumentElement();
				NodeList dataList = lists.getElementsByTagName("data");
				int c = 0;
				for (int i = 0; i < dataList.getLength(); i++) {
					NodeList dataNodeList = dataList.item(i).getChildNodes();
					for (int j = 0; j < dataNodeList.getLength(); j++) {
						Node itemNode = dataNodeList.item(j);
						if (itemNode.getFirstChild() != null) {
							String nodeName = itemNode.getNodeName();
							String nodeValue = itemNode.getFirstChild().getNodeValue();
							hm.put(nodeName + "[" + i + "]", nodeValue);
						}
					}// for j
					c++;
				}// for i
				hm.put("count", Integer.toString(c));
			} catch (Exception e) {
				Log.e("com.cms.sample.xml2HashMap", e.getMessage());
			}
			GETHM = hm;
			return hm;
		}
	 



}