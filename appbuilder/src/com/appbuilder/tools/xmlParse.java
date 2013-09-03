package com.appbuilder.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParserException;

import android.content.Context;
import android.content.res.XmlResourceParser;

import com.appbuilder.main.R;

public class xmlParse {
	Context context;
	public xmlParse(Context context){
		 this.context = context;
	}
	
	public List<Map<String, String>> getData() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        XmlResourceParser xrp = context.getResources().getXml(R.xml.tabconfig);

        try {
            // 直到文档的结尾处
            while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
                // 如果遇到了开始标签
                if (xrp.getEventType() == XmlResourceParser.START_TAG) {
                    String tagName = xrp.getName();// 获取标签的名字
                    if (tagName.equals("tab")) {
                        Map<String, String> map = new HashMap<String, String>();
                        String activity = xrp.getAttributeValue(0);// 通过属性索引来获取属性值
                        map.put("activity", activity);
                        map.put("name", xrp.nextText());
                        list.add(map);
                    }
                }
                xrp.next();// 获取解析下一个事件
            }
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }
	
	
	}
	


		
