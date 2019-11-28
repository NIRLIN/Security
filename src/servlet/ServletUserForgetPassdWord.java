package servlet;

import dao.DaoUserForgetPassdWord;
import dao.UseNameFindId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/ServletUserForgetPassdWord")
public class ServletUserForgetPassdWord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name=request.getParameter("Name");

        String user_pass=request.getParameter("New_Password");
        String user_id= UseNameFindId.useNameFindId(user_name);
        DaoUserForgetPassdWord.daoUserForgetPassdWord(user_id,user_pass);
        response.sendRedirect("http://localhost:8080/Security_war_exploded/user/page/login.html");
    }
}
