/**
 * 
 */
package cn.newgxu.bgt.util;


import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author general
 * @email 463734522@qq.com
 * @time 2013年7月15日
 */
public class SessionUtil {

	
	
	public static HttpSession getSession(){
		HttpSession session =  ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
		 return session;
	}
	
	public static void setAttributeForSession(String key,Object object){
		getSession().setAttribute(key, object);
	}
	
	public static Object getAttributeFromSessionByKey(String key){
		Object object = getSession().getAttribute(key);
		return object;
	}
	
	public static void deleteAttributeFromSession(String key){
		getSession().removeAttribute(key);
	}
}
