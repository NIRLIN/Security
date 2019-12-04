package dao;


import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/27 17:04
 */
public class DaoUserAddPay {
    public static int daoAdminLogin(String user_id){
        int num=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="update   users set user_balance=user_balance+1000 where user_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user_id);
            num=preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null)
                    connection.close();
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return num;
    }
}
