package frsf.isi.lunaojeda.dam.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity {

    private TextView tvAliasCBU, tvCBU;
    private EditText etNombre, etClave, etClave2, etCorreo, etNumeroTarjeta, etVencimientoTarjeta, etCcv, etAliasCBU, etCBU;
    private Switch swVendedor;
    private CheckBox cbTerminosCondiciones;
    private Button btnRegistrar;

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

        etAliasCBU = (EditText)findViewById(R.id.etAliasCBU);
        etCBU = (EditText)findViewById(R.id.etCBU);
        tvAliasCBU = findViewById(R.id.tvAliasCBU);
        tvCBU = findViewById(R.id.tvCBU);

        swVendedor = (Switch)findViewById(R.id.swVendendor);
        cbTerminosCondiciones = (CheckBox)findViewById(R.id.cbTerminosCondiciones);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        //SimpleDateFormat mascara = new SimpleDateFormat("MM/YY");
        //mascara.

        swVendedor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    tvAliasCBU.setVisibility(View.GONE);
                    etAliasCBU.setVisibility(View.GONE);
                    etAliasCBU.setText("");
                    tvCBU.setVisibility(View.GONE);
                    etCBU.setVisibility(View.GONE);
                    etCBU.setText("");
                }
                else{
                    tvAliasCBU.setVisibility(View.VISIBLE);
                    etAliasCBU.setVisibility(View.VISIBLE);
                    tvCBU.setVisibility(View.VISIBLE);
                    etCBU.setVisibility(View.VISIBLE);
                }
            }
        });

        cbTerminosCondiciones.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                btnRegistrar.setEnabled(b);
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar(view);
            }
        });
    }



    public void registrar(View v){
        try{
            this.validarFormulario(v);
        }
        catch(Exception e){
        }
    }

    public void validarFormulario(View v) throws Exception {
        if (!this.nombreValido()
                || !this.claveValida(etClave)
                || !this.claveValida(etClave2)
                || !this.clavesValidas()
                || !this.correoValido()
                || !this.tarjetaValida()
                || !this.validarTerminosCondiciones()
        )
            throw new Exception("Formulario incorrecto");

        if(this.swVendedor.isChecked()){
            if(!this.datosCuentaValidos())
                throw new Exception("Formulario vendedor incorrecto");
        }
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
        else if (etCcv.getText().toString().isEmpty()) {
            Toast.makeText(this, "Numero de verificación incompleto", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(etCcv.getText().toString().length()!= 3){
            Toast.makeText(this, "Numero de verificación incorrecto", Toast.LENGTH_LONG).show();
            return false;
        }
        else if (etVencimientoTarjeta.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Fecha de vencimiento incompleta", Toast.LENGTH_LONG).show();
            return false;
        }
        //else if(etVencimientoTarjeta.getText().toString())


        return true;
    }

    public boolean validarTerminosCondiciones(){
        if(!cbTerminosCondiciones.isChecked()) {
            Toast.makeText(this, "Debe aceptar los terminos y condiciones.", Toast.LENGTH_LONG).show();
            return false;
        }
        else return true;
    }

    public boolean datosCuentaValidos(){
        if(this.etAliasCBU.getText().toString().isEmpty()
        || this.etCBU.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe completar los datos de cuenta bancaria.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
