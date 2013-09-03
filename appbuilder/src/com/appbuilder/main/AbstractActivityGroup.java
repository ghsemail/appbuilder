package com.appbuilder.main;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;

public abstract class AbstractActivityGroup extends ActivityGroup implements
		CompoundButton.OnCheckedChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initTabBarButtons();
	}

	/** Activity??iewå®¹å? **/
	private ViewGroup container;

	private LocalActivityManager localActivityManager;

	/**
	 * ??½½Activity??iewå®¹å???d???å®?? <br>
	 * ??»¥?¨å?å±??ä»¶ä¸­???ä¹??idï¼??è¿?????ä¸??æ³??å¾??ä¸?iewå®¹å????è±?	 * 
	 * @return ViewGroup
	 */
	abstract protected ViewGroup getContainer();

	/**
	 * ä¾???°ç±»è°??ï¼??????????d????????	 * 
	 * @param id
	 */
	protected void initTabBarButton(int id) {
		RadioButton btn = (RadioButton) findViewById(id);
		btn.setOnCheckedChangeListener(this);
	}

	/**
	 * å¿?¡»???è¿?¸ª?¹æ?ï¼?????å¹¶å?å§?????????????	 */
	abstract protected void initTabBarButtons();

	/**
	 * ä¸ºå???ctivity?????ntentä¿¡æ?
	 * 
	 * @param cls
	 * @return
	 */
	private Intent initIntent(Class<?> cls) {
		return new Intent(this, cls).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	}

	/**
	 * ?¨å??°ç±»ä¸??????½å?Activityå®¹å????Activityç§»é?ï¼??å°??å®????¸ªActivity???
	 * 
	 * @param activityName
	 *            ??½½??ctivity??ocalActivityManagerä¸?????
	 * @param activityClassTye
	 *            è¦??è½?ctivity??±»??	 */
	protected void setContainerView(String activityName,
			Class<?> activityClassTye) {
		if (null == localActivityManager) {
			localActivityManager = getLocalActivityManager();
		}

		if (null == container) {
			container = getContainer();
		}

		// ç§»é?????¨å??¨é???iew
		container.removeAllViews();

		Activity contentActivity = localActivityManager
				.getActivity(activityName);
		if (null == contentActivity) {
			localActivityManager.startActivity(activityName,
					initIntent(activityClassTye));
		}

		// ??½½Activity
		container.addView(localActivityManager.getActivity(activityName)
				.getWindow().getDecorView(), new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	}

}