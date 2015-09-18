package com.example.universityofroad_shortcut;


import com.example.universityofroad.R;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.*;

public class Sc_WriteActivity extends Sc_BaseActivity {
	  private Button cancelButton;
	  private Context context = this;
	  private String date;
	  private EditText editText;
	  private Sc_Date getDate;
	  private Button sureButton;
	  private TextView textView;

	  protected void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	    setContentView(R.layout.writedown);
	    this.textView = ((TextView)findViewById(R.id.writedate));
	    this.editText = ((Sc_DrawLine)findViewById(R.id.edittext));
	    this.cancelButton = ((Button)findViewById(R.id.button));
	    this.sureButton = ((Button)findViewById(R.id.button2));
	    this.getDate = new Sc_Date();
	    this.date = this.getDate.getDate();
	    this.textView.setText(this.date);
	    
	  //���������¼� ��ֹ�����Ρ��桱���˳�activity����� ������������д
		editText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (keyCode == KeyEvent.KEYCODE_DEL) {
					if (keyCode == KeyEvent.KEYCODE_DEL) {
						;
					}
				}
				return false;
			}
		});
	    
	    
	    
	    //���水ť
	    this.sureButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				SQLiteDatabase localSqLiteDatabase = new Sc_SqliteHelper(Sc_WriteActivity.this.context, null, null, 0).getWritableDatabase();
				Sc_Notepad localNotepad = new Sc_Notepad();
				Sc_ChangeSqlite localChangeSqlite = new Sc_ChangeSqlite();
				String strContent = Sc_WriteActivity.this.editText.getText().toString();
				if (strContent.equals("")) {
					Toast.makeText(Sc_WriteActivity.this.context, "����Ϊ��", Toast.LENGTH_SHORT).show();
					return;
				}
				//�õ������ı���ʱ�����ʾ���� ������
				String strTitle=strContent.length()>8?" "+strContent.substring(0, 8):strContent;
				//�����ı����ڵ���
				localNotepad.setContent(strContent);
				//�����ı������
				localNotepad.setTitle(strTitle);
				//�����ı�������
				localNotepad.setdata(date);
				//�����ݲ������ݿ�
				localChangeSqlite.add(localSqLiteDatabase, localNotepad);
				finish();
			}
		});
	    
	    //ȡ����ť
	    this.cancelButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
	  }
	  
}


























