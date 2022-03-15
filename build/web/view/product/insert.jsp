<%-- 
    Document   : insert
    Created on : Feb 27, 2022, 12:55:18 AM
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Worker"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product | Insert</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <%
            ArrayList<Worker> workers = (ArrayList<Worker>) request.getAttribute("workers");
        %>
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
        

        <div class="container">
            <h2>Contact Form</h2>
            <form action="insert" method="POST">

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
                    <input type="text" name="category" placeholder="Nhập thể loại sản phẩm">
                </div>

                <div class="form-row">
                    <label for="model">Mẫu mã</label>
                    <input type="text" name="model" placeholder="Nhập mẫu mã sản phẩm">
                </div>

                <div class="form-row">
                    <label for="price">Đơn giá</label>
                    <input type="text" name="price" placeholder="Nhập đơn giá sản phẩm">
                </div>

                <div class="form-row">
                    <div class="col">
                        <label for="manufactureDate">Ngày sản xuất</label>
                        <input type="date" name="manufactureDate" class="form-control" value="">
                    </div>
                    <div class="col">
                        <label for="expireDate">Hạn bảo hành</label>
                        <input type="date" name="expireDate" class="form-control" value="">
                    </div>
                </div>


                <div class="form-row">
                    <div class="col">
                        <label for="guide">Hướng dẫn sử dụng</label>
                        <textarea name="guid" placeholder="Nhập hướng dẫn sử dụng" style="height:200px"></textarea>
                    </div>
                </div>

                <div>
                    <div class="form-row">


                        <div class="form-group col-md-4">
                            <label for="wid">Nhân viên</label>
                            <select name="wid" class="form-control">

                                <%for (Worker w : workers) {%>
                                <option 
                                    value="<%=w.getWid()%>">
                                    <%=w.getWname()%>
                                </option>
                                <%}%>

                            </select>
                        </div>
                    </div>
                </div>


                <div>
                    <input type="submit" value="Submit">
                </div>

            </form>
        </div>
    </body>
</html>
