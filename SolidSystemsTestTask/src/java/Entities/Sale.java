package Entities;

import java.sql.Date;

public class Sale {

    private int saleId;
    private String prodname;
    private int count;
    private int sum;
    private Date date;

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getsaleId() {
        return saleId;
    }

    public String getProdname() {
        return prodname;
    }

    public int getSum() {
        return sum;
    }

    public int getCount() {
        return count;
    }

    public Date getDate() {
        return date;
    }
}
