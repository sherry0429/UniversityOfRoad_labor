package com.example.universityofroad_shortcut;

import java.util.ArrayList;
import java.util.Map;

import com.example.universityofroad.R;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;


import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class Sc_NotepadAdapter extends BaseAdapter {

	public Context context;
	public Context activity;
	public LayoutInflater inflater;
	public ArrayList<Map<String, Object>> list;

	public Sc_NotepadAdapter(Activity activity, ArrayList<Map<String, Object>> list) {

		this.context = activity;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		// 此处在去掉if语句之后，刷新语句重新生效
		SetShow setShow = new SetShow();
		// 取出map中的展开标记
		Map<String, Object> map = list.get(arg0);
		boolean boo = (Boolean) map.get("EXPANDED");
		if (!boo) {
			arg1 = inflater.inflate(R.layout.showtypes, arg2, false);
			setShow.contentView = (TextView) arg1
					.findViewById(R.id.contentTextView);
			setShow.dateView = (TextView) arg1.findViewById(R.id.dateTextView);
			String str = (String) list.get(arg0).get("titleItem");
			String dateStr = (String) list.get(arg0).get("dateItem");
			setShow.contentView.setText("   " + str);
			setShow.dateView.setText(dateStr);
			
			//编辑按钮和删除按钮
//			setShow.showButtonWrite = (Button) arg1
//					.findViewById(R.id.smallbutton1);
			

//			setShow.showButtonDelete = (Button) arg1
//					.findViewById(R.id.smallbutton2);
//			setShow.showButtonWrite.setOnClickListener(new WriteButtonListener(
//					arg0));
			/*
			setShow.showButtonDelete
					.setOnClickListener(new DeleteButtonListener(arg0));
					*/
		} else {
			arg1 = inflater.inflate(R.layout.style, arg2, false);
			setShow.cContentView = (Sc_TextViewLine) arg1
					.findViewById(R.id.changecontentview);
			setShow.cDateView = (TextView) arg1
					.findViewById(R.id.changedateview);
			String str = (String) list.get(arg0).get("contentItem");
			String dateStr = (String) list.get(arg0).get("dateItem");
			setShow.cContentView.setText("" + str);
			setShow.cDateView.setText(dateStr);
			
			//设置编辑按钮
//			setShow.styleButtonWrite = (Button) arg1
//					.findViewById(R.id.stylebutton1);
//			setShow.styleButtonWrite
//					.setOnClickListener(new WriteButtonListener(arg0));
			
			//设置删除按钮
//			setShow.styleButtonDelete = (Button) arg1
//					.findViewById(R.id.stylebutton2);
//			setShow.styleButtonDelete
//					.setOnClickListener(new DeleteButtonListener(arg0));
		}
		
		return arg1;
	}

//	//编辑按钮监听器
//	class WriteButtonListener implements OnClickListener {
//		private int position;
//
//		public WriteButtonListener(int position) {
//			this.position = position;
//		}
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//
//			Bundle b = new Bundle();
//			b.putString("contentItem",
//					(String) list.get(position).get("contentItem"));
//			b.putString("dateItem", (String) list.get(position).get("dateItem"));
//			b.putString("idItem", (String) list.get(position).get("idItem"));
//			Intent intent = new Intent((Sc_ShortCutNote) context,
//					Sc_EditActivity.class);
//			intent.putExtras(b);
//			((Sc_ShortCutNote) context).startActivity(intent);
//		}
//
//	}

	/*
	class DeleteButtonListener implements OnClickListener {
		private int position;

		public DeleteButtonListener(int position) {
			this.position = position;

		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			// TODO Auto-generated method stub

			android.app.AlertDialog.Builder builder = new Builder(context);
			builder.setTitle("确定删除？");
			builder.setPositiveButton("删除",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int i) {
							// TODO Auto-generated method stub
							Sc_SqliteHelper sql = new Sc_SqliteHelper(context, null,
									null, 0);
							SQLiteDatabase dataBase = sql.getWritableDatabase();
							Sc_ChangeSqlite change = new Sc_ChangeSqlite();
							Sc_Notepad notepad = new Sc_Notepad();
							notepad.setid((String) list.get(position).get(
									"idItem"));
							change.delete(dataBase, notepad);
							// 此处调用activity里的方法需逐渐向上转型
							((Sc_ShortCutNote) context).showUpdate();
							// a.showUpdate();

						}
					});
			builder.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.dismiss();
						}
					});
			builder.create();
			builder.show();
		}

	}
	*/
	
	public void Remove(int position){
		Sc_SqliteHelper sql = new Sc_SqliteHelper(context, null,
				null, 0);
		SQLiteDatabase dataBase = sql.getWritableDatabase();
		Sc_ChangeSqlite change = new Sc_ChangeSqlite();
		Sc_Notepad notepad = new Sc_Notepad();
		notepad.setid((String) list.get(position).get(
				"idItem"));
		change.delete(dataBase, notepad);
		// 此处调用activity里的方法需逐渐向上转型
		((Sc_ShortCutNote) context).showUpdate();
		// a.showUpdate();
	}

	class SetShow {
		public TextView contentView;
		public TextView dateView;
		public Sc_TextViewLine cContentView;
		public TextView cDateView;
		
		//以下为编辑按钮和删除按钮 已废弃
//		public Button styleButtonWrite;
//		public Button styleButtonDelete;
//		public Button showButtonWrite;
//		public Button showButtonDelete;
	}
	
	

}
