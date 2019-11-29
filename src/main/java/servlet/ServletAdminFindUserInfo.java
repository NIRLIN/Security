package servlet;

import dao.DaoAdminFindOneUser;
import dao.DaoAdminUpdateSecurity;
import po.Securitys;
import po.Users;

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
 * @date 2019/11/28 10:26
 */
@WebServlet(name = "ServletAdminFindUserInfo",urlPatterns = "/servlet/ServletAdminFindUserInfo")
public class ServletAdminFindUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user_id=request.getParameter("user_id");
        Users user=DaoAdminFindOneUser.FindUser(user_id);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/admin/page/user_info.jsp").forward(request, response);

    }
}
