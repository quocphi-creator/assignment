<%-- 
    Document   : listbill
    Created on : Mar 4, 2022, 2:48:57 AM
    Author     : ADMIN
--%>

<%@page import="model.Bill"%>
<%@page import="model.ManufactureDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bill list</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <%
            ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
        %>
        <style>

            * {box-sizing: border-box;}

            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            .topnav {
                overflow: hidden;
                background-color: #e9e9e9;
            }

            .topnav a {
                float: left;
                display: block;
                color: black;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            .topnav a.active {
                background-color: #2196F3;
                color: white;
            }

            .topnav .search-container {
                float: right;
            }

            .topnav input[type=text] {
                padding: 6px;
                margin-top: 8px;
                font-size: 17px;
                border: none;
            }

            .topnav .search-container button {
                float: right;
                padding: 6px 10px;
                margin-top: 8px;
                margin-right: 16px;
                background: #ddd;
                font-size: 17px;
                border: none;
                cursor: pointer;
            }

            .topnav .search-container button:hover {
                background: #ccc;
            }

            @media screen and (max-width: 600px) {
                .topnav .search-container {
                    float: none;
                }
                .topnav a, .topnav input[type=text], .topnav .search-container button {
                    float: none;
                    display: block;
                    text-align: left;
                    width: 100%;
                    margin: 0;
                    padding: 14px;
                }
                .topnav input[type=text] {
                    border: 1px solid #ccc;  
                }
            }
        </style>

    </head>
    <body>
        <div class="topnav">
            <a class="active" href="#">Home</a>
            <a href="list">Quản lý kho linh kiện</a>
            
            <div class="search-container">
                <form action="list" method="POST">
                    <input type="text" name="bname" placeholder="Search tên linh kiện.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
    </div>

    <%if (bills.size() > 0) {%>
    <div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Mã Đơn</th>
                    <th scope="col">Tên linh kiện</th>
                    <th scope="col">Thể loại</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Đầu vào</th>
                    <th scope="col">Đã SX</th>
                    <th scope="col">Bị hỏng</th>
                    <th scope="col">Còn lại</th>
                    <th scope="col">Thao tác</th>
                    
                </tr>
            </thead>
            <tbody>
                <%for (Bill b : bills) {%>
                <tr>
                    <td scope="col"><%=b.getBid()%></td>
                    <td scope="col"><%=b.getCname()%></td>
                    <td scope="col"><%=b.getCategory()%></td>
                    <td scope="col"><%=b.getUnitPrice()%></td>
                    <td scope="col"><%=b.getQuantity()%></td>
                    <td scope="col"></td>
                    <td scope="col"></td>
                    <td scope="col"></td>
                    <td scope="col">
                        <form action="export" method="POST">
                            <input type="hidden" name="bid" value="<%=b.getBid()%>">
                            <input type="submit" value="Xuất kho">
                        </form>
                    </td>
                </tr>
                <%}%>

            </tbody>
        </table>
    </div>
    <%} else {%>
    <h2>No record to display</h2>
    <%}%>
    
</body>
</html>
