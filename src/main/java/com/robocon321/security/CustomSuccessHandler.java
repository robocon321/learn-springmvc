package com.robocon321.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.robocon321.util.SecurityUtil;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted())
			return;
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtil.getAuthorities();
		if(isAdmin(roles)) url = "/admin/new/list?page=1&limit=2";
		if(isUser(roles)) url = "/trang-chu";
		return url;
	}

	@SuppressWarnings("unused")
	private boolean isAdmin(List<String> roles) {
		return roles.contains("ADMIN");
	}

	@SuppressWarnings("unused")
	private boolean isUser(List<String> roles) {
		return roles.contains("USER");
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	
}
