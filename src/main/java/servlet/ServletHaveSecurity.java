package servlet;

import dao.SelectUserHaveSecurity;
import dao.UseNameFindId;
import po.Deals;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servlet/ServletHaveSecurity")
public class ServletHaveSecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name= (String) request.getSession().getAttribute("name");

        String user_id= UseNameFindId.useNameFindId(name);
        ArrayList list= SelectUserHaveSecurity.selectUserHaveSecurity(user_id);
        request.setAttribute("list",list);
        request.getRequestDispatcher("../user/page/userhave-list.jsp").forward(request, response);
    }
}
