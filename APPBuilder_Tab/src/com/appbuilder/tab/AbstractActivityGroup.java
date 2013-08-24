package com.appbuilder.tab;

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

	/** Activity的View容器 **/
	private ViewGroup container;

	private LocalActivityManager localActivityManager;

	/**
	 * 加载Activity的View容器的id可自定义 <br>
	 * 可以在布局文件中自定义其id，通过重写这个方法获得这个View容器的对象
	 * 
	 * @return ViewGroup
	 */
	abstract protected ViewGroup getContainer();

	/**
	 * 供实现类调用，根据导航按钮id初始化按钮
	 * 
	 * @param id
	 */
	protected void initTabBarButton(int id) {
		RadioButton btn = (RadioButton) findViewById(id);
		btn.setOnCheckedChangeListener(this);
	}

	/**
	 * 必须重写这个方法，来遍历并初始化所有的导航按钮
	 */
	abstract protected void initTabBarButtons();

	/**
	 * 为启动Activity初始化Intent信息
	 * 
	 * @param cls
	 * @return
	 */
	private Intent initIntent(Class<?> cls) {
		return new Intent(this, cls).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	}

	/**
	 * 在实现类中调用，能将Activity容器内的Activity移除，再将指定的某个Activity加入
	 * 
	 * @param activityName
	 *            加载的Activity在localActivityManager中的名字
	 * @param activityClassTye
	 *            要加载Activity的类型
	 */
	protected void setContainerView(String activityName,
			Class<?> activityClassTye) {
		if (null == localActivityManager) {
			localActivityManager = getLocalActivityManager();
		}

		if (null == container) {
			container = getContainer();
		}

		// 移除内容部分全部的View
		container.removeAllViews();

		Activity contentActivity = localActivityManager
				.getActivity(activityName);
		if (null == contentActivity) {
			localActivityManager.startActivity(activityName,
					initIntent(activityClassTye));
		}

		// 加载Activity
		container.addView(localActivityManager.getActivity(activityName)
				.getWindow().getDecorView(), new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	}

}