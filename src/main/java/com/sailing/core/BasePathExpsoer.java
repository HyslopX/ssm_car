/**
 * tzdeskϵͳƽ̨
 * tzupload
 * com.tz.core
 * BasePathExpsoer.java
 * ������:xuchengfei 
 * ʱ�䣺2015��11��13��-����10:27:57 
 * 2015̶�ݽ���˾-��Ȩ����
 */
package com.sailing.core;

import javax.servlet.ServletContext;

import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;


public class BasePathExpsoer implements ServletContextAware {

	private ServletContext application;
	private String basePath;

	public void init() {
		if (StringUtils.isEmpty(basePath)) {
			basePath = application.getContextPath();
		}
		application.setAttribute("basePath", basePath);
		application.setAttribute("resPath", basePath + "/resources");
	}

	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}

	public void setbasePath(String basePath) {
		this.basePath = basePath;
	}

}
