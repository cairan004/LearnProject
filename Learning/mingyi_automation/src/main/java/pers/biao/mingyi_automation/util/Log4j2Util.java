package pers.biao.mingyi_automation.util;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

public class Log4j2Util {
	private static ConfigurationSource source;
	private static final String path = "\\src\\main\\java\\pers\\biao\\mingyi_automation\\config\\log4j2.xml";
	
	/*
	 * 初始化log4j2.xml的位置
	 */
	public static Logger initLog4j2(String clazzName){		
		try {
			source = new ConfigurationSource(new FileInputStream(System.getProperty("user.dir")+path));
			Configurator.initialize(null, source);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return LogManager.getLogger(clazzName);
	}
}
