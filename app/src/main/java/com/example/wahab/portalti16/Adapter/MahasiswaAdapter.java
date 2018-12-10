package com.example.wahab.portalti16.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wahab.portalti16.Entity.Mahasiswa;
import com.example.wahab.portalti16.Holder.MahasiswaHolder;
import com.example.wahab.portalti16.R;

import java.util.List;

/**
 * Created by wahab on 10/12/18.
 */

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaHolder> {

    private List<Mahasiswa> mahasiswas;
    public MahasiswaAdapter(List<Mahasiswa> mahasiswas){
        this.mahasiswas=mahasiswas;
    }



    @Override
    public MahasiswaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        MahasiswaHolder holder = new MahasiswaHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MahasiswaHolder holder, int position) {
        holder.txt_nama.setText(mahasiswas.get(position).getName());
        holder.txt_nim.setText(mahasiswas.get(position).getNim());
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }

}