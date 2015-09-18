package com.example.universityofroad_execellent;

import java.util.List;
import java.util.Map;

import com.example.universityofroad.R;
import com.example.universityofroad.R.layout;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Ex_adapter extends BaseAdapter {

	private Context context;
	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private RelativeLayout relativeLayout;
	private LinearLayout linearLayout;
	//this list's every item is a Map<string,object>.
	public Ex_adapter(Context context, List<Map<String, Object>> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {

		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		Log.i("position","position:" + position);
		if (convertView == null) {
			inflater = LayoutInflater.from(parent.getContext());
			convertView = inflater.inflate(R.layout.listview_item_singleline, null);
			
			viewHolder = new ViewHolder();
			viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
			viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
			viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
			viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
			viewHolder.Class_image = (ImageView)convertView.findViewById(R.id.classimage);
			convertView.setTag(viewHolder);
		}
		
		else{
			
			
			//单边listview
			convertView = inflater.inflate(R.layout.listview_item_singleline, null);
			viewHolder = new ViewHolder();
			viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
			viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
			viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
			viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
			viewHolder.Class_image = (ImageView)convertView.findViewById(R.id.classimage);
			convertView.setTag(viewHolder);
		}
		
		/*
		//start 设置左右listview时间轴部分
		if(position == 0){
			convertView = inflater.inflate(R.layout.listview_item_left, null);
			viewHolder = new ViewHolder();
			viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
			viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
			viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
			viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
			convertView.setTag(viewHolder);
		}
		if(position == 1){
			convertView = inflater.inflate(R.layout.listview_item_right, null);
			viewHolder = new ViewHolder();
			viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
			viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
			viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
			viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
			convertView.setTag(viewHolder);
		}else if(position==2){
			convertView = inflater.inflate(R.layout.listview_item_left, null);
			viewHolder = new ViewHolder();
			viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
			viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
			viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
			viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
			convertView.setTag(viewHolder);
		}else if(position>2){
			if(position%2 == 0){
				convertView = inflater.inflate(R.layout.listview_item_left, null);
				viewHolder = new ViewHolder();
				viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
				viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
				viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
				viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
				convertView.setTag(viewHolder);
			}else{
				convertView = inflater.inflate(R.layout.listview_item_right, null);
				viewHolder = new ViewHolder();
				viewHolder.Address = (TextView) convertView.findViewById(R.id.Address);
				viewHolder.Name  = (TextView)convertView.findViewById(R.id.Name);
				viewHolder.Documetion = (TextView)convertView.findViewById(R.id.Documetion);
				viewHolder.class_way = (TextView)convertView.findViewById(R.id.class_way);
				convertView.setTag(viewHolder);
			}
		}
		*/
		//end


		
		
		viewHolder = (ViewHolder) convertView.getTag();	
		linearLayout = (LinearLayout)convertView.findViewById(R.id.linearall);
		relativeLayout = (RelativeLayout)convertView.findViewById(R.id.relative);

		//获取数据
		String Address = list.get(position).get("Address").toString();
		String Name = list.get(position).get("Name").toString();
		String Documetion = list.get(position).get("Documetion").toString();
		String class_way = list.get(position).get("class_way").toString();
		String id = list.get(position).get("Class_image").toString();
		int intid = Integer.parseInt(id);
		//得到数据
		viewHolder.Address.setText(Address);
		viewHolder.Name.setText(Name);
		viewHolder.Documetion.setText(Documetion);
		viewHolder.class_way.setText(class_way);
		Log.i("id", "intid" + intid);
		viewHolder.Class_image.setImageResource(intid);
		
		
//监听器检测		
//		relativeLayout.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Toast.makeText(v.getContext(), "AAA", Toast.LENGTH_SHORT).show();
//			}
//		});


		return convertView;
	}
	
	
	

	static class ViewHolder {
		public TextView Name;
		public TextView Documetion;
		public TextView Address;
		public TextView class_way;
		
		public ImageView Class_image;//标题图片
		public ImageView Class_human;//实验室成员图片
	}
}
