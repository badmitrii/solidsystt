<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            <%@include file="../styles/styles.css" %>
        </style>
        <table>
            <tr>
                <th class="header_content">Наименование</th>
                <th class="header_content">Количество</th>
                <th class="header_content">Сумма</th>
                <th class="header_content">Дата</th>
            </tr>
            <c:forEach var="sale" begin="0" step="1" items="${sales}">
                <tr>
                    <td class="content">${sale.prodname}</td>
                    <td class="content">${sale.count}</td>
                    <td class="content">${sale.sum}</td>
                    <td class="content">${sale.date}</td>
                    <td class="button_right_content"><input type="button" class="button_right" name="${sale.prodname}" value="Товар"></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="6"> 
                    <input class="add" type="button" id="addbut" value="Добавить информацию о продажах">
                </td>
            </tr>
        </table>
        <form id="modfrm" class="modifierForm">
            <div id="info">
                <span> </span>
            </div>
            <div id = "newsale">
                <p>Наименование</p>
                <select id="name" class="input_class">
                    <c:forEach var="product" begin="0" step="1" items="${products}">
                        <option value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
                <p>Количество</p>
                <input id="count" class="input_class" type="text">
                <p>Дата</p>
                <input id="date" class="input_class" type="text">
                <span id="datefooter">YYYY-MM-DD</span>
                <input id="create" class="button_foot" type="button" value="Создать">
            </div>
        </form>
        <script>
            <%@include file="../js/salescript.js" %>
        </script>
    </body>
</html>
