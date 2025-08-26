package com.covoro.validationservice.logging;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

@Component
@RequestScope
public class RequestAttributes {

	private String userId;
	private String userName;
	private String userRole;
	private String accessToken;

	public String getUserId() {
		return userId;
	}

	public RequestAttributes setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public RequestAttributes setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserRole() {
		return userRole;
	}

	public RequestAttributes setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public RequestAttributes setAccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public Map<String, String> getAttributeMap() {
		Map<String, String> attributeMap = new HashMap<>();
		attributeMap.put("userId", this.userId);
		attributeMap.put("userName", this.userName);
		attributeMap.put("userRole", this.userRole);
		attributeMap.put("accessToken", this.accessToken);
		return attributeMap;
	}

}
