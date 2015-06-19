
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import=" com.google.appengine.api.users.UserServiceFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jp.ac.tsuda.LinkDataDB"%>
<%@ page import="jp.ac.tsuda.Review"%>
<%@ page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<Review>list = LinkDataDB.read1();%>
<% //String rouge = (String) session.getAttribute("rouge"); %>
<!DOCTYPE html>
<html>
	<center>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ストア</title>
    </head>
    
    <body>
        <p><c:out value="${rouge}"/>についてのレビューを書き込む</p>
		<form action ="/reviewShow" method="post">
		<input type="text" size="50" name="comment">
		<input type="submit" value="送信">
		</form>
		<p>レビューの表示</p>
	<table id ="datatable" border="1">
	<%
	for(Review data:list){
		long id = data.getId();
		String userName=data.getUserName();
		String comment = data.getComment();
	%>
	<tr>
	<td><%=userName%></td>
	<td><%=comment%></td>
	</tr>
	<%
	}
	%>
	</table>
	<br>
    >> <a href="/review">戻る</a> <<
   	</body>
   	</center>
</html>