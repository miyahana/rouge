
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import=" com.google.appengine.api.users.UserServiceFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String rouge = (String) session.getAttribute("rouge"); %>
<%@ page import="jp.ac.tsuda.LinkDataDB"%>
<%@ page import="jp.ac.tsuda.Review"%>
<%@ page import="java.util.*" %>
<%List<Review>list = LinkDataDB.read1();%>
<%  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ストア</title>
    </head>
    
    <body>
        <p><%= rouge %> についてのレビューを書き込む</p>
		<form action ="/reviewShow" method="post">
		<input type="text" size="10" name="comment">
		<input type="submit" value="送信">
		</form>
		<p>レビューの表示</p>
	<table id ="datatable" border="1">
	<%
	for(Review data:list){
		long id = data.getId();
		String userName=data.getUserName();
		String comment = data.getComment();
		Date date = data.getDatetime();
	%>
	<tr>
	<td><%=userName%></td>
	<td><%=rouge%></td>
	<td><%=date%></td>
	</tr>
	<%
	}
	%>
	</table>
    <a href="/review">戻る</a>
   	</body>
</html>