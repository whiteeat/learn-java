<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/14
  Time: 11:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-1.4.2.min.js"></script>
  <!-- 编写jq代码请求 #id 选择器  .类选择器-->
    <script type="text/javascript">

          $(function () {
              $("#getJson").click(function () {

                  var  href =  this.href;

                  var  args = {"time":new Date()};

                  $.post(href,args,function (data) {
                       if(data == null){
                             alert(href);
                       }
                       alert(" name " + data.name  + " address =" + data.address);
                    })
                  return false;
              })
          })
    </script>
</head>
<body>


    <h1> 请求一个json 数据</h1>
    <a href="getJson"   id="getJson"> 点击获取json数据</a>
</body>
</html>
