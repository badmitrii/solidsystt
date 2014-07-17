<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
    <style>
        <%@include file="../styles/styles.css" %>
    </style>

    <table>
        <tr>
            <th class="header_content">Наименование</th>
            <th class="header_content">Стоимость</th>
        </tr>
        <c:forEach var="product" begin="0" step="1" items="${products}">
            <tr>
                <td class="content">${product.name}</td>
                <td class="content">${product.cost}</td>
                <td class="button_left_content"><input type="button" class="button_left" name="${product.id}" value="Удалить"></td>
                <td class="button_right_content"><input type="button" class="button_right" name="${product.name}" value="Продажи"></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4"> 
                <input class="add" type="button" id="addbut" value="Добавить новый товар">
            </td>
        </tr>
        <tr>
            <td colspan="4"> 
                <input class="add" type="button" id="updatebut" value="Изменить существующий товар">
            </td>
        </tr>
    </table>
    <form id="modfrm" class="modifierForm">
        <p id = "saleinfo">
        </p>
        <div id= "changeinfo">
            <div id="add">
                <p>Наименование</p>
                <input id="nameadd" class="input_class" type="text">
            </div>
            <div id="modifier">
                <p>Наименование</p>
                <select id="namemod" class="input_class" type="text">
                    <c:forEach var="product" begin="0" step="1" items="${products}">
                        <option value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
                <p>Новое названи</p>
                <input id="newnameadd" class="input_class" type="text">
            </div>
            <p>Цена</p>
            <input id= "cost" class="input_class" type="text">
            <input id="update" class="button_foot" type="button" value="Обновить">
            <input id="create" class="button_foot" type="button" value="Создать">
        </div>
    </form>
    <script>
        <%@include file="../js/script.js" %>
    </script>
</body>
</html>
