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
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import android.widget.TextView.OnEditorActionListener;

public class Sc_EditActivity extends Sc_BaseActivity {
	private Button cancelButton;
	private String content;
	private Context context = this;
	private String date;
	private Sc_Date dateNow;
	private EditText editText;
	private String id;
	private Button sureButton;
	private TextView textView;

	@Override
	protected void onCreate(Bundle paramBundle) {
		// TODO �Զ����ɵķ������
		super.onCreate(paramBundle);
		setContentView(R.layout.showedit);
		this.textView = ((TextView) findViewById(R.id.editdate));
		this.editText = ((Sc_DrawLine) findViewById(R.id.edittexttwo));
		this.cancelButton = ((Button) findViewById(R.id.editbutton));
		this.sureButton = ((Button) findViewById(R.id.editbutton2));
		this.date = getIntent().getStringExtra("dateItem");
		this.content = getIntent().getStringExtra("contentItem");
		this.id = getIntent().getStringExtra("idItem");

		System.out.println("-----idItem-----id=" + id);
		this.editText.setSelection(this.editText.length());
		this.editText.setText(this.content);
		this.textView.setText(this.date);
		this.dateNow = new Sc_Date();
		this.date = this.dateNow.getDate();
		this.textView.setText(this.date);
		
		//���������¼� ��ֹ�����Ρ��桱���˳�activity�����
	    editText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if (keyCode == KeyEvent.KEYCODE_DEL) {
					if (editText.getText().equals("")) {
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
				SQLiteDatabase localSqLiteDatabase = new Sc_SqliteHelper(
						Sc_EditActivity.this.context, null, null, 0)
						.getWritableDatabase();
				Sc_Notepad localNotepad = new Sc_Notepad();
				Sc_ChangeSqlite localChangeSqlite = new Sc_ChangeSqlite();
				String strContent = Sc_EditActivity.this.editText.getText()
						.toString();
				if (strContent.equals("")) {
					Toast.makeText(Sc_EditActivity.this.context, "����Ϊ��",
							Toast.LENGTH_SHORT).show();
					return;
				}
				
				//�õ������ı���ʱ�����ʾ���� ������
				String strTitle = strContent.length() > 8 ? " "
						+ strContent.substring(0, 8) : strContent;
						
				//�����ı����ַ���
				localNotepad.setContent(strContent);
				//�����ı������
				localNotepad.setTitle(strTitle);
				//�����ı���ʱ��
				localNotepad.setdata(date);
				//�����ı���id
				localNotepad.setid(id);
				System.out.println("-----id-----id=" + id);
				//�������������ݿ�
				localChangeSqlite.update(localSqLiteDatabase, localNotepad);
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
