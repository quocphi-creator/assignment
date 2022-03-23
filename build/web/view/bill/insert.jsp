<%-- 
    Document   : insert
    Created on : Feb 20, 2022, 3:00:17 PM
    Author     : ADMIN
--%>

<%@page import="model.Owner"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Bill</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/FormStyle.css">        
        <%
            ArrayList<Owner> ownerList = (ArrayList<Owner>) request.getAttribute("ownerList");
        %>

    </head>
    <body>
        <div class="container">
            <h2>Thêm Nguồn Hàng</h2>
            <form action="insert" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="bid">Mã đơn hàng</label>
                        <input type="text" name="bid" class="form-control" placeholder="Nhập mã đơn hàng" required="required">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cname">Tên linh kiện</label>
                        <input type="text" name="cname" class="form-control" placeholder="Nhập tên linh kiện" required="required">
                    </div>

                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="category">Thể loại</label>
                        <input type="text" name="category" class="form-control" placeholder="Nhập thể loại" required="required">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="quantity">Số lượng</label>
                        <input type="text" name="quantity" class="form-control" placeholder="Nhập số lượng" required="required">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="unitprice">Đơn giá</label>
                        <input type="text" name="unitprice" class="form-control" placeholder="Đơn giá" required="required">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="total">Thanh toán</label>
                        <input type="text" name="total" class="form-control" placeholder="Nhập số tiền" required="required">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="inputDate">Ngày nhập</label>
                        <input type="date" name="inputDate" class="form-control" placeholder="Chọn ngày" required="required">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="origin">xuất xứ</label>
                        <input type="text" name="origin" class="form-control" placeholder="Nhập xuất xứ" required="required">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="supplier">Nhà cung cấp</label>
                        <input type="text" name="supplier" class="form-control" placeholder="Tên nhà cung cấp" required="required">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="contact">Liên hệ</label>
                        <input type="text" name="contact" class="form-control" placeholder="Thông tin liên hệ" required="required">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-8">
                        <label for="address">Địa chỉ</label>
                        <input type="text" name="address" class="form-control" placeholder="Địa chỉ nhà cung cấp" required="required">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="oname">Bên mua</label>
                        <select name="oname" class="form-control">

                            <%for (Owner o : ownerList) {%>
                            <option value="<%=o.getOname()%>">
                                <%=o.getOname()%>
                            </option>
                            <%}%>

                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
            </form>
        </div>


    </body>
</html>
