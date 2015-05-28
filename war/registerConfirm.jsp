<%-- 
    Document   : registerConfirm
    Created on : 2015/01/14, 13:31:56
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jp.ac.tsuda.Data" %>

<%
Data registerUser = (Data) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ユーザー登録</title>
    </head>
    <body>
        <p>下記のユーザーを登録します</p>
        <p>
        名前：<%= registerUser.getUserName() %><br>
        パスワード：<%= registerUser.getPass() %><br>
        </p>
	<a href="/register">戻る</a>
	<a href="/register1">登録</a>
    </body>
</html>