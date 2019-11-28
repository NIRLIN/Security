package dao;

import jdk.jshell.execution.Util;
import utils.Utils;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
    public static int userLogin(String name,String password){
        int count=-1;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from users where user_name=? and user_pass=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            count=resultSet.getRow();
        }catch (SQLException e){
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
        return count;
    }
}
