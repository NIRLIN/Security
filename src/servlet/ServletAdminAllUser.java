package servlet;

import dao.DaoAdminFindAllDeal;
import dao.DaoAdminFindAllUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/28 10:26
 */
@WebServlet("/servlet/ServletAdminAllUser")
public class ServletAdminAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList list= DaoAdminFindAllUser.daoAdminFindAllUser();
        request.setAttribute("list",list);
        request.getRequestDispatcher("../admin/page/all_user.jsp").forward(request, response);
    }
}
