package frsf.isi.lunaojeda.dam.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class HOME extends AppCompatActivity {

    private TextView textView;
    private androidx.appcompat.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);

        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.mnuOpt1:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.mnuOpt2:
                intent = new Intent(this, ListaItems.class);
                startActivity(intent);
                return true;
            default:
                Toast.makeText(this, ". . . . ", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
