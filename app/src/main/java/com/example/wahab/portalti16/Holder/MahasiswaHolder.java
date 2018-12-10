package com.example.wahab.portalti16.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wahab.portalti16.R;

/**
 * Created by wahab on 10/12/18.
 */

public class MahasiswaHolder extends RecyclerView.ViewHolder {
    public TextView txt_nama;
    public TextView txt_nim;

    public MahasiswaHolder(View itemView) {
        super(itemView);
        txt_nama = (TextView) itemView.findViewById(R.id.tnama);
        txt_nim = (TextView) itemView.findViewById(R.id.tnim);
    }
}
