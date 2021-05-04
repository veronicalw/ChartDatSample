package com.example.diagramcovid;

import com.example.diagramcovid.CovidBar.Model;
import com.example.diagramcovid.SalesBar.ModelSales;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterface {
    @GET("provinsi")
    Call<List<Model>> getCovidData();

    @GET("v1/43062e4b-7bab-4499-81e5-c315dc013954")
    Call<List<ModelSales>> getSalesData();
}
