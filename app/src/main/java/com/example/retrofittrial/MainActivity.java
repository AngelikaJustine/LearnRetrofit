package com.example.retrofittrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofittrial.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private MainAdapter mainAdapter;
    private List<MainModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupView();
        setupRecycleView();

        getDataFromApi();
    }

    private void setupView(){
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecycleView(){
        mainAdapter = new MainAdapter(results, new MainAdapter.onAdapterListener() {
            @Override
            public void onClick(MainModel.Result data) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", data.getTitle());
                intent.putExtra("image", data.getImage());
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

    private void getDataFromApi(){

        progressBar.setVisibility(View.VISIBLE);

        ApiService.endPoint().getData().enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                progressBar.setVisibility(View.GONE);

                if(response.isSuccessful()){
                    List<MainModel.Result> results = response.body().getResults();
                    Log.d(TAG, results.toString());
                    mainAdapter.setData(results);
                }
            }

            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });

    }
}