package com.gonzalez.rafa.ejemplosqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    EditText apellidos;
    EditText nota;
    Button insertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = findViewById(R.id.editTname);
        apellidos = findViewById(R.id.editTApell);
        nota = findViewById(R.id.editTnota);

        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean resultado = false;
                resultado = baseDeDatos.insertar(nombre.getText().toString());
            }
        });
    }
}
