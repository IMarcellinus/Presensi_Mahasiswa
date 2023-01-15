package com.example.presensi_mahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RiwayatPresensi extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

//      Memanggil fungsi getData dari menurut nim, ganti nim jika perlu
        GetData("4.33.20.0.24");
    }

    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        super.onBackPressed();
    }

    public void GetData(String nim){
//        Call Api Base URL
        BaseURLApi retrofit = new BaseURLApi();
        Call<List<RiwayatModel>> call = retrofit.RetrofitUtilils().getRiwayat(nim);

        call.enqueue(new Callback<List<RiwayatModel>>() {
            @Override
            public void onResponse(Call<List<RiwayatModel>> call, Response<List<RiwayatModel>> response) {
                List<RiwayatModel> responseFromAPI = response.body();

                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleview);
                RiwayatAdapter adapter = new RiwayatAdapter((ArrayList<RiwayatModel>) responseFromAPI);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RiwayatPresensi.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<RiwayatModel>> call, Throwable t) {
                Log.e("anu", t.getMessage());
            }
        });
    }
}
