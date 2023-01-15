package com.example.presensi_mahasiswa;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.ViewHolder> {
    private ArrayList<RiwayatModel> dataList;

    public RiwayatAdapter(ArrayList<RiwayatModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RiwayatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_riwayat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatAdapter.ViewHolder playerViewHolder, int i) {
        playerViewHolder.tanggal.setText(dataList.get(i).getTanggal());
        playerViewHolder.jam.setText(dataList.get(i).getJam());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tanggal, jam;

        public ViewHolder(View itemView) {
            super(itemView);
            tanggal = (TextView) itemView.findViewById(R.id.tanggal);
            jam = (TextView) itemView.findViewById(R.id.jamabsen);
        }
    }
}
