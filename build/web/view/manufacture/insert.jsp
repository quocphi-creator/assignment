<%-- 
    Document   : insert
    Created on : Mar 5, 2022, 9:04:08 AM
    Author     : ADMIN
--%>

<%@page import="model.ManufactureDetail"%>
<%@page import="model.Worker"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manufacture | Insert</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/FormStyle.css">
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
            <h3>Nhập Thông Tin Sản Xuất</h3>
            <form action="insert" method="POST">

                <div class="form-row">
                    <label for="mid">Mã SX</label>
                    <input type="text" name="mid" placeholder="Nhập mã sản xuất" >
                </div>

                <div class="form-row">
                    <label for="producted">Số linh kiện đã sản xuất</label>
                    <input type="text" name="producted" placeholder="Nhập số lượng linh kiện đã được sản xuất.." required="required">
                </div>

                <div class="form-row">
                    <label for="removed">Số linh kiện bị loại bỏ</label>
                    <input type="text" name="removed" placeholder="Nhập số lượng linh kiện đã bị hỏng.." required="required">
                </div>




                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="outputdate">Ngày xuất kho</label>
                        <input type="date" name="outputdate" class="form-control" placeholder="Nhập ngày xuất kho" required="required">
                    </div>  


                    <div class="form-group col-md-4">
                        <label for="wid">Người phụ trách</label>
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


                <div>
                    <input type="submit" value="Submit">
                </div>

            </form>
        </div>
    </body>
</html>
