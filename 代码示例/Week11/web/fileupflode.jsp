<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/15
  Time: 12:35 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> 提交一个文件</h1>
<form action="putDate" method="post" enctype="multipart/form-data">
    文件：<input name="file" type="file">
    <input type="submit" value="提交">
</form>

<a href="downFile"> 点击下载</a>
</body>
</html>
