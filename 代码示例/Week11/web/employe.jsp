<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2020/1/13
  Time: 12:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="script/jquery-1.4.4.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(function () {
            //绑定delBook的click事件
            $("#delEmp").click(function () {
                //获取到点击删除的超链接
                var url = this.href;
                //给 隐藏表单的 action 赋值  url
                $("#hiddenForm").attr("action", url);
                //给隐藏表单的 hidden的值赋值 DELETE
                $(":hidden").val("DELETE");
                //提交表单
                $("#hiddenForm").submit();
                //必须返回false
                return false;
            })
        })
    </script>
</head>
<body>
<h1><a href="emp/emp01/100">查询公司职员的信息</a></h1> <br>

<h1> 添加信职员</h1>
<form action="emp/emp02" method="post">
    姓名<input type="text" name="name"> <br>
    密码<input type="text" name="paw"> <br>
    添加日期<input type="text" name="date"> <br>
    <input type="submit" value="提交">
</form>


<H1>删除</H1>
<a href="emp/emp03/200" id="delEmp"> 删除信息</a>
<!--转成rest 风格-->
<form action="" method="post" id="hiddenForm">
    <input type="hidden" name="_method">
</form>

<h1>updated更新</h1>
<form action="emp/emp04" method="post">
    姓名<input type="text" name="name"> <br>
    密码<input type="text" name="paw"> <br>
    添加日期<input type="text" name="date"> <br>
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改书籍">
</form>
<%--    -->--%>
<%--    <form action="" method="post" id="hiddenForm">--%>
<%--        <input type="hidden" name="_method">--%>
<%--    </form>--%>

</body>
</html>
