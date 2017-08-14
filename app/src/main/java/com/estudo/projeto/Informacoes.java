package com.estudo.projeto;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class Informacoes extends AppCompatActivity {

    private ImageView img;
    private TextView descricao;
    private Button btnMapa;

    public static final int SIMPLE_NOTIFICATION_ID = 10001;
    public static final int BIG_NOTIFICATION_ID = 10002;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        img = (ImageView)findViewById(R.id.img);
        descricao = (TextView)findViewById(R.id.descricao);
        btnMapa = (Button)findViewById(R.id.btnMapa);

        getSupportActionBar().setTitle(getIntent().getStringExtra("local")); //Possibilita a compatibilidade com todas as versões

        String url = getIntent().getStringExtra("url");
        String desc = getIntent().getStringExtra("descricao");
        final String endereco = getIntent().getStringExtra("end");

        Picasso.with(this)
                .load(url)
                .into(img);

        descricao.setText(desc);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + endereco));
                if(it.resolveActivity(getPackageManager()) != null) {
                    startActivity(it);
                }else{
                    Toast.makeText(Informacoes.this, "Não existe aplicação de mapa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
