<%-- 
    Document   : insert
    Created on : Feb 23, 2022, 9:17:01 PM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | Insert</title>
        
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
        <h3>Thêm nhân viên</h3>

        <div>
            <form action="insert" method="POST">
                <label for="wid">Worker ID</label>
                <input type="text" name="wid" placeholder="Nhập mã nhân viên">

                <label for="wname">Worker Name</label>
                <input type="text" name="wname" placeholder="Nhập tên nhân viên">

                <label for="phoneNumber">Phone number</label>
                <input type="text" name="phoneNumber" placeholder="Nhập Số điện thoại">

                <label for="monthSalary">Month salary</label>
                <input type="text" name="monthSalary" placeholder="Nhập lương/tháng">
                
                <label for="productSalary">Phone number</label>
                <input type="text" name="productSalary" placeholder="Nhập lương/SP">
                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
