<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<title>基础数据</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：基础数据&nbsp;&gt;&nbsp;数据字典管理&nbsp;&gt;&nbsp;数据字典列表
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="新建" onclick="to('base-showAddDict.action')">新建</a>
    <a href="javascript:toPage(1)" title="查询">查询</a>
  </div>
  <s:form action="base-showDictByIf.action">
  <div class="search_input">
    <ul class="txt">
      <li>类别：
      	<s:textfield name="query.dictType"/>
      </li>
      <li>条目：
     	 <s:textfield name="query.dictItem"/>
      </li>
      <li>值：
     	 <s:textfield name="query.dictValue"/>
      </li>
    </ul>
  </div>
  </s:form>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%">编号</th>
          <th width="20%">类别</th>
          <th width="30%">条目</th>
          <th width="10%">值</th>
          <th width="15%">是否可编辑</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
       <s:iterator  value="recordList" >
       <tr>
          <td><s:property value="dictId" /></td>
          <td><s:property value="dictType" /></td>
          <td><s:property value="dictItem" /></td>
          <td><s:property value="dictValue" /></td>
          <s:if test='dictIsEditable =="0"   '><td>可以</td> 
          <td><a href="base-showUptDict.action?delId=<s:property value="dictId" />"><img title="编辑" src="images/hammer_screwdriver.png" class="op_button"/> </a>
          <a href="base-delDict.action?delId=<s:property value="dictId" />"><img title="删除" src="images/cross.png" class="op_button" onclick="return confirm('确认要删除么!')"/></a></td></s:if>
          <s:else><td>不可以</td><td><a href="base-delDict.action?delId=<s:property value="dictId" />"><img title="删除" src="images/cross.png" class="op_button" onclick="return confirm('确认要删除么!')"/></a></td></s:else>
        </tr>
  	  </s:iterator> 
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/public/pageView.jspf" %>
</body>
</html>
