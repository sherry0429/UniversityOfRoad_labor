package com.example.universityofroad_shortcut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.example.universityofroad_shortcut.SwipeDismissListView.OnDismissCallback;
import com.example.universityofroad.R;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;
import com.example.universityofroad.R.menu;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Sc_ShortCutNote extends Activity {

	public String EXPANDED = "EXPANDED";
	public Sc_NotepadAdapter adapter;
	public ArrayList<Map<String, Object>> itemList;
	public SwipeDismissListView listView;
	public int number;
	public Button numberButton;
	public Button topButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shortcut_note);

		this.numberButton = ((Button) findViewById(R.id.number));
		this.topButton = ((Button) findViewById(R.id.topButton));
		this.listView = ((SwipeDismissListView) findViewById(R.id.listview));
		// this.listView.setDivider(getResources().getDrawable(android.R.color.white));
		this.listView.setDivider(null);
		this.listView.setOnItemClickListener(new ItemClick());
		this.listView.setOnItemLongClickListener(new ItemLongClick());
		this.topButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(Sc_ShortCutNote.this,
						Sc_WriteActivity.class);
				startActivity(intent);

			}
		});
		
		listView.setOnDismissCallback(new com.example.universityofroad_shortcut.SwipeDismissListView.OnDismissCallback() {
			
			@Override
			public void onDismiss(int dismissPosition) {
				// TODO Auto-generated method stub
				adapter.Remove(dismissPosition);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		showUpdate();
	}

	public void showUpdate() {
		// TODO 自动生成的方法存根
		this.itemList = new ArrayList<Map<String, Object>>();
		SQLiteDatabase localSqLiteDatabase = new Sc_SqliteHelper(this, null, null,
				0).getReadableDatabase();
		Iterator<Sc_Notepad> localIterator = new Sc_ChangeSqlite().query(
				localSqLiteDatabase).iterator();
		while (true) {
			if (!localIterator.hasNext()) {
				Collections.reverse(this.itemList);
				this.adapter = new Sc_NotepadAdapter(this, this.itemList);
				this.listView.setAdapter(this.adapter);
				if (this.itemList.size()==0) {
					number=0;
					this.numberButton.setText("");
				}
				return;
			}
			Sc_Notepad localNotepad = (Sc_Notepad) localIterator.next();
			HashMap<String, Object> localHashMap = new HashMap<String, Object>();
			localHashMap.put("titleItem", localNotepad.getTitle());
			localHashMap.put("dateItem", localNotepad.getdata());
			localHashMap.put("contentItem", localNotepad.getContent());
			localHashMap.put("idItem", localNotepad.getid());
			// 默认笔记是摊开还是折叠，true为摊开
			localHashMap.put("EXPANDED", Boolean.valueOf(true));
			this.itemList.add(localHashMap);
			this.number = this.itemList.size();
			System.out.println("number----------number=" + number);
			this.numberButton.setText("(" + this.number + ")");
		}

	}

	class ItemClick implements AdapterView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> paramAdapterView,
				View paramView, int paramInt, long paramLong) {
			// TODO 自动生成的方法存根
			System.out.println("item----------click");
			Map<String, Object> localMap = Sc_ShortCutNote.this.itemList
					.get(paramInt);
			if (((Boolean) localMap.get("EXPANDED")).booleanValue()) {
				localMap.put("EXPANDED", Boolean.valueOf(false));
			} else {
				localMap.put("EXPANDED", Boolean.valueOf(true));
			}
			//刷新listview
			Sc_ShortCutNote.this.adapter.notifyDataSetChanged();
		}

	}
	
	class ItemLongClick implements AdapterView.OnItemLongClickListener{
		private int position;
		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int paramint, long arg3) {
			// TODO Auto-generated method stub
			position = paramint;
			Bundle b = new Bundle();
			b.putString("contentItem",
					(String) Sc_ShortCutNote.this.itemList.get(position).get("contentItem"));
			b.putString("dateItem", (String) Sc_ShortCutNote.this.itemList.get(position).get("dateItem"));
			b.putString("idItem", (String) Sc_ShortCutNote.this.itemList.get(position).get("idItem"));
			Intent intent = new Intent(Sc_ShortCutNote.this,
					Sc_EditActivity.class);
			intent.putExtras(b);
			startActivity(intent);
			return false;
		}
		
	}


}
