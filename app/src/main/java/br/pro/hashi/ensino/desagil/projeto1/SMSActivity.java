package br.pro.hashi.ensino.desagil.projeto1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.MotionEvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;



public class SMSActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        float x1, y1, x2, y2;
        private ImageButton contacts;
        private Button buttonPermission;
        private Button buttonSend;

    private static final int REQUEST_SEND_SMS = 0;


    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {
        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        // Mostra essa bolha.
        toast.show();
    }
    // Método de conveniência para iniciar a SMSActivity.
    private void startSMSActivity() {

        // Constrói uma Intent que corresponde ao pedido de "iniciar Activity".
        Intent intent = new Intent(this, SMSActivity.class);

        // Inicia a Activity especificada na Intent.
        startActivity(intent);
    }



    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sms);

            contacts = (ImageButton) findViewById(R.id.procurar_contatos);
            contacts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivityContacts();
                }
            });


        buttonPermission = (Button) findViewById(R.id.buttonPermission);
        buttonPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPermission.setVisibility(View.GONE);
            }
        });

            buttonPermission.setOnClickListener((view) -> {


                    // Verifica se o aplicativo tem a permissão desejada.
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                        // Se tem, podemos iniciar a SMSActivity direto.
                        startSMSActivity();
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




                Spinner spinner_contacts = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter_contacts = ArrayAdapter.createFromResource(this,R.array.contatos, android.R.layout.simple_spinner_item);
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



            Spinner textMessage = findViewById(R.id.spinner);
            Spinner textPhone = findViewById(R.id.spinner2);
            Button buttonSend = findViewById(R.id.button_send);

            buttonSend.setOnClickListener((view) -> {
                String message = textMessage.getSelectedItem().toString();
                String phone = textPhone.getSelectedItem().toString();



                // Esta verificação do número de telefone é bem
                // rígida, pois exige até mesmo o código do país.
                if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                    showToast("Número inválido!");
                    return;
                }

                // Enviar uma mensagem de SMS. Por simplicidade,
                // não estou verificando se foi mesmo enviada,
                // mas é possível fazer uma versão que verifica.
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(phone, null, message, null, null);

                // Limpar o campo para nenhum engraçadinho
                // ficar apertando o botão várias vezes.
               // textMessage.setselection(0);
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
                    if(x1 < x2){
                        Intent i = new Intent(SMSActivity.this, Morse.class);

                        startActivity(i);
                    }else if(x1 > x2){
                        Intent i = new Intent(SMSActivity.this, MainActivity.class);

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


