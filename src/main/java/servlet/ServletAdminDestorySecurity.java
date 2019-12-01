package servlet;

import dao.DaoAdminLDeleteSecurity;
import dao.DaoAdminLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/27 16:58
 */
@WebServlet(urlPatterns = "/servlet/ServletAdminDestorySecurity",name = "ServletAdminDestorySecurity")
public class ServletAdminDestorySecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String securitys_id=request.getParameter("securitys_id");
        PrintWriter out=response.getWriter();
        int count= DaoAdminLDeleteSecurity.daoAdminLogin(securitys_id);
        if (count==1){
            out.print("<script>alert('删除成功！');</script>");

            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindAllSecurity");

        }else {
            out.print("<script>alert('删除失败！');</script>");

            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindOneSecurity?securitys_id="+securitys_id);


        }
    }
}
