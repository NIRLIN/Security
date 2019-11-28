package servlet;

import dao.DaoAddDeal;
import dao.UseNameFindId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/ServletUserBuySecurity")
public class ServletUserBuySecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String securitys_id=request.getParameter("securitys_id");
        String deal_count=request.getParameter("deal_count");
        String user_name= (String) request.getSession().getAttribute("name");
        String user_id= UseNameFindId.useNameFindId(user_name);
        int num= DaoAddDeal.daoAddDeal(securitys_id,user_id,deal_count);
        if (num==1){
            response.sendRedirect("http://localhost:8080/Security_war_exploded/servlet/ServletFindOneSecurity?securitys_id="+securitys_id);
        }else {
            response.sendRedirect("http://localhost:8080/Security_war_exploded/servlet/ServletAllFind");
        }
    }
}
