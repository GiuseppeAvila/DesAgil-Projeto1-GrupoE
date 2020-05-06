package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ListaContatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        String[] phoneNumber = getResources().getStringArray(R.array.numeros);
        String[] textPhone = getResources().getStringArray(R.array.nomes);
        ListView phones =findViewById(R.id.textNumeros);
        ListView contacts = findViewById(R.id.textViewNomes);

        Map<String, String> map = new HashMap<>();


    }

}
