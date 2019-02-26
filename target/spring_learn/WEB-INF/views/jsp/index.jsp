<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<div>
    <div style = "width: 20%;height:100%;background-color: red;float: left">
        <h2>你好:${sessionScope.username} ! <span><a href = "/spring/logout">退出</a></span></h2>
        <div></div>
        <ul class = "menu">
            <li>
                <a data-url = "<%=request.getContextPath()%>/admin" href = "javascript:void(0)">管理员菜单</a>
            </li>
            <li>
                <a data-url = "<%=request.getContextPath()%>/normal" href = "javascript:void(0)">普通用户菜单</a>
            </li>
            <li>
                <a data-url = "<%=request.getContextPath()%>/addmenu" href = "javascript:void(0)">菜单管理</a>
            </li>
            <li>
                <a data-url = "<%=request.getContextPath()%>/users/list" href = "javascript:void(0)">用户管理</a>
            </li>
            <li>
                <a data-url = "<%=request.getContextPath()%>/addmenu" href = "javascript:void(0)">日志管理</a>
            </li>
            <li>
                <a data-url = "<%=request.getContextPath()%>/addmenu" href = "javascript:void(0)">授权管理</a>
            </li>
        </ul>
    </div>
    <div style = "float: left;width: 80%;height:100%">
        <iframe id = "content"src = "http://ww.baidu.com" style = "height:100%;width:100%"></iframe>
    </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type = "application/javascript">
    $(function(){
        $(".menu li").bind("click",function(e){
            var url = $(e.target).attr("data-url");
            console.log("点击菜单：",url);
            $("#content").attr("src",url);
        })
    })

</script>
</html>
