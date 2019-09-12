package frsf.isi.lunaojeda.dam.sendmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.MaskFilter;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Date;

import java.util.logging.SimpleFormatter;

import frsf.isi.lunaojeda.dam.sendmeal.domain.CuentaBancaria;
import frsf.isi.lunaojeda.dam.sendmeal.domain.TarjetaCredito;
import frsf.isi.lunaojeda.dam.sendmeal.domain.TipoCuenta;
import frsf.isi.lunaojeda.dam.sendmeal.domain.Usuario;

public class MainActivity extends AppCompatActivity {

    private TextView tvNumeroCredito, tvAliasCBU, tvCBU;
    private EditText etNombre, etClave, etClave2, etCorreo, etNumeroTarjeta, etVencimientoTarjeta, etCcv, etAliasCBU, etCBU;
    private RadioGroup rgCuenta;
    private SeekBar sbCredito;

    private Switch swVendedor;

    private ToggleButton tbEmail;

    private CheckBox cbTerminosCondiciones;
    private Button btnRegistrar;

    private int credito = 0;

    Usuario usuario = new Usuario();
    TarjetaCredito tarjetaCredito;
    CuentaBancaria cuentaBancaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etClave = (EditText) findViewById(R.id.etClave);
        etClave2 = (EditText) findViewById(R.id.etClave2);
        etCorreo = (EditText) findViewById(R.id.etCorreo);

        etNumeroTarjeta = (EditText) findViewById(R.id.etNumeroTarjeta);
        etVencimientoTarjeta = (EditText) findViewById(R.id.etVencimientoTarjeta);
        etCcv = (EditText) findViewById(R.id.etCcv);

        etAliasCBU = (EditText) findViewById(R.id.etAliasCBU);
        etCBU = (EditText) findViewById(R.id.etCBU);
        tvAliasCBU = findViewById(R.id.tvAliasCBU);
        tvCBU = findViewById(R.id.tvCBU);

        swVendedor = (Switch) findViewById(R.id.swVendendor);
        cbTerminosCondiciones = (CheckBox) findViewById(R.id.cbTerminosCondiciones);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        /*etVencimientoTarjeta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String[] fecha = charSequence.toString().split("/");
                int mes = Integer.parseInt(fecha[0]);

                if(){
                    etVencimientoTarjeta.setText(etVencimientoTarjeta.getText().toString() + '/');
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/
        tvNumeroCredito = (TextView) findViewById(R.id.tvNumeroCredito);
        rgCuenta = (RadioGroup) findViewById(R.id.rgCuenta);

        sbCredito = (SeekBar) findViewById(R.id.sbCredito);

        tbEmail = findViewById(R.id.tbEmail);

        rgCuenta.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idRadioButton) {
                switch (idRadioButton) {
                    case -1:
                        break;
                    case R.id.rbCuentaBase:
                        credito = 100;
                        usuario.setTipoCuenta(TipoCuenta.BASE);
                        sbCredito.setProgress(credito);
                        break;
                    case R.id.rbCuentaPremium:
                        credito = 250;
                        usuario.setTipoCuenta(TipoCuenta.PREMIUM);
                        sbCredito.setProgress(credito);
                        break;
                    case R.id.rbCuentaFull:
                        credito = 500;
                        usuario.setTipoCuenta(TipoCuenta.FULL);
                        sbCredito.setProgress(credito);
                        break;
                }
                tvNumeroCredito.setText(String.valueOf(credito));
            }
        });

        sbCredito.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    // When the progress value has changed
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (progress<credito) {
                            int radioButtonId = rgCuenta.getCheckedRadioButtonId();
                            switch (radioButtonId) {
                                case -1:
                                    break;
                                case R.id.rbCuentaBase:
                                    if (progress < 100)
                                        sbCredito.setProgress(100);
                                    else
                                    {
                                        credito = progress;
                                        tvNumeroCredito.setText(String.valueOf(credito));
                                    }
                                    break;
                                case R.id.rbCuentaPremium:
                                    if (progress < 250)
                                        sbCredito.setProgress(250);
                                    else
                                    {
                                        credito = progress;
                                        tvNumeroCredito.setText(String.valueOf(credito));
                                    }
                                    break;
                                case R.id.rbCuentaFull:
                                    if(progress<500)
                                        sbCredito.setProgress(500);
                                    else
                                    {
                                        credito = progress;
                                        tvNumeroCredito.setText(String.valueOf(credito));
                                    }
                                    break;
                            }
                        } else {
                            credito = progress;
                            tvNumeroCredito.setText(String.valueOf(credito));
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        // This method will automatically
                        // called when the user touches the SeekBar
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // This method will automatically
                        // called when the user
                        // stops touching the SeekBar
                    }
                });

        swVendedor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {
                    tvAliasCBU.setVisibility(View.GONE);
                    etAliasCBU.setVisibility(View.GONE);
                    etAliasCBU.setText("");
                    tvCBU.setVisibility(View.GONE);
                    etCBU.setVisibility(View.GONE);
                    etCBU.setText("");
                } else {
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


    public void registrar(View v) {
        try {
            this.validarFormulario(v);
        } catch (Exception e) {
        }

        this.usuario.setNombre(this.etNombre.getText().toString());
        this.usuario.setClave(this.etClave.getText().toString());
        this.tarjetaCredito = new TarjetaCredito(Integer.parseInt(etCcv.getText().toString()), etNumeroTarjeta.getText().toString(), etVencimientoTarjeta.getText().toString());
        this.usuario.setTarjetaCredito(tarjetaCredito);

        if(swVendedor.isChecked()) {
            this.cuentaBancaria = new CuentaBancaria(etAliasCBU.getText().toString(),etCBU.getText().toString());
            this.usuario.setCuentaBancaria(cuentaBancaria);
        }

        this.usuario.setCredito(Double.parseDouble(String.valueOf(credito)));

        this.usuario.setNotificarMail(tbEmail.isChecked());

        Toast.makeText(this, "SE GUARDO EL USUARIO CORRECTAMENTE", Toast.LENGTH_LONG).show();
        
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

        if (this.swVendedor.isChecked()) {
            if (!this.datosCuentaValidos())
                throw new Exception("Formulario vendedor incorrecto");
        }
    }

    public boolean nombreValido() {
        if (etNombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Nombre incompleto", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean claveValida(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Clave incompleta", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean clavesValidas() {
        if (etClave.getText().toString() == etClave2.getText().toString()) {
            Toast.makeText(this, "Las claves no coinciden", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public boolean correoValido() {
        if (this.etCorreo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Correo incompleto", Toast.LENGTH_LONG).show();
            return false;
        } else {
            String[] formato = this.etCorreo.getText().toString().split("@");

            if (formato.length < 2 || formato[0].length() <= 0 || formato[1].length() < 3) {
                Toast.makeText(this, "Correo incorrecto", Toast.LENGTH_LONG).show();
                return false;
            }
        }

        return true;
    }

    public boolean tarjetaValida() {
        if (etNumeroTarjeta.getText().toString().isEmpty()) {
            Toast.makeText(this, "Numero de tarjeta incompleto", Toast.LENGTH_LONG).show();
            return false;
        } else if (etCcv.getText().toString().isEmpty()) {
            Toast.makeText(this, "Numero de verificación incompleto", Toast.LENGTH_LONG).show();
            return false;
        } else if (etCcv.getText().toString().length() != 3) {
            Toast.makeText(this, "Numero de verificación incorrecto", Toast.LENGTH_LONG).show();
            return false;
        } else if (etVencimientoTarjeta.getText().toString().isEmpty()) {
            Toast.makeText(this, "Fecha de vencimiento incompleta", Toast.LENGTH_LONG).show();
            return false;
        }
        //else if(etVencimientoTarjeta.getText().toString())


        return true;
    }

    public boolean validarTerminosCondiciones() {
        if (!cbTerminosCondiciones.isChecked()) {
            Toast.makeText(this, "Debe aceptar los terminos y condiciones.", Toast.LENGTH_LONG).show();
            return false;
        } else return true;
    }

    public boolean datosCuentaValidos() {
        if (this.etAliasCBU.getText().toString().isEmpty()
                || this.etCBU.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debe completar los datos de cuenta bancaria.", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
