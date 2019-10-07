package frsf.isi.lunaojeda.dam.sendmeal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import frsf.isi.lunaojeda.dam.sendmeal.domain.Plato;

public class PlatoRecyclerAdapter extends RecyclerView.Adapter<PlatoViewHolder> {
    private List<Plato> listaPlatos;


    public PlatoRecyclerAdapter(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    @NonNull
    @Override
    public PlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fila_plato, parent, false);
        PlatoViewHolder vh = new PlatoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoViewHolder holder, int position) {
        Plato plato =  listaPlatos.get(position);

        holder.nombreItem.setText(plato.getNombre());
        holder.precioItem.setText(String.valueOf(plato.getPrecio()));
    }

    @Override
    public int getItemCount() {
        return listaPlatos.size();
    }
}
