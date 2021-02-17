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
        try {
            securitys.setSecuritys_unitprice(Float.parseFloat(securitys_unitprice));
        }catch (Exception e){
            securitys.setSecuritys_unitprice(0);
            e.printStackTrace();
        }
        try {
            securitys.setSecuritys_residualquantity(Integer.parseInt(securitys_residualquantity));
        }catch (Exception e){
            securitys.setSecuritys_residualquantity(0);
            e.printStackTrace();
        }
        try {
            securitys.setSecuritys_totalquantity(Integer.parseInt(securitys_totalquantity));
        }catch (Exception e){
            e.printStackTrace();
            securitys.setSecuritys_totalquantity(0);

        }
        securitys.setSecuritys_address(securitys_address);
//        response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindAllSecurity");
        int count= DaoAdminAddSecurity.daoAdminAddSecurity(securitys,securitys_appeardata);
        if (count==1){
            response.sendRedirect(request.getContextPath()+"/servlet/ServletAdminFindAllSecurity");
        }else {
            PrintWriter out=response.getWriter();
            out.print("<script>alert('证券信息添加失败!\\n请重新添加！');window.location= \"../admin/page/security_add.jsp\";</script>");
            //response.sendRedirect("../user/page/index.jsp");

        }




    }
}
