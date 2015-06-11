<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jp.ac.tsuda.LinkDataDB"%>
<%@ page import="jp.ac.tsuda.Rouge"%>
<%@ page import="java.util.*" %>
<h1>データの表示</h1>
<%List<Rouge>list = LinkDataDB.read();%>
<table id ="datatable" border="1">
<%
for(Rouge data:list){
	long id = data.getId();
	String userName=data.getUserName();
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