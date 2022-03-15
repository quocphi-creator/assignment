<%-- 
    Document   : login
    Created on : Feb 16, 2022, 10:00:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/FormStyle.css">
        <link rel="stylesheet" href="../asset/css/loginStyle.css">
    </head>
    <body>

        <div class="container">
            <form action="login" method="post">
                <h1>Đăng nhập</h1>
                <div class="form-group">
                    <lable for="oname">User Name</lable>
                    <input type="text" name="oname" placeholder="Nhập user name" required="required">
                </div>

                <div class="form-group">
                    <lable for="password">Password</lable>
                    <input type="password" name="password" placeholder="Nhập Mật Khẩu" required="required">
                </div>

                <div class="form-group">
                    <input type="checkbox" value="remember" name="remember">
                    <label> Remember me </label>
                </div>
                
                <div class="form-group">
                    <input type="submit" value="Login">
                </div>
                <p>Bạn chưa có tài khoản? <a href="http://localhost:8080/ProductionManager/account/register">Đăng ký</a>.</p>
            </form>
        </div>

    </body>
</html>
