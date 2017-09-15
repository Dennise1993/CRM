package cn.crm.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.crm.entity.SysRight;
import cn.crm.right.biz.RightBiz;

public class InitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 获取容器与相关的Service对象
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		RightBiz rightBiz=(RightBiz)ac.getBean("rightBiz");
		
		//准备数据
		List<SysRight> topRights = rightBiz.getTopRights();
     	sce.getServletContext().setAttribute("topRights", topRights);
		System.out.println("------------> 已准备数据topRights <------------");
		
		Collection<String> allRights = rightBiz.getAllRights();
     	sce.getServletContext().setAttribute("allRights", allRights);
		System.out.println("------------> 已准备数据allRights <------------");
		
		
	}

}
