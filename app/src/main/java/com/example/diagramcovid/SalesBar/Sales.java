package com.example.diagramcovid.SalesBar;

import com.google.gson.annotations.SerializedName;

public class Sales {
    @SerializedName("fid")
    Integer fid;

    @SerializedName("product")
    String product;

    @SerializedName("month")
    String month;

    @SerializedName("year")
    Float year;

    @SerializedName("total_sales")
    Integer total_sales;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Float getYear() {
        return year;
    }

    public void setYear(Float year) {
        this.year = year;
    }

    public Integer getTotal_sales() {
        return total_sales;
    }

    public void setTotal_sales(Integer total_sales) {
        this.total_sales = total_sales;
    }
}
