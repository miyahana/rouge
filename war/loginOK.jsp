<%-- 
    Document   : loginOK
    Created on : 2014/12/22, 17:00:14
    Author     : 
--%>

<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ストア</title>
    </head>
    
    <body>
        <p>ようこそ <c:out value="${name}"/>さん</p>
        <a href="/ad2932/Main">注文画面へ</a>
        <a href="/ad2932/WelcomeServlet">トップへ</a>
    </body>
</html>