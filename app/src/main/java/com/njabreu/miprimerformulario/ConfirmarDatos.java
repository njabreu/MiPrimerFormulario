package com.njabreu.miprimerformulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        TextView tvNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvEmail =  (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcionContacto =  (TextView) findViewById(R.id.tvDescripcionContacto);
        TextView tvTelefono =  (TextView) findViewById(R.id.tvTelefono);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);


        String prefijo = getResources().getString(R.string.texto_inicial_etiqueta_telefono);


        //Get the data passed to caller intent
        Intent intent = getIntent();
        tvNombreCompleto.setText(intent.getStringExtra("etNombreCompleto"));

        tvTelefono.setText(prefijo +" " + intent.getStringExtra("etTelefono"));

        prefijo = getResources().getString(R.string.texto_inicial_etiqueta_email);
        tvEmail.setText(prefijo+" "+intent.getStringExtra("etEmail"));

        prefijo = getResources().getString(R.string.texto_inicial_etiqueta_descripcion);
        tvDescripcionContacto.setText(prefijo+" "+intent.getStringExtra("etDescripcionContacto"));

        prefijo = getResources().getString(R.string.texto_inicial_etiqueta_fecha_nacimiento);
        tvFechaNacimiento.setText(prefijo +" " + intent.getStringExtra("etFechaNacimiento"));

    }

    public void backToMainActivity(View view){
        finish();
    }
}
