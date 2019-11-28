package dao;

import com.mysql.cj.protocol.Resultset;
import po.Deals;
import utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectUserHaveSecurity {
    public static ArrayList selectUserHaveSecurity(String userid){
        ArrayList<Deals> list=new ArrayList<>();
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultset=null;

        String sql="select * from deals where deal_user_id=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userid);
            resultset=preparedStatement.executeQuery();
            while (resultset.next()){
                Deals deals=new Deals();
                deals.setDeal_id(resultset.getInt("deal_id"));
                deals.setDeal_time(resultset.getDate("deal_time"));
                deals.setDeal_security_id(resultset.getInt("deal_security_id"));
                deals.setDeal_user_id(resultset.getInt("deal_user_id"));
                deals.setDeal_unitprice(resultset.getDouble("deal_unitprice"));
                deals.setDeal_count(resultset.getInt("deal_count"));
                deals.setDeal_pricesum(resultset.getDouble("deal_pricesum"));
                list.add(deals);
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
