package com.ctp.ghub.enums.sms;

/**
 * 短信分类
 */
public enum SmsMessageEnum {

	REGISTER_VERIFY_CODE("register_verify_code","账号注册验证码");

	private String code;
	private String desc;

	SmsMessageEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
