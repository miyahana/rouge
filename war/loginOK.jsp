<%-- 
    Document   : loginOK
    Created on : 2014/12/22, 17:00:14
    Author     : 
--%>

<%@page import="jp.ac.tsuda.Data"%>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@page import=" com.google.appengine.api.users.UserServiceFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<center>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ストア</title>
    </head>
    
    <body>
        <p>ようこそ <c:out value="${name}"/>さん</p>
        >> <a href="/main">注文画面へ</a> / 
        <a href="/logout">ログアウト</a> / 
        <a href="/record">購入履歴</a> / 
        <a href="/review.jsp">レビュー</a> <<
    </body>
    </center>
</html>