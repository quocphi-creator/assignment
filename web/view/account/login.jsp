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
        <title>Login Forms</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/LoginFormStyle.css">
        
    </head>
    <body>
        <div class="container-fluid background">
            <div class="row justify-content-center">
                <div class="col-md-3 col-sm-6 col-xs-12 row-container">
                    <form action="login" method="post">
                        <h1>Đăng nhập</h1>
                        <div class="form-group">
                            <lable for="oname">User Name</lable>
                            <input type="text" name="oname" placeholder="Nhập user name">
                        </div>
                        
                        <div class="form-group">
                            <lable for="password">Password</lable>
                            <input type="text" name="password" placeholder="Nhập Mật Khẩu">
                        </div>
                       
                        <div class="form-group">
                            <input type="checkbox" value="remember" name="remember">
                            <label> Remember me </label>
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" value="Login">
                        </div>
                    </form>
                </div>
            </div>
        </div>





        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script src="../js/LoginFormScript.js"></script>
    </body>
</html>
