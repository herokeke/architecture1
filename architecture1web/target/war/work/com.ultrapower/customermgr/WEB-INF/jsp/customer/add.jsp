<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="${pageContext.request.contextPath}/customer/add" method="post">
     <table>
         <tr>
             <td>新增客户</td>
         </tr>
         <tr>
             <td>客户编号</td>
             <td><input type="text" name="customerId" value=""/></td>
             <td>客户密码</td>
             <td><input type="text" name="pwd" value=""/></td>
         </tr>
         <tr>
             <td>显示名称</td>
             <td><input type="text" name="showName" value=""/></td>
             <td>真实姓名</td>
             <td><input type="text" name="trueName" value=""/></td>
         </tr>
         <tr>
             <td>
                 <input type="submit" value="新增" />
             </td>
         </tr>
     </table>

 </form>
</body>
</html>
