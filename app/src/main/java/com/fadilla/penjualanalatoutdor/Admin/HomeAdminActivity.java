package com.fadilla.penjualanalatoutdor.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import com.fadilla.penjualanalatoutdor.R;
import com.fadilla.penjualanalatoutdor.Session.PrefSetting;
import com.fadilla.penjualanalatoutdor.Session.SessionManager;
import com.fadilla.penjualanalatoutdor.Users.LoginActivity;

import java.util.Calendar;

public class HomeAdminActivity extends AppCompatActivity {

    SessionManager session;
    SharedPreferences prefs;
    PrefSetting prefSetting;
    CardView cardExit, cardDataBarang, cardInputBarang, cardProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        prefSetting = new PrefSetting(this);
        prefs = prefSetting.getSharePreferances();

        session = new SessionManager(HomeAdminActivity.this);

        prefSetting.isLogin(session, prefs);

        cardExit = (CardView) findViewById(R.id.cardExit);
        cardDataBarang = (CardView) findViewById(R.id.cardDataBarang);
        cardInputBarang = (CardView) findViewById(R.id.cardInputBarang);
        cardProfile = (CardView) findViewById(R.id.cardProfile);

        cardExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setLogin(false);
                session.setSessid(0);
                Intent i = new Intent(HomeAdminActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        cardDataBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, ActivityDataBarang.class);
                startActivity(i);
                finish();
            }
        });

        cardInputBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, InputDataBarang.class);
                startActivity(i);
                finish();
            }
        });

        cardProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeAdminActivity.this, Profile.class);
                startActivity(i);
                finish();
            }
        });
    }
}