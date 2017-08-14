package com.estudo.projeto;

import android.graphics.Bitmap;

/**
 * Created by Isaac on 07/08/2017.
 */

public class Lugar {

    private String nome, cidade, descricao, url, endereco;
    private Bitmap bmp;

    public Lugar(String nome, String cidade, String descricao, String url, String endereco){
        this.nome = nome;
        this.cidade = cidade;
        this.descricao = descricao;
        this.url = url;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
