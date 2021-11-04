<%--
  Created by IntelliJ IDEA.
  User: Motherkiller
  Date: 2021/8/1 0001
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    ${cookie.username.value}--%>
<%--    将用户上一次登录的用户名回显到登录页面--%>
    <form action="http://localhost:9124/10_Cookie_Session/loginServlet" method="get">
        用户名：<input type="text" name="username" value="${cookie.username.value}"><br/>
        密码:   <input type="password" name="password" > <br/>
        <input type="submit" value="登录">

    </form>
</body>
</html>
