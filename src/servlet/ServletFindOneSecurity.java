package servlet;

import dao.DaoFindOneSecurity;
import dao.DaoFindUserHaveSecurity;
import po.Securitys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ServletFindOneSecurity")
public class ServletFindOneSecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securitys_id=request.getParameter("securitys_id");
        String user_name= (String) request.getSession().getAttribute("name");
//        PrintWriter out=response.getWriter();
//        out.println(securitys_id);
        Securitys securitys= DaoFindOneSecurity.daoFindOneSecurity(securitys_id);
        int HaveSecurity=DaoFindUserHaveSecurity.daoFindUserHaveSecurity(user_name,securitys_id);
        request.setAttribute("securitys",securitys);
        request.setAttribute("HaveSecurity",HaveSecurity);
        request.getRequestDispatcher("../user/page/security-information.jsp").forward(request, response);
    }
}
