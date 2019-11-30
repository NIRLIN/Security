package servlet;

import dao.DaoAdminUseNameFindId;
import dao.DaoChangeAdminPassword;
import dao.DaoChangeUserPassword;
import dao.UseNameFindId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet/ServletAdminPassWordChange",name = "ServletAdminPassWordChange")
public class ServletAdminPassWordChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name= (String) request.getSession().getAttribute("name");
        String user_id= DaoAdminUseNameFindId.useNameFindId(user_name);
        String old_password=request.getParameter("cpassword");
        String new_password=request.getParameter("npassword");
        int num= DaoChangeAdminPassword.daoChangeUserPassword(user_id,old_password,new_password);
        if (num==-1){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('error')</script>");
            response.setHeader("refresh","0.1;../user/page/password-change.jsp");
        }
        if (num==1){
            request.getSession().removeAttribute("name");
            PrintWriter out=response.getWriter();
            out.print("<script>alert('succeed')</script>");
            response.setHeader("refresh","0.1;../user/page/login.jsp");
        }

    }
}
