package servlet;

import dao.DaoAdminAddUser;
import po.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/28 11:08
 */
@WebServlet(name = "ServletAdminAddUser",urlPatterns = "/servlet/ServletAdminAddUser")
public class ServletAdminAddUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String user_name=request.getParameter("user_name");
        String user_pass=request.getParameter("user_pass");
        String user_sex=request.getParameter("user_sex");
        String user_nationality=request.getParameter("user_nationality");
        String user_balance=request.getParameter("user_balance");
        String user_profession=request.getParameter("user_profession");
        String user_workunit=request.getParameter("user_workunit");
        String user_phone=request.getParameter("user_phone");
        String user_idcard=request.getParameter("user_idcard");
        Users users=new Users();
        users.setUser_name(user_name);
        users.setUser_pass(user_pass);
        users.setUser_sex(user_sex);
        users.setUser_nationality(user_nationality);
        try{
            users.setUser_balance(Double.parseDouble(user_balance));
        }catch (Exception e){
            e.printStackTrace();
            users.setUser_balance(0);

        }
        users.setUser_profession(user_profession);
        users.setUser_workunit(user_workunit);
        users.setUser_phone(user_phone);
        users.setUser_idcard(user_idcard);

        int count= DaoAdminAddUser.daoAdminAddUser(users);
        if (count==1){
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminAllUser");
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script>alert('用户信息添加失败！!\\n请重新添加！');window.location= \"../admin/page/login.jsp\";</script>");
            //response.sendRedirect("../user/page/index.jsp");

        }
    }
}
