<%-- 
    Document   : search
    Created on : Feb 19, 2022, 2:42:30 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search bill</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">



    </head>
    <body>
        <div class="container-fluid">
            <div class="justify-content-center">
                <h1>Báo cáo đơn hàng</h1>
                <form action="search" method="POST">
                    <div class="form-group">
                        <lable for="year">Year</lable>
                        <input type="text" name="year" placeholder="Nhập năm cần báo cáo">
                    </div>

                    <div class="form-group">
                        <lable for="month">Month</lable>
                        <select name="month">
                            <option value="-1">Báo cáo năm</option>
                            <% for (int i = 1; i <= 12; i++) {%>
                            <option value="<%=i%>"> Báo cáo tháng <%=i%>
                            </option>
                            <%}%>
                        </select>
                    </div>

                    <div class="form-group">               
                        <input type="submit" value="Search">
                    </div>
                </form>

            </div>

            <div>
                <table>

                </table>
            </div>
        </div>
    </body>
</html>
