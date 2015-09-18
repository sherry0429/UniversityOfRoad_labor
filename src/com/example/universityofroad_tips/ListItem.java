package com.example.universityofroad_tips;

import android.R.integer;
import android.R.string;

public class ListItem {
	private String name;
	private String FileName;
	private int imageid;
	
	public ListItem(String name, int imageid , String FileName) {
		this.name = name;
		this.imageid = imageid;
		this.FileName = FileName;
	}

	public String getListItem_Name() {
		return name;
	}

	public int getListItem_Imageid() {
		return imageid;
	}
	
	public String getFileName(){
		return FileName;
	}
	
	
}
