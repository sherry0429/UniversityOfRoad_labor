package com.example.universityofroad_tips;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;

import javax.security.auth.login.LoginException;

import com.example.universityofroad.R;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;
import com.example.universityofroad.R.menu;
import com.example.universityofroad.R.raw;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ReadText extends Activity {

	private String FileName;
	private String book;
	private TextView text;
	private float zoomScale=2.0f;//缩放比例
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_text);
		InitStream();
		text = (TextView) findViewById(R.id.book);
		text.setText(book);
		new ZoomTextView(text, zoomScale);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_text, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void InitStream(){
		GetFileNameFromListItem();
		InputStream stream = LoadFile(FileName);
		if(stream!=null)
			book = getString(stream);
		else
			book = "Can't find txt.";
	}
	
	public static String getString(InputStream inputStream) {
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "gbk");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(inputStreamReader);
		StringBuffer sb = new StringBuffer("");
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private void GetFileNameFromListItem(){
		Intent intent = getIntent();
		FileName = intent.getStringExtra("Name");
	}
	
	
//	加入文件需要更改的地方
	private InputStream LoadFile(String str){
		InputStream stream = null;
		if(str.equals("swimming")){
			stream = getResources().openRawResource(R.raw.swimming);
		}else if(str.equals("swustcard")){
			stream = getResources().openRawResource(R.raw.swustcard);
		}else if(str.equals("qingjia")){
			stream = getResources().openRawResource(R.raw.qingjia);
		}else if(str.equals("jiangxuejin")){
			stream = getResources().openRawResource(R.raw.jiangxuejin);
		}else if(str.equals("biye")){
			stream = getResources().openRawResource(R.raw.biye);
		}else if(str.equals("diudongxi")){
			stream = getResources().openRawResource(R.raw.diudongxi);
		}else if(str.equals("yinhangka")){
			stream = getResources().openRawResource(R.raw.yinhangka);
		}else if(str.equals("shenfenzhen")){
			stream = getResources().openRawResource(R.raw.shenfenzhen);
		}else if(str.equals("xiaoka_chongzhi")){
			stream = getResources().openRawResource(R.raw.xiaoka_chongzhi);
		}
		return stream;
	}
}
