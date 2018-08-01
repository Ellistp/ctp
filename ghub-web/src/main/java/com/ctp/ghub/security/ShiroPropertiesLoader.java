package com.ctp.ghub.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class ShiroPropertiesLoader {
	
	private Logger logger = LoggerFactory.getLogger(ShiroPropertiesLoader.class);
	
	private String shiroConfigPath = "shiro-filter.properties";

	public void setShiroConfigPath(String path) {
		shiroConfigPath = path;
	}

	public String loadFilterConfig() {
		return loadConfig();
	}
	
	public String loadConfig() {
		StringBuilder sb = new StringBuilder();
		ClassPathResource resource = new ClassPathResource(shiroConfigPath);
		if (resource != null && resource.exists()) {  
			if (resource.isReadable()) {
				try {
					InputStream is = resource.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					String line;
					while ((line=br.readLine()) != null) {
						sb.append(line).append("\r\n");
					}  
					if (is != null) {
						is.close();  
					}  
					if (br != null) {
						br.close();
					}  
				} catch (IOException e) {
					logger.error("Failed to load shiro config: " + shiroConfigPath, e);
				}
			}
		}
		return sb.toString();
	}
}
