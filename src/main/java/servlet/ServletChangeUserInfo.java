package servlet;

import dao.DaoUpdataUserInfo;
import po.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ServletChangeUserInfo")
public class ServletChangeUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Users users=new Users();
        String name=request.getParameter("user_name");
        users.setUser_id(Integer.valueOf(request.getParameter("user_id")));
        users.setUser_name(request.getParameter("user_name"));
        users.setUser_sex(request.getParameter("user_sex"));
        users.setUser_nationality(request.getParameter("user_nationality"));
        users.setUser_profession(request.getParameter("user_profession"));
        users.setUser_workunit(request.getParameter("user_workunit"));
        users.setUser_phone(request.getParameter("user_phone"));
        users.setUser_idcard(request.getParameter("user_idcard"));
        int num=DaoUpdataUserInfo.daoUpdataUserInfo(users);
        if (num==-1){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('error')</script>");
            request.getContextPath();
            String url="0.1; "+request.getContextPath()+"/servlet/ServletFindOneUserInfo";
            response.setHeader("refresh",url);
        }
        if (num==1){

            PrintWriter out=response.getWriter();
            out.print("<script>alert('succeed')</script>");
            String url="0.1; "+request.getContextPath()+"/servlet/ServletFindOneUserInfo";
            response.setHeader("refresh",url);
        }
    }
}
