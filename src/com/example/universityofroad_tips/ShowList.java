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

	private static final int LoadError = 0;// ����ʧ��
	private static final int TIPS = 1;// Tips����
	private static final int STUDENT_BOOK = 2;// ѧ���ֲ�����
	private static final int EXCELLENT = 3;// ʵ�������
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
				// �õ���ǰ���ŵ�Item
				ListItem item = list.get(position);
				String txtName = item.getFileName();
				Intent intent = new Intent();
					intent = new Intent(ShowList.this, ReadText.class);
					intent.putExtra("Name", txtName);
				startActivity(intent);
			}
		});

	}

	// �����ļ���Ҫ���ĵĵط�
	public void InitListItem() {
		Intent intent = getIntent();
		CurrentWay = intent.getIntExtra("LoadWay", 0);
		ListItem item;
		//���item����Ҫ��ReadText��������ĺ��������ļ�����
			item = new ListItem("У԰����������~", R.drawable.monster_icon, "swustcard");
			list.add(item);
			item = new ListItem("��λ��ǵ����", R.drawable.monster_icon, "qingjia");
			list.add(item);
			item = new ListItem("�Ҳ�����Ӿ����", R.drawable.monster_icon, "swimming");
			list.add(item);
			item = new ListItem("������ȡ���и߱Ƹ�Ľ�ѧ��", R.drawable.monster_icon,
					"jiangxuejin");
			list.add(item);
			item = new ListItem("��ô�������ҵ", R.drawable.monster_icon, "biye");
			list.add(item);
			item = new ListItem("����������ô��", R.drawable.monster_icon, "diudongxi");
			list.add(item);
			item = new ListItem("�Բ����֤����", R.drawable.monster_icon, "shenfenzhen");
			list.add(item);
			item = new ListItem("��У����ֵ�����ְ취", R.drawable.monster_icon, "xiaoka_chongzhi");
			list.add(item);
			item = new ListItem("���п����", R.drawable.monster_icon, "yinhangka");
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
