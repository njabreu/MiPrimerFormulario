package com.njabreu.miprimerformulario;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.app.DatePickerDialog.OnDateSetListener;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static EditText etFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFechaNacimiento=  (EditText)findViewById(R.id.etFechaNacimiento);
    }

    public void showConfirmarDatos(View view)
    {
        Intent intent = new Intent(this, ConfirmarDatos.class);

        EditText etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        EditText etTelefono = (EditText) findViewById(R.id.etTelefono);
        EditText etDescripcionContacto = (EditText) findViewById(R.id.etDescripcionContacto);
        //DatePicker dtFechaNacimiento = (DatePicker) findViewById(R.id.dpFechaNacimiento);

        intent.putExtra("etNombreCompleto", etNombreCompleto.getText().toString());
        intent.putExtra("etEmail", etEmail.getText().toString());
        intent.putExtra("etTelefono", etTelefono.getText().toString());
        intent.putExtra("etDescripcionContacto", etDescripcionContacto.getText().toString());
        intent.putExtra("etFechaNacimiento", etFechaNacimiento.getText().toString());
        startActivity(intent);
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    ///La Clase que abre el dialog de la fecha usando DialogFragment
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        private DatePickerDialog.OnDateSetListener onDateSetListener;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(),this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            etFechaNacimiento.setText(
                    String.valueOf(day) + "/" + String.valueOf(month+1)+"/"+String.valueOf(year)
            );
        }

    }
}
