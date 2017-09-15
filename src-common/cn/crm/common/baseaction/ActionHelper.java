package cn.crm.common.baseaction;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ActionHelper {

	/**
	 * 解耦合的方式保存session
	 * @param key
	 * @param val
	 */
	public static void putSession(String key,Object val){
		Map<String,Object> map=ActionContext.getContext().getSession();
		if(map.containsKey(key)){
			map.remove(key);
		}
		map.put(key, val);
	}
	/**
	 * 以解耦合的方式移除session
	 */
	public static void removeSession(String key){
		Map<String,Object> map=ActionContext.getContext().getSession();
		if(map.containsKey(key)){
			map.remove(key);
		}
	}
	/**
	 * 获得session对象
	 * 
	 */
	public static Object getSession(String key){
		Object obj=null;
		Map<String,Object>map=ActionContext.getContext().getSession();
		if(map.containsKey(key)){
			obj=map.get(key);
		}
		return obj;
	}
	
	/**
	 * 耦合方式保存Session
	 * @param key
	 * @param val
	 */
	public static void servletSession(String key,Object val){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute(key, val);
	}
	
	/**
	 * 耦合的方式移除Session
	 * @param key
	 * @param val
	 */
	public static void servletClearSession(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
	}
}
