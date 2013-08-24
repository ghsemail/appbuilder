package com.appbuilder.tab;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.appbuilder.content.ContentActivity0;
import com.appbuilder.content.ContentActivity1;
import com.appbuilder.content.ContentActivity2;
import com.appbuilder.content.ContentActivity3;
import com.appbuilder.content.ContentActivity4;
import com.example.appbuilder_tab.R;

public class TabActivityGroup extends AbstractActivityGroup {
	// 加载的Activity的名字，LocalActivityManager就是通过这些名字来查找对应的Activity的。
	private static final String CONTENT_0 = "contentActivity0";
	private static final String CONTENT_1 = "contentActivity1";
	private static final String CONTENT_2 = "contentActivity2";
	private static final String CONTENT_3 = "contentActivity3";
	private static final String CONTENT_4 = "contentActivity4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_tab);
		super.onCreate(savedInstanceState);

		((RadioButton) findViewById(R.id.tab_radio_button0)).setChecked(true);
		setContainerView(CONTENT_0, ContentActivity0.class);
	}

	/**
	 * 找到自定义id的加载Activity的View
	 */
	@Override
	protected ViewGroup getContainer() {
		return (ViewGroup) findViewById(R.id.container);
	}

	/**
	 * 初始化按钮
	 */
	@Override
	protected void initTabBarButtons() {
		initTabBarButton(R.id.tab_radio_button0);
		initTabBarButton(R.id.tab_radio_button1);
		initTabBarButton(R.id.tab_radio_button2);
		initTabBarButton(R.id.tab_radio_button3);
		initTabBarButton(R.id.tab_radio_button4);
	}

	/**
	 * 导航按钮被点击时，具体发生的变化
	 */
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {

			case R.id.tab_radio_button0:
				setContainerView(CONTENT_0, ContentActivity0.class);
				break;

			case R.id.tab_radio_button1:
				setContainerView(CONTENT_1, ContentActivity1.class);
				break;

			case R.id.tab_radio_button2:
				setContainerView(CONTENT_2, ContentActivity2.class);
				break;

			case R.id.tab_radio_button3:
				setContainerView(CONTENT_3, ContentActivity3.class);
				break;

			case R.id.tab_radio_button4:
				setContainerView(CONTENT_4, ContentActivity4.class);
				break;

			default:
				break;
			}
		}
	}

}