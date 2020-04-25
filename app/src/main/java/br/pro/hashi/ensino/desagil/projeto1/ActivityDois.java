package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static br.pro.hashi.ensino.desagil.projeto1.R.*;

public class ActivityDois extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        TextView fome = (TextView) findViewById(id.TextFome);

    }
}
