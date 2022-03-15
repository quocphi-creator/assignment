<%-- 
    Document   : edit
    Created on : Feb 23, 2022, 11:27:04 PM
    Author     : ADMIN
--%>

<%@page import="model.Worker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | Edit</title>
        <%
            Worker worker = (Worker)request.getAttribute("worker");
        %>
            
        <style>
            input[type=text], select {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            input[type=submit] {
                width: 100%;
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            input[type=submit]:hover {
                background-color: #45a049;
            }

            div {
                border-radius: 5px;
                background-color: #f2f2f2;
                padding: 20px;
            }
        </style>
    </head>
    <body >
        <h2 style="text-align: center">Chỉnh Sửa Thông Tin Nhân Viên Có Mã: <%=worker.getWid()%></h2>

        <div>
            <form action="edit" method="POST">
                <!--<label for="wid">Worker ID: <%--= //worker.getWid()--%></label>-->
                <input type="hidden" name="wid" value="<%=worker.getWid()%>" placeholder="Nhập mã nhân viên">
            <br>
                <label for="wname">Worker Name</label>
                <input type="text" name="wname" value="<%=worker.getWname()%>" placeholder="Nhập tên nhân viên">

                <label for="phoneNumber">Phone number</label>
                <input type="text" name="phoneNumber" value="<%=worker.getPhoneNumber()%>" placeholder="Nhập Số điện thoại">

                <label for="monthSalary">Month salary</label>
                <input type="text" name="monthSalary" value="<%=worker.getMonthSalary()%>" placeholder="Nhập lương/tháng">
                
                <label for="productSalary">Phone number</label>
                <input type="text" name="productSalary" value="<%=worker.getProductSalary()%>" placeholder="Nhập lương/SP">
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>

