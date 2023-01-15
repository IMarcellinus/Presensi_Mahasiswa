package com.example.presensi_mahasiswa;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.Result;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        mScannerView.setAspectTolerance(0.5f);
        setContentView(mScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult){
//       Log.v("TAG", rawResult.getText());
//       Log.v("TAG", rawResult.getBarcodeFormat().toString());
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Scan Result");
//        builder.setMessage(rawResult.getText());
//        AlertDialog alert1 = builder.create();
//        alert1.show();
        postData("4.33.20.0.24", rawResult.getText());

        mScannerView.resumeCameraPreview(this);
    }

    private void postData(String nim, String kode){
        BaseURLApi retrofit = new BaseURLApi();
        Data data = new Data(nim, kode);

        Call<Data> call = retrofit.RetrofitUtilils().createPost(data);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data responseFromAPI = response.body();

                if (responseFromAPI.getStatus()) {
                    startActivity(new Intent(getApplicationContext(), PresensiSuccess.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), PresensiFailed.class));
                }

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(ScannerActivity.this, "Sesuatu ada yang salah!!!", Toast.LENGTH_SHORT).show();
                Log.e("anu", t.getMessage());
            }
        });
    }

}
