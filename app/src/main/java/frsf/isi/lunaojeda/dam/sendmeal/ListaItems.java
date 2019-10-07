package frsf.isi.lunaojeda.dam.sendmeal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import frsf.isi.lunaojeda.dam.sendmeal.domain.Plato;

public class ListaItems extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_items);
        this.layoutManager = new LinearLayoutManager(this);

        this.recyclerView = (RecyclerView) findViewById(R.id.rvListaPlatos);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.adapter = new PlatoRecyclerAdapter(Plato.getLista());
        recyclerView.setAdapter(adapter);
    }
}
