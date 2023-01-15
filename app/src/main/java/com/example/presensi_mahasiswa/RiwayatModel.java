package com.example.presensi_mahasiswa;

public class RiwayatModel {
    private String tanggal;
    private String jam;

//    public RiwayatModel(String tanggal, String jam) {
//        this.tanggal = tanggal;
//        this.jam = jam;
//    }

    public RiwayatModel() {
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
