package org.apache.jsp.view.manufacture;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ManufactureDetail;
import model.Worker;
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manufacture | Insert</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\" integrity=\"sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn\" crossorigin=\"anonymous\">\n");
      out.write("        ");

            ArrayList<Worker> workers = (ArrayList<Worker>) request.getAttribute("workers");
            ArrayList<ManufactureDetail> details = (ArrayList<ManufactureDetail>)request.getAttribute("details");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        body {font-family: Arial, Helvetica, sans-serif;}\n");
      out.write("        * {box-sizing: border-box;}\n");
      out.write("\n");
      out.write("        input[type=text], select, textarea {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            margin-top: 6px;\n");
      out.write("            margin-bottom: 16px;\n");
      out.write("            resize: vertical;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=submit] {\n");
      out.write("            background-color: #04AA6D;\n");
      out.write("            color: white;\n");
      out.write("            padding: 12px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        input[type=submit]:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            border-radius: 5px;\n");
      out.write("            background-color: #f2f2f2;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h3>Nhập Thông Tin Sản Xuất</h3>\n");
      out.write("            <form action=\"insert\" method=\"POST\">\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <label for=\"mid\">Mã SX</label>\n");
      out.write("                    <input type=\"text\" name=\"mid\" placeholder=\"Nhập mã sản xuất\" >\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <label for=\"producted\">Số linh kiện đã sản xuất</label>\n");
      out.write("                    <input type=\"text\" name=\"producted\" placeholder=\"Nhập số lượng linh kiện đã được sản xuất..\" required=\"required\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <label for=\"removed\">Số linh kiện bị loại bỏ</label>\n");
      out.write("                    <input type=\"text\" name=\"removed\" placeholder=\"Nhập số lượng linh kiện đã bị hỏng..\" required=\"required\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"form-group col-md-6\">\n");
      out.write("                        <label for=\"outputdate\">Ngày xuất kho</label>\n");
      out.write("                        <input type=\"date\" name=\"outputdate\" class=\"form-control\" placeholder=\"Nhập ngày xuất kho\" required=\"required\">\n");
      out.write("                    </div>  \n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"form-group col-md-4\">\n");
      out.write("                        <label for=\"wid\">Người phụ trách</label>\n");
      out.write("                        <select name=\"wid\" class=\"form-control\">\n");
      out.write("\n");
      out.write("                            ");
for (Worker w : workers) {
      out.write("\n");
      out.write("                            <option \n");
      out.write("                                value=\"");
      out.print(w.getWid());
      out.write("\">\n");
      out.write("                                ");
      out.print(w.getWname());
      out.write("\n");
      out.write("                            </option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"submit\" value=\"Submit\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
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
