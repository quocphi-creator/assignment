<%-- 
    Document   : search
    Created on : Mar 3, 2022, 2:06:11 AM
    Author     : ADMIN
--%>

<%@page import="java.time.YearMonth"%>
<%@page import="model.ManufactureDetail"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manufacturing | Search</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <script>
            function deleteManuDetail(mid) {
                var result = confirm("Bạn có chắc muốn xóa chi tiết này ?");
                if (result) {
                    window.location.href = "delete?mid="+mid;
                }
            }
        </script>
        
        <%
            ArrayList<ManufactureDetail> manuList = (ArrayList<ManufactureDetail>) request.getAttribute("manuList");
            YearMonth ym = (YearMonth) request.getAttribute("ym");
        %>
    </head>
    <body>
        <div class="justify-content-center">
            <h1>Chi Tiết Sản Xuất</h1>
            <form action="search" method="POST">

                <div class="form-group">
                    <label for="month">Nhập tháng cần báo cáo:</label>
                    <input type="month"  name="month" value="<%=(ym.getYear() == 1) ? "" : ym%>" selected="selected">
                </div>

                <div class="form-group">               
                    <input type="submit" value="Search">
                </div>
            </form>
        </div>
        
                
        <%if (manuList.size() > 0) {%>
        <div>
            
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Mã SX</th>
                        <th scope="col">ID-Tên linh kiện</th>
                        <th scope="col">Thể loại</th>
                        <th scope="col">Số lượng nhập</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Người phụ trách</th>
                        <th scope="col">Ngày xuất kho</th>
                        <th scope="col">Đã SX</th>
                        <th scope="col">Bị hỏng</th>
                        <th scope="col" colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (ManufactureDetail m : manuList) {%>
                    <tr>
                        <td scope="col"><%=m.getOrderID()%></td>
                        <td scope="col">(ID = <%=m.getBill().getBid()%>) <%=m.getBill().getCname()%></td>
                        <td scope="col"><%=m.getBill().getCategory()%></td>
                        <td scope="col"><%=m.getBill().getQuantity()%></td>
                        <td scope="col"><%=m.getBill().getUnitPrice()%></td>
                        <td scope="col"><%=m.getWorker().getWname()%></td>
                        <td scope="col"><%=m.getOutputDate()%></td>
                        <td scope="col"><%=m.getProducted()%></td>
                        <td scope="col"><%=m.getRemoved()%></td>
                        <td scope="col"><a href="edit?mid=<%=m.getOrderID()%>">Edit</td>
                        <td scope="col"><a href="#" onclick="deleteManuDetail(<%=m.getOrderID()%>)">Delete</td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%} else {%>
        <h2>No record to display</h2>
        <%}%>
        
        </div>
</body>
</html>
