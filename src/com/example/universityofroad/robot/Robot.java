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
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
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

public class Robot extends Activity
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
		setContentView(R.layout.main_chatting);
		
		initView();
		
		mAdapter = new ChatMessageAdapter(this, mDatas);
		mChatView.setAdapter(mAdapter);
        if (savedInstanceState != null) {  
            temp = savedInstanceState.getString("temp");  
            System.out.println("onCreate: temp = " + temp);  
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
				"10.西南科技大学在哪\n" +
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
				openOptionsMenu();
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
		
	}
	

	
	//防止用户直接返回丢失聊天信息
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(!exit){
			Toast.makeText(Robot.this, "确定要返回嘛？返回的话聊天记录会消失的哦！\n" +
					"你可以先长按选择文本来保存内容，再进行返回哦！\n" +
					"再按一次返回会退出！", Toast.LENGTH_SHORT).show();
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
	
	

}
