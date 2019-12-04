package utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import dao.DaoAdminLogin;
import dao.DaoUserAddPay;
import dao.UseNameFindId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/12/2 21:08
 */
@WebServlet("/utils/AliPay")
public class AliPay extends HttpServlet {
    private static int order_no=100000;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String APP_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGFOjokHx3fhoYfLMNtPuS2YRX77bkLfl0V7kQDOrT+mb7K+K0hXtHaiaJWdtCqHVbFNXoDs71drTbl3I/3MaKzxtNJd2tavlvbXXHVjVLP+9QchW3QUPwvDE+nIyDPt/TKonLWKZs0egFm3GBbsXOATj6rX0ZuPMO3dx+l3Pw9oM+Gw70Umpv+ZVKO5SJEwJtNgTVX5pfiTzjnKH/I8UlORn/e/xI5t1ubYYr0BDUeI9A8hHGMYR6C+VUdIWTdzAX1220BwS93Nf/aE14No05SGsTGXvM/zB7PnvSc6bKHjsrWrH9qat8uX2jpbluk45auyTegb2brrX2jumiPEdpAgMBAAECggEALxJoMj2HdOvwfWhJ9CX1rDhxHe4qZzE8wnuJnPjr+D+Qp91gWcAC5698l/vT3jMGAFPwROfuAH8MP4uLsJ/xlAnhq9P/X0KPD29+Sd0aGLD5c2SZ+xwOnhVztGeBbRJFwfzNI3ab9tg6fL11u9sH1qrXNipyIPWtXyrEnizNp2phwn7Yy8eUP1krl0RTwpop3DXV4xbqyieytCg63wKXoFHcqXznHieyxs3CDf6v0hgnYNRbdwDoICC8PvW9H7wcKXrMC8gHGAP7Jt/yg89CW2Ro4fXgBc6DKv0n2JLrnx/ArdwrLaG0D6D1wsn029g/bGt1tUQBP4dS5idF4a6fgQKBgQC/KGNCKxLf+lR6o1mliF+2fZreV8ItEXxsmefm5FYny0FXr0umhJu5OweaTt+gKSemjhJ7NOcEbAbtZHH56S/TlGafb30jSWW96e8hcPK9RDunfu2jnep8GoE4snGnRlIGTvpgcpjr8jeWyuloJWs8ufJyyj/Q/BgKfmGtPXGR4wKBgQCzkDFD8dVwCOZ+4AeNXi/Ghjf3kh+WPRwooms3pERIlEEjkQ+/7LfngsqVvwXT0glqYQeBykylbbLC47RCFHT7P+RIUdhblGLzJ1SSh2xVW4RZZ63H2okIel8OMBaaMiK6lY6uuCP0wXYXlXH++UGmrA51L75KlM/J8JYjA7fTQwKBgQCscZHBUjwvw5LMI2ousyys4vh/lal8oKafDeQu3VN/iJOEt4VGTaBxY/gC0x5XTGkRjl7LuLiiu5UwOIm9Sgg0FU7Si2/XElJvFYb8ovjHlrM98XoNPNsYY4ypCgkPPpemSz8BHMApMZPGO3x90CvCV3iI5zzUmWZSqRoSfzhhwwKBgArBupHNbPHXNqenGAy59ba416V3FXlUk9lDUZT1vDl02CofSIhA0AuIZEZwORMlY/cBdQerbMgEOE9AgM3sl81tWGmUrZde3kaetoxInI7Ierc4ZMqyJr9hRUx+SPxXwIjY6MFCurSw2jgzda7Gk84+RGd0wruJCqGYTgYu9NYtAoGBAKs9iDtUsnEEDLcEyGCI9x6I3N/4K3XtJmQrYT5nSNXvtieymnc5IWGMLcTj7775GfXaPJDsM127gyOD4WqlgHQOjAeZqySF0NqZ1PkGa62oHFuph/PmESrU9LftndeaRG3hYNsks/Dhx4jlMFqXGGT9r42isM/IQ5k8zqd6Z6wj";
        String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAn+qy5LJNkKOu1rgVRBdzF5iwl70iQSEMiaI5y/LGOy8+aSIH3i3p/Bh8nCITZS/Mi/qZ+5WDYaVow/bc7evUGOUdSKqJQany4u/ARw0Rq6VVeCeU8ylifFfvnnDttLvkSGGHtJ5MMuiZiYnRubM5AkMxECS0Tj7/TKdiH8iF2CruRv1hzDkkMvdqPfm3h27FC1LPSa/YME96S4CHIfVD5Tc3b6EXbEwZm8Nw9dSPa4iAOWXqxxSW3zNE8tcH70r7m4KOJmGNiQz2+pFoCz5HgUcsC2E2JYAMP4BvGAt53yPq+AyMteyAqhLd833knGvgXfQLaO8bS5i1sUPNscic6QIDAQAB";

        String user_id= request.getParameter("user_id");

        String out_trade_no="20180020010"+order_no;
        order_no++;
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", "2016101600699486", APP_PRIVATE_KEY, "json", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
//        alipayRequest.setReturnUrl(request.getContextPath()+"/servlet/ServletUserPay");
        alipayRequest.setReturnUrl("http://60.205.190.186:8080"+request.getContextPath()+"/servlet/ServletUserPay?user_id="+user_id);
        alipayRequest.setNotifyUrl("http://60.205.190.186:8080"+request.getContextPath()+"/servlet/ServletFindOneUserInfo");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+out_trade_no+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":1000," +
                "    \"subject\":\"证券账户充值\"," +
                "    \"body\":\"证券账户充值\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

}
