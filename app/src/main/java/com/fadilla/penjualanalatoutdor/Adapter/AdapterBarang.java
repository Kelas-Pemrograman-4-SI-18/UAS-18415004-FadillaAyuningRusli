package com.fadilla.penjualanalatoutdor.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fadilla.penjualanalatoutdor.Model.ModelBarang;
import com.fadilla.penjualanalatoutdor.R;
import com.fadilla.penjualanalatoutdor.server.BaseURL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBarang extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<ModelBarang> item;

    public AdapterBarang(Activity activity, List<ModelBarang> item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.content_barang, null);


        TextView namabarang = (TextView) convertView.findViewById(R.id.txtnamabarang);
        TextView kodebarang     = (TextView) convertView.findViewById(R.id.txtkodebarang);
        TextView harga         = (TextView) convertView.findViewById(R.id.txtharga);
        TextView jumlah         = (TextView) convertView.findViewById(R.id.txtjumlah);
        ImageView gambarbarang         = (ImageView) convertView.findViewById(R.id.gambarbarang);

        namabarang.setText(item.get(position).getNamabarang());
        kodebarang.setText(item.get(position).getKodebarang());
        harga.setText("Rp." + item.get(position).getHargabarang());
        jumlah.setText(item.get(position).getJumlah());
        Picasso.get().load(BaseURL.baseUrl + "gambar/" + item.get(position).getGambar())
                .resize(40, 40)
                .centerCrop()
                .into(gambarbarang);
        return convertView;
    }
}
