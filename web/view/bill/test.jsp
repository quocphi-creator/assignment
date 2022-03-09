<%-- 
    Document   : test
    Created on : Mar 9, 2022, 1:54:33 AM
    Author     : ADMIN
--%>

<%--@page import="model.Bill"--%>
<%--@page import="java.util.ArrayList"--%>
<%--@page contentType="text/html" pageEncoding="UTF-8"--%>
<!DOCTYPE html>
<!--html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search bill</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

        <%--
            ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
            ArrayList<Integer> monthList = (ArrayList<Integer>) request.getAttribute("monthList");
            int month = (Integer) request.getAttribute("month");
            int year = (Integer) request.getAttribute("year");
            
        --%>

        <script>
            function deleteBill(bid) {
                var result = confirm("B?n c� ch?c mu?n x�a th�ng tin ngu?n h�ng ? C�c th�ng tin li�n quan trong s?n xu?t s? b? x�a.");
                
                if (result) {
                    window.location.href = "delete?bid="+bid;
                }    
            }
        </script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="justify-content-center">
                <h1>B�o c�o ??n h�ng</h1>
                <form action="search" method="POST">
                    <div class="form-group">
                        <lable for="year">Year</lable>
                        <input type="text" name="year" selected="selected" placeholder="Nh?p n?m c?n b�o c�o">
                    </div>

                    <div class="form-group">
                        <lable for="month">Month</lable>
                        <select name="month">
                            <option value="-1">B�o c�o n?m</option>

                            <%--for (Integer item : monthList) {%>
                            <option
                                <%=(item == month) ? "selected=\"selected\"" : ""%>
                                value="<%=item%>"> B�o c�o th�ng <%=item%></option>
                            <%}--%>

                        </select>
                    </div>

                    <div class="form-group">               
                        <input type="submit" value="Search">
                    </div>
                </form>
            </div>

            <%--if (bills.size() > 0) {%>
            <div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">M� ??n</th>
                            <th scope="col">T�n linh ki?n</th>
                            <th scope="col">Th? lo?i</th>
                            <th scope="col">??n g�a</th>
                            <th scope="col">S? l??ng</th>
                            <th scope="col">T?ng ti?n</th>
                            <th scope="col">Ng�y nh?p</th>
                            <th scope="col">Xu?t x?</th>
                            <th scope="col">Nh� cung c?p</th>
                            <th scope="col">??a ch?</th>
                            <th scope="col">Li�n h?</th>
                            <th scope="col">B�n mua</th>
                            <th scope="col" colspan="2">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%for (Bill b : bills) {%>
                        <tr>
                            <td scope="col"><%=b.getBid()%></td>
                            <td scope="col"><%=b.getCname()%></td>
                            <td scope="col"><%=b.getCategory()%></td>
                            <td scope="col"><%=b.getUnitPrice()%></td>
                            <td scope="col"><%=b.getQuantity()%></td>
                            <td scope="col"><%=b.getTotal()%></td>
                            <td scope="col"><%=b.getInputDate()%></td>
                            <td scope="col"><%=b.getOrigin()%></td>
                            <td scope="col"><%=b.getSupplierName()%></td>
                            <td scope="col"><%=b.getAddress()%></td>
                            <td scope="col"><%=b.getContact()%></td>
                            <td scope="col"><%=b.getOwner().getOname()%></td>

                            <td scope="col"><a onclick="deleteBill(<%=b.getBid()%>)" href="#">X�a</a></td>
                            <td scope="col"><a href="edit?bid=<%=b.getBid()%>">Ch?nh s?a</a></td>

                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
            <%} else {%>
            <h2>No record to display</h2>
            <%}--%>
            <a href="insert">Insert
        </div>


    </body>
</html>
>


