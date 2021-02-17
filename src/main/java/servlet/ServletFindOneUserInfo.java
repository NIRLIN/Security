package servlet;

import dao.SelectOneUser;
import po.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/servlet/ServletFindOneUserInfo")
public class ServletFindOneUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name= (String) request.getSession().getAttribute("name");
        Users user= SelectOneUser.FindUser(user_name);

        request.setAttribute("user", user);

        request.getRequestDispatcher("../user/page/userinformation-detail.jsp").forward(request, response);
    }
}
