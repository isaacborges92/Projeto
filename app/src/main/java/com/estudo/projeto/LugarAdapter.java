package com.estudo.projeto;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Isaac on 07/08/2017.
 */

public class LugarAdapter extends ArrayAdapter<Lugar> {


    public LugarAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Lugar> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Lugar lugar = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_lugar, parent, false);
        }

        TextView txtNome = (TextView)convertView.findViewById(R.id.txtNome);
        TextView txtCidade = (TextView)convertView.findViewById(R.id.txtCidade);
        ImageView imagem = (ImageView)convertView.findViewById(R.id.imagem);

        txtNome.setText(lugar.getNome());
        txtCidade.setText(lugar.getCidade());

        Picasso.with(getContext())
                .load(lugar.getUrl())
                .fit()
                .centerCrop()
                .into(imagem);

        return convertView;
    }
}
