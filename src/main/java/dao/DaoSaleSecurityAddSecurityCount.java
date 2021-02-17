package dao;

import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoSaleSecurityAddSecurityCount {
    public static void daoSaleSecurityAddSecurityCount(int securitys_id,String securitys_residualquantity){
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        int securitys_residualquantity1=0;
        String sql1="select * from securitys where securitys_id=?";
        String sql2="update securitys set securitys_residualquantity=? where securitys_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setInt(1,securitys_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                securitys_residualquantity1=resultSet.getInt("securitys_residualquantity");
            }
            securitys_residualquantity1=securitys_residualquantity1+Integer.valueOf(securitys_residualquantity);


            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setInt(1,securitys_residualquantity1);
            preparedStatement.setInt(2,securitys_id);
            preparedStatement.executeUpdate();

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
    }
}
