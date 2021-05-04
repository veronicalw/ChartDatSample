package com.example.diagramcovid.SalesBar;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ModelSales implements Serializable {
    @SerializedName("sales")
    private Sales getSalesList;

    public Sales getGetSalesList() {
        return getSalesList;
    }

    public void setGetSalesList(Sales getSalesList) {
        this.getSalesList = getSalesList;
    }
//    @SerializedName("product")
//    private Object getProduct = null;
//
//    @SerializedName("month")
//    private Object getMonth = null;
//
//    @SerializedName("total_sales")
//    private Object getTotalSales = null;
//
//    public Object getGetProduct() {
//        return getProduct;
//    }
//
//    public Object getGetMonth() {
//        return getMonth;
//    }
//
//    public Object getGetTotalSales() {
//        return getTotalSales;
//    }

}
