package com.example.ejercicio4_5;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MuestraFormulario extends AppCompatActivity {

    public TextView verNombre,verApellido,verPreferencias,verEstadoCivil,verDatos;
    public Button btnVolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muestra_formulario);

        verNombre  = (TextView) findViewById(R.id.verNombre);
        verApellido  = (TextView) findViewById(R.id.verApellido);
        verPreferencias  = (TextView) findViewById(R.id.verPreferencias);
        verEstadoCivil  = (TextView) findViewById(R.id.verEstadoCivil);

        btnVolver = (Button) findViewById(R.id.btnVolver);
        verDatos  = (TextView) findViewById(R.id.verDatos);


        mostrarDatos();
    }
    public void volver(View view){
        Intent intent=new Intent(MuestraFormulario.this,MainActivity.class);
        startActivity(intent);
    }

    public void mostrarDatos() {
        Bundle datos=this.getIntent().getExtras();//coge los datos del anterior activity en este caso el Main
        String nombre= datos.getString("name");
        String apellido= datos.getString("ape");
        String estadoCivil= datos.getString("radio");
        String preferencias= datos.getString("check");
        verNombre.setText(nombre);
        verApellido.setText(apellido);
        verEstadoCivil.setText(estadoCivil);
        verPreferencias.setText(preferencias);

        verDatos.setText("Usted es "+ nombre +" "+apellido+" y esta "+estadoCivil+". Sus preferencias son: "
                          + preferencias );
    }
    //+", "+ Educación +", "+ Arte
}
