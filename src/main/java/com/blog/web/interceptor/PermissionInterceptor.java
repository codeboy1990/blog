package com.blog.web.interceptor;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class PermissionInterceptor implements HandlerInterceptor {

//	@Autowired
//	private AdminRolePermissionsService adminRolePermissionsService;
//
//	@Autowired
//	private AdminPermissionService adminPermissionService;
//
//	@Autowired
//	private AdminRoleService adminRoleService;

	private List<String> excludes;

	public void setExcludes(List<String> excludes) {
		this.excludes = excludes;
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String reqPath = request.getServletPath();
		for (String pathPattern : excludes) {
			if (Pattern.matches(pathPattern, reqPath)) {
				return true;
			}
		}
		return true;
//		AdminUser adminUser = (AdminUser) request.getSession().getAttribute(APP.SessionAttrKeys.LOGIN_ADMIN_KEY);
//		if (APP.OtherKyes.MAIN_ADMIN_USERNAME.equals(adminUser.getUserName())) {
//			return true;
//		}

//		List<AdminRolePermissions> adminRolePermissions = adminRolePermissionsService.findByRoleId(adminUser.getRoleId());
//		List<Integer> pids = new ArrayList<Integer>();
//		for (AdminRolePermissions arp : adminRolePermissions) {
//			pids.add(arp.getpId());
//		}
//		if (pids.isEmpty()) {
//			if (isAjax(request)) {
//				response.setStatus(405);
//				response.flushBuffer();
//			} else {
//				response.sendRedirect(request.getSession().getServletContext().getContextPath() + Url.Common.NOAUTH);
//			}
//			return false;
//		}
//		List<AdminPermission> permissions = adminPermissionService.findByIds(pids);
//		for (AdminPermission permission : permissions) {
//			if (reqPath.equals(permission.getUrl())) {
//				return true;
//			}
//		}
//		if (isAjax(request)) {
//			response.setStatus(405);
//			response.flushBuffer();
//		} else {
//			response.sendRedirect(request.getSession().getServletContext().getContextPath() + Url.Common.NOAUTH);
//		}
//
//		return false;
	}

//	private  boolean isAjax(HttpServletRequest request) {
//		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
//			return true;
//		}
//		return false;
//	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}


}
