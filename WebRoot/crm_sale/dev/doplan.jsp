<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>营销管理</title>
<link href="../../css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="../../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/javascript.js"></script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：营销管理&nbsp;&gt;&nbsp;客户开发计划&nbsp;&gt;&nbsp;<a href="list.jsp">开发计划</a>&nbsp;&gt;&nbsp;制定计划
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
  </div>
  <div class="out_bg">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126" height="50">编号</td>
          <td width="411">1</td>
          <td width="126">机会来源</td>
          <td width="442">路上碰见</td>
        </tr>
        <tr>
          <td height="50">客户名称</td>
          <td>睿智数码</td>
          <td>成功几率</td>
          <td>80%</td>
        </tr>
        <tr>
          <td height="50">概要</td>
          <td>这个客户很重要！</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="50">联系人</td>
          <td>时先生</td>
          <td>联系人电话</td>
          <td>15037715979</td>
        </tr>
        <tr style="padding:0px;">
          <td valign="top">机会描述</td>
          <td>三天内拿下！</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="50">创建人</td>
          <td>Mr.Shi</td>
          <td>创建时间</td>
          <td>2013-9-25</td>
        </tr>
         <tr>
          <td height="50">指派给</td>
          <td>Mr.Shi</td>
          <td>指派时间</td>
          <td>2013-9-25</td>
        </tr>
      </table>
    </div>
  </div>
  <div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="table_list" >
      <thead>
        <tr>
       	  <th width="10%">计划编号</th>
          <th width="30%">计划项</th>
          <th width="10%">操作</th>
          <th width="10%">执行结果</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td><input type="text" size="100"  value="采购笔记本电脑意向"/></td>
           <td><input type="button" value="执行计划" />&nbsp;&nbsp;<input type="button" value="删除计划" /></td>
          <td>未开发</td>
        </tr>
        </tbody>
      </table>
      </div>
</div>
</body>
</html>
