package com.example.universityofroad_tips;

import android.util.Log;
import android.widget.TextView;

public class ZoomTextView extends ZoomView<TextView>
{
	/**��С����*/
	public static final float MIN_TEXT_SIZE = 20.0f;
	
	/**�����ͼ*/
	public static final float MAX_TEXT_SIZE = 50.0f;

	/** ���ű��� */
	float scale;

	/** ���������С */
	float textSize;

	public ZoomTextView(TextView view, float scale)
	{

		super(view);
		this.scale = scale;
		
		textSize = view.getTextSize();
		textSize = textSize/2;
		Log.i("TEXT", "size:" + textSize);
	}

	/**
	 * �Ŵ�
	 */
	protected void zoomOut()
	{
		textSize += scale;
		if (textSize > MAX_TEXT_SIZE)
		{
			textSize = MAX_TEXT_SIZE;
		}
		view.setTextSize(textSize);
	}

	/**
	 * ��С
	 */
	protected void zoomIn()
	{
		textSize -= scale;
		if (textSize < MIN_TEXT_SIZE)
		{
			textSize = MIN_TEXT_SIZE;
		}
		view.setTextSize(textSize);
	}

}
