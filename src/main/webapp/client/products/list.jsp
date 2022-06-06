<%@ page import="fpt.aptech.t2009m1helloworld.controller.product.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: uinhi
  Date: 6/6/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Product> products = (List<Product>) request.getAttribute("product");
%>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>List Product</h1>
<ul>
    <%for (Product product: products) {%>
    <li>
        <%=product.toString()%> &nbsp;
        <a href="/shopping-cart/add?productId=<%product.getId()%>&quantity=1">Add to cart</a>
    </li>
    <%}%>
</ul>
</body>
</html>
