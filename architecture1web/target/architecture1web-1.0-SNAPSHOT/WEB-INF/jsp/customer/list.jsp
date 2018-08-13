<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <table>
     <tr>
         <td>
             <a href="${pageContext.request.contextPath}/customer/toAdd">添加客户</a>
         </td>
     </tr>
     <tr>
         <td>客户列表</td>
     </tr>
     <tr>
         <td>客户编号</td>
         <td>显示名称</td>
         <td>真实姓名</td>
         <td>客户密码</td>
         <td>注册时间</td>
         <td>操作</td>
     </tr>

 <c:forEach var="m" items="${page.list}">
     <tr>
         <td>${m.customerId}</td>
         <td>${m.pwd}</td>
         <td>${m.showName}</td>
         <td>${m.trueName}</td>
         <td>${m.registerTime}</td>
         <td>
             <a href="${pageContext.request.contextPath}/customer/toUpdate/${m.pid}">修改</a>

             <a href="${pageContext.request.contextPath}/customer/toDelete/${m.pid}">删除</a>
         </td>
     </tr>
 </c:forEach>
<tr>
    <td>
        <tags:page pageInfo="${page}" paginationSize="5"/>
    </td>
</tr>
 </table>
</body>
</html>
