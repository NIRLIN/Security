package dao;

import po.Users;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUpdataUserInfo {
    public static int daoUpdataUserInfo(Users users){
        int num=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="UPDATE users SET user_name=?,user_sex=?,user_nationality=?,user_profession=?,user_workunit=?,user_phone=?,user_idcard=? WHERE user_id = ? ";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,users.getUser_name());
            preparedStatement.setString(2,users.getUser_sex());
            preparedStatement.setString(3,users.getUser_nationality());
            preparedStatement.setString(4,users.getUser_profession());
            preparedStatement.setString(5,users.getUser_workunit());
            preparedStatement.setString(6,users.getUser_phone());
            preparedStatement.setString(7,users.getUser_idcard());
            preparedStatement.setString(8,String.valueOf(users.getUser_id()));
            num=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null)
                    connection.close();
                if (preparedStatement!=null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return num;
    }
}
