package com.fadilla.penjualanalatoutdor.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fadilla.penjualanalatoutdor.Adapter.AdapterBarang;
import com.fadilla.penjualanalatoutdor.Model.ModelBarang;
import com.fadilla.penjualanalatoutdor.R;
import com.fadilla.penjualanalatoutdor.server.BaseURL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityDataBarang extends AppCompatActivity {

    ProgressDialog pDialog;

    AdapterBarang adapter;
    ListView list;

    ArrayList<ModelBarang> newsList = new ArrayList<ModelBarang>();
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_barang);

        getSupportActionBar().setTitle("Data Barang");
        mRequestQueue = Volley.newRequestQueue(this);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        list = (ListView) findViewById(R.id.array_list);
        newsList.clear();
        adapter = new AdapterBarang(ActivityDataBarang.this, newsList);
        list.setAdapter(adapter);
        getAllBarang();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ActivityDataBarang.this, HomeAdminActivity.class);
        startActivity(i);
        finish();
    }

    private void getAllBarang() {
        // Pass second argument as "null" for GET requests
        pDialog.setMessage("Loading");
        showDialog();
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, BaseURL.databarang, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        hideDialog();
                        try {
                            boolean status = response.getBoolean("error");
                            if (status == false) {
                                Log.d("data barang = ", response.toString());
                                String data = response.getString("data");
                                JSONArray jsonArray = new JSONArray(data);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    final ModelBarang barang = new ModelBarang();
                                    final String _id = jsonObject.getString("_id");
                                    final String kodebarang = jsonObject.getString("kodebarang");
                                    final String namabarang = jsonObject.getString("namabarang");
                                    final String jumlah = jsonObject.getString("jumlah");
                                    final String hargabarang = jsonObject.getString("hargabarang");
                                    final String gambar = jsonObject.getString("gambar");
                                    barang.setKodebarang(kodebarang);
                                    barang.setNamabarang(namabarang);
                                    barang.setJumlah(jumlah);
                                    barang.setHargabarang(hargabarang);
                                    barang.setGambar(gambar);

                                    barang.set_id(_id);

                                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                            // TODO Auto-generated method stub
                                            Intent a = new Intent(ActivityDataBarang.this, EditBarangDanHapusActivity.class);
                                            a.putExtra("kodebarang", newsList.get(position).getKodebarang());
                                            a.putExtra("_id", newsList.get(position).get_id());
                                            a.putExtra("namabarang", newsList.get(position).getNamabarang());
                                            a.putExtra("jumlah", newsList.get(position).getJumlah());
                                            a.putExtra("hargabarang", newsList.get(position).getHargabarang());
                                            a.putExtra("gambar", newsList.get(position).getGambar());
                                            startActivity(a);
                                        }
                                    });
                                    newsList.add(barang);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
                hideDialog();
            }
        });

        /* Add your Requests to the RequestQueue to execute */
        mRequestQueue.add(req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }



}