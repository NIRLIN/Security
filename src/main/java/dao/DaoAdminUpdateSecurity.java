package dao;

import po.Securitys;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/29 13:48
 */
public class DaoAdminUpdateSecurity {
    public static int daoAdminUpdateSecurity(Securitys securitys){
        int count=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="update securitys set securitys_short=?,securitys_companyname=?,securitys_phone=?,securitys_unitprice=?,securitys_residualquantity=?,securitys_totalquantity=?,securitys_address=?,securitys_appeardata=? where securitys_id=?";





        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,securitys.getSecuritys_short());
            preparedStatement.setString(2,securitys.getSecuritys_companyname());
            preparedStatement.setString(3,securitys.getSecuritys_phone());
            preparedStatement.setFloat(4,securitys.getSecuritys_unitprice());
            preparedStatement.setInt(5,securitys.getSecuritys_residualquantity());
            preparedStatement.setInt(6,securitys.getSecuritys_totalquantity());
            preparedStatement.setString(7,securitys.getSecuritys_address());
            preparedStatement.setString(8, securitys.getSecuritys_appeardata1());
            preparedStatement.setInt(9,securitys.getSecuritys_id());
            preparedStatement.executeUpdate();

            count=1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null)
                    connection.close();
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        return count;
    }
}
