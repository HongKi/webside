package com.webside.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.webside.exception.SystemException;

public class ResourceUtil {
	
	private static final ResourceBundle BOUNDLE = java.util.ResourceBundle.getBundle("webside");
	public static Map<String,Object> resourceMap = new HashMap<String,Object>();//准备资源文件的添加
	private static final Logger LOG = Logger.getLogger(ResourceUtil.class);
	
	static {
		try {
			LOG.info("##读取配置文件参数开始##");
			readAllProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			LOG.info("##读取配置文件参数结束##");
		}
	}
	
	public static void readAllProperties() throws FileNotFoundException,IOException  {
        Enumeration en =BOUNDLE.getKeys();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String name=BOUNDLE.getString(key);
            LOG.info(key+"=="+name);
        }
	}
	
	private void ResourceUtil() {
	
	}
	
	/**
	 * 查找页面的title配置名称
	 * @return
	 */
	public static final String getTitle(){
		return BOUNDLE.getString("webside.title");
	}
	
	/**
	 * 查找配置项的关键字
	 * @param args
	 */
	public static final String getKeyWords(){
		return BOUNDLE.getString("webside.keywords");
	}
	
	/**
	 * 查找配置项的描述
	 * @param args
	 */
	public static final String getDescription(){
		return BOUNDLE.getString("webside.description");
	}
	
	/**
	 * 查找配置项的工程版本
	 * @param args
	 */
	public static final String getVersion(){
		return BOUNDLE.getString("webside.version");
	}
	
	public static void main(String[] args) {
		ResourceUtil ru =new ResourceUtil();
	}
}
