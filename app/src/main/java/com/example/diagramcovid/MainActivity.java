package com.example.diagramcovid;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;

import com.example.diagramcovid.CovidBar.Model;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = findViewById(R.id.PieChart);
        getPieChart();

    }

    private void getPieChart(){
        Call<List<Model>> call = ApiClient.getApiCovid().create(ApiInterface.class).getCovidData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.body() != null){
                    List<PieEntry> covidEntries = new ArrayList<>();
                    for (Model covid : response.body()){
                        covidEntries.add(new PieEntry(covid
                                .getmAttributes().getKasus_Posi(), covid.getmAttributes().getProvinsi()));
                        pieChart.animateXY(5000,5000);

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

                        PieDataSet pieDataSet = new PieDataSet(covidEntries, "Jumlah kasus covid per-provinsi");
                        pieDataSet.setColors(colors);

                        PieData pieData = new PieData(pieDataSet);
                        pieChart.setData(pieData);

                        Description description = new Description();
                        description.setText("Kasus Positif Covid-19");
                        pieChart.setDescription(description);
                        pieChart.invalidate();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("TAG ERROR : " , t.getMessage());
            }
        });
    }
}