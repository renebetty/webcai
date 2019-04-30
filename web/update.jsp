<%--
  Created by IntelliJ IDEA.
  User: 76534
  Date: 2019/4/30
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这里是更新页面</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ProductServlet" method="post">
    <!-- 后台是通过name属性指定的值,来进行数据的获取 -->
    商品名:<input type="text" name="name" value="${requestScope.product.name}"/><br/>
    商品价格:<input type="text" name="price" value="${requestScope.product.price}"/><br/>
    商品备注:<input type="text" name="remark" value="${requestScope.product.remark}"/></br>
    <input type="hidden" name="type" value="update" />
    <input type="hidden" name="id" value="${requestScope.product.id}" />
    <button type="submit">更新商品</button>
</form>
</body>
</html>
