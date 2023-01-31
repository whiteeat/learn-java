<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/13
  Time: 11:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script  type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.4.4.min.js"></script>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
           $(function () {

                $(".delMonster").click(function () {
                      //提示是否真的删除
                      var  flag  = confirm("你确定要删除该怪物吗？");
                      if(flag){
                          // 获取到删除 href
                          var  url = this.href;
                          // 给隐藏的表单的action赋值
                          $("#hiddenForm").attr("action",url);
                          //
                          // $(":hidden").val("DELETE");
                          // 提交表单
                          $("#hiddenForm").submit();
                          return false;
                      }else {
                           return false;
                      }
                })
           })
    </script>
</head>
<body>
    <h1>~妖怪在此聚会~</h1>
    <!-- 给删除请求提供一个隐藏的表单 -->
    <form  action=""  method="post"  id="hiddenForm">
            <input type="hidden"  name="_method"  value="DELETE">
    </form>

    <!-- 显示时，因为springMVC不擅长显示，因此这里我们使用jstl标签完成c -->



    <table  border="1" width="600">
     <tr>
         <th>编号</th>
         <th>名字</th>
         <th>电子邮件</th>
         <th>性别</th>
         <th>门派</th>
         <th>编辑</th>
         <th>删除</th>
     </tr>
     <!-- 使用foreach标签遍历取出妖怪 -->
     <c:forEach items="${requestScope.monsters}" var="monster">
          <tr>
               <td>${monster.monsterId}</td>
               <td>${monster.monsterName}</td>
               <td>${monster.email}</td>
               <td>${monster.gender ==1?"男":"女"}</td>
               <td>${monster.school.schoolName}</td>
<%--               <td>${monster.age}</td>--%>
               <td><a href="monsters/${monster.monsterId}" >编辑</a></td>
               <td> <a href="monster/${monster.monsterId}" class="delMonster">删除</a> </td>
          </tr>
     </c:forEach>
 </table>
</body>
</html>
