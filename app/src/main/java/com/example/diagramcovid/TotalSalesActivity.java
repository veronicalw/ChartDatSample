package com.example.diagramcovid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.diagramcovid.CovidBar.Model;
import com.example.diagramcovid.SalesBar.ModelSales;
import com.example.diagramcovid.SalesBar.Sales;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TotalSalesActivity extends AppCompatActivity {
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_sales);

        barChart = findViewById(R.id.BarChart);
        getBarChart();
    }

    private void getBarChart() {
        Call<List<ModelSales>> call = ApiClient.getSales().create(ApiInterface.class).getSalesData();
        call.enqueue(new Callback<List<ModelSales>>() {
            @Override
            public void onResponse(Call<List<ModelSales>> call, Response<List<ModelSales>> response) {
                if (response.body() != null){
                    List<BarEntry> barEntries = new ArrayList<>();
                    for (ModelSales sales: response.body()){
                        barEntries.add(new BarEntry(sales.getGetSalesList().getYear(), sales.getGetSalesList().getTotal_sales()));
                    }
                    ArrayList<Integer> colors = new ArrayList<>();

                    for (int c : ColorTemplate.VORDIPLOM_COLORS)
                        colors.add(c);

                    for (int c : ColorTemplate.JOYFUL_COLORS)
                        colors.add(c);

                    for (int c : ColorTemplate.COLORFUL_COLORS)
                        colors.add(c);

                    for (int c : ColorTemplate.LIBERTY_COLORS)
                        colors.add(c);

                    for (int c : ColorTemplate.PASTEL_COLORS)
                        colors.add(c);
                    colors.add(ColorTemplate.getHoloBlue());

                    BarDataSet barDataSet = new BarDataSet(barEntries, "Penjualan");
                    barDataSet.setColors(colors);

                    BarData barData = new BarData(barDataSet);
                    barData.setBarWidth(0.9f);

                    barChart.setVisibility(View.VISIBLE);
                    barChart.animateY(5000);
                    barChart.setData(barData);
                    barChart.setFitBars(true);

                    Description description = new Description();
                    description.setText("Total Penjualan Produk Apple per-tahun");

                    barChart.setDescription(description);
                    barChart.invalidate();
                }
            }

            @Override
            public void onFailure(Call<List<ModelSales>> call, Throwable t) {
                Log.d("TAG ERROR ", t.getMessage());
            }
        });
    }
}