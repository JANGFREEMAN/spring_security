<%--
  Created by IntelliJ IDEA.
  User: 44831
  Date: 2019/2/26
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
    <h2>用户列表</h2>
    <table border="1" style = "width:1000px">
        <tr>
            <th>用户名</th>
            <th>所属角色</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>zhangsan</td>
            <td>管理员</td>
            <td>20111212</td>
            <th><a  href = "<%=request.getContextPath()%>/users/addOrUpdateUser" id = "add" style = "margin-right: 10px">新增</a><a>修改</a></th>
        </tr>
    </table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type = "application/javascript">
    <%=request.getAttribute("users")%>
    $(function(){

    })
</script>
</html>
