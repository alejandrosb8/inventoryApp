package com.example.registrodearticulos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class verVentas extends AppCompatActivity {

    ListView listView_ventas;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_ventas);

        listView_ventas = findViewById(R.id.listView_ventas);

        String files[] = fileList();
        if (fileExist(files, "ventas.txt")) {
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("ventas.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String txt = "";

                while (line != null) {
                    txt += line + "_";
                    line = br.readLine();
                    System.out.println(line);
                }
                String ventas[] = txt.split("_");

                br.close();
                file.close();

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_register, ventas);
                listView_ventas.setAdapter(adapter);
            } catch (IOException e) {

            }
        }
    }
    // Metodo para comprobar que un archivo fichero existe.
    private boolean fileExist(String files[], String name) {
        for (int i = 0; i < files.length; i++) {
            if (name.equals(files[i])) {
                return true;
            }
        }
        return false;
    }
}