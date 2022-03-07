<%-- 
    Document   : salary
    Created on : Mar 7, 2022, 9:12:44 PM
    Author     : ADMIN
--%>

<%@page import="java.time.YearMonth"%>
<%@page import="model.ReportWorkerSalary"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Báo cáo | Tiền lương</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <%
            ArrayList<ReportWorkerSalary> salaries = (ArrayList<ReportWorkerSalary>) request.getAttribute("salary");
            YearMonth ym = (YearMonth) request.getAttribute("ym");
        %>

    </head>
    <body>
        <div>

            <div class="justify-content-center">
                <h1>Báo cáo lương công nhân</h1>
                <form action="salary" method="POST">

                    <div class="form-group">
                        <label for="month">Nhập tháng cần báo cáo:</label>
                        <input type="month"  name="month" value="<%=(ym.getYear() == 1) ? "" : ym%>" selected="selected">
                    </div>

                    <div class="form-group">               
                        <input type="submit" value="Search">
                    </div>
                </form>
            </div>

            <%if (salaries.size() > 0) {%>
            <div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">Mã NV</th>
                            <th scope="col">Tên nhân viên</th>
                            <th scope="col">SĐT</th>
                            <th scope="col">Lương Cứng</th>
                            <th scope="col">thưởng/SP</th>
                            <th scope="col">Số SP</th>
                            <th scope="col">Tổng Lương</th>

                        </tr>
                    </thead>
                    <tbody>
                        <%for (ReportWorkerSalary s : salaries) {%>
                        <tr>
                        <th scope="col"><%=s.getWorker().getWid()%></th>
                        <th scope="col"><%=s.getWorker().getWname()%></th>
                        <th scope="col"><%=s.getWorker().getPhoneNumber()%></th>
                        <th scope="col"><%=s.getWorker().getMonthSalary()%></th>
                        <th scope="col"><%=s.getWorker().getProductSalary()%></th>
                        <th scope="col"><%=s.getCount()%></th>
                        <th scope="col"><%=(s.getWorker().getMonthSalary() + s.getWorker().getProductSalary() * s.getCount()) %> VNĐ</th>
                        </tr>
                        <%}%>

                    </tbody>
                </table>
            </div>
            <%} else {%>
            Không có dữ liệu để hiển thị.
            <%}%>

        </div>
    </body>
</html>
