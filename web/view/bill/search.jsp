<%-- 
    Document   : search
    Created on : Feb 19, 2022, 2:42:30 PM
    Author     : ADMIN
--%>

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
        <title>Trang Quản Trị | Nguồn Hàng</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../asset/css/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <%
            ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
            ArrayList<Integer> monthList = (ArrayList<Integer>) request.getAttribute("monthList");
            int month = (Integer) request.getAttribute("month");
            String monthStr;
            if (month < 10) {
                monthStr = "0"+month;
            } else {
                monthStr = String.valueOf(month);
            }
            int year = (Integer) request.getAttribute("year");
            int amount = (Integer) request.getAttribute("amount");
            int money = (Integer) request.getAttribute("money");
        %>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">Trang Quản trị</a>




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

                <form action="search" method="POST">
                    <div class="form-row">
                        <lable for="year">Year</lable>
                        <input class="row-1" type="text" name="year" selected="selected" placeholder="Nhập năm cần báo cáo">
                    </div>

                    <div class="form-row">
                        <lable for="month">Month</lable>
                        <select name="month" class="row-2">
                            <option value="-1">Báo cáo năm</option>

                            <%for (Integer item : monthList) {%>
                            <option
                                <%=(item == month) ? "selected=\"selected\"" : ""%>
                                value="<%=item%>"> Báo cáo tháng <%=item%></option>
                            <%}%>

                        </select>
                    </div>

                    <div class="form-group">               
                        <input type="submit" value="Search" class="search-time">
                    </div>
                </form>
            </div>

            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Sửa tài khoản</a></li>

                        <li><a class="dropdown-item" href="#!">Đăng xuất</a></li>
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
                                Xem danh sách
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/bill/search">Danh sách nguồn hàng </a>
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/product/search">Danh sách sản phẩm</a>
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/worker/search">Danh sách công nhân</a>
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
                        <div class="small">Logged in as:</div>

                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Trang Quản trị</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Tổng thể nguồn hàng</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-6 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <%if (month == -1 || year == -1) {%>
                                    <div class="card-body">Tổng số linh kiện nhập vào từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#"><%=amount%> (Linh kiện)</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                    <%} else {%>
                                    <div class="card-body">Tổng số linh kiện nhập vào tháng <%=month%> năm <%=year%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#" style="text-decoration: none"><%=amount%> (Linh kiện)</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                    <%}%>

                                </div>
                            </div>
                            <div class="col-xl-6 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <%if (month == -1 || year == -1) {%>
                                    <div class="card-body">Tổng số tiền mua linh kiện từ trước đến nay</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/cost"><%=money%> (VNĐ)</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                    <%} else {%>
                                    <div class="card-body">Tổng số tiền mua linh kiện tháng <%=month%> năm <%=year%></div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="http://localhost:8080/ProductionManager/report/cost?month=<%=year%>-<%=monthStr%>"><%=money%> (VNĐ)</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                    <%}%>

                                </div>
                            </div>
                            <!--                            <div class="col-xl-3 col-md-6">
                                                            <div class="card bg-success text-white mb-4">
                                                                <div class="card-body">Tổng tài sản</div>
                                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                                    <a class="small text-white stretched-link" href="#">Xem chi tiết</a>
                                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-xl-3 col-md-6">
                                                            <div class="card bg-danger text-white mb-4">
                                                                <div class="card-body">Lãng phí</div>
                                                                <div class="card-footer d-flex align-items-center justify-content-between">
                                                                    <a class="small text-white stretched-link" href="#">Xem chi tiết</a>
                                                                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                                                </div>
                                                            </div>
                                                        </div>-->
                        </div>

                        <div class="aaa" >
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Danh sách nguồn hàng
                            </div>
                            <div class="card-body">
                                <%if (bills.isEmpty()) {%>
                                <h3>Không có dữ liệu để hiển thị</h3>
                                <%} else {%>
                                <table id="datatablesSimple" class="table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Mã</th>
                                            <th>Tên LK</th>
                                            <th>Thể loại</th>
                                            <th>Đơn giá</th>
                                            <th>Số lượng</th>
                                            <th>Thực chi</th>
                                            <th>Ngày nhập</th>
                                            <th>Xuất xứ</th>
                                            <th>Nhà cung cấp</th>
                                            <th>Địa chỉ</th>
                                            <th>Liên hệ</th>
                                            <th>Bên mua</th>
                                            <th colspan="2">Thao tác</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <%for (Bill b : bills) {%>
                                        <tr>
                                            <td scope="col"><%=b.getBid()%></td>
                                            <td scope="col"><%=b.getCname()%></td>
                                            <td scope="col"><%=b.getCategory()%></td>
                                            <td scope="col"><%=b.getUnitPrice()%> (VNĐ/LK)</td>
                                            <td scope="col"><%=b.getQuantity()%></td>
                                            <td scope="col"><%=b.getTotal()%> (VNĐ)</td>
                                            <td scope="col"><%=b.getInputDate()%></td>
                                            <td scope="col"><%=b.getOrigin()%></td>
                                            <td scope="col"><%=b.getSupplierName()%></td>
                                            <td scope="col"><%=b.getAddress()%></td>
                                            <td scope="col"><%=b.getContact()%></td>
                                            <td scope="col"><%=b.getOwner().getOname()%></td>

                                            <td scope="col"><a onclick="deleteBill(<%=b.getBid()%>)" href="#">Xóa</a></td>
                                            <td scope="col"><a href="edit?bid=<%=b.getBid()%>">Sửa</a></td>

                                        </tr>
                                        <%}%>
                                    </tbody>

                                </table>
                                <%}%>

                                <a href="insert"><button class="w3-button w3-teal">+</button></a>
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
                                                function deleteBill(bid) {
                                                    var result = confirm("Bạn có chắc muốn xóa thông tin nguồn hàng ? Các thông tin liên quan trong sản xuất sẽ bị xóa.");

                                                    if (result) {
                                                        window.location.href = "delete?bid=" + bid;
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


