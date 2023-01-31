<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/13
  Time: 5:53 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改Person</h1>
<!-- 当我们需要修改某个Javabenan 信息时 ，需要保证表单字段的字段名字 和javaben 的属性名保持一致-->
<form action="person/update" method="Post">
    <!-- 为了让handler 获取id , 将id 值放入隐藏域-->
    <input type="hidden" name="id" value="100">
    <input type="hidden" name="_method" value="PUT">
    编号 <input type="text" disabled="disabled" name="id" value="100">
    名字 <input type="text" name="name">
    <input type="submit" value="点击修改"/>
</form>
</body>
</html>
