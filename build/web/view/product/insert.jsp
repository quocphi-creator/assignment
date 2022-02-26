<%-- 
    Document   : insert
    Created on : Feb 27, 2022, 12:55:18 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #04AA6D;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <body>
        <h3>Contact Form</h3>

        <div class="container">
            <form action="search" method="POST">

                <div class="form-row">
                    <label for="pid">Mã sản phẩm</label>
                    <input type="text" name="pid" placeholder="Nhập mã sản phẩm">
                </div>

                <div class="form-row">
                    <label for="pname">Tên sản phẩm</label>
                    <input type="text" name="pname" placeholder="Nhập tên sản phẩm">
                </div>

                <div class="form-row">
                    <label for="category">Thể loại</label>
                    <input type="text" name="model" placeholder="Nhập thể loại sản phẩm">
                </div>

                <div class="form-row">
                    <label for="model">Mẫu mã</label>
                    <input type="text" name="model" placeholder="Nhập thể loại sản phẩm">
                </div>

                <div class="form-row">
                    <div>
                        <label for="manufactureDate">Ngày sản xuất</label>
                        <input type="date" name="manufactureDate" class="form-control" value="">
                    </div>
                    <div>
                        <label for="expireDate">Hạn sử dụng</label>
                        <input type="date" name="expireDate" class="form-control" value="">
                    </div>
                </div>

                <div>
                    <label for="guide">Hướng dẫn sử dụng</label>
                    <textarea name="model" placeholder="Nhập hướng dẫn sử dụng" style="height:200px"></textarea>

                </div>

                <div>
                    <label for="month">Search month</label>

                    <input type="month" name="month" value="2018-05">
                </div>

                <div>
                    <input type="submit" value="Submit">
                </div>

            </form>
        </div>
    </body>
</html>
