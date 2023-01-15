package com.example.presensi_mahasiswa;

public class Data {
    // string variables for our name and job
    private String nim;
    private String kode;
    private boolean status;

    public Data(String nim, String kode) {
        this.nim = nim;
        this.kode = kode;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public boolean getStatus() {return  status;}

    public void setStatus(boolean status) { this.status = status; }
}
