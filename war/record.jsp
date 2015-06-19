<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jp.ac.tsuda.LinkDataDB"%>
<%@ page import="jp.ac.tsuda.Rouge"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
	<center>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注文確認</title>
	</head>
	<body>
	<h1>購入履歴</h1>
	<%List<Rouge>list = LinkDataDB.read();%>
	<table id ="datatable" border="1">
	<%
	for(Rouge data:list){
		long id = data.getId();
		String userName = data.getUserName();
		String rouge = data.getRouge();
		int count = data.getNumber();
	%>
	<tr>
	<td><%=userName%></td>
	<td><%=rouge%></td>
	<td><%=count%></td>
	</tr>
	<%
	}
	%>
	</table>
	<br>
	>> <a href="/loginOK.jsp">戻る</a> <<
	</body>
	</center>
</html>