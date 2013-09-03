package com.appbuilder.main;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.appbuilder.activity.CallActivity;
import com.appbuilder.tools.xmlParse;

public class TabActivityGroup extends AbstractActivityGroup {
	private static xmlParse ac;
	private List<Map<String, String>> data;
	private static final String CONTENT_0 = "contentActivity0";
	private static final String CONTENT_1 = "contentActivity1";
	private static final String CONTENT_2 = "contentActivity2";
	private static final String CONTENT_3 = "contentActivity3";
	private static final String CONTENT_4 = "contentActivity4";
	private Class content0;
	private Class content1;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		setContentView(R.layout.activity_tab);
		super.onCreate(savedInstanceState);
		ac = new xmlParse(this);
		data = ac.getData();
		
		((RadioButton) findViewById(R.id.tab_radio_button0)).setChecked(true);
				try {
					content0 = Class.forName("com.appbuilder.activity."+data.get(0).get("activity").toString());
					content1 = Class.forName("com.appbuilder.activity."+data.get(1).get("activity").toString());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				setContainerView(CONTENT_0, content0);
	}


	@Override
	protected ViewGroup getContainer() {
		return (ViewGroup) findViewById(R.id.container);
	}


	@Override
	protected void initTabBarButtons() {
		initTabBarButton(R.id.tab_radio_button0);
		initTabBarButton(R.id.tab_radio_button1);
		initTabBarButton(R.id.tab_radio_button2);
		initTabBarButton(R.id.tab_radio_button3);
		initTabBarButton(R.id.tab_radio_more);
	}


	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {

			case R.id.tab_radio_button0:
				setContainerView(CONTENT_0, content0);
			//	setContainerView(CONTENT_0, CallActivity.class);
				break;

			case R.id.tab_radio_button1:
				setContainerView(CONTENT_1, content1);
				break;

			case R.id.tab_radio_button2:
				//setContainerView(CONTENT_2, ContentActivity2.class);
				break;

			case R.id.tab_radio_button3:
				//setContainerView(CONTENT_3, ContentActivity3.class);
				break;

			case R.id.tab_radio_more:
				//setContainerView(CONTENT_4, ContentActivity4.class);
				break;

			default:
				break;
			}
		}
	}

}