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

        textViewMorseToChar= findViewById(R.id.textViewMorseToChar);
        switch1 = (Switch)findViewById(R.id.switch1);

        String text1 = "";
        String[] morseChars2 = new String[]{".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---", "....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-", ".....", "....-", "...--", "..---", ".----", "-....", "--...", "---..", "----.", "-----"};
        LinkedList listMorse3 = new LinkedList(Arrays.asList(morseChars2));
        for (int i = 0; i < morseChars2.length; i++) {
            String morse = listMorse3.get(i).toString();
            text1 += listMorse3.get(i) + ":       " + translator.morseToChar(morse)+ "\n";
        }
        textViewMorseToChar.setText(text1);

        switch1.setOnClickListener((view) -> {
            Boolean switchState = switch1.isChecked();
            String str1, str2;
            if (switchState) {
                str1 = switch1.getTextOn().toString();
                String text = "";
                String[] morseChars = new String[]{".", "-", "..", ".-", "-.", "--", "...", "..-", ".-.", ".--", "-..", "-.-", "--.", "---", "....", "...-", "..-.", ".-..", ".--.", ".---", "-...", "-..-", "-.-.", "-.--", "--..", "--.-", ".....", "....-", "...--", "..---", ".----", "-....", "--...", "---..", "----.", "-----"};
                LinkedList listMorse = new LinkedList(Arrays.asList(morseChars));
                for (int i = 0; i < morseChars.length; i++) {
                    String morse =  listMorse.get(i).toString();
                    text += listMorse.get(i) + ":       " + translator.morseToChar(morse) +"\n";
                }
                textViewMorseToChar.setText(text);
            }
            else {
                String text = "";
                str1 = switch1.getTextOff().toString();
                char[] letras = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i','j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
                LinkedList listLetras = new LinkedList(Arrays.asList(letras));
                for (int i = 0; i < letras.length; i++) {
                    text += letras[i] + ":       " + translator.charToMorse(letras[i]) + "\n";

                }
                textViewMorseToChar.setText(text);

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
