package frsf.isi.lunaojeda.dam.sendmeal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlatoViewHolder extends RecyclerView.ViewHolder {
    public ImageView imagenItem;
    public TextView nombreItem, precioItem;

    public PlatoViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imagenItem = itemView.findViewById(R.id.imagenItem);
        this.nombreItem = itemView.findViewById(R.id.nombreItem);
        this.precioItem = itemView.findViewById(R.id.precioItem);
    }
}
