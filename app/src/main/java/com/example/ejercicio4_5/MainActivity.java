package com.example.ejercicio4_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

/**
 * author Asier Aranda
 */

public class MainActivity extends AppCompatActivity {
    public Button enviarDatos;
    public EditText nombre,apellido;
    public RadioButton radio_Soltero,radio_Casado,radio_Divorciado,radio_Viudo;
    public CheckBox familia,videojuegos,arte,educacion,carreras,deportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button
        enviarDatos      = (Button) findViewById(R.id.enviarDatos);//puente de comunicacion entre parte logica y grafica
        //editText
        nombre           = (EditText) findViewById(R.id.nombre);
        apellido         = (EditText)findViewById(R.id.apellido);
        //radioButton
        radio_Soltero    = (RadioButton) findViewById(R.id.radio_Soltero);
        radio_Casado     = (RadioButton) findViewById(R.id.radio_Casado);
        radio_Divorciado = (RadioButton) findViewById(R.id.radio_Divorciado);
        radio_Viudo      = (RadioButton) findViewById(R.id.radio_Viudo);
        //Checkbox
        familia         = (CheckBox) findViewById(R.id.familia);
        videojuegos     = (CheckBox) findViewById(R.id.videojuegos);
        arte            = (CheckBox) findViewById(R.id.arte);
        educacion       = (CheckBox) findViewById(R.id.educacion);
        carreras        = (CheckBox) findViewById(R.id.carreras);
        deportes        = (CheckBox) findViewById(R.id.deportes);

    }

    //radiobutton control
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";// variable donde se almacenara el dato del radioButton
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_Soltero:
                if (checked)
                    str = "Soltero";
                break;
            case R.id.radio_Casado:
                if (checked)
                    str = "Casado";
                break;
            case R.id.radio_Divorciado:
                if (checked)
                    str = "Divorciado";
                break;
            case R.id.radio_Viudo:
                if (checked)
                    str = "Viudo";
                break;
        }
        Intent i = new Intent(MainActivity.this, MuestraFormulario.class);
        i.putExtra("radio", str); // enviaras lo que contiene str a la siguiente Activity

    }

    public void onCheckboxClicked(View view) {
        String prefe="";
        if(deportes.isChecked())          prefe = "Deportes";
        else if(carreras.isChecked())     prefe = "Carreras";
        else if(educacion.isChecked())    prefe = "Educacion";
        else if(arte.isChecked())         prefe = "Arte";
        else if(videojuegos.isChecked())  prefe = "Videojuegos";
        else if(familia.isChecked())      prefe = "Familia";

        Intent x = new Intent(MainActivity.this, MuestraFormulario.class);
        x.putExtra("check", prefe); // enviaras lo que contiene str a la siguiente Activity

    }
    public void enviarDatos(View view){
        String name=nombre.getText().toString();
        String ape =apellido.getText().toString();

        Intent i=new Intent(MainActivity.this, MuestraFormulario.class);

        i.putExtra("name", name);
        i.putExtra("ape", ape);


        startActivity(i);
    }
}