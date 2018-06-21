package pers.biao.mingyi_automation.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesUtil {
	private static InputStream inputStream;
	private static Properties properties;
	private static final  String USER_PROPERTIES = System.getProperty("user.dir")+"\\src\\main\\java\\pers\\biao\\mingyi_automation\\config\\"+"User.properties";
	private static final  String ANDROID_PROPERTIES = System.getProperty("user.dir")+"\\src\\main\\java\\pers\\biao\\mingyi_automation\\config\\"+"Android.properties";

	/*
	 * 获取User.properties对应key的value, value为String型
	 */
	public static String getUserStrValue(String key) throws IOException{
		try {
			inputStream = new FileInputStream(USER_PROPERTIES);
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			inputStream.close();
		}
		return properties.getProperty(key);
	}
	
	/*
	 * 获取User.properties对应key的value, value为Int型
	 */
	public static Integer getUserIntValue(String key) throws NumberFormatException, IOException{
		return Integer.parseInt(getUserStrValue(key));
	}
	
	/*
	 * 遍历Android.properties,获取所有的key和value
	 */
	public static Iterator<?> getAndroidProperties() throws IOException{
		try {
			inputStream = new FileInputStream(ANDROID_PROPERTIES);
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			inputStream.close();
		}
		Iterator<?> iterator = properties.entrySet().iterator();
		return iterator;
	}
}
