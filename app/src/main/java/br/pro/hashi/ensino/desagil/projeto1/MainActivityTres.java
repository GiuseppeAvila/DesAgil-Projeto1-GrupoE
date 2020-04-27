package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static br.pro.hashi.ensino.desagil.projeto1.R.*;

public class MainActivityTres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tres);
        TextView sede = (TextView) findViewById(id.textSede);
        String text = getIntent().getStringExtra("text");
        sede.setText(text);

    }
}
