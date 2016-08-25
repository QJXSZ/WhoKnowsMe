package com.qjkobe.config;

import java.io.InputStream;
import java.util.Properties;

public class SystemConfig {
	public static Properties p = new Properties();
	static {
		InputStream inputStream = null;
		try {
			inputStream = SystemConfig.class.newInstance().getClass()
					.getClassLoader()
					.getResourceAsStream("config/system.properties");
			p.load(inputStream);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
}
