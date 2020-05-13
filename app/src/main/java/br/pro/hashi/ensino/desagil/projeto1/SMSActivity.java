package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.view.MotionEvent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicReference;


public class SMSActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    float x1, y1, x2, y2;
    private Button buttonSend;


    private static final int REQUEST_SEND_SMS = 0;



    // Método de conveniência para iniciar a SMSActivity.
    private void startSMSActivity() {

        // Constrói uma Intent que corresponde ao pedido de "iniciar Activity".
        Intent intent = new Intent(this, SMSActivity.class);

        // Inicia a Activity especificada na Intent.
        startActivity(intent);
    }

//CRIAÇÃO DA ATIVIDADE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

//CHAMANDO OS BOTÕES E CAIXA DE TEXTO
        ImageButton contacts = findViewById(R.id.procurar_contatos);
        Button buttonPermission = findViewById(R.id.buttonPermission);
        Switch switchmorse = findViewById(R.id.switchmorse);
        Button buttonSend = findViewById(R.id.button_send);
        Button buttonMorse = findViewById(R.id.morse);
        Button buttonPalavra= findViewById(R.id.buttonpalavra);
        Button buttonLetra = findViewById(R.id.buttonletra);
        TextView textEnvio = findViewById(R.id.textEnviado);
        TextView textoMorse = findViewById(R.id.textoMorse);

        Translator arvore = new Translator();
        LinkedList<String> mensagem_morse = new LinkedList<>();
        LinkedList<String> mensagem_romano = new LinkedList<>();


        AtomicReference<Boolean> finalBool = new AtomicReference<>(true);
// ATRIBUINDO VALOR AO SWITCH

        switchmorse.setChecked(false);



//FUNÇÃO PARA ABRIR OS CONTATOS
        contacts.setOnClickListener((view) -> {
            openActivityContacts();
        });


//FUNÇÃO PARA O BOTÃO DE PERMISSÃO

        buttonPermission.setOnClickListener((view) -> {

            // Verifica se o aplicativo tem a permissão desejada.
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                buttonPermission.setVisibility(View.GONE);
            } else {

                // Senão, precisamos pedir essa permissão.

                // Cria um vetor de permissões a pedir. Como queremos
                // uma só, parece um pouco feio, mas é bem conveniente
                // quando queremos pedir várias permissões de uma vez.
                String[] permissions = new String[]{
                        Manifest.permission.SEND_SMS,
                };

                ActivityCompat.requestPermissions(this, permissions, REQUEST_SEND_SMS);
            }
        });


//FUNÇÃO PARA O BOTÃO DE ENVIO
        Spinner spinner_contacts = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter_contacts = ArrayAdapter.createFromResource(this,R.array.contatos, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_numeros = ArrayAdapter.createFromResource(this,R.array.numeros, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_contacts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_contacts.setAdapter(adapter_contacts);
        spinner_contacts.setOnItemSelectedListener(this);


        Spinner spinner_msgs = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter_msgs = ArrayAdapter.createFromResource(this,R.array.mensagens, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter_msgs.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_msgs.setAdapter(adapter_msgs);
        spinner_msgs.setOnItemSelectedListener(this);



        Spinner textMessage = findViewById(R.id.spinner2);
        Spinner textPhone = findViewById(R.id.spinner);


// CONDICAO INICIAL QUANDO A ATIVIDADE COMECA PARA SWITCH

        switchmorse.setText("Romano");
        buttonMorse.setVisibility(View.INVISIBLE);
        buttonLetra.setVisibility(View.INVISIBLE);
        buttonPalavra.setVisibility(View.INVISIBLE);
        spinner_msgs.setVisibility(View.VISIBLE);

// FUNCAO QUE MUDA O SWITCH
        switchmorse.setOnClickListener((view) -> {

            Boolean switchState = switchmorse.isChecked();

            if (switchState){
                switchmorse.setText("Morse");
                spinner_msgs.setVisibility(View.INVISIBLE);
                buttonMorse.setVisibility(View.VISIBLE);
                buttonLetra.setVisibility(View.VISIBLE);
                buttonPalavra.setVisibility(View.VISIBLE);


            }
            else{
                switchmorse.setText("Romano");
                buttonMorse.setVisibility(View.INVISIBLE);
                buttonLetra.setVisibility(View.INVISIBLE);
                buttonPalavra.setVisibility(View.INVISIBLE);
                spinner_msgs.setVisibility(View.VISIBLE);

            }

        });




// FUNCAO QUE DETEMINA O BOTAO PARA O MORSE


        buttonMorse.setOnClickListener((view) -> {
            if (finalBool.get()) {
                String simboloPonto = new String();
                simboloPonto = ".";
                mensagem_morse.add(simboloPonto);
                Object[] array = mensagem_morse.toArray();
                String message = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
                textoMorse.setText(message);
            }else{
                textEnvio.setText("");
                mensagem_romano.clear();
                finalBool.set(true);
            }

        });

        buttonMorse.setOnLongClickListener((view) -> {
            if (finalBool.get()) {

                String simboloTraco = new String();
                simboloTraco = "-";
                mensagem_morse.add(simboloTraco);
                Object[] array = mensagem_morse.toArray();
                String message = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
                textoMorse.setText(message);
            }else{
                textEnvio.setText("");
                mensagem_romano.clear();
                finalBool.set(true);
            }
            return true;
        });


// FUNCAO PARA BOTAO DE PALAVRAS

        buttonPalavra.setOnClickListener((view) -> {

            mensagem_romano.add("H");


        });



//FUNCAO QUE DETERMINA O BOTAO PARA A SEPARACAO DE LETRAS

        buttonLetra.setOnClickListener((view) -> {
            Object[] array = mensagem_morse.toArray();
            String message = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");
            char letra = arvore.morseToChar(message);
            String string =String.valueOf(letra);
            mensagem_romano.add(string);
            Object[] arrayy = mensagem_romano.toArray();
            String messagem = Arrays.toString(arrayy).replaceAll("\\[|\\]|,|\\s", "");
            message.replace('H','L');
            textEnvio.setText(messagem);
            mensagem_morse.clear();
            textoMorse.setText("");



        });




// FUNCAO PARA O BOTAO DE ENVIO

        buttonSend.setOnClickListener((view) -> {
            Boolean switchState = switchmorse.isChecked();

            if (switchState) {
                Object[] array = mensagem_romano.toArray();
                String message = Arrays.toString(array).replaceAll("\\[|\\]|,|\\s", "");

                int id = textPhone.getSelectedItemPosition();
                String numero = (String) adapter_numeros.getItem(id);
                if (message.isEmpty()) {
                    showToast("Mensagem inválida!");
                    return;
                }else{

                    textEnvio.setText("Enviado para: "+numero+System.lineSeparator()+System.lineSeparator()+"Mensagem: "+message);
                    finalBool.set(false);
                }


                // Enviar uma mensagem de SMS. Por simplicidade,
                // não estou verificando se foi mesmo enviada,
                // mas é possível fazer uma versão que verifica.
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(numero, null, message, null, null);


            }
            else{
                String message = textMessage.getSelectedItem().toString();
                int id = textPhone.getSelectedItemPosition();
                String numero = (String) adapter_numeros.getItem(id);
                if (message.isEmpty()) {
                    showToast("Mensagem inválida!");
                    return;
                }else{

                    textEnvio.setText("Enviado para: "+numero+System.lineSeparator()+System.lineSeparator()+"Mensagem: "+message);
                }


                // Enviar uma mensagem de SMS. Por simplicidade,
                // não estou verificando se foi mesmo enviada,
                // mas é possível fazer uma versão que verifica.
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(numero, null, message, null, null);}


        });


    }


    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {
        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        // Mostra essa bolha.
        toast.show();
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
                if(x1 < x2){
                    Intent i = new Intent(SMSActivity.this, MainActivity.class);

                    startActivity(i);
                }else if(x1 > x2){
                    Intent i = new Intent(SMSActivity.this, Morse.class);

                    startActivity(i);
                }
                break;
        }
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sSelected=adapterView.getItemAtPosition(i).toString();

        Toast.makeText(this,sSelected,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void openActivityContacts() {
        Intent intent = new Intent(this, ListaContatos.class);
        startActivity(intent);
    }


    // Como consequência da chamada de requestPermissions acima, este
    // método é chamado quando o usuário responde o pedido de permissão.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // Verifica se de fato é uma resposta ao pedido acima e se a
        // resposta foi positiva. As respostas estão armazenadas no
        // vetor grantResults, que pode estar vazio se o usuário
        // escolheu simplesmente ignorar o pedido e não responder nada.
        if (requestCode == REQUEST_SEND_SMS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // Se foi positiva, podemos iniciar a SMSActivity.
            startSMSActivity();
        }
    }
}
