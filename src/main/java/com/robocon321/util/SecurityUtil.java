package com.robocon321.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.robocon321.dto.MyUser;

public class SecurityUtil {
	
	public static MyUser getPrincipal() {
		MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return myUser;
	}
 	
	public static List<String> getAuthorities() {
		List<String> results = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for(GrantedAuthority authority: authorities) results.add(authority.getAuthority());
		return results;
	}
}
