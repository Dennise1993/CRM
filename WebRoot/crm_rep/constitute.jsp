<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>统计报表</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：统计报表&nbsp;&gt;&nbsp;客户构成分析
    <hr class="hr1" />
  </div>
  <div class="operation_button"> <a href="javascript:toPage(1)" title="查询">查询</a> </div>
  <s:form action="constitute_show">
  <div class="search_input">
    <ul class="txt">
      <li>报表方式：
        <s:select name="viewType"  list="#{0:'按等级', 1:'按信用度',2:'按满意度'}" >
        </s:select>
      </li>
    </ul>
  </div>
  </s:form>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="15%">编号</th>
          <th width="65%">等级</th>
          <th width="20%">客户数量</th>
        </tr>
      </thead>
      <tbody>
       <s:iterator  id="objects" value="recordList" status="status">
        <tr>
          <td>${(currentPage - 1) * pageSize + status.count}</td>
          <td><s:property value="#objects[0]" /> </td>
          <td><s:property value="#objects[1]" /> </td>
        </tr>
      </s:iterator>
      </tbody>
    </table>
  </div>
 <%@ include file="/public/pageView.jspf" %>
</div>
</body>
</html>
