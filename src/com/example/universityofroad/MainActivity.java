package com.example.universityofroad;

import com.example.universityofroad_about.AboutUs;
import com.example.universityofroad_choose.ChooseView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

	private Button left;
	private Button right;
	private Button About_us;
	private int startcount=0;
	private Intent GoNext;
	
	
	private void MakeStartOne_TobeTrue(){
		SharedPreferences sharePreferences = getSharedPreferences("SimpleData", MODE_PRIVATE);
		startcount = sharePreferences.getInt("startcount", 1);
		startcount++;
		
        SharedPreferences.Editor editor = getSharedPreferences("SimpleData", MODE_PRIVATE).edit();
        editor.putInt("StartCount", startcount);
        editor.commit();
	}
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainport);
        //记录启动次数
        MakeStartOne_TobeTrue();
        left = (Button)findViewById(R.id.first);
        right = (Button)findViewById(R.id.second);
        About_us = (Button)findViewById(R.id.about);
        left.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				GoNext = new Intent(MainActivity.this,StudentNeedKnow.class);
				startActivity(GoNext);
			}
		});
        right.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "我们会尽快上线这块功能!", Toast.LENGTH_SHORT).show();
				//GoNext = new Intent(MainActivity.this,ChooseView.class);
				//startActivity(GoNext);
			}
		});
        About_us.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,AboutUs.class);
				startActivity(intent);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	// TODO Auto-generated method stub
    	if(startcount >=0 ){
    		this.finish();
    	}
    	return super.onKeyDown(keyCode, event);
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
    
//	class Mylistener implements OnClickListener {
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//		}
//
//	}

}
