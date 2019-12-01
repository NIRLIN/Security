package servlet;

import dao.DaoAdminLogin;
import dao.DaoUserForgetPass;
import utils.AliSms;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/27 16:58
 */
@WebServlet(urlPatterns = "/servlet/ServletUserForgetPass",name = "ServletUserForgetPass")
public class ServletUserForgetPass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String name=request.getParameter("name");
        String phone=request.getParameter("phone");

        int count= DaoUserForgetPass.daoAdminLogin(name,phone);
        String code;
        if (count==1){
            code= AliSms.getAliSms(phone);
        }else {
            code="000000";
        }
        String s= "{\"result\":\""+count+"\",\"code\":\""+code+"\"}";
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");//返回的格式必须设置为application/json
        response.getWriter().write(s);
    }
}
