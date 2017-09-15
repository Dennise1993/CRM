<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>客户开发计划列表</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" src="datepicker/WdatePicker.js"> </script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：营销管理&nbsp;&gt;&nbsp;销售机会管理&nbsp;&gt;&nbsp;销售机会
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="add.jsp" title="新建">新建</a>
    <a href="javascript:toPage(1)" title="查询">查询</a>
  </div>
  
  <s:form action="showUser">
  <div class="search_input">
    <ul class="txt">
      <li>客户名称：
        <s:textfield name="msgpage.chcCustName" />
      </li>
      <li>联系人：
        <s:textfield name="msgpage.chcLinkman" />
      </li>
      <li>创建时间：
        <input type="text" size="30" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" />
      </li>
    </ul>
  </div>
  </s:form>
  
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
          <th width="5%">编号</th>
          <th width="15%">客户名称</th>
          <th width="15%">概要</th>
          <th width="10%">联系人</th>
          <th width="15%">联系电话</th>
          <th width="15%">创建时间</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
      <s:iterator value="recordList">
        <tr>
          <td>
            <s:property value="chcId"/>
          </td>
          <td><a href="#">
            <s:property value="chcCustName"/>
          </a></td>
          <td>
            <s:property value="chcTitle"/>
          </td>
          <td>
            <s:property value="chcLinkman"/>
          </td>
          <td>
            <s:property value="chcMobile"/>
          </td>
          <td>
            <s:date name="chcCreateDate" format="yyyy-MM-dd" />
          </td>
          <td>
              <s:if test="#session.LOGIN_USER.hasRightsByName('指派销售机会')">
              <a href="AddPatch.action?chaId=<s:property value="chcId" />"> <img title="指派销售机会" src="images/user.ico" class="op_button"  /> </a>
              </s:if>
          	  <a href="AddPlan.action?chaId=<s:property value="chcId" />"> <img title="修改销售机会" src="images/gear.ico" class="op_button"  /> </a>
          	  <img title="删除销售机会" src="images/delete.ico" class="op_button" onclick="to('')" />
          
          </td>
        </tr>
        
        </s:iterator>
      </tbody>
    </table>
  </div>
  
</div>
<%@ include file="/public/pageView.jspf" %>
</body>
</html>
