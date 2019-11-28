package servlet;

import dao.SelectAllSecurity;
import po.Securitys;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servlet/ServletAdminFindAllSecurity")
public class ServletAdminFindAllSecurity extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("text/html;GB2312");
//        out.println("iuhiu");
        SelectAllSecurity selectAllSecurity = new SelectAllSecurity();
        ArrayList<Securitys> list = selectAllSecurity.selectAllSecurity();//寻找所有的证券
        request.setAttribute("list", list);//将list存储到Attribute

        request.getRequestDispatcher("../admin/page/security-list.jsp").forward(request, response);//转发请求

    }
}
