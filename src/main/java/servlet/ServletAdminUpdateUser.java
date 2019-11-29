package servlet;

import dao.DaoAdminUpdateSecurity;
import dao.DaoUpdataUserInfo;
import po.Securitys;
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
 * @date 2019/11/28 10:26
 */
@WebServlet(name = "ServletAdminUpdateUser",urlPatterns = "/servlet/ServletAdminUpdateUser")
public class ServletAdminUpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Users users=new Users();
        String user_id=request.getParameter("user_id");
        users.setUser_id(Integer.valueOf(request.getParameter("user_id")));
        users.setUser_name(request.getParameter("user_name"));
        users.setUser_sex(request.getParameter("user_sex"));
        users.setUser_nationality(request.getParameter("user_nationality"));
        users.setUser_profession(request.getParameter("user_profession"));
        users.setUser_workunit(request.getParameter("user_workunit"));
        users.setUser_phone(request.getParameter("user_phone"));
        users.setUser_idcard(request.getParameter("user_idcard"));
        int count= DaoUpdataUserInfo.daoUpdataUserInfo(users);

        if (count==1){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('信息修改成功');</script>");
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindUserInfo?user_id="+user_id);

        }else {
            PrintWriter out=response.getWriter();

            out.print("<script>alert('信息修改失败');</script>");
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindUserInfo?user_id="+user_id);


        }

    }
}
