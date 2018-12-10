package com.example.wahab.portalti16;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.wahab.portalti16.Adapter.MahasiswaAdapter;
import com.example.wahab.portalti16.Entity.DaftarMahasiswa;
import com.example.wahab.portalti16.Network.Network;
import com.example.wahab.portalti16.Network.Router;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;
    public Button button_tambah;
    LinearLayoutManager llm=new LinearLayoutManager(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView)findViewById(R.id.lst_mahasiswa);
        recyclerView.setLayoutManager(llm);
        //casting Button
        button_tambah = (Button)findViewById(R.id.btnTambah);
        requestDaftarMahasiswa();
    }

    @Override
    protected void onStart() {
        super.onStart();
        requestDaftarMahasiswa();
        btnTambah();
    }

    private void requestDaftarMahasiswa(){
        Router services = Network.request().create(Router.class);
        services.getMahasiswa().enqueue(new Callback<DaftarMahasiswa>() {
            @Override
            public void onResponse(Call<DaftarMahasiswa> call, Response<DaftarMahasiswa> response) {
                //cek request yang dilakukan, berhasil atau tidak
                if(response.isSuccessful()){
                    DaftarMahasiswa mahasiswas = response.body();
                    Log.d("TI16", mahasiswas.getTitle());
                    MahasiswaAdapter adapter = new MahasiswaAdapter(mahasiswas.getData());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<DaftarMahasiswa> call, Throwable t) {
                onMahasiswaError();
            }
        });
    }

    private void onMahasiswaError(){
        Toast.makeText(MainActivity.this,"Gagal, Silahkan periksa koneksi internet anda",Toast.LENGTH_LONG).show();
    }

    private void btnTambah() {
        button_tambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(MainActivity.this, AddMahasiswaActivity.class);
                startActivity(tambah);
            }
        });
    }
}
