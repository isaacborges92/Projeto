package com.estudo.projeto;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AddLocal extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_local);
        getSupportActionBar().setTitle(getString(R.string.add_local));
    }
}