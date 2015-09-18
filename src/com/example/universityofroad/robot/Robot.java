package com.example.universityofroad.robot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.universityofroad.R;
import com.example.universityofroad.robot.ChatMessage;
import com.example.universityofroad.robot.ChatMessage.Type;
import com.example.universityofroad.robot.HttpUtils;
import com.example.universityofroad_tips.ShowList;

public class Robot extends Activity
{
	
	//INPUT �������������Ϣ
	//OUTPUT �ͻ��˷�������Ϣ
	/**
	 * չʾ��Ϣ��listview
	 */
	private ListView mChatView;
	private Button button;
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

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_chatting);
		
		initView();
		
		mAdapter = new ChatMessageAdapter(this, mDatas);
		mChatView.setAdapter(mAdapter);

	}

	private void initView()
	{
		mChatView = (ListView) findViewById(R.id.id_chat_listView);
		mMsg = (EditText) findViewById(R.id.id_chat_msg);
		mDatas.add(new ChatMessage(Type.INPUT, "�������֣�Hello��\n" +
				"��������ҹ������Ƶ��������⣺" +
				"���룺\n" +
				"1.����������ô��\n" +
				"2.��ʧ������֤\n" +
				"3.��ѧ��\n" +
				"4.ũ�п�\n" +
				"5.���\n" +
				"6.ʲô��У԰��\n" +
				"7.ʲô��ѧʿѧλ֤��\n" +
				"8.�Ҷ���У԰��\n" +
				"9.����ô�����ܱ�ҵ\n" +
				"10.���ϿƼ���ѧ����\n" +
				"��ȻҲ������������������Ŷ��������֪��֪���Ͳ���˵��~~~" +
				"��������ԣ�����~\n" +
				"��������Ҳ�������⣬����Խ�����ʹ𰸷��͵�380881937@qq.com," +
				"��������Ա��ˣ���һ�������ҵ�ʱ���Ҿͻ�ش���Ŷ��\n" +
				"Ը�������Ŀ��ģ�"));
		button = (Button)findViewById(R.id.go_uninternet);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Robot.this,ShowList.class);
				startActivity(intent);
			}
		});
		
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

		// �ر�������
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		// �õ�InputMethodManager��ʵ��
		if (imm.isActive())
		{
			// �������
			imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
					InputMethodManager.HIDE_NOT_ALWAYS);
			// �ر������̣�����������ͬ������������л�������ر�״̬��
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

}