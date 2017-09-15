<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>${pageContext.request.contextPath}/crm_Left</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css" type="text/css"  />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css" type="text/css"  />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/javascript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/simpla.jquery.configuration.js"></script>
<%@ taglib prefix="s" uri="/struts-tags"  %>
</head>
<body>
<div>
  <div id="loader"><img src="images/1d_2.gif"/></div>
  <div class="current_user attention">
    <div> 欢迎您，<strong>${LOGIN_USER.usrName}</strong><br />
      [${LOGIN_USER.sysRole.roleName}，<a href="userRight_logout.action" target="parentFrame">退出</a>] </div>
  </div>
  <div id="sidebar">
    <div id="sidebar-wrapper">
      <ul id="main-nav">
     <%-- 显示一级菜单 --%>
      <s:iterator value="#application.topRights" status="status">
      <s:if test="#session.LOGIN_USER.hasRightsByName(rightName)">
        <li> <a href="#" <s:if test="#status.count==1">class="nav-top-item current" </s:if><s:else>class="nav-top-item" </s:else> id="man_nav_${status.count}" onclick="list_sub_nav(id)"> ${rightName} </a>
          <ul>
          <%-- 显示二级菜单 --%>
           <s:iterator value="sysRights" status="s">
           <s:if test="#session.LOGIN_USER.hasRightsByName(rightName)">
            <li><a href="${pageContext.request.contextPath}/${rightUrl}" target="rightFrame" id="a_nav_${s.count+status.count}" onclick="a_sub_nav(id)">${rightName}</a></li>
           </s:if>
           </s:iterator>
          </ul>
        </li>   
         </s:if>
         </s:iterator>
      </ul>
    </div>
  </div>
</div>
</body>
</html>
