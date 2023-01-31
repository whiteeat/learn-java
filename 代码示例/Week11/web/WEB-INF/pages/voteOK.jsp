<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/13
  Time: 3:42 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
shouw params
<h1>获取的的数据显示页面 voteok!</h1>
<hr>
取出 request域的数据
address:${address}
主人名字 ${requestScope.master.masterName}
主任信息：${requestScope.master};

<br>
主人名字 [session]${sessionScope.myMaster.masterName}
主任信息：[session]${sessionScope.myMaster};

主人名字 session]${sessionScope.myMaster2.masterName}
主任信息：session]${sessionScope.myMaster2};

<br>

</body>
</html>
