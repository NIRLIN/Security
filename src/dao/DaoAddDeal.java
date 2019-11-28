package dao;

import utils.Utils;

import javax.naming.PartialResultException;
import java.io.CharConversionException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaoAddDeal {
    public static int daoAddDeal(String securitys_id,String user_id,String deal_count){
        int num=0;
        Connection connection= Utils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql1="select securitys_unitprice,securitys_residualquantity from securitys where securitys_id=?";
        String sql2="INSERT INTO `deals`(deal_time,deal_security_id,deal_user_id,deal_unitprice,deal_count,deal_pricesum) VALUES (?,?,?,?,?,?)";
        String sql3="UPDATE securitys SET securitys_residualquantity = ? WHERE securitys_id = ? ";
        String sql4="select * from deals where deal_security_id=? and deal_user_id=?";
        String sql5="UPDATE deals SET deal_count = ? ,deal_pricesum=? WHERE deal_security_id = ? ";
        String sql6="UPDATE users SET user_balance = ? WHERE user_id = ? ";
        String sql7="select * from users where user_id=?";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String deal_time=df.format(new Date());
        String deal_unitprice,deal_pricesum,securitys_residualquantity,deal_count1="0";
        try {
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,securitys_id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            deal_unitprice=resultSet.getString("securitys_unitprice");//获得证券单价
            securitys_residualquantity=resultSet.getString("securitys_residualquantity");//获得证券剩余数量

            deal_pricesum=String.valueOf((Double.valueOf(deal_unitprice))*(Double.valueOf(deal_count)));//计算购买所需总额

            preparedStatement=connection.prepareStatement(sql4);
            preparedStatement.setString(1,securitys_id);
            preparedStatement.setString(2,user_id);
            resultSet=preparedStatement.executeQuery();//获取此用户是否已购买过
            while (resultSet.next()){
                deal_count1=resultSet.getString("deal_count");
            }
            resultSet.first();
            resultSet.last();
            int num1=resultSet.getRow();

            if(num1!=1) {//将要交易的证券未被该用户购买过时进行插入操作
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1, deal_time);
                preparedStatement.setString(2, securitys_id);
                preparedStatement.setString(3, user_id);
                preparedStatement.setString(4, deal_unitprice);
                preparedStatement.setString(5, deal_count);
                preparedStatement.setString(6, deal_pricesum);
                num = preparedStatement.executeUpdate();//对deals表进行插入
            }
            if (num1==1){//将要购入的证券已经被购买过的进行数据修改操作
                deal_count1=String.valueOf(Double.valueOf(deal_count1)+Double.valueOf(deal_count));
                deal_pricesum=String.valueOf(Double.valueOf(deal_count1)*Double.valueOf(deal_unitprice));
                preparedStatement=connection.prepareStatement(sql5);
                preparedStatement.setString(1,deal_count1);
                preparedStatement.setString(2,deal_pricesum);
                preparedStatement.setString(3,securitys_id);
                num=preparedStatement.executeUpdate();
            }



            preparedStatement=connection.prepareStatement(sql3);
            securitys_residualquantity=String.valueOf((Double.valueOf(securitys_residualquantity))-(Double.valueOf(deal_count)));
            preparedStatement.setString(1,securitys_residualquantity);
            preparedStatement.setString(2,securitys_id);
            int num2=preparedStatement.executeUpdate();//对证券剩余数量进行修改

            //查询用户账户余额
            preparedStatement=connection.prepareStatement(sql7);
            preparedStatement.setString(1,user_id);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            double user_balance=resultSet.getDouble("user_balance");


            user_balance=user_balance-Double.valueOf(deal_count)*Double.valueOf(deal_unitprice);


            //修改用户账户余额

            preparedStatement=connection.prepareStatement(sql6);
            preparedStatement.setDouble(1,user_balance);
            preparedStatement.setString(2,user_id);
            int num3=preparedStatement.executeUpdate();


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
