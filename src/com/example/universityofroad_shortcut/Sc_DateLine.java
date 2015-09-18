package com.example.universityofroad_shortcut;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class Sc_DateLine extends TextView {

	private Paint ePaint = new Paint();

	public Sc_DateLine(Context context) {
		super(context);
		// TODO 自动生成的构造函数存根
	}

	public Sc_DateLine(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO 自动生成的构造函数存根
		this.ePaint.setColor(-16777216);
		this.ePaint.setStyle(Paint.Style.STROKE);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO 自动生成的方法存根
		canvas.drawLine(0.0F, 40.0F, getWidth(), 40.0F, this.ePaint);
		super.onDraw(canvas);
	}

}
