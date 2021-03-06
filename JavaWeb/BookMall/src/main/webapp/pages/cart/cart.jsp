<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("确认删除【" + $(this).parent().parent().find("td:first").text() + "】？");
            });
            $("a.clearItems").click(function () {
                return confirm("确认清空购物车？");
            });
            $(".updateItem").change(function () {     //给输入框绑定内容发生改变事件
                let bookId = $(this).attr("bookId");
                let count = this.value;
                if (confirm("确定将商品数量修改为" + count + "？")) {
                    location.href = "${basePath}cartServlet?action=updateItem&id=" + bookId + "&count=" + count;
                } else {
                    this.value = this.defaultValue;     //defaultValue是默认的value值
                }
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%@include file="/pages/common/message.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>${item.value.name}</td>
                <td><input type="text" value="${item.value.count}" bookId="${item.value.id}" class="updateItem"
                           style="width: 70px;"></td>
                <td>${item.value.price}</td>
                <td>${item.value.totalPrice}</td>
                <td><a href="cartServlet?action=deleteItem&id=${item.value.id}" class="deleteItem">删除</a></td>
            </tr>
        </c:forEach>

    </table>

    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="cartServlet?action=clear" class="clearItems">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=creatOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/footer.jsp" %>

</body>
</html>