package com.example.constant;
import java.util.HashMap;
import java.util.Map;
public final class RoleAuthMap {

private static final Map<String, String> map= new HashMap<>();
	
	static {
		map.put("BROKER", "ADD_USER,ADD_DEAL");
		map.put("ADMIN","ADD_BROKER,ADD_USER,ADD_DEAL");
	}
	
	public static String getAuthForRole(String role) {
		return map.get(role);
	}
}
