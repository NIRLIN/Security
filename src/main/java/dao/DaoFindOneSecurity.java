package dao;

import po.Securitys;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoFindOneSecurity {
    public static Securitys daoFindOneSecurity(String securitys_id) {
        Securitys securitys = new Securitys();
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from securitys where securitys_id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,securitys_id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            securitys.setSecuritys_id(resultSet.getInt("securitys_id"));
            securitys.setSecuritys_short(resultSet.getString("securitys_short"));
            securitys.setSecuritys_companyname(resultSet.getString("securitys_companyname"));
            securitys.setSecuritys_unitprice(resultSet.getFloat("securitys_unitprice"));
            securitys.setSecuritys_residualquantity(resultSet.getInt("securitys_residualquantity"));
            securitys.setSecuritys_totalquantity(resultSet.getInt("securitys_totalquantity"));
            securitys.setSecuritys_address(resultSet.getString("securitys_address"));
            securitys.setSecuritys_appeardata(resultSet.getDate("securitys_appeardata"));
            securitys.setSecuritys_phone(resultSet.getString("securitys_phone"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        return securitys;
    }
}
