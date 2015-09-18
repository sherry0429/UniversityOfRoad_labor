package com.example.universityofroad_tips;

import java.util.List;

import com.example.universityofroad.R;
import com.example.universityofroad.R.id;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyselfListItemAdapter extends ArrayAdapter<ListItem> {

	private int resourceId;

	public MyselfListItemAdapter(Context context, int resource,
			List<ListItem> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		resourceId = resource;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ListItem item =getItem(position);
		ViewHolder viewHolder;
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.Image=(ImageView)view.findViewById(R.id.imageView1);
			viewHolder.Name=(TextView)view.findViewById(R.id.textView1);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.Image.setImageResource(item.getListItem_Imageid());
		viewHolder.Name.setText(item.getListItem_Name());
		return view;
	}
	
	
	class ViewHolder { 
		ImageView Image; 
		TextView Name; 
		}

}
