<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<title>客户开发计划</title>
<link href="css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/javascript.js"></script>
<script type="text/javascript" >
    function check(){
      
    var biao=document.getElementById("biao")//表单的对象
    var time=document.getElementById("time").value;//时间
    var palce=document.getElementById("palce").value;//地点
    var title=document.getElementById("title").value;//概要
       if(time!=null&&time!=""){
           if(palce!=null&&palce!=""){
              if(title!=null&&title!=""){
                 biao.submit();
                 alert("保存成功！！");
                  }else{
                 alert("概要不为空！！！！");
           }
           }else{
           alert("地点不为空！！！！");
           }
       }else{
         alert("时间不为空！！！！");
       }
       
      } 
  
</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">客户信息</a>&nbsp;&gt;&nbsp;交往记录&nbsp;&gt;&nbsp;新建交往记录
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="保存" onclick="check()">保存</a>
  </div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_show txt">
        <tr>
          <td width="100" align="center">客户编号：</td>
          <td width="200"><s:property value="ast"/></td>
          <td width="100" align="center">客户名称：</td>
          <td width="200"><s:property value="gongname"/></td>
        </tr>
  </table>
  <div class="out_bg">
    <div class="in_bg">
  <!-- 添加表单属性把数据放到表单中进行传递 -->
     <form id="biao" action="Scstaddone?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>" method="post">
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126">时间</td>
          <td width="411"><input id="time" name="cstact.atvDate" type="text" value="" /></td>
          <td width="126">地点</td>
          <td width="442"><input id="palce" name="cstact.atvPlace" type="text" value="" /></td>
        </tr>
        <tr>
          <td>概要</td>
          <td><input id="title" name="cstact.atvTitle" type="text" value="" /></td>
        </tr>
        <tr>
          <td valign="top">详细信息</td>
          <td><textarea name="cstact.atvDesc" rows="6" cols="36" ></textarea></td>
          <td></td>
          <td></td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</div>
</body>
</html>
