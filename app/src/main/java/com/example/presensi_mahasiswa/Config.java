package com.example.presensi_mahasiswa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface Config {
    @GET("riwayat.php")
    Call<Riwayat> createPost(@Body Riwayat riwayat);
}
