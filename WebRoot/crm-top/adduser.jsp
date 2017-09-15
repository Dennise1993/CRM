<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<title>日程</title>
<link href="../css/stylesheet.css" rel="stylesheet" type="text/css" />
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../js/simpla.jquery.configuration.js"></script>
<script type="text/javascript" src="../js/javascript.js"></script>
<script type="text/javascript" src="../datepicker/WdatePicker.js"> </script>
<script type="text/javascript" > 
  //姓名提交
   function checkname(){
        var userName = document.getElementById("userName").value;
		var nameMess = document.getElementById("nameMess");
		nameMess.innerHTML = "";
		var reg = /^\w{4,16}$/;
		if (!reg.test(userName)) {
	
			nameMess.innerHTML = "用户名必须由数字、下划线或字母字符组成的4-16位字符";
			return false;
		} else {
		    return true;
		}
   }
   //密码
   function checkpass(){
        var passWord = document.getElementById("passWord").value;
		var passMess = document.getElementById("passMess");
		passMess.innerHTML = "";
		var reg = /^\w{4,16}$/;
		if (!reg.test(passWord)) {
	
			passMess.innerHTML = "用密码必须由数字、下划线或字母字符组成的4-16位字符";
			return false;
		} else {
		    return true;
		}
   } 
   //确认密码
    function checkrepass(){
        var passWord = document.getElementById("passWord").value;
        var repassWord = document.getElementById("repassWord").value;
		var repassMess = document.getElementById("repassMess");
		repassMess.innerHTML = "";
		if (passWord!=repassWord) {
			repassMess.innerHTML = "密码、确认密码不一致";
			return false;
		} else {
		    return true;
		}
   } 
   //表单提交的时候进行判断
   function check(){
      var tename=checkname();
      var tepass=checkpass();
      var terepass=checkrepass();
      if(tename && tepass && terepass){
     	 alert("用户新建成功,点击确定返回首页！");
           document.forms[0].submit();
      }
     
   }
   
</script>
</head>
<body>
   <div style="padding:5px;">
    <div class="txt" style="padding-top:3px;" >当前位置：首页&nbsp;&gt;&nbsp;新建用户&nbsp;&gt;&nbsp;
    <hr class="hr1" />
  </div>
  <div class="operation_button">
  	<a href="#" title="返回" onclick="back()">返回</a>
    <a href="#" title="保存" onclick="check();">保存</a>
  </div>
      <div class="out_bg">
			<div class="in_bg">
			<!-- 提交的信息放入表单中进行提交表单后边携带数据 -->
			  <form action="saveTopUser.action"  method="post">
				<table border="0" cellpadding="0" cellspacing="0"
					class="table_input txt">
					<tr>
						<td width="126">用户名称：</td>
						<td width="411"><input id="userName" name="sysuser.usrName" type="text" onblur="checkname();"   />
						 &nbsp;&nbsp;<span id="nameMess"></span></td>
					</tr>	
					<tr>
						<td width="126">用户密码：</td>
						<td width="442"><input id="passWord" name="sysuser.usrPassword" type="password" onblur="checkpass();" />
						&nbsp;&nbsp;<span id="passMess"></span></td>													
				    </tr>
					<tr>
						<td width="126">确认密码：</td>
						<td width="442"><input id="repassWord"  type="password" onblur="checkrepass();" />
						&nbsp;&nbsp;<span id="repassMess"></span></td>													
					</tr>
					
					  <tr>
					    <td width="126">用户角色：</td>
					      <td width="442">
					      <s:select list="#{4:'销售主管',5:'客户经理',6:'普通员工' }"  name="sysuser.sysRole.roleId"></s:select>
						 </td>
					</tr>
				</table>
		     </form>
		  </div>
		</div>
      </div>
</body>
</html>
