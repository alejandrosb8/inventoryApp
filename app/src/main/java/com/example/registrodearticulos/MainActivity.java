package com.example.registrodearticulos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAgregarCompra(View view){
        Intent i = new Intent(this, agregarCompra.class);
        startActivity(i);

    }
    public void goToAgregarVenta(View view){
        Intent i = new Intent(this, agregarVenta.class);
        startActivity(i);

    }
    public void goToVerCompras(View view){
        Intent i = new Intent(this, verCompras.class);
        startActivity(i);

    }
    public void goToVerVentas(View view){
        Intent i = new Intent(this, verVentas.class);
        startActivity(i);

    }
}