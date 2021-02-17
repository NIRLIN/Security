package dao;

import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoFindUserHaveSecurity {
    public static int daoFindUserHaveSecurity(String user_name,String securitys_id){
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String user_id;
        int deal_count=0;
        String sql1="select user_id from users where user_name=?";
        String sql2="select deal_count from deals where deal_user_id=? and deal_security_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,user_name);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            user_id=String.valueOf(resultSet.getInt("user_id"));
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setString(1,user_id);
            preparedStatement.setString(2,securitys_id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            deal_count=resultSet.getInt("deal_count");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return deal_count;
    }
}
