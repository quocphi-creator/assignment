<%-- 
    Document   : register
    Created on : Mar 13, 2022, 10:52:24 PM
    Author     : ADMIN
--%>

<%@page import="model.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tài khoản | Đăng ký</title>
        <!--<link rel="stylesheet" href="../asset/css/registerStyle.css"><link >-->
        <link rel="stylesheet" href="../asset/css/FormStyle.css">        

        <%
            ArrayList<Group> groups = (ArrayList<Group>) request.getAttribute("groups");
        %>

    </head>
    <body>
        <div class="container">
            <form action="register" method="POST">
                <div>
                    <h1>Đăng ký tài khoản</h1>
                    <p>Vui lòng nhập thông tin vào các dòng sau.</p>
                    <hr>

                    <div class="form-control">
                        <label for="username"><b>Tên tài khoản</b></label>
                        <input type="text" name="username" placeholder="Nhập tên tài khoản (không chứa ký tự đặc biệt và dấu cách)" name="psw" id="psw" required>

                    </div>

                    <div class="form-control">
                        <label for="password"><b>Mật khẩu</b></label>
                        <input type="password" name="password" placeholder="Nhập mật khẩu" name="psw-repeat" id="psw-repeat" required>
                    </div>

                    <div class="form-row form-control">
                        <label for="group">Vai trò của của bạn:</label>
                        <select name="group" class="form-control">

                            <%for (Group g : groups) {%>
                            <option value="<%=g.getGid()%>">
                                <%=g.getGname()%>
                            </option>
                            <%}%>

                        </select>
                    </div>
                    <hr>
                    <p>Chú ý: Tên tài khoản phải là duy nhất</p>

                    <button type="submit" class="registerbtn">Đăng ký</button>
                </div>

                <div class="container signin">
                    <p>Bạn đã có tài khoản? <a href="http://localhost:8080/ProductionManager/account/login">Đăng nhập</a>.</p>
                </div>
            </form>
        </div>>
    </body>
</html>
