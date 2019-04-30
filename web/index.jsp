<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>190429</title>
  </head>
  <body>
<!--html标签，编写一个form表单完成用户数据的收集
    post代表post请求，Servlet的doPost方法会自动调用
    action 跳转的目标地址：Servlet地址在web.xml中有配置

-->

  <ul>
      <li><a href="save.jsp">添加商品</a> </li>
      <li><a href="search.jsp">查询商品</a> </li>
  </ul>

<%--  <form action="/webcai/ProductServlet" method="post">--%>
<%--      <!--后台是通过name属性的值，来确定数据的获取-->--%>
<%--      商品名：<input type="text" name="name"/><br/>--%>
<%--      商品价格：<input type="text" name="price"/><br/>--%>
<%--      商品备注：<input type="text" name="remark"/><br/>--%>
<%--      <button type="submit">添加商品</button>--%>
<%--      <input type="hidden" name="type" value="save">--%>
<%--  </form>--%>

  </body>
</html>
