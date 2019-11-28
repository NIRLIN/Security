package servlet;

import dao.DaoFindDeal;
import dao.DaoFindOneSecurity;
import dao.UseNameFindId;
import po.Deals;
import po.Securitys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet/ServletAdminFindDealSecurityInfo")
public class ServletAdminFindDealSecurityInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_name= (String) request.getSession().getAttribute("name");
        String user_id= UseNameFindId.useNameFindId(user_name);
        String deal_id=request.getParameter("deal_id");
        Deals deals= DaoFindDeal.daoFindDeal(deal_id);
        String security_id=String.valueOf(deals.getDeal_security_id());
        Securitys securitys= DaoFindOneSecurity.daoFindOneSecurity(security_id);
        request.setAttribute("deals",deals);
        request.setAttribute("securitys",securitys);
        request.getRequestDispatcher("../admin/page/deals_information.jsp").forward(request, response);


    }
}
