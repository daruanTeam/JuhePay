package com.shanjupay.merchant.common.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LoginUser {
	private String mobile;
	private Map<String, Object> payload = new HashMap<>();
	private String clientId;
	private String username;
	private Long tenantId;

	@Override
	public String toString() {
		return "LoginUser{" +
				"mobile='" + mobile + '\'' +
				", payload=" + payload +
				", clientId='" + clientId + '\'' +
				", username='" + username + '\'' +
				", tenantId=" + tenantId +
				'}';
	}
}
