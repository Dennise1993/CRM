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
  <div class="txt" style="padding-top:3px;" >当前位置：基础数据&nbsp;&gt;&nbsp;查询产品信息
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="javascript:toPage(1)" title="查询">查询</a>
  </div>
  <s:form action="base-showProduct.action">
  <div class="search_input">
    <ul class="txt">
      <li>名称：
        <s:textfield name="queryProduct.prodName"/>
      </li>
      <li>型号：
        <s:textfield name="queryProduct.prodType"/>
      </li>
      <li>批次：
        <s:textfield name="queryProduct.prodBatch"/>
      </li>
    </ul>
  </div>
  </s:form>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%">编号</th>
          <th width="20%">名称</th>
          <th width="15%">型号</th>
          <th width="15%">等级/批次</th>
          <th width="5%">单位</th>
          <th width="10%">单价(元)</th>
          <th width="25%">备注</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator  value="recordList" >
        <tr>
          <td><s:property value="prodId" /></td>
          <td><s:property value="prodName" /></td>
          <td><s:property value="prodType" /></td>
          <td><s:property value="prodBatch" /></td>
          <td><s:property value="prodUnit" /></td>
          <td><s:property value="prodPrice" /></td>
          <td><s:property value="prodMemo" /></td>
        </tr>
  	  </s:iterator> 
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/public/pageView.jspf" %>
</body>
</html>
