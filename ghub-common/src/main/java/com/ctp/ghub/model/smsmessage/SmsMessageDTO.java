package com.ctp.ghub.model.smsmessage;

import java.io.Serializable;

/**
 * 短信传值对象
 */
public class SmsMessageDTO implements Serializable {

	private static final long serialVersionUID = 1846543625430914616L;

	private String mobile;
	
	private String smsMessageType;
	
	private String content;
	
	private String values; // 短信模板参数（{"key1":"value1","key2":"value2"}）

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSmsMessageType() {
		return smsMessageType;
	}

	public void setSmsMessageType(String smsMessageType) {
		this.smsMessageType = smsMessageType;
	}

	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}
	
}
