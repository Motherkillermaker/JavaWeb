<%--
  Created by IntelliJ IDEA.
  User: Motherkiller
  Date: 2021/8/4 0004
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%

    System.out.println("target.jsp页面执行了");

    System.out.println("target.jsp的线程为：" + Thread.currentThread().getName());

    System.out.println(" target.jsp " + request.getParameter("username"));

  %>

</body>
</html>
