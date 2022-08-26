package com.fjar.evaluacinsemana4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2;
    private Button btnOperar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOperar = (Button) findViewById(R.id.btnCalcular);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);

        btnOperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Operaciones operaciones = new Operaciones();
                int a = Integer.parseInt(edt1.getText().toString());
                int b = Integer.parseInt(edt2.getText().toString());
                String hipotenusa = String.valueOf(operaciones.CalcularHipotenusa(a, b));
                Toast.makeText(MainActivity.this, "La hipotenusa es: " + hipotenusa, Toast.LENGTH_SHORT).show();
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
            Toast.makeText(this, "Se encuentra en el inicio del programa", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.CaclularHipotenusa){
            Toast.makeText(this, "Se encuentra en esta ventana", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.CalcVolumen){
            finish();
            Intent intent = new Intent(this, EjercicioVolumen.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}