<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/25
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="//cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
</head>
<script>
    $(function(){
        $("#getage").click(function(){
            $.ajax({
                type: "POST",
                url: "${ctx}/test/getage",
                data: {
                    name: $("#name").html()
                },
                dataType: "json",
                success: function(data){
                    temp = eval(data);
                    $("#age").html(temp.age);
                }
            });

        });

    });
</script>
<body>
<div id="name">${test.name}</div><br>
<span id="age"></span>
<button id="getage">点击获取年龄</button>
</body>
</html>
