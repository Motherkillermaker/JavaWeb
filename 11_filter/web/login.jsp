<%--
  Created by IntelliJ IDEA.
  User: Motherkiller
  Date: 2021/8/4 0004
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    这是登录页面。login.jsp 页面 <br>
    <form action="http://localhost:9618/11_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/> <br>
        密 码：<input type="password" name="password"/> <br>
        <input type="submit" />
    </form>

</body>
</html>
