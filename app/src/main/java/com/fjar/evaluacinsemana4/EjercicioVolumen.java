package com.fjar.evaluacinsemana4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EjercicioVolumen extends AppCompatActivity {
    private Button btnCalcVol;
    private EditText edt1, edt2;
    private Spinner spn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_volumen);
        spn1 = (Spinner) findViewById(R.id.spinner);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btnCalcVol = (Button) findViewById(R.id.btnVolumen);

        String[] opciones = {"Seleccione una opción", "cubo", "cilindro", "esfera"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spn1.setAdapter(adapter);

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                switch (item){
                    case "cubo":
                        edt1.setEnabled(true);
                        edt1.setHint("Ingrese un valor para los lados");
                        edt2.setEnabled(false);
                        edt2.setHint("");
                        break;
                    case "cilindro":
                        edt1.setEnabled(true);
                        edt1.setHint("Ingrese un v;alor para el radio");
                        edt2.setEnabled(true);
                        edt2.setHint("Ingrese un valor para la altura");
                        break;
                    case "esfera":
                        edt1.setEnabled(true);
                        edt1.setHint("Ingrese un valor para el radio");
                        edt2.setEnabled(false);
                        edt2.setHint("");
                        break;
                    default:
                        edt1.setEnabled(false);
                        edt1.setHint("");
                        edt2.setEnabled(false);
                        edt2.setHint("");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnCalcVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selec = spn1.getSelectedItem().toString();
                String volumen = "";
                Operaciones operaciones = new Operaciones();
                switch (selec){
                    case "cubo":
                        volumen = String.valueOf(operaciones.calcVolumenCubo(Integer.parseInt(edt1.getText().toString())));
                        break;
                    case "cilindro":
                        int r = Integer.parseInt(edt1.getText().toString());
                        int h = Integer.parseInt(edt2.getText().toString());
                        volumen = String.valueOf(operaciones.calcVolumenCilindro(r, h));
                        break;
                    case "esfera":
                        int rad = Integer.parseInt(edt1.getText().toString());
                        volumen = String.valueOf(operaciones.calcVolumenEsfera(rad));
                        break;
                    default:
                        break;
                }
                Toast.makeText(EjercicioVolumen.this, "El volumen es: " + volumen, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Salir) {
            finishAffinity();
        } else if (id == R.id.Volver) {
            finish();
            Intent volver = new Intent(this, MainActivity.class);
            startActivity(volver);
        }else if(id == R.id.CaclularHipotenusa){
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else if(id == R.id.CalcVolumen){

            Toast.makeText(this, "Se encuentra en esta ventana", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}