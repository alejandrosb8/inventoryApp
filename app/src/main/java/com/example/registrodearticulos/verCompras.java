package com.example.registrodearticulos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class verCompras extends AppCompatActivity {

    ListView listView_compras;

    String compras[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_compras);

        listView_compras = findViewById(R.id.listView_compras);

        String files[] = fileList();
        if (fileExist(files, "compras.txt")) {
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("compras.txt"));
                BufferedReader br = new BufferedReader(file);

                int counter = 0;
                while (br.readLine() != null) {
                    counter++;
                }
                br.close();

                compras = new String[counter];
                BufferedReader br2 = new BufferedReader(file);

                for(int i = 0; i < counter; i++) {
                    compras[i] = br.readLine();
                }

                br2.close();
                file.close();
            } catch (IOException e) {

            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_register, compras);
        listView_compras.setAdapter(adapter);
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