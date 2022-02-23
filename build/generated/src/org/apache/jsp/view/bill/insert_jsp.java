package org.apache.jsp.view.bill;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Owner;
import java.util.ArrayList;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Insert Bill</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("        ");

            ArrayList<Owner> ownerList = (ArrayList<Owner>) request.getAttribute("ownerList");
        
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"insert\" method=\"POST\">\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"bid\">Mã đơn hàng</label>\n");
      out.write("                    <input type=\"text\" name=\"bid\" class=\"form-control\" placeholder=\"Nhập mã đơn hàng\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"cname\">Tên linh kiện</label>\n");
      out.write("                    <input type=\"text\" name=\"cname\" class=\"form-control\" placeholder=\"Nhập tên linh kiện\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"category\">Thể loại</label>\n");
      out.write("                    <input type=\"text\" name=\"category\" class=\"form-control\" placeholder=\"Nhập thể loại\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"quantity\">Số lượng</label>\n");
      out.write("                    <input type=\"text\" name=\"quantity\" class=\"form-control\" placeholder=\"Nhập số lượng\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"unitprice\">Đơn giá</label>\n");
      out.write("                    <input type=\"text\" name=\"unitprice\" class=\"form-control\" placeholder=\"Đơn giá\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"total\">Thanh toán</label>\n");
      out.write("                    <input type=\"text\" name=\"total\" class=\"form-control\" placeholder=\"Nhập số tiền\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"inputDate\">Ngày nhập</label>\n");
      out.write("                    <input type=\"date\" name=\"inputDate\" class=\"form-control\" placeholder=\"Chọn ngày\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"origin\">xuất xứ</label>\n");
      out.write("                    <input type=\"text\" name=\"origin\" class=\"form-control\" placeholder=\"Nhập xuất xứ\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"supplier\">Nhà cung cấp</label>\n");
      out.write("                    <input type=\"text\" name=\"supplier\" class=\"form-control\" placeholder=\"Tên nhà cung cấp\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-6\">\n");
      out.write("                    <label for=\"contact\">Liên hệ</label>\n");
      out.write("                    <input type=\"text\" name=\"contact\" class=\"form-control\" placeholder=\"Thông tin liên hệ\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-row\">\n");
      out.write("\n");
      out.write("                <div class=\"form-group col-md-8\">\n");
      out.write("                    <label for=\"address\">Địa chỉ</label>\n");
      out.write("                    <input type=\"text\" name=\"address\" class=\"form-control\" placeholder=\"Địa chỉ nhà cung cấp\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group col-md-4\">\n");
      out.write("                    <label for=\"oname\">Bên mua</label>\n");
      out.write("                    <select name=\"oname\" class=\"form-control\">\n");
      out.write("\n");
      out.write("                        ");
for (Owner o : ownerList) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(o.getOname());
      out.write("\">\n");
      out.write("                            ");
      out.print(o.getOname());
      out.write("\n");
      out.write("                        </option>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">Save</button>\n");
      out.write("        </form>\n");
      out.write("                        \n");
      out.write("    </body>\n");
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
