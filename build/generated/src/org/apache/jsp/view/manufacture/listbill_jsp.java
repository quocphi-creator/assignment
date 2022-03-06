package org.apache.jsp.view.manufacture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Bill;
import model.ManufactureDetail;
import java.util.ArrayList;

public final class listbill_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Bill list</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        ");

            ArrayList<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
            Integer productedDetail = (Integer)session.getAttribute("productedDetail");
            Integer removedDetail = (Integer)session.getAttribute("removedDetail");
            Integer inventory = (Integer)session.getAttribute("inventory");
        
      out.write("\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            * {box-sizing: border-box;}\n");
      out.write("\n");
      out.write("            body {\n");
      out.write("                margin: 0;\n");
      out.write("                font-family: Arial, Helvetica, sans-serif;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav {\n");
      out.write("                overflow: hidden;\n");
      out.write("                background-color: #e9e9e9;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav a {\n");
      out.write("                float: left;\n");
      out.write("                display: block;\n");
      out.write("                color: black;\n");
      out.write("                text-align: center;\n");
      out.write("                padding: 14px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 17px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav a:hover {\n");
      out.write("                background-color: #ddd;\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav a.active {\n");
      out.write("                background-color: #2196F3;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav .search-container {\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav input[type=text] {\n");
      out.write("                padding: 6px;\n");
      out.write("                margin-top: 8px;\n");
      out.write("                font-size: 17px;\n");
      out.write("                border: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav .search-container button {\n");
      out.write("                float: right;\n");
      out.write("                padding: 6px 10px;\n");
      out.write("                margin-top: 8px;\n");
      out.write("                margin-right: 16px;\n");
      out.write("                background: #ddd;\n");
      out.write("                font-size: 17px;\n");
      out.write("                border: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .topnav .search-container button:hover {\n");
      out.write("                background: #ccc;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @media screen and (max-width: 600px) {\n");
      out.write("                .topnav .search-container {\n");
      out.write("                    float: none;\n");
      out.write("                }\n");
      out.write("                .topnav a, .topnav input[type=text], .topnav .search-container button {\n");
      out.write("                    float: none;\n");
      out.write("                    display: block;\n");
      out.write("                    text-align: left;\n");
      out.write("                    width: 100%;\n");
      out.write("                    margin: 0;\n");
      out.write("                    padding: 14px;\n");
      out.write("                }\n");
      out.write("                .topnav input[type=text] {\n");
      out.write("                    border: 1px solid #ccc;  \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"topnav\">\n");
      out.write("            <a class=\"active\" href=\"#\">Trang chủ</a>\n");
      out.write("            <a href=\"list\">Quản lý kho linh kiện</a>\n");
      out.write("            \n");
      out.write("            <div class=\"search-container\">\n");
      out.write("                <form action=\"list\" method=\"POST\">\n");
      out.write("                    <input type=\"text\" name=\"bname\" placeholder=\"Search tên linh kiện..\" name=\"search\">\n");
      out.write("                    <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
if (bills.size() > 0) {
      out.write("\n");
      out.write("    <div>\n");
      out.write("        <table class=\"table table-bordered\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th scope=\"col\">Mã Đơn</th>\n");
      out.write("                    <th scope=\"col\">Tên linh kiện</th>\n");
      out.write("                    <th scope=\"col\">Thể loại</th>\n");
      out.write("                    <th scope=\"col\">Đơn giá</th>\n");
      out.write("                    <th scope=\"col\">Đầu vào</th>\n");
      out.write("                    <th scope=\"col\">Đã SX</th>\n");
      out.write("                    <th scope=\"col\">Bị hỏng</th>\n");
      out.write("                    <th scope=\"col\">Còn lại</th>\n");
      out.write("                    <th scope=\"col\">Thao tác</th>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
for (Bill b : bills) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td scope=\"col\">");
      out.print(b.getBid());
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(b.getCname());
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(b.getCategory());
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(b.getUnitPrice());
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(b.getQuantity());
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(productedDetail);
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(removedDetail);
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">");
      out.print(inventory);
      out.write("</td>\n");
      out.write("                    <td scope=\"col\">\n");
      out.write("                        <form action=\"export\" method=\"POST\">\n");
      out.write("                            <input type=\"hidden\" name=\"bid\" value=\"");
      out.print(b.getBid());
      out.write("\">\n");
      out.write("                            <input type=\"submit\" value=\"Xuất kho\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    ");
} else {
      out.write("\n");
      out.write("    <h2>No record to display</h2>\n");
      out.write("    ");
}
      out.write("\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
