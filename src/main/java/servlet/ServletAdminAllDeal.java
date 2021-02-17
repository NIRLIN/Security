package servlet;

import dao.DaoAdminFindAllDeal;
import dao.SelectUserHaveSecurity;
import dao.UseNameFindId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servlet/ServletAdminAllDeal")
public class ServletAdminAllDeal extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList list= DaoAdminFindAllDeal.selectUserHaveSecurity();
        request.setAttribute("list",list);
        request.getRequestDispatcher("../admin/page/deal-list.jsp").forward(request, response);
    }
}
