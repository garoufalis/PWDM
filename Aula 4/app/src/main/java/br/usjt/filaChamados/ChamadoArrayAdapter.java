package br.usjt.filaChamados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter<Chamado> {
    public ChamadoArrayAdapter(Context context, List<Chamado> chamados) {
        super(context, -1, chamados);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chamado chamadoDaVez = getItem(position);
        Fila filaDaVez = chamadoDaVez.getFila();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.list_item, parent, false);
        ImageView filaIconImageView = view.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaFilaTextView =
                view.findViewById(R.id.descricaoChamadoNaFilaTextView);
        TextView statusChamadoNaFilaTextView =
                view.findViewById(R.id.statusChamadoNaFilaTextView);
        TextView dataAberturaChamadoNaFilaTextView =
                view.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
        TextView dataFechamentoChamadoNaFilaTextView =
                view.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
        filaIconImageView.setImageResource(filaDaVez.getIconId());
        descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao());
        statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());
        dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null) {
            dataFechamentoChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataFechamento()));
        }
        return view;
    }
}