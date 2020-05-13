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
    TextView textViewMorseToChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morse);
        translator = new Translator();
        textViewMorseToChar= findViewById(R.id.textViewMorseToChar);
        switch1 = (Switch)findViewById(R.id.switch1);
        textViewMorseToChar.setText("oiiiiiiii");


        String text = "";
        String letras = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < letras.length(); i++) {
            text += letras.charAt(i) + ":       " + translator.charToMorse(letras.charAt(i)) + "\n";

        }
        textViewMorseToChar.setText(text);


        switch1.setOnClickListener((view) -> {
            Boolean switchState = switch1.isChecked();

            if (switchState) {
                String text2 = "";
                String[] morseChars = new String[]{".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---", "....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-", ".....", "....-", "...--", "..---", ".----", "-....", "--...", "---..", "----.", "-----"};
                LinkedList listMorse = new LinkedList(Arrays.asList(morseChars));
                for (int i = 0; i < morseChars.length; i++) {
                    String morse =  listMorse.get(i).toString();
                    text2 += listMorse.get(i) + ":       " + translator.morseToChar(morse) +"\n";
                }
                textViewMorseToChar.setText(text2);
            }
            else {
                String text1 = "";
                String letras1 = "abcdefghijklmnopqrstuvwxyz";
                for (int i = 0; i < letras1.length(); i++) {
                    text1 += letras1.charAt(i) + ":       " + translator.charToMorse(letras1.charAt(i)) + "\n";
                }
                textViewMorseToChar.setText(text1);
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