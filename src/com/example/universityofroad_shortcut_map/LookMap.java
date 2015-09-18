package com.example.universityofroad_shortcut_map;

import java.io.InputStream;

import com.example.universityofroad.R;
import com.example.universityofroad.R.drawable;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;
import com.example.universityofroad.R.menu;
import com.example.universityofroad_shortcut_map.MatrixImageView.MatrixTouchListener;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LookMap extends Activity {

	private MatrixImageView img;
	private Bitmap bitmap;
	private MatrixTouchListener listener;
	private RelativeLayout mainLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_look_map);
		mainLayout = (RelativeLayout)findViewById(R.id.RelativeLayout1);
		RelativeLayout.LayoutParams item = new RelativeLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
				android.widget.LinearLayout.LayoutParams.MATCH_PARENT);
//		item.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE); 
		item.addRule(RelativeLayout.ALIGN_BASELINE, RelativeLayout.TRUE);
		img = new MatrixImageView(LookMap.this);
		img.setId(110);
		img.setImageResource(R.drawable.swust_map);
		img.setScaleType(ScaleType.CENTER_CROP);
		bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
		img.setImageBitmap(bitmap);
		mainLayout.addView(img, item);
		
		Toast.makeText(LookMap.this, "这个界面太挫了，我们会更新的哈！", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.look_map, menu);
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
