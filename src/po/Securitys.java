package po;

import javax.print.DocFlavor;
import java.util.Date;

public class Securitys {
    private int securitys_id;
    private String securitys_short;
    private String securitys_companyname;
    private float securitys_unitprice;
    private int securitys_residualquantity;
    private int securitys_totalquantity;
    private String securitys_address;
    private String securitys_phone;

    public String getSecuritys_phone() {
        return securitys_phone;
    }

    public void setSecuritys_phone(String securitys_phone) {
        this.securitys_phone = securitys_phone;
    }

    private Date securitys_appeardata;

    public int getSecuritys_id() {
        return securitys_id;
    }

    public void setSecuritys_id(int security_id) {
        this.securitys_id = security_id;
    }

    public String getSecuritys_short() {
        return securitys_short;
    }

    public void setSecuritys_short(String securitys_short) {
        this.securitys_short = securitys_short;
    }

    public String getSecuritys_companyname() {
        return securitys_companyname;
    }

    public void setSecuritys_companyname(String securitys_companyname) {
        this.securitys_companyname = securitys_companyname;
    }

    public float getSecuritys_unitprice() {
        return securitys_unitprice;
    }

    public void setSecuritys_unitprice(float securitys_unitprice) {
        this.securitys_unitprice = securitys_unitprice;
    }

    public int getSecuritys_residualquantity() {
        return securitys_residualquantity;
    }

    public void setSecuritys_residualquantity(int securitys_residualquantity) {
        this.securitys_residualquantity = securitys_residualquantity;
    }

    public int getSecuritys_totalquantity() {
        return securitys_totalquantity;
    }

    public void setSecuritys_totalquantity(int securitys_totalquantity) {
        this.securitys_totalquantity = securitys_totalquantity;
    }

    public String getSecuritys_address() {
        return securitys_address;
    }

    public void setSecuritys_address(String securitys_address) {
        this.securitys_address = securitys_address;
    }

    public Date getSecuritys_appeardata() {
        return securitys_appeardata;
    }

    public void setSecuritys_appeardata(Date securitys_appeardata) {
        this.securitys_appeardata = securitys_appeardata;
    }

}
