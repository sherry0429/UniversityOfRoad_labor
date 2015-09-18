package com.example.universityofroad;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Excellent_adapter extends BaseAdapter{

	private List<Map<String, Object>>dataList;
	private LayoutInflater layoutInflater;
	private Context context;
	
	public Excellent_adapter(Context context,List<Map<String, Object>> data){
		this.context = context;
		this.dataList = data;
		this.layoutInflater = LayoutInflater.from(context);
	}
	
	//一个item包含的内容:
	public final class Item{
		public ImageView image;
		public TextView name;
		public TextView address;
		public TextView linkman;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		return convertView;
	}

}
