<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>模块信息查看</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="back"><a href="#" onclick=" window.history.go(-1)">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块信息系查看
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tr class="odd" >
		<td>模块名称:</td>
		<td><input disabled="disabled" type="text"  value="${module.name }"/></td>
	</tr>
	<tr class="odd">
		<td>模块类型:</td>
		<td>
		<input disabled="disabled" type="text"  value="${module.ctype }"/>
		</td>
	</tr>
	<tr class="odd">
		<td>上级模块:</td>
		<td>
		<input disabled="disabled" type="text"  value="${module.parentModule.name}"/>
		</td>
	</tr>
	<tr class="odd">
		<td>排序号:</td>
		<td><input disabled="disabled" type="text" name="orderNo" value="${module.orderNo }"/></td>
	</tr>
	<tr class="odd">
		<td>状态:</td>
		<td>
		
			<input disabled="disabled" type="radio" name="state" value="1" <c:if test="${module.state==1}">checked="checked"</c:if>/>启用
			<input disabled="disabled" type="radio" name="state" value="0" <c:if test="${module.state==0}">checked="checked"</c:if>/>停用
		</td>
	</tr> 
	<tr class="odd">
		<td>备注信息:</td>
		<td>
			<textarea disabled="disabled" style="height:130px;width:100%" name="remark">${module.remark }</textarea>
		</td>
	</tr>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

