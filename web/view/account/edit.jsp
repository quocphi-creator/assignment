<%-- 
    Document   : login
    Created on : Feb 16, 2022, 10:00:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/FormStyle.css">
        <link rel="stylesheet" href="../asset/css/loginStyle.css">

        <style>
            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: white;
                padding: 16px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                transition-duration: 0.4s;
                width: 142px;
                height: 50px;
                text-align: center;
                border-radius: 4px;
                padding: 12px 20px;
            }

            .button1 {
                background-color: white; 
                color: black; 
                border: 2px solid #4CAF50;
            }

            .button1:hover {
                background-color: #4CAF50;
                color: white;
            }

            .button2 {
                background-color: white; 
                color: black; 
                border: 2px solid #008CBA;
            }

            .button2:hover {
                background-color: #008CBA;
                color: white;
            }

            .button3 {
                background-color: white; 
                color: black; 
                border: 2px solid #f44336;
            }

            .button3:hover {
                background-color: #f44336;
                color: white;
            }

            .button4 {
                background-color: white;
                color: black;
                border: 2px solid #e7e7e7;
            }

            .button4:hover {background-color: #e7e7e7;}

            .button5 {
                background-color: white;
                color: black;
                border: 2px solid #555555;
            }

            .button5:hover {
                background-color: #555555;
                color: white;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <form action="edit" method="post">
                <h1 style="text-align: center">Thông tin tài khoản</h1>
                <div class="form-group">
                    <lable for="oname">Tên tài khoản</lable>
                    <input type="text" name="oname" value="${sessionScope.account.oname}" placeholder="Nhập user name" required="required">
                </div>

                <div class="form-group">
                    <lable for="password">Mật khẩu</lable>
                    <input type="password" name="password" value="${sessionScope.account.password}" placeholder="Nhập Mật Khẩu" required="required">
                </div>

                <div class="form-group">
                    <input type="submit" value="Save">
                    <button class="button button3" >
                        <a href="delete?oname=${sessionScope.account.oname}" onclick="return confirm('Bạn có chắc muốn xóa tài khoản ?')"> Xóa tài khoản
                    </button>
                </div>
                <!--                <div>
                                   
                                </div>-->

            </form>
        </div>

    </body>
</html>
