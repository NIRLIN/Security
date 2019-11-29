package servlet;

import dao.DaoAdminFindAllUser;
import dao.DaoAdminUpdateSecurity;
import po.Securitys;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/28 10:26
 */
@WebServlet(name = "ServletAdminAUpdateSecurity",urlPatterns = "/servlet/ServletAdminAUpdateSecurity")
public class ServletAdminAUpdateSecurity extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String securitys_id=request.getParameter("securitys_id");
        String securitys_short=request.getParameter("securitys_short");
        String securitys_companyname=request.getParameter("securitys_companyname");
        String securitys_unitprice=request.getParameter("securitys_unitprice");
        String securitys_residualquantity=request.getParameter("securitys_residualquantity");
        String securitys_totalquantity=request.getParameter("securitys_totalquantity");
        String securitys_address=request.getParameter("securitys_address");
        String securitys_phone=request.getParameter("securitys_phone");
        String securitys_appeardata=request.getParameter("securitys_appeardata");

        Securitys securitys=new Securitys();
        securitys.setSecuritys_id(Integer.valueOf(securitys_id));
        securitys.setSecuritys_short(securitys_short);
        securitys.setSecuritys_companyname(securitys_companyname);
        securitys.setSecuritys_phone(securitys_phone);
        securitys.setSecuritys_unitprice(Float.valueOf(securitys_unitprice));
        securitys.setSecuritys_residualquantity(Integer.valueOf(securitys_residualquantity));
        securitys.setSecuritys_totalquantity(Integer.valueOf(securitys_totalquantity));
        securitys.setSecuritys_address(securitys_address);
        securitys.setSecuritys_appeardata1(securitys_appeardata);

        int count= DaoAdminUpdateSecurity.daoAdminUpdateSecurity(securitys);
        if (count==1){
            PrintWriter out=response.getWriter();
            out.print("<script>alert('证券信息修改成功');</script>");
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindOneSecurity?securitys_id="+securitys_id);

        }else {
            PrintWriter out=response.getWriter();

            out.print("<script>alert('证券信息修改失败');</script>");
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindOneSecurity?securitys_id="+securitys_id);

        }

    }
}
