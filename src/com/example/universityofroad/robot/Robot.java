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
	
	//INPUT �������������Ϣ
	//OUTPUT �ͻ��˷�������Ϣ
	/**
	 * չʾ��Ϣ��listview
	 */
	private ListView mChatView;
	private Button button;
	private Button questionButton;
	private boolean exit;
	private String temp;
	//temp,onResume,OnSaveInstanceState,���ڱ��浱ǰactivity״̬,��ֹ���ڴ治���������ڴ����
	
	private DrawerLayout mDrawerLayout;//�󻬲˵�
	private boolean mDrawLayout_state = false;
	//�������ı���
	/**
	 * ��Ϊ���û���������С����
	 */
	private int mSlop = 200;
	/**
	 * ��������û��Ƿ����ڻ����Ļ�������
	 */
	private boolean mSwiping_left = false;
	private boolean mSwiping_right = false;
	/**
	 * ��ָ���µ�position
	 */
	private int mDownPosition;
	private float mDownX;
	private float mDownY;
	
	
	
	/**
	 * �ı���
	 */
	private EditText mMsg;
	/**
	 * �洢������Ϣ
	 */
	private List<ChatMessage> mDatas = new ArrayList<ChatMessage>();
	/**
	 * ������
	 */
	private ChatMessageAdapter mAdapter;

	private Handler mHandler = new Handler()
	{
		public void handleMessage(android.os.Message msg)
		{
			ChatMessage from = (ChatMessage) msg.obj;
			mDatas.add(from);
			//ˢ��listview
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
		
		//��ֹ�ڴ���յ�ǰactivity��δ����
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
        // �л���Ļ����ᵼ��activity�Ĵݻٺ��ؽ�  
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
		mDatas.add(new ChatMessage(Type.INPUT, "�������֣�Hello��\n" +
				"��������ҹ������Ƶ��������⣺" +
				"���룺\n" +
				"1.����������ô��\n" +
				"2.��ʧ�����֤\n" +
				"3.��ѧ��\n" +
				"4.ũ�п�\n" +
				"5.���\n" +
				"6.ʲô��У԰��\n" +
				"7.ʲô��ѧʿѧλ֤��\n" +
				"8.�Ҷ���У԰��\n" +
				"9.����ô�����ܱ�ҵ\n" +
				"10.ͼ��ݼ��㿪��\n" +
				"11.���� ��ݵ���\n" +
				"��ȻҲ������������������Ŷ��������֪��֪���Ͳ���˵��~~~" +
				"��������ԣ�����~\n" +
				"��������Ҳ�������⣬����Խ�����ʹ𰸷��͵�380881937@qq.com," +
				"��������Ա��ˣ���һ�������ҵ�ʱ���Ҿͻ�ش���Ŷ��\n" +
				"Ը�������Ŀ��ģ�"));
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
		
		exit = false;//���ڶԻ����水���ؼ�ʱ,��ʾ���غ����������¼
		
		
		//�ж�EditText��ǰ�Ƿ��ȡ���� �������ȡ ��ô���������
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
		//��ʼ���໬�˵�
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
		//��ʼ���໬�˵�
		mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_menu_left);
		mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
				Gravity.RIGHT);
		

	}
	
	//��ֹ�û�ֱ�ӷ��ض�ʧ������Ϣ
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(!exit){
			Toast toast = Toast.makeText(Robot.this, "ȷ��Ҫ��������صĻ������¼����ʧ��Ŷ��\n" +
					"������ȳ����ı���ѡ�񱣴���Ҫ�����ݣ��ٽ��з���Ŷ��\n" +
					"�ٰ�һ�η��ػ��˳���", Toast.LENGTH_LONG);
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
			Toast.makeText(this, "ʲô����д�ͷ�����ҿƣ��ٺٺٺٺٺٺٺ١���", Toast.LENGTH_SHORT).show();
			return;
		}

		ChatMessage to = new ChatMessage(Type.OUTPUT, msg);
		to.setDate(new Date());
		mDatas.add(to);

		mAdapter.notifyDataSetChanged();
		mChatView.setSelection(mDatas.size() - 1);

		mMsg.setText("");

		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		// �õ�InputMethodManager��ʵ��
		if (imm.isActive())
		{
			// �������
			imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
					InputMethodManager.HIDE_NOT_ALWAYS);
			// �ر�����̣�����������ͬ������������л�������ر�״̬��
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
					from = new ChatMessage(Type.INPUT, "������ɧ��~�����������Ļ������Ե�����Ͻǵİ�ť���߲鿴��~");
				}
				Message message = Message.obtain();
				message.obj = from;
				mHandler.sendMessage(message);
			};
		}.start();

	}
	
	//������ʾ�˵��Ĵ���
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
	 * ������ָ�����ķ���
	 * 
	 * @param ev
	 * @return
	 */
	private boolean handleActionMove(MotionEvent ev) {
		float deltaX = ev.getX() - mDownX;
		float deltaY = ev.getY() - mDownY;
		// ���һ��� X���򻬶��ľ������mSlop����Y���򻬶��ľ���С��mSlop����ʾ���Ի���
		//���󻬶� �ر�fragment
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
	 * ��ָ̧����¼�����
	 * @param ev
	 */
	private void handleActionUp(MotionEvent ev) {
		;
	}

}
