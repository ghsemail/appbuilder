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

	/** Activity??iew容�? **/
	private ViewGroup container;

	private LocalActivityManager localActivityManager;

	/**
	 * ??��Activity??iew容�???d???�?? <br>
	 * ??��?��?�??件中???�??id�??�?????�??�??�??�?iew容�????�?	 * 
	 * @return ViewGroup
	 */
	abstract protected ViewGroup getContainer();

	/**
	 * �???�类�??�??????????d????????	 * 
	 * @param id
	 */
	protected void initTabBarButton(int id) {
		RadioButton btn = (RadioButton) findViewById(id);
		btn.setOnCheckedChangeListener(this);
	}

	/**
	 * �?��???�?��?��?�?????并�?�?????????????	 */
	abstract protected void initTabBarButtons();

	/**
	 * 为�???ctivity?????ntent信�?
	 * 
	 * @param cls
	 * @return
	 */
	private Intent initIntent(Class<?> cls) {
		return new Intent(this, cls).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	}

	/**
	 * ?��??�类�??????��?Activity容�????Activity移�?�??�??�????��Activity???
	 * 
	 * @param activityName
	 *            ??��??ctivity??ocalActivityManager�?????
	 * @param activityClassTye
	 *            �??�?ctivity??��??	 */
	protected void setContainerView(String activityName,
			Class<?> activityClassTye) {
		if (null == localActivityManager) {
			localActivityManager = getLocalActivityManager();
		}

		if (null == container) {
			container = getContainer();
		}

		// 移�?????��??��???iew
		container.removeAllViews();

		Activity contentActivity = localActivityManager
				.getActivity(activityName);
		if (null == contentActivity) {
			localActivityManager.startActivity(activityName,
					initIntent(activityClassTye));
		}

		// ??��Activity
		container.addView(localActivityManager.getActivity(activityName)
				.getWindow().getDecorView(), new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	}

}