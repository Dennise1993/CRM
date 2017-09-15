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
    function preserve(temp){
      var preserve=document.getElementById("preserve");
      var kmName=document.getElementById("kmName").value;//姓名
     var telphone=document.getElementById("telphone").value;//办公电话
        if(kmName!=""&&kmName!=null){
           
          if(telphone!=""&&telphone!=null){
             alert("联系人保存成功！！欧耶")
             preserve.submit();
        }else{
          alert("联系人办公电话不能为空");
        }
        }else{
           alert("联系人姓名不能为空");
        }
        
      
    }
      
       
  
     
</script>
</head>

<body>
<div style="padding:5px;">
  <div class="txt" style="padding-top:3px;" >当前位置：客户开发计划&nbsp;&gt;&nbsp;客户信息管理&nbsp;&gt;&nbsp;<a href="ScustomerShow">客户信息</a>&nbsp;&gt;&nbsp;联系人&nbsp;&gt;&nbsp;编辑联系人
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="保存" onclick="preserve()">保存</a>
  </div>
  <table border="0" cellpadding="0" cellspacing="0" class="table_show txt">
        <tr>
          <td width="100" align="center">客户编号：</td>
          <td width="200"><s:property value="ast"/></td>
          <td width="100" align="center">客户名称：</td>
          <td width="200"><s:property value="gongname"/></td>        
        </tr>
  </table>
    
  <div class="out_bg">s
    <div class="in_bg">
    <!-- 数据以表单的形式提交 -->
     <form id="preserve" action="Scstpreserve?ast=<s:property value='ast'/>&gongname=<s:property value='gongname'/>&cstlinkman.lkmId=<s:property value='cstlinkman.lkmId'/>" method="post" >
     
      <table border="0" cellpadding="0" cellspacing="0" class="table_input txt">
        <tr>
          <td width="126">姓名</td>
          <td width="411"><input id="kmName" name="cstlinkman.lkmName" type="text" value="<s:property value='cstlinkman.lkmName'/>" /></td>
          <td width="126">性别</td>
          <td width="442"><input type="radio" value="男" name="cstlinkman.lkmSex" id="radio" />男<input type="radio" value="女" name="cstlinkman.lkmSex" id="radio"  />女
</td>
        </tr>
        <tr>
          <td>职位</td>
          <td><input name="cstlinkman.lkmPostion" type="text" value="<s:property value='cstlinkman.lkmPostion'/>" /></td>
          <td>办公电话</td>
          <td><input id="telphone" name="cstlinkman.lkmTel" type="text" value="<s:property value='cstlinkman.lkmTel'/>" /></td>
        </tr>
        <tr>
          <td>手机</td>
          <td><input name="cstlinkman.lkmMobile" type="text" value="<s:property value='cstlinkman.lkmMobile'/>" /></td>
          <td>备注</td>
          <td><input name="cstlinkman.lkmMemo" type="text" value="<s:property value='cstlinkman.lkmMemo'/>" /></td>
        </tr>
      </table>
      </form>
    </div>
  </div>
  
</div>
</body>
</html>
