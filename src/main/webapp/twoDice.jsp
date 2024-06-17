<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Random" %>
<%!
    int getRandomInt(int range) {
        return new Random().nextInt(range)+1;
    }
%>

<%--<% 메서드 영역 - service()의 내부 %>--%>

<%
    int idx1 = getRandomInt(6);
    int idx2 = getRandomInt(6);
%>

<html>
<head>
    <title>twoDice.jsp</title>
</head>
<body>
<img src = 'resources/img/dice<%=idx1%>.jpg'>
<img src = 'resources/img/dice<%=idx2%>.jpg'>
</body>
</html>