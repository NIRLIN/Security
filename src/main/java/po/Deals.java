package po;

import java.util.Date;

public class Deals {

    private int deal_id;
    private Date deal_time;
    private int deal_security_id;
    private int deal_user_id;
    private double deal_unitprice;
    private int deal_count;
    private double deal_pricesum;

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public Date getDeal_time() {
        return deal_time;
    }

    public void setDeal_time(Date deal_time) {
        this.deal_time = deal_time;
    }

    public int getDeal_security_id() {
        return deal_security_id;
    }

    public void setDeal_security_id(int deal_security_id) {
        this.deal_security_id = deal_security_id;
    }

    public int getDeal_user_id() {
        return deal_user_id;
    }

    public void setDeal_user_id(int deal_user_id) {
        this.deal_user_id = deal_user_id;
    }

    public double getDeal_unitprice() {
        return deal_unitprice;
    }

    public void setDeal_unitprice(double deal_unitprice) {
        this.deal_unitprice = deal_unitprice;
    }

    public int getDeal_count() {
        return deal_count;
    }

    public void setDeal_count(int deal_count) {
        this.deal_count = deal_count;
    }

    public double getDeal_pricesum() {
        return deal_pricesum;
    }

    public void setDeal_pricesum(double deal_pricesum) {
        this.deal_pricesum = deal_pricesum;
    }


}
