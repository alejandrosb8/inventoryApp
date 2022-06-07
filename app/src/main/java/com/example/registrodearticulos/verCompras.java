package com.example.registrodearticulos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class verCompras extends AppCompatActivity {

    TextView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_compras);

        lista = (TextView) findViewById(R.id.textView3);
        lista.setText("\n\n\n\n\n\n\nh\n\n\n\n\nh\n\n\n\n\n\nf\n\n\nf\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nHola");

        String files[] = fileList();
        if (fileExist(files, "compras.txt")) {
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("compras.txt"));
                BufferedReader br = new BufferedReader(file);
                String line = br.readLine();
                String txt = "";
                while(line != null) {
                    txt += line + "\n";
                    line = br.readLine();
                }
                br.close();
                file.close();

            } catch (IOException e) {

            }
        }
    }

    // Metodo para comprobar que un archivo fichero existe.
    private boolean fileExist(String files[], String name) {
        for(int i = 0; i < files.length; i++) {
            if(name.equals(files[i])) {
                return true;
            }
        }
        return false;
    }
}