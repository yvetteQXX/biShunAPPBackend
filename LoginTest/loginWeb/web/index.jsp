<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/7/11
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="LoginServlet">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit" value="登陆">
    <input type="reset" value="重置">
</form>

<form method="POST" action="WeChatServlet">
    code：<input type="text" name="code">
    <input type="submit" value="发送">
</form>
</body>
</html>
