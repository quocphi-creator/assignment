<%-- 
    Document   : search
    Created on : Feb 26, 2022, 5:02:53 PM
    Author     : ADMIN
--%>

<%@page import="java.time.YearMonth"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product | Search</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <%
            ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
            YearMonth ym = (YearMonth) request.getAttribute("ym");
        %>

        <script>
            function deleteProduct(pid) {
                var result = confirm("Bạn có chắc muốn xóa sản phẩm này ?");
                if (result) {
                    window.location.href = "delete?pid="+pid;
                }
            }
        </script>
    </head>
    <body>
        <div class="justify-content-center">
            <h1>Báo cáo Sản phẩm</h1>
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

        <%if (products.size() > 0) {%>
        <div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Thể loại</th>
                        <th scope="col">Mẫu mã</th>
                        <th scope="col">Đơn giá</th>
                        <th scope="col">Ngày sản xuất</th>
                        <th scope="col">Hạn bảo hành</th>
                        <th scope="col">hướng dẫn</th>
                        <th scope="col">Nhân viên</th>

                        <th scope="col" colspan="2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Product p : products) {%>
                    <tr>
                        <td scope="col"><%=p.getPid()%></td>
                        <td scope="col"><%=p.getPname()%></td>
                        <td scope="col"><%=p.getCategory()%></td>
                        <td scope="col"><%=p.getModel()%></td>
                        <td scope="col"><%=p.getPrice()%></td>
                        <td scope="col"><%=p.getManufactureDate()%></td>
                        <td scope="col"><%=p.getExpireDate()%></td>
                        <td scope="col"><%=p.getGuid()%></td>
                        <td scope="col"><%=p.getWorker().getWname()%></td>
                        <td scope="col"><a href="#" onclick="deleteProduct(<%=p.getPid()%>)">Xóa</a></td>
                        <td scope="col"><a href="edit?pid=<%=p.getPid()%>">Chỉnh sửa</a></td>

                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <%} else {%>
        <h2>No record to display</h2>
        <%}%>
        <a href="insert">Insert</a>
        </div>
</body>
</html>
