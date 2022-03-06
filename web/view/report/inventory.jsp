<%-- 
    Document   : inventory
    Created on : Mar 6, 2022, 2:15:18 PM
    Author     : ADMIN
--%>

<%@page import="model.ReportInventory"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Báo cáo | Kho linh kiện</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <%
            ArrayList<ReportInventory> inventoryList = (ArrayList<ReportInventory>) request.getAttribute("inventoryList");
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
            <a class="active" href="#">Trang chủ</a>
            <a href="list">Quản lý kho linh kiện</a>

            <div class="search-container">
                <form action="inventory" method="POST">
                    <input type="text" name="cname" placeholder="Search tên linh kiện.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>
    </div>

    <%if (inventoryList.size() > 0) {%>
    <div>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">Mã LK</th>
                    <th scope="col">Tên linh kiện</th>
                    <th scope="col">Thể loại</th>
                    <th scope="col">Số lượng đầu vào</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Đã SX</th>
                    <th scope="col">Bị hỏng</th>
                    <th scope="col">Tồn kho</th>
                </tr>
            </thead>
            <tbody>
                <%for (ReportInventory inventory : inventoryList) {%>
                <tr>
                    <th scope="col"><%=inventory.getBill().getBid()%></th>
                    <th scope="col"><%=inventory.getBill().getCname()%></th>
                    <th scope="col"><%=inventory.getBill().getCategory()%></th>
                    <th scope="col"><%=inventory.getBill().getQuantity()%></th>
                    <th scope="col"><%=inventory.getBill().getUnitPrice()%></th>
                    <th scope="col"><%=inventory.getProducted()%></th>
                    <th scope="col"><%=inventory.getRemoved()%></th>
                    <th scope="col"><%=(inventory.getBill().getQuantity()- inventory.getProducted() - inventory.getRemoved())%></th>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    <%} else {%>
    Không có dữ liệu để hiển thị.
    <%}%>


</div>
</body>
</html>
