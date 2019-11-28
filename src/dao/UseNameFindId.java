package dao;

import jdk.jshell.execution.Util;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseNameFindId {
    public static String useNameFindId(String name){
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from users where user_name=?";
        String user_id="";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            user_id=String.valueOf(resultSet.getInt("user_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null)
                    connection.close();
                if (preparedStatement!=null)
                    preparedStatement.close();
                if (resultSet!=null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user_id;

    }
}
