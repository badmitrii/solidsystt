<%-- 
    Document   : redirect
    Created on : 17.07.2014, 7:01:51
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link type="text/css" href="../../styles/mainpage.css" rel="stylesheet">

    </head>
    <body>
        <style>
            <%@include file="WEB-INF/styles/mainpage.css" %>
        </style>
        <div class="main">
            <input type="button" class="but" id="task1" value="Список товаров"/>
            <input type="button" class="but" id="task2" value="Продажи"/>
        </div>
        <div class="helper"> </div>
        <script>
            var task1 = document.getElementById("task1");
            var task2 = document.getElementById("task2");
            task1.onclick = function() {
                window.location = '/SolidSystemsTestTask/products.htm';
            }
            task2.onclick = function() {
                window.location = '/SolidSystemsTestTask/sales.htm';
            }
        </script>
    </body>
</html>