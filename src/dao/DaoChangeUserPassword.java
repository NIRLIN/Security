package dao;

import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoChangeUserPassword {
    public static int daoChangeUserPassword(String user_id, String old_password, String new_password) {
        int num = 0;
        Connection connection = Utils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql1 = "select user_pass from users where user_id=?";
        String sql2 = "UPDATE users SET user_pass = ? WHERE user_id = ? ";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, user_id);
            resultSet = preparedStatement.executeQuery();
            String old_password1 = "-1";
            while (resultSet.next()) {
                old_password1 = resultSet.getString("user_pass");
            }
            if (old_password.equals(old_password1)) {
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1, new_password);
                preparedStatement.setString(2, user_id);
                num = preparedStatement.executeUpdate();
            } else {
                num = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
