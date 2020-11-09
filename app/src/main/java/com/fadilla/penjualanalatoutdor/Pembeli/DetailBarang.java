package com.fadilla.penjualanalatoutdor.Pembeli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.fadilla.penjualanalatoutdor.R;
import com.fadilla.penjualanalatoutdor.server.BaseURL;
import com.squareup.picasso.Picasso;

public class DetailBarang extends AppCompatActivity {
    EditText edtKodeBarang, edtNamaBarang, edtJumlah, edtHargaBarang;
    ImageView imgGambarBarang;

    String strKodeBarang, strNamaBarang, strJumlah, strHargaBarang, strGamabr, _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        edtKodeBarang = (EditText) findViewById(R.id.edtKodeBarang);
        edtNamaBarang = (EditText) findViewById(R.id.edtNamaBarang);
        edtJumlah = (EditText) findViewById(R.id.edtJumlah);
        edtHargaBarang = (EditText) findViewById(R.id.edtHargaBarang);

        imgGambarBarang = (ImageView) findViewById(R.id.gambar);

        Intent i = getIntent();
        strKodeBarang = i.getStringExtra("kodebarang");
        strNamaBarang = i.getStringExtra("namabarang");
        strJumlah = i.getStringExtra("jumlah");
        strHargaBarang = i.getStringExtra("hargabarang");
        strGamabr = i.getStringExtra("gambar");
        _id = i.getStringExtra("_id");
        edtKodeBarang.setText(strKodeBarang);
//        edtJudulBuku.setText(strJudulBuku);
        edtNamaBarang.setText(strNamaBarang);
        edtJumlah.setText(strJumlah);
        edtHargaBarang.setText(strHargaBarang);
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + strGamabr)
                .into(imgGambarBarang);
    }
}