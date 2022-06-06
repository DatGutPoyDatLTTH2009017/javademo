<%@ page import="fpt.aptech.t2009m1helloworld.util.ShoppingCartHelper" %>
<%@ page import="fpt.aptech.t2009m1helloworld.entity.ShoppingCart" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="fpt.aptech.t2009m1helloworld.entity.CartItem" %><%--
  Created by IntelliJ IDEA.
  User: uinhi
  Date: 6/6/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(request);
    ShoppingCart shoppingCart = shoppingCartHelper.getCart();
    Locale loc = new Locale("vi","VN");
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h1>List products in shopping cart</h1>
<ul>
    <%for (CartItem cartItem : shoppingCart.getListItems()){%>
    <li>
        <%=cartItem.getProductName%>
        <%=nf.format(cartItem.getUnitPrice)%>
        <%=cartItem.getQuantity%>
        <a href="/shopping-cart/add?productId=<%=cartItem.getProductId()%>&quantity=1" style="...">+</a>
        <a href="/shopping-cart/sub?productId=<%=cartItem.getProductId()%>&quantity=1" style="...">-</a>
        <a href="/shopping-cart/remove?productId=<%=cartItem.getProductId()%>" style="...">x</a>
    </li>
    <%}%>
</ul>
<strong>Total price: <%nf.format(shoppingCart.getTotalPrice())%></strong>
<div>
    <strong><a href="/products">Back to shopping</a></strong>
</div>
</body>
</html>
