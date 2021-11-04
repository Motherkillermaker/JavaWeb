<%--
  Created by IntelliJ IDEA.
  User: Motherkiller
  Date: 2021/7/27 0027
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //动态的base标签值
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);


%>
<%--显示访问的地址和端口号--%>
<%--<%=basePath%>--%>

<!--		设置 base标签 + 永远固定相对路径跳转的结果-->
<base href = "<%=basePath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
