<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/23
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        response.getWriter().write("response输出1 <br>");
        response.getWriter().write("response输出2 <br>");

        out.write("out输出1：<br/>");
        out.write("out输出2：<br/>");
//        out.print(12);
    %>
</body>
</html>
