package com.example.registrodearticulos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class agregarCompra extends AppCompatActivity {

    EditText input_name;
    EditText input_amount;
    TextView textView_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_compra);

        input_name = findViewById(R.id.input_name);
        input_amount = findViewById(R.id.input_amount);
        textView_message = findViewById(R.id.textView_message);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void agregarCompra(View view) {

        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("compras.txt", Activity.MODE_PRIVATE));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            LocalDate localDate = LocalDate.now();

            String lineToSave = input_name.getText().toString() + "|" + input_amount.getText().toString() + "|" + dtf.format(localDate).toString();

            file.write(lineToSave);

            file.flush();
            file.close();

            input_name.setText("");
            input_amount.setText("");

            Toast.makeText(this, "Producto Guardado", Toast.LENGTH_LONG).show();

        } catch (IOException e) {
        }
    }

    /*private boolean fileExist(String files [], String fileName){
        for(int i=0; i < files.length;i++){
            if(fileName.equals(files[i])) {
                return true;
            }
        }
        return false;
    }*/
}