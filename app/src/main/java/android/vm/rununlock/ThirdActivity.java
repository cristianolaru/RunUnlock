package android.vm.rununlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ThirdActivity extends AppCompatActivity{
    TextView risposta;
    Button registrati;
    EditText registrazioneUsername, registrazionePassword, registrazione2Password, registrazioneEmail;
    String rUsername, rPassword, r2Password;
    Intent intent2;
    boolean xo=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        risposta=(TextView) findViewById(R.id.TV_risposta);

        registrazioneUsername=(EditText) findViewById(R.id.id_registrazione_username);
        registrazionePassword =(EditText) findViewById(R.id.id_inserimento_password);
        registrazione2Password=(EditText) findViewById(R.id.id_inserimento2_password);
        registrazioneEmail=(EditText) findViewById(R.id.id_inserimento_email);
        registrati=(Button) findViewById(R.id.button_registrati);
        intent2 = getIntent();

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            do {


                if (registrazionePassword == registrazione2Password && registrazionePassword.length() < 4 && registrazionePassword.length() > 8)
                    risposta.setText("Password Errore");
                else
                    risposta.setText("Ok!");


            }while ((risposta.equals("Ok!")));

            }
        });
    }
}


