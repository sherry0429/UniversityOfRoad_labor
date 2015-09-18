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
		// TODO 自动生成的方法存根
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
		
		//监听键盘事件 防止按两次“叉”会退出activity的情况
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
	    
		
		//保存按钮
		this.sureButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				SQLiteDatabase localSqLiteDatabase = new Sc_SqliteHelper(
						Sc_EditActivity.this.context, null, null, 0)
						.getWritableDatabase();
				Sc_Notepad localNotepad = new Sc_Notepad();
				Sc_ChangeSqlite localChangeSqlite = new Sc_ChangeSqlite();
				String strContent = Sc_EditActivity.this.editText.getText()
						.toString();
				if (strContent.equals("")) {
					Toast.makeText(Sc_EditActivity.this.context, "内容为空",
							Toast.LENGTH_SHORT).show();
					return;
				}
				
				//得到隐藏文本框时最多显示的字 即标题
				String strTitle = strContent.length() > 8 ? " "
						+ strContent.substring(0, 8) : strContent;
						
				//设置文本框字符串
				localNotepad.setContent(strContent);
				//设置文本框标题
				localNotepad.setTitle(strTitle);
				//设置文本框时间
				localNotepad.setdata(date);
				//设置文本框id
				localNotepad.setid(id);
				System.out.println("-----id-----id=" + id);
				//将数据输入数据库
				localChangeSqlite.update(localSqLiteDatabase, localNotepad);
				finish();
			}
		});
		//取消按钮
		this.cancelButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
	}
	

}
