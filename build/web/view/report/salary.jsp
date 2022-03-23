<%-- 
    Document   : search
    Created on : Feb 19, 2022, 2:42:30 PM
    Author     : ADMIN
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="model.ReportWorkerSalary"%>
<%@page import="model.ManufactureDetail"%>
<%@page import="java.time.YearMonth"%>
<%@page import="model.Product"%>
<%@page import="model.Product"%>
<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Báo cáo | Lương công nhân</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../asset/css/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

        <%
            ArrayList<ReportWorkerSalary> salaries = (ArrayList<ReportWorkerSalary>) request.getAttribute("salary");
            YearMonth ym = (YearMonth) request.getAttribute("ym");
            String monthStr = "";
            if (ym.getMonthValue() < 10) {
                monthStr = "0" + ym.getMonthValue();
            } else {
                monthStr = String.valueOf(ym.getMonthValue());
            }
        %>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="http://localhost:8080/ProductionManager/report/inventory">Trang Quản trị</a>




            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>


            <!-- Navbar Search-->
            <!--            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                            <div class="input-group">
                                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                                <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                            </div>
                        </form>-->

            <div class="form-agline">

                <form action="salary" method="GET" id="search-month">

                    <div class="form-group" id="month-input">
                        <!--<p for="month">Tháng cần báo cáo:</p>-->
                        <input type="month"  name="month" value="<%=(ym.getYear() == 1) ? "" : ym%>" selected="selected">
                        <input type="submit" value="Search">
                    </div>

                    <!--                    <div class="form-group" id="search-btn">               
                                            <input type="submit" value="Search">
                                        </div>-->
                </form>
            </div>

            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="http://localhost:8080/ProductionManager/account/edit">Tài khoản</a></li>

                        <li><a class="dropdown-item" href="http://localhost:8080/ProductionManager/account/logout">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">

                            <div class="sb-sidenav-menu-heading">Tác vụ</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Danh sách
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/bill/search">Danh sách nguồn hàng </a>
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/product/search">Danh sách sản phẩm</a>
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/worker/search">Danh sách nhân công</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Báo cáo
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Sản xuất
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/manufacture/search">Báo cáo chi tiết</a>
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/report/inventory">Tồn kho linh kiện</a>
                                            <!--<a class="nav-link" href="password.html">Xuất kho</a>-->
                                        </nav>
                                    </div>
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Chi phí
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/report/salary">Chi phí nhân công</a>
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/report/cost">Chi phí đầu vào</a>
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/report/assets">Giá trị thành phẩm</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>


                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Đăng nhập bằng: ${sessionScope.account.oname}</div>

                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Trang quản trị</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Báo cáo lương nhân công</li>
                        </ol>
                        <%if (ym.getYear() == 1) {%>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Chi phí đầu vào từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/cost">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalCost}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Lương nhân công từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/salary">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalSalary}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Tổng tài sản từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/assets">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalProduct}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Số tiền lãng phí từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/waste">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalWaste}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%} else {%>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Chi phí đầu vào tháng <%=ym.getMonthValue()%> năm <%=ym.getYear()%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/cost?month=<%=ym.getYear()%>-<%=monthStr%>">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalCost}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Lương tháng <%=ym.getMonthValue()%> năm <%=ym.getYear()%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/salary?month=<%=ym.getYear()%>-<%=monthStr%>">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalSalary}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">Tổng tài sản tháng <%=ym.getMonthValue()%> năm <%=ym.getYear()%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/assets?month=<%=ym.getYear()%>-<%=monthStr%>">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalProduct}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">Lãng phí tháng <%=ym.getMonthValue()%> năm <%=ym.getYear()%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/waste?month=<%=ym.getYear()%>-<%=monthStr%>">
                                            <fmt:setLocale value = "vi_VN"/>
                                            <fmt:formatNumber type="currency" value="${requestScope.totalWaste}" />
                                        </a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%}%>


                        <div class="aaa" >
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                <%if (ym.getYear() != 1) {%>
                                Bảng báo cáo lương tháng <%=ym.getMonth().getValue()%> năm <%=ym.getYear()%>
                                <%} else {%>
                                Bảng lương nhân công từ trước đến nay.
                                <%}%>

                            </div>
                            <div class="card-body">
                                <%if (salaries.size() == 0) {%>
                                <h3>Không có dữ liệu để hiển thị.</h3>
                                <%} else {%>
                                <table id="datatablesSimple" class="table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã NV</th>
                                            <th scope="col">Tên nhân viên</th>
                                            <th scope="col">SĐT</th>
                                            <th scope="col">Lương Cứng</th>
                                            <th scope="col">Thưởng/SP</th>
                                            <th scope="col">Số SP</th>
                                            <th scope="col">Lĩnh Lương</th>

                                        </tr>

                                    </thead>

                                    <tbody>
                                        <c:forEach items="${requestScope.salary}" var="s">
                                            <tr>
                                                <td scope="col">${s.worker.wid}</td>
                                                <td scope="col">${s.worker.wname}</td>
                                                <td scope="col">${s.worker.phoneNumber}</td>
                                                <td scope="col">
                                                    <fmt:setLocale value = "vi_VN"/>
                                                    <fmt:formatNumber type="currency" value="${s.worker.monthSalary}" />
                                                </td>
                                                <td scope="col">
                                                    <fmt:setLocale value = "vi_VN"/>
                                                    <fmt:formatNumber type="currency" value="${s.worker.productSalary}" />
                                                </td>
                                                <td scope="col">${s.count}</th>
                                                <th scope="col">
                                                    <fmt:setLocale value = "vi_VN"/>
                                                    <fmt:formatNumber type="currency" value="${s.worker.monthSalary + s.worker.productSalary*s.count}" />
                                                </th>
                                            </tr>
                                        </c:forEach>
                                        <tr>

                                            <c:set var="total" value="${0}"/>
                                            <c:forEach var="s" items="${requestScope.salary}">
                                                <c:set var="total" value="${total + (s.worker.monthSalary + s.worker.productSalary*s.count)}" />
                                            </c:forEach>


                                            <th scope="col" style="text-align: center" colspan="7">
                                                Tổng lương: <fmt:formatNumber type="currency" value="${total}" />
                                            </th>
                                        </tr>
                                    </tbody>

                                </table>
                                <%}%>


                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Địa chỉ: Xã Bảo Ái, Huyện Yên Bình, Tỉnh Yên Bái</div>

                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../asset/js/scripts.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../asset/js/datatables-simple-demo.js"></script>

        <script>
            function deleteManuDetail(mid) {
                var result = confirm("Bạn có chắc muốn xóa chi tiết này ?");
                if (result) {
                    window.location.href = "delete?mid=" + mid;
                }
            }
        </script>

        <script type="text/javascript">
            function clickServlet() {
                document.getElementById('searchproduct').click();
            }
        </script>
    </body>
</html>


