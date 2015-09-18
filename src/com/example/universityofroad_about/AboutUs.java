package com.example.universityofroad_about;

import com.example.universityofroad.R;
import com.example.universityofroad.R.id;
import com.example.universityofroad.R.layout;
import com.example.universityofroad.R.menu;
import com.example.universityofroad_tips.ZoomTextView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class AboutUs extends Activity {

	private String str = new String();
	private float zoomScale=0.5f;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
		textView = (TextView)findViewById(R.id.about_text);
		init();
		textView.setText(str);
		new ZoomTextView(textView, zoomScale);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_us, menu);
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
	
	public void init()
	{
		str = "计科院的学弟学妹们好哇！\n" +
				"这是大学之路正式版第二弹！\n" +
				"大家可以看到功能翻新了哦！\n" +
				"笔记本界面加入了滑动删除，长按编辑的功能！\n" +
				"新生Tips界面加入了一个小机器人哦！当然如果不联网的话可以点击右上角查看以前的离线列表！\n" +
				"卓越班界面我们翻新重做了，但是现在没有充足的信息，希望大家能踊跃提供哦！\n" +
				"希望大家多多支持！\n" +
				"如果使用中出现BUG，可以发邮件到380881937@qq.com噢！\n" +
				"目前地图功能以及“大学之路”这两个功能我们会在下个版本进行更新！\n" +
				"关于大学之路：它就是让你能够自己DIY一条大学的学习路线哦！\n" +
				"因为我们的美工太挫了（雾~）所以我们把界面都统一了，如果小伙伴们有更好的界面欢迎发邮件哦！我们审核后决定使用会著名作者的！\n" +
				"目前大家可以用它来随手记下大学生活里的事，\n" +
				"调教妖怪play，查看卓越班和实验室以及各个团队的信息（希望大家踊跃提供信息哈~）！\n\n" +
				"项目组成员：\n\n" +
				"我就是妖怪\n\n" +
				"Bunny\n\n" +
				"繁华落尽^曲终人散\n\n" +
				"fantasy\n\n" +
				"哦嚯嚯~\n\n" +
				"Thank you for every thing   o(*￣▽￣*)ブ ";
	}
}
