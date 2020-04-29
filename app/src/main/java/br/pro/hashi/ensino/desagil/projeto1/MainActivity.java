package br.pro.hashi.ensino.desagil.projeto1;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private TextView textMessage;
    private Button buttonEmergency;
    private Button buttonHunger;
    private Button buttonThirst;
    private Button buttonPain;
    private Button buttonToilet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEmergency = (Button) findViewById(R.id.buttonEmergencia);
        textMessage = (TextView) findViewById(R.id.textMensagem);
        mediaPlayer = MediaPlayer.create(this, R.raw.emergency);
        buttonEmergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        buttonHunger = (Button) findViewById(R.id.buttonFome);
        buttonThirst = (Button) findViewById(R.id.buttonSede);
        buttonPain = (Button) findViewById(R.id.buttonDor);
        buttonToilet = (Button) findViewById(R.id.buttonBanheiro);

        buttonHunger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
                if (textMessage.getText().toString().equals("Estou com fome!")) {
                    textMessage.setVisibility(View.INVISIBLE);
                    textMessage.setText("");
                } else {
                    textMessage.setText("Estou com fome!");
                    textMessage.setBackgroundColor(0xFFFFFFFF);
                    textMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonThirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
                if (textMessage.getText().toString().equals("Estou com sede!")) {
                    textMessage.setVisibility(View.INVISIBLE);
                    textMessage.setText("");
                } else {
                    textMessage.setText("Estou com sede!");
                    textMessage.setBackgroundColor(0xFFFFFFFF);
                    textMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonPain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
                if (textMessage.getText().toString().equals("Estou com dor!")) {
                    textMessage.setVisibility(View.INVISIBLE);
                    textMessage.setText("");
                } else {
                    textMessage.setText("Estou com dor!");
                    textMessage.setBackgroundColor(0xFFFFFFFF);
                    textMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        buttonToilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) { mediaPlayer.pause(); }
                if (textMessage.getText().toString().equals("Preciso ir ao banheiro!")) {
                    textMessage.setVisibility(View.INVISIBLE);
                    textMessage.setText("");
                } else {
                    textMessage.setText("Preciso ir ao banheiro!");
                    textMessage.setBackgroundColor(0xFFFFFFFF);
                    textMessage.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
