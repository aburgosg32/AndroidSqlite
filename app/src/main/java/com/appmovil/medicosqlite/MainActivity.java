package com.appmovil.medicosqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editApellidos, editNombres, editTelefono, editCmp;
    Spinner spnEspecialidad;
    Button btnRegistrar;
    ListView lstMedicos;
    Medico medicojava;
    ArrayAdapter<String> adapter;
    int idSeleccionado  = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //inicializamos los controles

            editApellidos = findViewById(R.id.editApellidos);
            editNombres = findViewById(R.id.editNombre);
            editTelefono = findViewById(R.id.editTelefono);
            editCmp = findViewById(R.id.editCmp);
            spnEspecialidad = findViewById(R.id.spnEspecialidad);
            btnRegistrar = findViewById(R.id.btnInsertarMedico);
            lstMedicos = findViewById(R.id.lstListarMedicos);

            medicojava = new Medico(this);

            String[] especialidades = {"medicina","cardiologia"};
            ArrayAdapter<String> especialidadAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,especialidades);
            spnEspecialidad.setAdapter(especialidadAdapter);

            actualizarLista();

            btnRegistrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    medicojava.insertarMedico(editApellidos.getText().toString(),
                            editNombres.getText().toString(),
                            editTelefono.getText().toString(),
                            editCmp.getText().toString(),
                            spnEspecialidad.getSelectedItem().toString());
                    actualizarLista();
                }

            });

                actualizarLista();
    }


    private void actualizarLista() {
        List<String> medicos = medicojava.obtenerMedicos();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicos);
        lstMedicos.setAdapter(adapter);
    }

}



