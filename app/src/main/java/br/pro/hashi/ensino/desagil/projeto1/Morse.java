package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedList;

public class Morse extends AppCompatActivity {
    float x1, y1, x2, y2;
    private Translator translator;
    Switch switch1;
    TextView textViewMorseToChar1;
    TextView textViewMorseToChar2;
    TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);
        translator = new Translator();
        textViewMorseToChar1 = findViewById(R.id.textViewMorseToChar1);
        textViewMorseToChar2 = findViewById(R.id.textViewMorseToChar2);
        switch1 = (Switch)findViewById(R.id.switch1);
        titulo= findViewById(R.id.titulo);

        String[] text1 = {""};
        String[] text2 = {""};

        String letras1 = "abcdefghijklm";
        String letras2 = "nopqrstuvwxyz0123456789";

        String[] morseChars1 = new String[]{".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--."};
        String[] morseChars2 = new String[]{"---", "....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-", ".....", "....-", "...--", "..---", ".----", "-....", "--...", "---..", "----.", "-----"};
        LinkedList listMorse1 = new LinkedList(Arrays.asList(morseChars1));
        LinkedList listMorse2 = new LinkedList(Arrays.asList(morseChars2));

        for (int i = 0; i < letras1.length(); i++) {
            text1[0] += letras1.charAt(i) + ":       " + translator.charToMorse(letras1.charAt(i)) + "\n";
            text2[0] += letras2.charAt(i) + ":       " + translator.charToMorse(letras2.charAt(i)) + "\n";
        }
        textViewMorseToChar1.setText(text1[0]);
        textViewMorseToChar2.setText(text2[0]);
        titulo.setText("Romano para morse");

        switch1.setOnClickListener((view) -> {
            Boolean switchState = switch1.isChecked();

            if (switchState) {
                text1[0] = "";
                text2[0] = "";

                for (int i = 0; i < morseChars1.length; i++) {
                    String morse1 =  listMorse1.get(i).toString();
                    String morse2 =  listMorse1.get(i).toString();
                    text1[0] += listMorse1.get(i) + ":       " + translator.morseToChar(morse1) +"\n";
                    text2[0] += listMorse2.get(i) + ":       " + translator.morseToChar(morse2) +"\n";
                }
                textViewMorseToChar1.setText(text1[0]);
                textViewMorseToChar1.setText(text2[0]);
                titulo.setText("Morse para romano");
            }
            else {
                text1[0] = "";
                text2[0] = "";

                for (int i = 0; i < letras1.length(); i++) {
                    text1[0] += letras1.charAt(i) + ":       " + translator.charToMorse(letras1.charAt(i)) + "\n";
                    text2[0] += letras2.charAt(i) + ":       " + translator.charToMorse(letras2.charAt(i)) + "\n";
                }

                textViewMorseToChar1.setText(text1[0]);
                textViewMorseToChar2.setText(text2[0]);
                titulo.setText("Romano para morse");

            }

            });
    }
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
                    Intent i = new Intent(Morse.this, MainActivity.class);
                    startActivity(i);
                }else if(x1 < x2){
                    Intent i = new Intent(Morse.this, SMSActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}
