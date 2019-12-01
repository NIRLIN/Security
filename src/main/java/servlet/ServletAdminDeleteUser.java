package servlet;

import dao.DaoAdminLDeleteSecurity;
import dao.DaoAdminLDeleteUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/27 16:58
 */
@WebServlet(urlPatterns = "/servlet/ServletAdminDeleteUser",name = "ServletAdminDeleteUser")
public class ServletAdminDeleteUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id=request.getParameter("user_id");
        PrintWriter out=response.getWriter();
        int count= DaoAdminLDeleteUser.daoAdminLogin(user_id);
        if (count==1){
            out.print("<script>alert('删除成功！');</script>");

            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminAllUser");

        }else {
            out.print("<script>alert('删除失败！');</script>");

            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindUserInfo?securitys_id="+user_id);


        }
    }
}
