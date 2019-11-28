package dao;

import po.Deals;
import po.Users;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoAdminFindAllUser {
    public static ArrayList daoAdminFindAllUser(){
        ArrayList<Users> list=new ArrayList<>();
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultset=null;

        String sql="select * from users";
        try{
            preparedStatement=connection.prepareStatement(sql);
            resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                Users users=new Users();
                users.setUser_id(resultset.getInt("user_id"));
                users.setUser_pass(resultset.getString("user_pass"));
                users.setUser_name(resultset.getString("user_name"));
                users.setUser_sex(resultset.getString("user_sex"));
                users.setUser_nationality(resultset.getString("user_nationality"));
                users.setUser_balance(resultset.getDouble("user_balance"));
                users.setUser_profession(resultset.getString("user_profession"));
                users.setUser_workunit(resultset.getString("user_workunit"));
                users.setUser_phone(resultset.getString("user_phone"));
                users.setUser_idcard(resultset.getString("user_idcard"));
                list.add(users);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                if (connection!=null)
                    connection.close();
                if (preparedStatement!=null)
                    preparedStatement.close();
                if (resultset!=null)
                    resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
