<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<HTML>
<HEAD>
<TITLE>login</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<script type="text/javascript" src="/crm/script/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/crm/script/right/login.js"></script>
<style>
	th{
		font-size:12px;
		text-align:right;
		font-weight:normal;
	}
	td{
		font-size:12px;
		text-align:left;
	}
	input{
		width:100px;
		font-size:12px;
		border:solid 1px lightblue;
	}
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 style="text-align:center;padding-top:20px;">
<TABLE WIDTH=800 BORDER=0 CELLPADDING=0 CELLSPACING=0>
  <TR>
		<TD COLSPAN=7>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_01.jpg" WIDTH=800 HEIGHT=71 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=71 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>&nbsp;
		
		</TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=66 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=7>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_03.jpg" WIDTH=800 HEIGHT=6 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=6 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=3>&nbsp; </TD>
		<TD COLSPAN=3 ROWSPAN=2>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_05.jpg" WIDTH=426 HEIGHT=83 ALT=""></TD>
		
    <TD ROWSPAN=3>&nbsp;</TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=44 ALT=""></TD>
	</TR>
	<TR>
		
    <TD ROWSPAN=4>&nbsp; </TD>
		<TD COLSPAN=2>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_08.jpg" WIDTH=94 HEIGHT=39 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=39 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=3>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_09.jpg" WIDTH=15 HEIGHT=141 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=2 background="${pageContext.request.contextPath}/images/login/login_10.jpg" >
	<form action="userRight_login.action" method="post" onsubmit="return checkit();">
	<table width="100%">
        
        <tr> 
          <th>用户名</th>
          <td><s:textfield name="usrName" size="20" tabindex="1" cssClass="TextField required" id="loginNameInput" /></td>
        </tr>
        <tr> 
          <th>密　码</th>
          <td><s:password name="usrPassword" id="aa" size="20" tabindex="2" showPassword="false" cssClass="TextField required" /></td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><input type="image" src="${pageContext.request.contextPath}/images/login/login_button.jpg" style="width: 73px;height: 25px"/></td>
        </tr>
      </table>     
	</form>
	<span id="error" style="color:red;font-size:12px;"><s:fielderror/></span>
	<input type="hidden" id="userStstus" value="1"/>
    </TD>
		<TD COLSPAN=2>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_11.jpg" WIDTH=304 HEIGHT=86 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=86 ALT=""></TD>
	</TR>
	<TR>
		<TD ROWSPAN=2>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_12.jpg" WIDTH=19 HEIGHT=55 ALT=""></TD>
		
    <TD COLSPAN=2 ROWSPAN=3>&nbsp; </TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=28 ALT=""></TD>
	</TR>
	<TR>
		<TD COLSPAN=2>
			<IMG SRC="${pageContext.request.contextPath}/images/login/login_14.jpg" WIDTH=201 HEIGHT=27 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=27 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=5>&nbsp; </TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=67 ALT=""></TD>
	</TR>
	<TR>
		
    <TD COLSPAN=7 background="${pageContext.request.contextPath}/images/login/login_16.jpg" style="text-align:right;padding-right:25px;"> 
			&copy; 2013 北京阿博泰克北大青鸟信息技术有限公司
    </TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=1 HEIGHT=55 ALT=""></TD>
	</TR>
	<TR>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=150 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=15 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=79 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=122 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=19 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=285 HEIGHT=1 ALT=""></TD>
		<TD>
			<IMG SRC="${pageContext.request.contextPath}/images/login/spacer.gif" WIDTH=130 HEIGHT=1 ALT=""></TD>
		<TD></TD>
	</TR>
</TABLE>

</BODY>
</HTML>