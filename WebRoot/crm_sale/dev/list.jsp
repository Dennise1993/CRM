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
  <div class="txt" style="padding-top:3px;" >当前位置：营销管理&nbsp;&gt;&nbsp;客户开发计划&nbsp;&gt;&nbsp;开发计划
    <hr class="hr1" />
  </div>
  <div class="operation_button">
    <a href="javascript:toPage(1)" title="查询">查询</a>
  </div>
  <s:form action="sal-showDev.action" method="post">
  <div class="search_input">
    <ul class="txt">
      <li>客户名称：
       	<s:textfield name="queryDev.chcCustName" />
      </li>
      <li>负责人：
       	<s:textfield name="queryDev.chcLinkman" />
      </li>
      <li>概要：
       	<s:textfield name="queryDev.chcTitle"  />
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
          <th width="10%">负责人</th>
          <th width="15%">公司电话</th>
          <th width="10%">状态</th>
          <th width="15%">概要</th>
          <th width="15%">操作</th>
        </tr>
      </thead>
      <tbody>
		<s:iterator value="recordList">      
        <tr>
          <td>
          <s:property value="chcId"/>
          </td>
          <td>
          <a href="#"><s:property value="chcCustName"/></a>
          </td>
          <td>
          <s:property value="chcLinkman"/>
          </td>
          <td>
          <s:property value="chcMobile"/>
		  </td>
		  <td>
          <s:property value="chcTitle"/>
          </td>
          <s:if test='chcStatus=="1"'>
			<td>未开发</td>
			<td>
          	<a href="dev-showPlan.action?planId=<s:property value='chcId'/>"><img title="制定计划" src="images/pencil.ico" class="op_button"  /></a>
         	<a href="#"><img title="执行计划" src="images/right.ico" class="op_button" /></a>
         	</td>
          </s:if>
          <s:elseif test='chcStatus=="2"'>
           <td>开发中</td>
           <td>
          	<a href="dev-showPlan.action?planId=<s:property value='chcId'/>"><img title="制定计划" src="images/pencil.ico" class="op_button"  /></a>
         	<a href="#"><img title="执行计划" src="images/right.ico" class="op_button" /></a>
        	<a href="#"><img title="开发成功" src="images/tick.ico" class="op_button"  /></a>
        	<a href="#"><img title="开发失败" src="images/block.ico" class="op_button" /></a>
           </td>
          </s:elseif>
          <s:elseif test='chcStatus=="3"'>
			<td>已归档</td>
			<td><a href="#"><img title="已归档" src="images/briefcase.ico" class="op_button" /></a></td>
          </s:elseif>
        </tr>
        </s:iterator>
      </tbody>
    </table>
  </div>
  <%@ include file="/public/pageView.jspf" %>
</div>
</body>
</html>
