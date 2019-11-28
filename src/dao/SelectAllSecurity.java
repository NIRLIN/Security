package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import po.Securitys;
import utils.Utils;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class SelectAllSecurity {
    public ArrayList selectAllSecurity(){
        Connection conn = Utils.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Securitys> list=new ArrayList<>();
        String sql = "select * from securitys";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {//对证券信息进行操作
                Securitys securitys = new Securitys();
                securitys.setSecuritys_id(rs.getInt("securitys_id"));
                securitys.setSecuritys_short(rs.getString("securitys_short"));
                securitys.setSecuritys_companyname(rs.getString("securitys_companyname"));
                securitys.setSecuritys_unitprice(rs.getFloat("securitys_unitprice"));
                securitys.setSecuritys_residualquantity(rs.getInt("securitys_residualquantity"));
                securitys.setSecuritys_totalquantity(rs.getInt("securitys_totalquantity"));
                securitys.setSecuritys_address(rs.getString("securitys_address"));
                securitys.setSecuritys_appeardata(rs.getDate("securitys_appeardata"));
                list.add(securitys);//添加商品信息
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(conn!=null)
                         conn.close();
                    if (rs!=null)
                        rs.close();
                    if (pst!=null)
                        pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return list;
    }
}
