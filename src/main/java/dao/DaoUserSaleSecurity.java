package dao;

import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUserSaleSecurity {
    public static int daoUserSaleSecurity(String user_id,String deal_id,String deal_count){
        int num=0;
        int deal_count1=0;
        String deal_count2=deal_count;
        double deal_pricenum=0,deal_pricenum1=0;
        double deal_unitprice=0;
        double user_balance=0;
        int deal_security_id=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql1="select * from deals where deal_id=?";
        String sql2="update deals set deal_count=?,deal_pricesum=? where deal_id=?";
        String sql3="select user_balance from users where user_id=?";
        String sql4="update users set user_balance=? where user_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,deal_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                deal_count1=resultSet.getInt("deal_count");
                deal_pricenum=resultSet.getDouble("deal_pricesum");
                deal_unitprice=resultSet.getDouble("deal_unitprice");
                deal_security_id=resultSet.getInt("deal_security_id");
            }
            deal_pricenum=deal_pricenum-deal_unitprice*Integer.valueOf(deal_count);
            deal_pricenum1=deal_unitprice*Integer.valueOf(deal_count);
            deal_count=String.valueOf(deal_count1-Double.valueOf(deal_count));

            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setString(1,deal_count);
            preparedStatement.setDouble(2,deal_pricenum);
            preparedStatement.setString(3,deal_id);
            num=preparedStatement.executeUpdate();//修改deals表中的deal_count,deal_pricesum

            preparedStatement=connection.prepareStatement(sql3);
            preparedStatement.setString(1,user_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user_balance=resultSet.getDouble("user_balance");
            }
            user_balance=user_balance+deal_pricenum1;


            preparedStatement=connection.prepareStatement(sql4);
            preparedStatement.setDouble(1,user_balance);
            preparedStatement.setString(2,user_id);
            int num1=preparedStatement.executeUpdate();


            DaoSaleSecurityAddSecurityCount.daoSaleSecurityAddSecurityCount(deal_security_id,deal_count2);




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

        return num;
    }
}
