<%--<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: zhou--%>
<%--  Date: 2020/1/14--%>
<%--  Time: 12:21 上午--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash;       <H1>添加页面</H1>&ndash;%&gt;--%>
<%--       <h1>添加怪物~</h1>--%>
<%--       <!-- 添加怪物是，我们使用springmvc标签--%>
<%--           1.引入springMVC标签form:form--%>
<%--           2.path属性类似我们以前写的name属性--%>
<%--           3.如果我们使用springmvc from标签后，要求必须给一个 modelAttribute值，这个值--%>
<%--           表示的是model的属性名，即使是空的给一个.,否则报错--%>
<%--        -->--%>
<%--&lt;%&ndash;        <from:form action="monsters" method="post"  modelAttribute="monster">&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪名字:<form:input path="monsterName"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪年龄:<form:input path="age"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪生日:<form:input path="birthday"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪薪水:<form:input path="salary"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪电邮:<form:input path="email"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪性别:<form:radiobuttons path="gender"  items="${requestScope.genders}" />&ndash;%&gt;--%>
<%--&lt;%&ndash;            妖怪门派:<from:select path="school.schoolId" items="${requestScope.schools}"  itemLabel="schoolName"  itemValue="schoolId">&ndash;%&gt;--%>
<%--&lt;%&ndash;        </from:select>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <input type="submit" value="添加怪物">&ndash;%&gt;--%>
<%--&lt;%&ndash;        </from:form>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>添加怪物~</h1>
<!-- 添加怪物是，我们使用springmvc标签
    1.引入springMVC标签form:form
    2.path属性类似我们以前写的name属性
    3.如果我们使用springmvc from标签后，要求必须给一个 modelAttribute值，这个值
    表示的是model的属性名，即使是空的给一个.,否则报错
    标签要中的数据要在 modelAttribute 去拿到
 -->
<form:form action="monsters" method="post"  modelAttribute="monster">
    妖怪名字:<form:input path="monsterName" /> <form:errors path="monsterName"></form:errors><br><br>
    妖怪年龄:<form:input path="age" /><form:errors path="age"></form:errors><br><br>
    妖怪生日:<form:input path="birthday" /><form:errors path="birthday"></form:errors><br><br>
    妖怪薪水:<form:input path="salary" /><form:errors path="salary"></form:errors><br><br>
    妖怪电邮:<form:input path="email" /><form:errors path="email"></form:errors><br><br>
    妖怪性别 :<form:radiobuttons path="gender"  items="${requestScope.genders}"/><br><br>
    <%--
        school.schoolId: 将来提交给handler时的名字
        items="${requestScope.schools }: 遍历形成 <option></option>
        itemLabel="schoolName" 就是<option>???</option>
        itemValue="schoolId" 就是 <option value="??"></option>
     --%>
    妖怪门派:<form:select path="school.schoolId" items="${requestScope.schools}"
                      itemLabel="schoolName" itemValue="schoolId">
</form:select><br><br>
    <input type="submit" value="添加怪物">
</form:form>
</body>
</html>