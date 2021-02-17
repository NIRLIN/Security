package servlet;

import dao.UserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ServletUserLogin")
public class ServletUserLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        int count= UserLogin.userLogin(name,password);
        response.setContentType("text/html;charset=utf-8");
        if (count==1){
            response.sendRedirect("../user/page/index.jsp");
            session.setAttribute("name",name);
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script>alert('账号或密码错误!\\n请重新输入！');window.location= \"../user/page/login.jsp\";</script>");
            //response.sendRedirect("../user/page/index.jsp");

        }
    }
}
