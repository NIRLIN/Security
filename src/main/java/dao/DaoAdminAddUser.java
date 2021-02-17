package dao;

import po.Securitys;
import po.Users;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author NieLin
 * @version 1.0
 * @date 2019/11/28 9:27
 */
public class DaoAdminAddUser {
    public static int daoAdminAddUser(Users users){
        int count=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="INSERT INTO users (user_pass,user_name,user_sex,user_nationality,user_balance,user_profession,user_workunit,user_phone,user_idcard) VALUES (?,?,?,?,?,?,?,?,?)";


        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,users.getUser_pass());
            preparedStatement.setString(2,users.getUser_name());
            preparedStatement.setString(3,users.getUser_sex());
            preparedStatement.setString(4,users.getUser_nationality());
            preparedStatement.setDouble(5,users.getUser_balance());
            preparedStatement.setString(6,users.getUser_profession());
            preparedStatement.setString(7,users.getUser_workunit());
            preparedStatement.setString(8,users.getUser_phone());
            preparedStatement.setString(9,users.getUser_idcard());

            preparedStatement.execute();

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
