package servlet;

import dao.DaoFindDeal;
import dao.DaoUserSaleSecurity;
import dao.UseNameFindId;
import po.Deals;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/ServletUserSaleSecurity")
public class ServletUserSaleSecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name= (String) request.getSession().getAttribute("name");
        String user_id= UseNameFindId.useNameFindId(user_name);
        String deal_id=request.getParameter("deal_id");
        String deal_count=request.getParameter("deal_count");
        int num= DaoUserSaleSecurity.daoUserSaleSecurity(user_id,deal_id,deal_count);
        String url="http://localhost:8080/Security_war_exploded/servlet/ServletFindDealSecurityInfo?deal_id="+deal_id;
        response.sendRedirect(url);
    }
}
