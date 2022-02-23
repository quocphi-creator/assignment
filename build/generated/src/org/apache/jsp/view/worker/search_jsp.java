package org.apache.jsp.view.worker;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Worker;
import java.util.ArrayList;

public final class search_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Worker | Search</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../asset/css/WorkerSearchBar.css\">\n");
      out.write("        ");

            ArrayList<Worker> workers = (ArrayList<Worker>) request.getAttribute("workers");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"topnav\">\n");
      out.write("            <p2 class=\"active\" href=\"#home>Thông tin công nhân</p2>\n");
      out.write("            \n");
      out.write("            <div class=\"search-container\">\n");
      out.write("                <form action=\"search\" method=\"POST\">\n");
      out.write("                    <input type=\"text\" placeholder=\"Search name\" name=\"wname\">\n");
      out.write("                    <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
if (workers.size() > 0) {
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <table class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">Mã nhân viên</th>\n");
      out.write("                        <th scope=\"col\">Tên nhân viên</th>\n");
      out.write("                        <th scope=\"col\">Số điện thoại</th>\n");
      out.write("                        <th scope=\"col\">Lương/tháng</th>\n");
      out.write("                        <th scope=\"col\">Lương/Sản phẩm</th>\n");
      out.write("                        <th scope=\"col\" colspan=\"2\">Action</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
for (Worker w : workers) {
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td scope=\"col\">");
      out.print(w.getWid());
      out.write("</td>\n");
      out.write("                        <td scope=\"col\">");
      out.print(w.getWname());
      out.write("</td>\n");
      out.write("                        <td scope=\"col\">");
      out.print(w.getPhoneNumber());
      out.write("</td>                          \n");
      out.write("                        <td scope=\"col\">");
      out.print(w.getMonthSalary());
      out.write("</td>\n");
      out.write("                        <td scope=\"col\">");
      out.print(w.getProductSalary());
      out.write("(VNĐ/SP)</td>\n");
      out.write("\n");
      out.write("                        <td scope=\"col\"><a href=\"#\">Xóa</a></td>\n");
      out.write("                        <td scope=\"col\"><a href=\"edit?bid=");
      out.print(w.getWid());
      out.write("\">Chỉnh sửa</a></td>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <h2>No record to display</h2>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <a href=\"insert\">Insert\n");
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
