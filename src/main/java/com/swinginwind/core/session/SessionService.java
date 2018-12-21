package com.swinginwind.core.session;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
	
	private ThreadLocal<Object> sessionThreadLocal = new ThreadLocal<Object>();
	private ThreadLocal<String> sessionIdThreadLocal = new ThreadLocal<String>();
	
	@Cacheable(value="sessionCache", key="#id")
	public Object getSession(String id) {
		return null;
	}
	
	@CachePut(value="sessionCache", key="#id")
	public Object setSession(String id, Object obj) {
		sessionThreadLocal.set(obj);
		sessionIdThreadLocal.set(id);
		return obj;
	}
	
	public void setCurrentSession(Object obj) {
		if(sessionIdThreadLocal.get() != null)
			this.setSession(sessionIdThreadLocal.get(), obj);
	}

	public ThreadLocal<Object> getSessionThreadLocal() {
		return sessionThreadLocal;
	}
	
	public ThreadLocal<String> getSessionIdThreadLocal() {
		return sessionIdThreadLocal;
	}
	
	public Object getSession() {
		if(sessionThreadLocal != null) {
			return sessionThreadLocal.get();
		}
		return null;
	}
	
	public String getSessionId() {
		if(sessionIdThreadLocal != null) {
			return sessionIdThreadLocal.get();
		}
		return null;
	}

}
