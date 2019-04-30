<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>商品查询页面</title>
</head>
<body>
<!-- method="get" 会跳转doGet方法中-->
<form action="<%=request.getContextPath()%>/ProductServlet" method="get">
        查询关键字<input type="text" name="keyword" value="${sessionScope.keyword}">
    <button>搜索</button>
    <input type="hidden" name="type" value="query">
</form>

<table border="1" width="600px">
    <!--tr行 td列 th标题-->
    <tr>
        <th>编号</th>
        <th>名字</th>
        <th>价格</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <!-- 有多个条记录,则会自动生成多少行-->
    <!--  html页面中如果显示java代码,则需要jstl标签-->
    <!-- jstl标签,首先要在页面顶部导入库 -->
    <!-- item用来存储集合信息, var用来存储迭代集合中的每个对象 -->
    <c:forEach items="${requestScope.proList}" var="product">
        <tr>
            <!-- 添加el表达式则说明表达式内部是一个变量 -->
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.remark}</td>
            <td>
                <a href="<%=request.getContextPath()%>/ProductServlet?id=${product.id}&type=delete">删除</a>|
                <a href="<%=request.getContextPath()%>/ProductServlet?id=${product.id}&type=getById">更新</a>

            </td>
        </tr>
    </c:forEach>

</table>


</body>
</html>
