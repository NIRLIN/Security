package servlet;

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
@WebServlet(urlPatterns = "/servlet/ServletAdminLogin",name = "ServletAdminLogin")
public class ServletAdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name=request.getParameter("name");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();

        int count= DaoAdminLogin.daoAdminLogin(name,password);
        if (count==1){
            response.sendRedirect("../admin/page/index.jsp");

            session.setAttribute("admin_name",name);
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script>alert('账号或密码错误!\\n请重新输入！');window.location= \"../admin/page/login.jsp\";</script>");
            //response.sendRedirect("../user/page/index.jsp");

        }
    }
}
