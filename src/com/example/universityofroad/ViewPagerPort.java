package com.example.universityofroad;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import javax.security.auth.PrivateCredentialPermission;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.UnderlinePageIndicator;

import android.R.bool;
import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ViewPagerPort extends Activity implements OnTouchListener{

	private View view1, view2, view3;
	private List<View> viewList;// view数组
	private ViewPager viewPager; // 对应的viewPager

	private CirclePageIndicator indicator;
	private int CurrentView;
	private int lastX=0;
	private boolean StartFirstTime;
//	检测是否第一次启动应用
	private int CheckStartTimes(){
		int result=0;
		try{
			SharedPreferences sharePreferences = getSharedPreferences("SimpleData", MODE_PRIVATE);
			SharedPreferences.Editor editor = getSharedPreferences("SimpleData", MODE_PRIVATE).edit();
	        //editor.putInt("StartCount", result);
	        //editor.commit();
			result = sharePreferences.getInt("StartCount", 0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager_port);
		//如果不是第一次启动应用 就不播放欢迎界面了
		if(CheckStartTimes()>=1){
			Intent jumpToMain = new Intent(ViewPagerPort.this,MainActivity.class);
			startActivity(jumpToMain);
			this.finish();
		}
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		LayoutInflater inflater = getLayoutInflater();
		view1 = inflater.inflate(R.layout.port_1, null);
		view2 = inflater.inflate(R.layout.port_2, null);
		view3 = inflater.inflate(R.layout.port_3, null);
		

		viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewPager.setOnTouchListener(this);
		PagerAdapter pagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return viewList.size();
			}

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				// TODO Auto-generated method stub
				container.removeView(viewList.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				// TODO Auto-generated method stub
				container.addView(viewList.get(position));

				return viewList.get(position);
			}
		};

		viewPager.setAdapter(pagerAdapter);
		//viewpager下的线
		indicator = (CirclePageIndicator)findViewById(R.id.indicator);
		indicator.setViewPager(viewPager);
		
		indicator.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.i("onPageSelected","arg0:"+arg0);
				CurrentView = arg0;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				Log.i("onPageScrolled","arg0:"+arg0+" arg1:"+arg1+" arg2:"+arg2);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				Log.i("onPageScrollStateChanged","arg0:"+arg0);
			}
		});

	}

	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			lastX=(int)event.getX();
//			Toast.makeText(ViewPagerPort.this, String.valueOf(lastX), Toast.LENGTH_SHORT).show();
			break;
		case MotionEvent.ACTION_MOVE:
//			Toast.makeText(ViewPagerPort.this, "Move", Toast.LENGTH_SHORT).show();
			if((lastX-event.getX())>=150 && CurrentView == viewList.size()-1){

				Intent intent = new Intent(ViewPagerPort.this,MainActivity.class);
				startActivity(intent);
				OpenTime_add();
				this.finish();

			}
			break;
		default:
			break;
		}
		return false;
	}
	
	//已经打开了一次
	private void OpenTime_add(){
        SharedPreferences.Editor editor = getSharedPreferences("SimpleData", MODE_PRIVATE).edit();
        editor.putInt("StartCount", 1);
        editor.commit();
	}
	

}
