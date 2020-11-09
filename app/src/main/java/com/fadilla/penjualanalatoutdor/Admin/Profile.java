package com.fadilla.penjualanalatoutdor.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.fadilla.penjualanalatoutdor.R;
import com.fadilla.penjualanalatoutdor.Session.PrefSetting;

public class Profile extends AppCompatActivity {

    TextView txtUserName, txtNamaLengkap, txtEmail, txtNotelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setTitle("Profile User");

        txtUserName = (TextView) findViewById(R.id.userName);
        txtNamaLengkap = (TextView) findViewById(R.id.namaLengkap);
        txtEmail = (TextView) findViewById(R.id.email);
        txtNotelp = (TextView) findViewById(R.id.noTelp);

        txtUserName.setText(PrefSetting.username);
        txtNamaLengkap.setText(PrefSetting.namalengkap);
        txtEmail.setText(PrefSetting.email);
        txtNotelp.setText(PrefSetting.notelp);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Profile.this, HomeAdminActivity.class);
        startActivity(i);
        finish();
    }
}