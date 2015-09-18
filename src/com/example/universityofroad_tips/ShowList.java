package com.example.universityofroad_tips;

import java.util.ArrayList;
import java.util.List;

import com.example.universityofroad.R;
import com.example.universityofroad.R.drawable;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;
import com.example.universityofroad.R.menu;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.StatusUpdates;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ShowList extends Activity {

	private static final int LoadError = 0;// 载入失败
	private static final int TIPS = 1;// Tips数据
	private static final int STUDENT_BOOK = 2;// 学生手册数据
	private static final int EXCELLENT = 3;// 实验班数据
	private int CurrentWay;
	private MyselfListItemAdapter adapter;
	private List<ListItem> list = new ArrayList<ListItem>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_list);
		InitListItem();
		adapter = new MyselfListItemAdapter(ShowList.this,
				R.layout.listitem_layout, list);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				// 得到当前按着的Item
				ListItem item = list.get(position);
				String txtName = item.getFileName();
				Intent intent = new Intent();
					intent = new Intent(ShowList.this, ReadText.class);
					intent.putExtra("Name", txtName);
				startActivity(intent);
			}
		});

	}

	// 加入文件需要更改的地方
	public void InitListItem() {
		Intent intent = getIntent();
		CurrentWay = intent.getIntExtra("LoadWay", 0);
		ListItem item;
		//添加item后还需要在ReadText的最下面的函数进行文件关联
			item = new ListItem("校园卡，看过来~", R.drawable.monster_icon, "swustcard");
			list.add(item);
			item = new ListItem("如何机智的请假", R.drawable.monster_icon, "qingjia");
			list.add(item);
			item = new ListItem("我不想游泳啊！", R.drawable.monster_icon, "swimming");
			list.add(item);
			item = new ListItem("怎样获取具有高逼格的奖学金", R.drawable.monster_icon,
					"jiangxuejin");
			list.add(item);
			item = new ListItem("怎么样才算毕业", R.drawable.monster_icon, "biye");
			list.add(item);
			item = new ListItem("丢东西了怎么办", R.drawable.monster_icon, "diudongxi");
			list.add(item);
			item = new ListItem("卧槽身份证掉了", R.drawable.monster_icon, "shenfenzhen");
			list.add(item);
			item = new ListItem("给校卡充值的三种办法", R.drawable.monster_icon, "xiaoka_chongzhi");
			list.add(item);
			item = new ListItem("银行卡相关", R.drawable.monster_icon, "yinhangka");
			list.add(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_list, menu);
		return true;
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
}
