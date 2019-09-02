package frsf.isi.lunaojeda.dam.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etClave, etClave2, etCorreo, etNumeroTarjeta, etVencimientoTarjeta, etCcv;
    private Switch swVendedor;
    private CheckBox cbTerminosCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        etClave = (EditText)findViewById(R.id.etClave);
        etClave2 = (EditText)findViewById(R.id.etClave2);
        etCorreo = (EditText)findViewById(R.id.etCorreo);

        etNumeroTarjeta = (EditText)findViewById(R.id.etNumeroTarjeta);
        etVencimientoTarjeta = (EditText)findViewById(R.id.etVencimientoTarjeta);
        etCcv = (EditText)findViewById(R.id.etCcv);

        swVendedor = (Switch)findViewById(R.id.swVendendor);
        cbTerminosCondiciones = (CheckBox)findViewById(R.id.cbTerminosCondiciones);
    }

    public void registrar(View v){
        try{
            this.validarFormulario();
            if(this.swVendedor.isChecked())
                this.validarFormularioVendedor(v);
            else    
                this.validarFormularioCliente(v);
        }
        catch(Exception e){
        }
    }

    public void validarFormulario() throws Exception {
        if (!this.nombreValido()
                || !this.claveValida(etClave)
                || !this.claveValida(etClave2)
                || !this.clavesValidas()
                || !this.correoValido()
                || !this.tarjetaValida()
        )
            throw new Exception("Formulario incorrecto");
    }

    public boolean nombreValido(){
        if(etNombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nombre incompleto", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean claveValida(EditText editText){
        if(editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Clave incompleta", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean clavesValidas(){
        if(etClave.getText().toString() == etClave2.getText().toString()) {
            Toast.makeText(this, "Las claves no coinciden", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean correoValido(){
        if(this.etCorreo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Correo incompleto", Toast.LENGTH_LONG).show();
            return false;
        }
        else{
            String[] formato = this.etCorreo.getText().toString().split("@");

            if(formato.length<2 || formato[0].length()<= 0 || formato[1].length()<3) {
                Toast.makeText(this, "Correo incorrecto", Toast.LENGTH_LONG).show();
                return false;
            }
        }
        
        return true;
    }

    public boolean tarjetaValida(){
        if(etNumeroTarjeta.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Numero de tarjeta incompleto", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (etVencimientoTarjeta.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Fecha de vencimiento incompleta", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (etCcv.getText().toString().isEmpty()) {
            Toast.makeText(this, "Numero de verificación incompleto", Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }
    

    private void validarFormularioVendedor(View v) throws Exception {
    }

    private void validarFormularioCliente(View v) throws Exception {
    }
}
