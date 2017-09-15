<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<title>基础数据</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：基础数据&nbsp;&gt;&nbsp;数据字典管理&nbsp;&gt;&nbsp;<a href="base-showDictByIf.action">数据字典列表</a>&nbsp;&gt;&nbsp;新建数据字典
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="base-showDictByIf.action" title="返回" >返回</a>
    <a href="#" title="保存" onclick="return saveDict()">保存</a>
  </div>
  <div class="out_bg">
  
  	<s:form action="base-AddDict.action" id="addDist" method="post">
    <div class="in_bg">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126">编号</td>
          <td width="411"><input style="background-color: #CCC" type="text" readonly="readonly" id="dictId" name="dictId" value="<s:property value="max" />" /></td>
          <td width="126">类别</td>
          <td width="442"><input type="text" value="" id="dictType" name="dictType" /></td>
        </tr>
        <tr>
          <td>条目</td>
          <td><input type="text" id="dictItem" name="dictItem"/></td>
          <td>值</td>
          <td><input type="text" id="dictValue" name="dictValue"/></td>
        </tr>
        <tr>
          <td>是否可编辑</td>
          <td><input type="checkbox" id="checkbox" name="dictIsEditable"  /></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </div>
    </s:form>
  </div>
</div>
</body>
</html>
