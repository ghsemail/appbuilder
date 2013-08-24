package com.appbuilder.content;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.appbuilder_tab.R;


public class ContentActivity0 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common);
		
		TextView text = (TextView) findViewById(R.id.text);
		text.setText(this.getClass().getName());
		text.setBackgroundColor(this.getResources().getColor(R.color.content_bg_0));
	}
}
