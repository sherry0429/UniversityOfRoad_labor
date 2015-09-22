package com.example.universityofroad;


import com.example.universityofroad.robot.Robot;
import com.example.universityofroad_execellent.Ex_listmap;
import com.example.universityofroad_shortcut.Sc_ShortCutNote;
import com.example.universityofroad_shortcut_map.LookMap;
import com.example.universityofroad_tips.ShowList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class StudentNeedKnow extends Activity {

	private MyTouchListener myTouchListener = new MyTouchListener();
	private Button button1,button2,button3,button4;
	
	private void InitWidget(){
		button1 = (Button)findViewById(R.id.Tips);
		button2 = (Button)findViewById(R.id.Eatbool);
		button4 = (Button)findViewById(R.id.Laboratory_and_Excellent_class);
		button1.setOnTouchListener(myTouchListener);
		button2.setOnTouchListener(myTouchListener);
		button4.setOnTouchListener(myTouchListener);
	}
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_need_know);
        InitWidget();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.student_need_know, menu);
		return true;
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		button1.setBackgroundResource(R.drawable.tips);
		button2.setBackgroundResource(R.drawable.bool);
		button4.setBackgroundResource(R.drawable.exce);
		super.onStop();
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
	
	class MyTouchListener implements OnTouchListener {

		Intent next;
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				switch (v.getId()) {
				case R.id.Tips:
//					v.setBackgroundResource(R.color.black);
					v.setBackgroundResource(R.drawable.stu);
					break;
				case R.id.Eatbool:
//					v.setBackgroundResource(R.color.Cantsee);
					v.setBackgroundResource(R.drawable.bool_eat);
					break;
				case R.id.Laboratory_and_Excellent_class:
//					v.setBackgroundResource(R.color.whitesmoke);
					v.setBackgroundResource(R.drawable.exce_on);
					break;
				default:
					break;
				}

			} 
			else if (event.getAction() == MotionEvent.ACTION_UP) {
				switch (v.getId()) {
				case R.id.Tips:
//					v.setBackgroundResource(R.drawable.tips);
					next = new Intent(StudentNeedKnow.this,
							Robot.class);
					startActivity(next);
					break;
				case R.id.Eatbool:
//					v.setBackgroundResource(R.color.Cantsee);
					next = new Intent(StudentNeedKnow.this,
							Sc_ShortCutNote.class);
//					next.putExtra("LoadWay", 2);
					
					startActivity(next);
					break;
				case R.id.Laboratory_and_Excellent_class:
//					v.setBackgroundResource(R.color.Cantsee);
					next = new Intent(StudentNeedKnow.this,
							Ex_listmap.class);
					//next.putExtra("LoadWay", 3);
					startActivity(next);
					//Toast.makeText(StudentNeedKnow.this, "¾´ÇëÆÚ´ý£¡", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}

			}
			return false;
		}

	}
}
