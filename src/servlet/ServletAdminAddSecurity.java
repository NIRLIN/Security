package servlet;

import dao.DaoAdminAddSecurity;
import po.Securitys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/28 8:55
 */
@WebServlet("/servlet/ServletAdminAddSecurity")
public class ServletAdminAddSecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String  securitys_short=request.getParameter("securitys_short");
        String  securitys_companyname=request.getParameter("securitys_companyname");
        String  securitys_phone=request.getParameter("securitys_phone");
        String  securitys_unitprice=request.getParameter("securitys_unitprice");
        String  securitys_residualquantity=request.getParameter("securitys_residualquantity");
        String  securitys_totalquantity=request.getParameter("securitys_totalquantity");
        String  securitys_address=request.getParameter("securitys_address");
        String  securitys_appeardata=request.getParameter("securitys_appeardata");
        Securitys securitys=new Securitys();
        securitys.setSecuritys_short(securitys_short);
        securitys.setSecuritys_companyname(securitys_companyname);
        securitys.setSecuritys_phone(securitys_phone);
        securitys.setSecuritys_unitprice(Float.valueOf(securitys_unitprice));
        securitys.setSecuritys_residualquantity(Integer.valueOf(securitys_residualquantity));
        securitys.setSecuritys_totalquantity(Integer.valueOf(securitys_totalquantity));
        securitys.setSecuritys_address(securitys_address);

        int count= DaoAdminAddSecurity.daoAdminAddSecurity(securitys,securitys_appeardata);
        if (count==1){
            response.sendRedirect("/Security_war_exploded/servlet/ServletAdminFindAllSecurity");
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script>alert('证券信息添加失败!\\n请重新添加！');window.location= \"../admin/page/login.html\";</script>");
            //response.sendRedirect("../user/page/index.jsp");

        }




    }
}
