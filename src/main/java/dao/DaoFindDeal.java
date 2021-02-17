package dao;


import po.Deals;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoFindDeal {
    public static Deals daoFindDeal(String deal_id){
        Deals deals=new Deals();
        deals.setDeal_id(Integer.valueOf(deal_id));
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from deals where deal_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,deal_id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                deals.setDeal_time(resultSet.getDate("deal_time"));
                deals.setDeal_security_id(Integer.valueOf(resultSet.getString("deal_security_id")));
                deals.setDeal_user_id(Integer.valueOf(resultSet.getString("deal_user_id")));
                deals.setDeal_unitprice(resultSet.getDouble("deal_unitprice"));
                deals.setDeal_count(resultSet.getInt("deal_count"));
                deals.setDeal_pricesum(resultSet.getDouble("deal_pricesum"));
            }
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


        return deals;
    }
}
