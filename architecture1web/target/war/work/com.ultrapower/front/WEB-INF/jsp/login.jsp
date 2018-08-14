<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2018/8/13
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
        <td>登录名</td>
        <td><input type="text" name="customerId"></td>
        </tr>
        <tr>
            <td>登陆密码</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登陆">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
