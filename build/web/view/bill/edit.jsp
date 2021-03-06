<%-- 
    Document   : edit
    Created on : Feb 21, 2022, 1:27:57 PM
    Author     : ADMIN
--%>

<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Owner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Bill</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="../asset/css/FormStyle.css">        
        <%
            ArrayList<Owner> ownerList = (ArrayList<Owner>) request.getAttribute("ownerList");
            Bill bill = (Bill) request.getAttribute("bill");
        %>
    </head>
    <body>
        <div class="container">
            <h2 style="text-align: center">Sửa Thông Tin Nguồn Hàng Có Mã: <%=bill.getBid()%></h2>
            <form action="edit" method="POST">

                <div class="form-row">
                    <div class="form-group col-md-12">
<!--                        <label for="bid">Update thông tin cho đơn hàng có mã: </label>-->
                        <input type="hidden" name="bid" value="<%=bill.getBid()%>" placeholder="Nhập mã đơn hàng">
                    </div>

                </div>
                <div class="form-row">

                    <div class="form-group col-md-12">
                        <label for="cname">Tên linh kiện</label>
                        <input type="text" name="cname" value="<%=bill.getCname()%>" class="form-control" placeholder="Nhập tên linh kiện">
                    </div>

                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="category">Thể loại</label>
                        <input type="text" name="category" value="<%=bill.getCategory()%>" class="form-control" placeholder="Nhập thể loại">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="quantity">Số lượng</label>
                        <input type="text" name="quantity" value="<%=bill.getQuantity()%>" class="form-control" placeholder="Nhập số lượng">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="unitprice">Đơn giá</label>
                        <input type="text" name="unitprice" value="<%=bill.getUnitPrice()%>" class="form-control" placeholder="Đơn giá">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="total">Thanh toán</label>
                        <input type="text" name="total" value="<%=bill.getTotal()%>" class="form-control" placeholder="Nhập số tiền">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="inputDate">Ngày nhập</label>
                        <input type="date" name="inputDate" value="<%=bill.getInputDate()%>" class="form-control" placeholder="Chọn ngày">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="origin">xuất xứ</label>
                        <input type="text" name="origin" value="<%=bill.getOrigin()%>" class="form-control" placeholder="Nhập xuất xứ">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-6">
                        <label for="supplier">Nhà cung cấp</label>
                        <input type="text" name="supplier" value="<%=bill.getSupplierName()%>" class="form-control" placeholder="Tên nhà cung cấp">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="contact">Liên hệ</label>
                        <input type="text" name="contact" value="<%=bill.getContact()%>" class="form-control" placeholder="Thông tin liên hệ">
                    </div>
                </div>
                <div class="form-row">

                    <div class="form-group col-md-8">
                        <label for="address">Địa chỉ</label>
                        <input type="text" name="address" value="<%=bill.getAddress()%>" class="form-control" placeholder="Địa chỉ nhà cung cấp">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="oname">Bên mua</label>
                        <select name="oname" class="form-control">

                            <%for (Owner o : ownerList) {%>
                            <option 
                                <%=(bill.getOwner().getOname() == o.getOname()) ? "selected=\"selected\"" : ""%>
                                value="<%=o.getOname()%>">
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
