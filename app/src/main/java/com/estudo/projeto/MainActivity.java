package com.estudo.projeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int ADICIONAR_LUGAR = 1;
    public static final List<Lugar> lugarList = new ArrayList<>();

    private LugarAdapter lugarAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.lstLugares);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Lugar lugar = (Lugar)parent.getItemAtPosition(position); //retornaItem(position);
                Intent intent = new Intent(MainActivity.this,Informacoes.class);
                intent.putExtra("local", lugar.getNome());
                intent.putExtra("descricao", lugar.getDescricao());
                intent.putExtra("url", lugar.getUrl());
                intent.putExtra("end", lugar.getEndereco());

                //based on item add info to intent
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        lugarList.add(new Lugar("Estátua do Padre Cícero",
                                "Juazeiro do Norte",
                                "O monumento em homenagem ao Padre Cícero Romão Batista foi inaugurado no dia 1º de novembro de 1969, no alto da Serra do Catolé ou, como é mais conhecida, Colina do Horto, pelo então prefeito Mauro Sampaio. A estátua conta com 27 metros de altura, e se constitui na terceira maior do mundo em concreto, esculpida por Armando Lacerda em um local que era sempre escolhido pelo sacerdote para os seus retiros espirituais. Existe uma estimativa que aponta a visitação ao monumento na ordem de 2,5 milhões de pessoas por ano. De um lado fica o Museu Vivo e, do outro, enorme quadro da ceia larga com 17x4m, enquanto há alguns metros está sendo construída a Igreja de Bom Jesus do Horto.",
                                "http://www2.juazeiro.ce.gov.br/Cidade/g_Estatua-de-Padre-Cicero.jpg",
                                "Estátua do Padre Cícero na colina do Horto - Juazeiro do Norte - Ce"));

        lugarList.add(new Lugar("Paróquia de Nossa Senhora das Dores",
                                "Juazeiro do Norte",
                                "A Capela de Nossa Senhora foi construída em 1827, elevada a paróquia em 20 de janeiro de 1917, à Santuário em 2004 e à condição de Basílica Menor em 15 de setembro de 2008, tornando-se hoje um dos centros religiosos mais visitados do Nordeste.",
                                "http://diocesedecrato.org/wp-content/uploads/sites/10/2017/01/BASILICA1.jpg",
                                " Santuário Basílica de Nossa Senhora das Dores - Juazeiro do Norte - Ce"));

        lugarList.add(new Lugar("Memorial Padre Cícero",
                                "Juazeiro do Norte",
                                "O Memorial Padre Cícero foi inaugurado no dia 22 de julho de 1988 com a presença do então Presidente da República, José Sarney, para ser um ambiente de estudos, pesquisas e palestras sobre o sacerdote. Existe um museu com vários objetos que foram do seu uso pessoal, como vestimentas e louças, além de fotografias e algumas obras de arte da época. Na biblioteca do mesmo, uma vasta bibliografia reunindo as muitas obras de quem escreveu a favor e as poucas dos que pensavam diferente sobre o padre. O auditório tem capacidade para 400 pessoas e o Memorial foi construído no largo da Capela do Socorro, onde o sacerdote foi sepultado.",
                                "http://www2.juazeiro.ce.gov.br/Cidade/g_Memorial-Padre-Cicero.jpg",
                                "Memorial Padre Cícero - Juazeiro do Norte - Ce"));

        lugarList.add(new Lugar("Santuário de São Francisco das Chagas",
                                "Juazeiro do Norte",
                                "A Igreja dos Franciscanos fica localizada na Rua Monsenhor Juviniano Barreto, se constituindo num dos maiores e mais belos templos dessa ordem no Brasil.\n" +
                                        "No seu teto, citações de nomes de famílias que contribuíram de alguma maneira para a obra erguida em estilo lombardo-saxônico e na forma de Cruz Latina Dupla.\n" +
                                        " \n" +
                                        "A imagem de São Francisco no altar-mor foi esculpida em Gênova, na Itália, e outra em um enorme pedestal é circundada pela Praça das Almas, que são passarelas suspensas como réplica à Praça de São Pedro no Vaticano. Sua torre de 45 metros de altura conta com um bonito relógio e mais oito sinos que tocam trechos do Hino a São Francisco. O estilo é Romano “Lombardo”.\n" +
                                        "O imenso Santuário de São Francisco das Chagas comporta cerca de 30 mil cristãos em época de romaria.",
                                "http://www.miseria.com.br/fotos_not/2011/07/01/20120410141000_capa.jpg",
                                "Santuário São Francisco das Chagas - Juazeiro do Norte - Ce"));

        lugarAdapter = new LugarAdapter(getApplicationContext(), R.layout.item_lugar, lugarList);
        listView.setAdapter(lugarAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // User chose the "Settings" item, show the app settings UI...
                Intent intent = new Intent(MainActivity.this,AddLocal.class);
                startActivityForResult(intent, ADICIONAR_LUGAR);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADICIONAR_LUGAR) {
            if (resultCode == RESULT_OK) {
                lugarAdapter.notifyDataSetChanged();
                listView.setAdapter(lugarAdapter);
            }
        }
    }
}
