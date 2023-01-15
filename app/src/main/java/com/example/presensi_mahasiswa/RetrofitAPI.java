package com.example.presensi_mahasiswa;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitAPI {
    @POST("api.php")
    Call<Data> createPost(@Body Data data);

    @GET("riwayat.php")
    Call<List<RiwayatModel>> getRiwayat(@Query("nim") String nim);
}

