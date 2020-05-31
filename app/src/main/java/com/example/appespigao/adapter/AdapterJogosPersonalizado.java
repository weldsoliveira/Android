package com.example.appespigao.adapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appespigao.R;
import com.example.appespigao.models.Jogo;

import java.util.List;

public class AdapterJogosPersonalizado extends BaseAdapter {

    private final List<Jogo> jogos;
    private final Activity act;

    public AdapterJogosPersonalizado(List<Jogo> jogos, Activity act) {
        this.jogos = jogos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return jogos.size();
    }

    @Override
    public Object getItem(int position) {
        return jogos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.lista_jogo_personalizada, parent, false);

        Jogo jogo = jogos.get(position);

        TextView nome = (TextView)
                view.findViewById(R.id.lista_curso_personalizada_numeros);
        nome.setText(jogo.getNumeros().toString());

        TextView nomeBloco = (TextView)
                view.findViewById(R.id.lista_jogos_personalizada_nomeBloco);
        nomeBloco.setText(jogo.getnomeBloco());

        return view;
    }
}