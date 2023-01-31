<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/13
  Time: 3:41 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h1>request url d params</h1>
      <a href="vote/vote01?name=tom">request url d params</a><br>
      <a  href="vote/vote2">获取消息头部信息</a><br>
      <h1> 添加主人信息</h1>
        <!--  为了让springMVC 直接到master 对象数据，
           要求这里的字段名称和对象的名称保持一致，级联添加属性也是一样保持名字对应关系
           -->
      <form action="vote/vote09" method="post">
            主人号:<input type="text" name="id">
            主人名:<input type="text" name="masterName"> <br>
            宠物名:<input type="text" name="pet.petName"> <br>
            <input type="submit" value="添加宠物">
      </form>
      <h1>测试prepare的使用</h1>
      <a href="vote/vote08"> 请求为updateMessage</a>
      <br>
      <a  href="/vote/vote01">请求测试 testo1</a>
      <a  href="/vote/vote09?username=tom100">点击请求测试 testo1</a>
</body>
</html>
