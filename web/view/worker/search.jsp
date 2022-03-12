<%-- 
    Document   : search
    Created on : Feb 19, 2022, 2:42:30 PM
    Author     : ADMIN
--%>

<%@page import="model.Worker"%>
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
        <title>Trang Quản Trị | Nhân công</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="../asset/css/style.css" rel="stylesheet" />
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

        <%
            ArrayList<Worker> workers = (ArrayList<Worker>) request.getAttribute("workers");
            ArrayList<Worker> workersByName = (ArrayList<Worker>) request.getAttribute("workersname");
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
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" name="bname" type="text" placeholder="Search tên công nhân..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>

            <!--            <div class="form-agline">
            
                            <form action="search" method="POST" id="search-month">
            
                                <div class="form-group" id="month-input">
                                    <p for="month">Tháng cần báo cáo:</p>
                                    <input type="month"  name="month" value="<%--=(ym.getYear() == 1) ? "" : ym--%>" selected="selected">
                                    <input type="submit" value="Search">
                                </div>-->

            <!--                    <div class="form-group" id="search-btn">               
                                    <input type="submit" value="Search">
                                </div>-->
            <!--</form>-->
            <!--</div>-->

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
                                Danh sách
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="http://localhost:8080/ProductionManager/bill/search">Danh sách nguồn hàng </a>
                                    <a class="nav-link" id="searchproduct" onclick="clickServlet()" href="http://localhost:8080/ProductionManager/product/search">Danh sách sản phẩm</a>
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
                                            <a class="nav-link" href="http://localhost:8080/ProductionManager/report/inventory">Quản lý Kho linh kiện</a>
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
                                            <a class="nav-link" href="500.html">Giá trị thành phẩm</a>
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
                        <h1 class="mt-4">Trang quản trị</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Danh sách nhân công</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">Chi phí đầu vào</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">Xem chi tiết</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">Chi phí nhân công</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">Xem chi tiết</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
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
                            </div>
                        </div>

                        <div class="aaa" >
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                Bảng thông tin nhân công
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple" class="table-bordered">
                                    <thead>
                                        <tr>
                                            <th scope="col">Mã nhân viên</th>
                                            <th scope="col">Tên nhân viên</th>
                                            <th scope="col">Số điện thoại</th>
                                            <th scope="col">Lương/Tháng</th>
                                            <th scope="col">Lương/Sản phẩm</th>
                                            <th scope="col" colspan="2">Action</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <%for (Worker w : workersByName) {%>
                    <tr>
                        <td scope="col"><%=w.getWid()%></td>
                        <td scope="col"><%=w.getWname()%></td>
                        <td scope="col"><%=w.getPhoneNumber()%></td>                          
                        <td scope="col"><%=w.getMonthSalary()%>  (VNĐ/Tháng)</td>
                        <td scope="col"><%=w.getProductSalary()%>(VNĐ/SP)</td>

                        <td scope="col"><a href="#" onclick="deleteWorker(<%=w.getWid()%>);">Xóa</a></td>
                        <td scope="col"><a href="edit?wid=<%=w.getWid()%>">Chỉnh sửa</a></td>

                    </tr>
                    <%}%>
                                    </tbody>

                                </table>
                                <a href="http://localhost:8080/ProductionManager/bill/insert"><button class="w3-button w3-teal">+</button></a>
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
                                        function deleteWorker(wid)
                                        {
                                            var result = confirm("Bạn có chắc muốn xóa nhân viên này?");
                                            if (result)
                                            {
                                                window.location.href = "delete?wid=" + wid;
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


