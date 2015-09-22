package com.example.universityofroad.robot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.universityofroad.R;
import com.example.universityofroad.robot.ChatMessage;
import com.example.universityofroad.robot.ChatMessage.Type;
import com.example.universityofroad.robot.HttpUtils;
import com.example.universityofroad_tips.ShowList;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class Robot extends FragmentActivity
{
	
	//INPUT 服务器传入的信息
	//OUTPUT 客户端发出的信息
	/**
	 * 展示消息的listview
	 */
	private ListView mChatView;
	private Button button;
	private Button questionButton;
	private boolean exit;
	private String temp;
	//temp,onResume,OnSaveInstanceState,用于保存当前activity状态,防止因内存不足而引起的内存回收
	
	private DrawerLayout mDrawerLayout;//左滑菜单
	private boolean mDrawLayout_state = false;
	//处理滑动的变量
	/**
	 * 认为是用户滑动的最小距离
	 */
	private int mSlop = 200;
	/**
	 * 用来标记用户是否正在滑动的滑动方向
	 */
	private boolean mSwiping_left = false;
	private boolean mSwiping_right = false;
	/**
	 * 手指按下的position
	 */
	private int mDownPosition;
	private float mDownX;
	private float mDownY;
	
	
	
	/**
	 * 文本域
	 */
	private EditText mMsg;
	/**
	 * 存储聊天消息
	 */
	private List<ChatMessage> mDatas = new ArrayList<ChatMessage>();
	/**
	 * 适配器
	 */
	private ChatMessageAdapter mAdapter;

	private Handler mHandler = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			ChatMessage from = (ChatMessage) msg.obj;
			mDatas.add(from);
			//刷新listview
			mAdapter.notifyDataSetChanged();
			mChatView.setSelection(mDatas.size() - 1);
		};
	};

	//Create
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		super.onCreate(savedInstanceState);
		try{
		setContentView(R.layout.main_chatting);
		
		initView();
		
		mAdapter = new ChatMessageAdapter(this, mDatas);
		mChatView.setAdapter(mAdapter);
		
		//防止内存回收当前activity并未保存
        if (savedInstanceState != null) {  
            temp = savedInstanceState.getString("temp");  
            System.out.println("onCreate: temp = " + temp);  
        }  
		}catch(Exception e){
			e.printStackTrace();
			Log.i("LoadError:", "error:" + e.toString());
		}
	}
	//Menu
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
        temp = "xing";  
        System.out.println("onResume: temp = " + temp);  
        // 切换屏幕方向会导致activity的摧毁和重建  
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {  
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);  
        }  
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	// TODO Auto-generated method stub
    	super.onSaveInstanceState(outState);
    	outState.putString("temp", temp);
    }
	

	private void initView()
	{
		mChatView = (ListView) findViewById(R.id.id_chat_listView);
		mMsg = (EditText) findViewById(R.id.id_chat_msg);
		mDatas.add(new ChatMessage(Type.INPUT, "我是妖怪，Hello！\n" +
				"你可以问我关于西科的以下问题：" +
				"输入：\n" +
				"1.丢东西了怎么办\n" +
				"2.丢失了身份证\n" +
				"3.奖学金\n" +
				"4.农行卡\n" +
				"5.请假\n" +
				"6.什么是校园卡\n" +
				"7.什么是学士学位证书\n" +
				"8.我丢了校园卡\n" +
				"9.我怎么样才能毕业\n" +
				"10.图书馆几点开门\n" +
				"11.查快递 快递单号\n" +
				"当然也可以问我其他的问题哦！不过我知不知道就不好说辣~~~" +
				"你可以试试，哈哈~\n" +
				"如果遇到我不会的问题，你可以将问题和答案发送到380881937@qq.com," +
				"经过管理员审核，下一次再问我的时候，我就会回答了哦！\n" +
				"愿你今天过的开心！"));
		button = (Button)findViewById(R.id.go_uninternet);
		questionButton = (Button)findViewById(R.id.show_question);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Robot.this,ShowList.class);
				startActivity(intent);
			}
		});
		questionButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!mDrawLayout_state){
				mDrawerLayout.openDrawer(Gravity.LEFT);
				mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
						Gravity.RIGHT);
				mDrawLayout_state = true;	
				}else{
					mDrawerLayout.closeDrawer(Gravity.LEFT);
					mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
							Gravity.RIGHT);
					mDrawLayout_state = false;
				}
			}
		});
		
		exit = false;//当在对话界面按返回键时,提示返回后会清除聊天记录
		
		
		//判断EditText当前是否获取焦点 如果不获取 那么隐藏软键盘
		OnFocusChangeListener mFocusChangedListener;
		mFocusChangedListener = new OnFocusChangeListener() {
		    @Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus) {
					;
				} else {
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				}
			}
		};
		EditText variableValueView = (EditText) findViewById(R.id.id_chat_msg);
		variableValueView.setOnFocusChangeListener(mFocusChangedListener);
		//初始化侧滑菜单
		initmenu();
		initmenu_event();
	}
	
	private void initmenu_event(){
		mDrawerLayout.setDrawerListener(new DrawerListener() {
			
			@Override
			public void onDrawerStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// TODO Auto-generated method stub
				if (drawerView.getTag().equals("LEFT")) {
					View mContent = mDrawerLayout.getChildAt(0);
					View mMenu = drawerView;
					float scale = 1 - slideOffset;
					float rightScale = 0.8f + scale * 0.2f;

					float leftScale = 1 - 0.3f * scale;

					ViewHelper.setScaleX(mMenu, leftScale);
					ViewHelper.setScaleY(mMenu, leftScale);
					ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
					ViewHelper.setTranslationX(mContent,
							mMenu.getMeasuredWidth() * (1 - scale));
					ViewHelper.setPivotX(mContent, 0);
					ViewHelper.setPivotY(mContent,
							mContent.getMeasuredHeight() / 2);
					mContent.invalidate();
					ViewHelper.setScaleX(mContent, rightScale);
					ViewHelper.setScaleY(mContent, rightScale);
				}
			}

			@Override
			public void onDrawerOpened(View arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onDrawerClosed(View arg0) {
				// TODO Auto-generated method stub
				mDrawerLayout.setDrawerLockMode(
						DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
			}
		});
	}
	
	private void initmenu(){
		//初始化侧滑菜单
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_menu_left);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
				Gravity.RIGHT);
		

	}
	
	//防止用户直接返回丢失聊天信息
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(!exit){
			Toast toast = Toast.makeText(Robot.this, "确定要返回嘛？返回的话聊天记录会消失的哦！\n" +
					"你可以先长按文本来选择保存需要的内容，再进行返回哦！\n" +
					"再按一次返回会退出！", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			
			exit=true;
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void sendMessage(View view)
	{
		final String msg = mMsg.getText().toString();
		if (TextUtils.isEmpty(msg))
		{
			Toast.makeText(this, "什么都不写就发，会挂科，嘿嘿嘿嘿嘿嘿嘿嘿……", Toast.LENGTH_SHORT).show();
			return;
		}

		ChatMessage to = new ChatMessage(Type.OUTPUT, msg);
		to.setDate(new Date());
		mDatas.add(to);

		mAdapter.notifyDataSetChanged();
		mChatView.setSelection(mDatas.size() - 1);

		mMsg.setText("");

		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		// 得到InputMethodManager的实例
		if (imm.isActive())
		{
			// 如果开启
			imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
					InputMethodManager.HIDE_NOT_ALWAYS);
			// 关闭软键盘，开启方法相同，这个方法是切换开启与关闭状态的
		}

		new Thread()
		{
			public void run()
			{
				ChatMessage from = null;
				try
				{
					from = HttpUtils.sendMsg(msg);
				} catch (Exception e)
				{
					from = new ChatMessage(Type.INPUT, "联网啊骚年~不方便联网的话，可以点击右上角的按钮离线查看哈~");
				}
				Message message = Message.obtain();
				message.obj = from;
				mHandler.sendMessage(message);
			};
		}.start();

	}
	
	//滑动显示菜单的处理
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:
			handleActionDown(ev);
			break;
		case MotionEvent.ACTION_MOVE:
			handleActionMove(ev);
			break;
		case MotionEvent.ACTION_UP:
			handleActionUp(ev);
			break;
		}
		return super.dispatchTouchEvent(ev);
	}
	
	private void handleActionDown(MotionEvent ev) {
		mDownX = ev.getX();
		mDownY = ev.getY();
	}
	

	/**
	 * 处理手指滑动的方法
	 * 
	 * @param ev
	 * @return
	 */
	private boolean handleActionMove(MotionEvent ev) {
		float deltaX = ev.getX() - mDownX;
		float deltaY = ev.getY() - mDownY;
		// 向右滑动 X方向滑动的距离大于mSlop并且Y方向滑动的距离小于mSlop，表示可以滑动
		//向左滑动 关闭fragment
		if (deltaX > 0 && Math.abs(deltaX) > mSlop && Math.abs(deltaY) < mSlop/2) {
			mSwiping_left=false;
			mDrawerLayout.openDrawer(Gravity.LEFT);
			mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
					Gravity.RIGHT);
		}else if(deltaX < 0 && Math.abs(deltaX) > mSlop && Math.abs(deltaY) < mSlop/2){
			mSwiping_left=true;
		}
		
		if (mSwiping_right) {

		}else if(mSwiping_left){
			mSwiping_right=false;
		}

		return super.onTouchEvent(ev);

	}

	/**
	 * 手指抬起的事件处理
	 * @param ev
	 */
	private void handleActionUp(MotionEvent ev) {
		;
	}

}
