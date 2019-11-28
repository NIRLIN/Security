package dao;

import po.Users;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectOneUser {
    public static Users FindUser(String name){
        Users users=new Users();
        Connection conn= Utils.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select * from users where user_name=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            rs=pst.executeQuery();
            while (rs.next()){
                users.setUser_id(rs.getInt("user_id"));
                users.setUser_pass(rs.getString("user_pass"));
                users.setUser_name(rs.getString("user_name"));
                users.setUser_sex(rs.getString("user_sex"));
                users.setUser_nationality(rs.getString("user_nationality"));
                users.setUser_balance(rs.getDouble("user_balance"));
                users.setUser_profession(rs.getString("user_profession"));
                users.setUser_workunit(rs.getString("user_workunit"));
                users.setUser_phone(rs.getString("user_phone"));
                users.setUser_idcard(rs.getString("user_idcard"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn!=null)
                    conn.close();
                if (pst!=null)
                    pst.close();
                if (rs!=null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return users;
    }
}
