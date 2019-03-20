<%--
  Created by IntelliJ IDEA.
  User: Genius
  Date: 2019/3/16
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String path = request.getContextPath();
    request.setAttribute("path", path);%>

<html>
<head>
    <title>登录</title>
</head>
<body>
<fieldset>

    <legend>login</legend>
    <form action="${path}/check.do" method="post">
        <label>name</label><input name="name" placeholder="name"><br>
        <label>name</label><input name="pwd" placeholder="password"><br>
        <button>login</button>
        <p>${param.msg}</p>
    </form>
</fieldset>

</body>
<script src="../js/jquery-1.4.3.js"></script>
<script>
    function login() {
        var name = $('#name').val();
        var pwd = $("#pwd").val();
        var data = {
            "name": name,
            "pwd": pwd
        };
        $.post('${path}', data, function (data) {
            var state = data.state;

        }, 'json');

    }

</script>
</html>
