<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>导航</title>
<link href="${pageContext.request.contextPath}/css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div>
	<div class="logo"></div>
    <div class="navigation">
  <ul class="shortcut_buttons_set">
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/topindex.jsp" target="rightFrame" id="top_topindex" onclick="a_sub_nav(id)"><span> <img src="${pageContext.request.contextPath}/images/home.ico" alt="icon" /><br />
      首页 </span></a></li>
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/file.jsp" target="rightFrame" id="top_file" onclick="a_sub_nav(id)" ><span> <img src="${pageContext.request.contextPath}/images/calendar.ico" alt="icon" /><br />
      日程 </span></a></li>
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/notice.jsp" target="rightFrame" id="top_notice" onclick="a_sub_nav(id)" ><span> <img src="${pageContext.request.contextPath}/images/clipboard.ico" alt="icon" /><br />
      公告栏 </span></a></li>
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/domessage.jsp" target="rightFrame" id="top_domessage" onclick="a_sub_nav(id)" ><span> <img src="${pageContext.request.contextPath}/images/write.png" alt="icon" /><br />
      写消息 </span></a></li>
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/message.jsp" target="rightFrame" id="top_message" onclick="a_sub_nav(id)"><span> <img src="${pageContext.request.contextPath}/images/bubble.ico" alt="icon" /><br />
      我的消息 </span></a></li>
    <li><a class="shortcut_button" href="${pageContext.request.contextPath}/crm-top/recycle.jsp" target="rightFrame" id="top_rerecycle" onclick="a_sub_nav(id)"><span> <img src="${pageContext.request.contextPath}/images/trash.ico" alt="icon" /><br />
      回收站 </span></a></li>
  </ul>
  <!-- end shortcut_buttons_set --> 
</div>
</div>
</body>
</html>
