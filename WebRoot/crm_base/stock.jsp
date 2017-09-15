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
  <div class="txt" style="padding-top:3px;" >当前位置：基础数据&nbsp;&gt;&nbsp;查询库存
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="javascript:toPage(1)" title="查询">查询</a>
  </div>
  <s:form action="base-showStorage.action">
  <div class="search_input">
    <ul class="txt">
      <li>产品：
         <s:textfield name="queryStorage.prodName"/>
      </li>
      <li>仓库：
        <s:textfield name="queryStorage.stkWarehouse"/>
      </li>
    </ul>
  </div>
  </s:form>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%">序号</th>
          <th width="15%">名称</th>
          <th width="15%">仓库</th>
          <th width="15%">货位</th>
          <th width="10%">件数</th>
          <th width="25%">备注</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator  value="recordList" >
        <tr>
          <td><s:property value="stkId" /></td>
          <td><s:property value="product.prodName" /></td>
          <td><s:property value="stkWarehouse" /></td>
          <td><s:property value="stkWare" /></td>
          <td><s:property value="stkCount" /></td>
          <td><s:property value="stkMemo" /></td>
        </tr>
  	  </s:iterator> 
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/public/pageView.jspf" %>
</body>
</html>
