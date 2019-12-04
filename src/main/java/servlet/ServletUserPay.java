package servlet;

import dao.DaoAdminLogin;
import dao.DaoUserAddPay;
import dao.UseNameFindId;

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
@WebServlet(urlPatterns = "/servlet/ServletUserPay",name = "ServletUserPay")
public class ServletUserPay extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String user_id=request.getParameter("user_id");



        int count= DaoUserAddPay.daoAdminLogin(user_id);
        response.sendRedirect(request.getContextPath()+"/servlet/ServletFindOneUserInfo?user_id="+user_id);


    }
}
