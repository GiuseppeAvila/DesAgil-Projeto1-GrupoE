package br.pro.hashi.ensino.desagil.projeto1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


//CHAMANDO AS VARIAVEIS DA ATIVIDADE
    private MediaPlayer mediaPlayer;
    float x1, y1, x2, y2;

// INÍCIO DA ATIVIDADE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//CHAMANDO OS BOTTÕES DA ATIVIDADE
        Button buttonEmergency =findViewById(R.id.buttonEmergencia);
        Button buttonHunger = findViewById(R.id.buttonFome);
        Button buttonThirst = findViewById(R.id.buttonSede);
        Button buttonPain = findViewById(R.id.buttonDor);
        Button buttonToilet = findViewById(R.id.buttonBanheiro);


//CHAMANDO O TEXTO DA ATIVIDADE
        TextView textMessage = findViewById(R.id.textMensagem);



//CHAMANDO O PLAYER DA ATIVIDADE
        mediaPlayer = MediaPlayer.create(this, R.raw.emergency);



//FUNÇÃO DO BOTÃO EMERGENCY
        buttonEmergency.setOnClickListener((view) -> {
            if (textMessage.getText().toString().equals("! EMERGÊNCIA !")) {
                // Pause the music player
                mediaPlayer.pause();
                textMessage.setVisibility(View.INVISIBLE);
                textMessage.setText("");
                // If it's not playing
            } else {
                // Resume the music player
                mediaPlayer.start();
                textMessage.setText("! EMERGÊNCIA !");
                textMessage.setBackgroundColor(0xFFCC0000);
                textMessage.setVisibility(View.VISIBLE);
            }
        });

//FUNÇAO DO BOTÃO HUNGER

        buttonHunger.setOnClickListener((view) -> {
            if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
            if (textMessage.getText().toString().equals("Estou com fome!")) {
                textMessage.setVisibility(View.INVISIBLE);
                textMessage.setText("");
            } else {
                textMessage.setText("Estou com fome!");
                textMessage.setBackgroundColor(0xFFFFFFFF);
                textMessage.setVisibility(View.VISIBLE);
            }
        });


//FUNÇÃO DO BOTÃO THIRST
        buttonThirst.setOnClickListener((view) -> {
            if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
            if (textMessage.getText().toString().equals("Estou com sede!")) {
                textMessage.setVisibility(View.INVISIBLE);
                textMessage.setText("");
            } else {
                textMessage.setText("Estou com sede!");
                textMessage.setBackgroundColor(0xFFFFFFFF);
                textMessage.setVisibility(View.VISIBLE);
            }
        });


//FUNÇÃO DO BOTÃO PAIN
        buttonPain.setOnClickListener((view) -> {
            if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
            if (textMessage.getText().toString().equals("Estou com dor!")) {
                textMessage.setVisibility(View.INVISIBLE);
                textMessage.setText("");
            } else {
                textMessage.setText("Estou com dor!");
                textMessage.setBackgroundColor(0xFFFFFFFF);
                textMessage.setVisibility(View.VISIBLE);
            }
        });


//FUNÇÃO DO BOTÃO TOILET
        buttonToilet.setOnClickListener((view) -> {
            if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
            if (textMessage.getText().toString().equals("Preciso ir ao banheiro!")) {
                textMessage.setVisibility(View.INVISIBLE);
                textMessage.setText("");
            } else {
                textMessage.setText("Preciso ir ao banheiro!");
                textMessage.setBackgroundColor(0xFFFFFFFF);
                textMessage.setVisibility(View.VISIBLE);
            }
        });

    }



//MÉTODO PARA SLIDE DE TELA
    // SMSACTIVITY
    // MORSE
    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                 x1 = touchEvent.getX();
                 y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 > x2){
                Intent i = new Intent(MainActivity.this, SMSActivity.class);
                startActivity(i);
            }

            break;
        }
        return false;
    }

}
