package com.estudo.projeto;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by Isaac on 13/08/2017.
 */

public class FragmentAddLocal extends Fragment {

    private EditText edtLocal, edtCidade, edtDescricao, edtEndereco, edtURL;
    private ImageButton btnPreview;
    private Button btnEnviar;

    public boolean verificaCampos(){
        if(edtURL.getText().toString().trim().length() <= 0){
           return false;
        }else if(edtLocal.getText().toString().trim().length() <= 0){
            return false;
        }else if(edtCidade.getText().toString().trim().length() <= 0){
            return false;
        }else if(edtDescricao.getText().toString().trim().length() <= 0){
            return false;
        }else if(edtEndereco.getText().toString().trim().length() <= 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_local, null);

        edtLocal = (EditText)v.findViewById(R.id.edtAddLocal);
        edtCidade = (EditText)v.findViewById(R.id.edtAddCidade);
        edtDescricao = (EditText)v.findViewById(R.id.edtAddDescricao);
        edtEndereco = (EditText)v.findViewById(R.id.edtAddEndereco);
        edtURL = (EditText)v.findViewById(R.id.edtAddURL);

        btnPreview = (ImageButton)v.findViewById(R.id.btnPreview);
        btnEnviar = (Button)v.findViewById(R.id.btnEnviar);

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(edtURL.getText().toString().trim().length() > 0) {
                final Dialog dialog = new Dialog(getView().getContext());
                dialog.setContentView(R.layout.preview_dialog);

                Drawable d = new ColorDrawable(Color.BLACK);
                d.setAlpha(130);
                dialog.getWindow().setBackgroundDrawable(d);

                ImageView img = (ImageView) dialog.findViewById(R.id.imgPreview);

                Button btn = (Button) dialog.findViewById(R.id.btnOk);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                Picasso.with(dialog.getContext())
                        .load(edtURL.getText().toString())
                        .fit()
                        .centerCrop()
                        .into(img);

                dialog.show();
            }else{
                Toast.makeText(getView().getContext(), getString(R.string.link) + "!!!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(verificaCampos()) {
                if (edtURL.getText().toString().trim().length() > 0) {
                    Lugar lugar = new Lugar(edtLocal.getText().toString(),
                            edtCidade.getText().toString(),
                            edtDescricao.getText().toString(),
                            edtURL.getText().toString(),
                            edtEndereco.getText().toString());

                    MainActivity.lugarList.add(lugar);
                    Toast.makeText(getView().getContext(), getString(R.string.localAdicionado) + "!!!", Toast.LENGTH_SHORT).show();
                    getActivity().setResult(Activity.RESULT_OK);
                    getActivity().onBackPressed();
                }
            }else{
                Toast.makeText(getView().getContext(), getString(R.string.todosOsCampos) + "!!!", Toast.LENGTH_SHORT).show();
            }
            }
        });

        return v;
    }
}
