<%-- 
    Document   : search
    Created on : Feb 22, 2022, 10:28:01 PM
    Author     : ADMIN
--%>

<%@page import="model.Worker"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Worker | Search</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/WorkerSearchBar.css">
        <%
            ArrayList<Worker> workers = (ArrayList<Worker>) request.getAttribute("workers");
        %>
    </head>
    <body>
        <div class="topnav">
            <p2 class="active" href="#home>Thông tin công nhân</p2>
            
            <div class="search-container">
                <form action="search" method="POST">
                    <input type="text" placeholder="Search name" name="wname">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
            </div>
        </div>

        <%if (workers.size() > 0) {%>
        <div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Mã nhân viên</th>
                        <th scope="col">Tên nhân viên</th>
                        <th scope="col">Số điện thoại</th>
                        <th scope="col">Lương/tháng</th>
                        <th scope="col">Lương/Sản phẩm</th>
                        <th scope="col" colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Worker w : workers) {%>
                    <tr>
                        <td scope="col"><%=w.getWid()%></td>
                        <td scope="col"><%=w.getWname()%></td>
                        <td scope="col"><%=w.getPhoneNumber()%></td>                          
                        <td scope="col"><%=w.getMonthSalary()%>  (VNĐ/Tháng)</td>
                        <td scope="col"><%=w.getProductSalary()%>(VNĐ/SP)</td>

                        <td scope="col"><a href="#">Xóa</a></td>
                        <td scope="col"><a href="edit?wid=<%=w.getWid()%>">Chỉnh sửa</a></td>

                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%} else {%>
        <h2>No record to display</h2>
        <%}%>
        <a href="insert">Insert
    </body>
</html>
