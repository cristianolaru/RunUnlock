package android.vm.rununlock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ThirdActivity extends AppCompatActivity{
    TextView risposta;
    Button registrati;
    EditText registrazioneUsername, registrazionePassword, registrazione2Password, registrazioneEmail;
    String rUsername, rPassword, r2Password;
    Intent intent2;
    boolean xo=false;
    Context context;
    int duration;
    Toast toast;

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

                if (controlloPassword(registrazionePassword.getText()+"",registrazione2Password.getText()+"")){
                    context = getApplicationContext();
                    CharSequence text = "loading...";
                    duration = Toast.LENGTH_LONG;
                    toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    context = getApplicationContext();
                    CharSequence text = "Le password non sono uguali";
                    duration = Toast.LENGTH_LONG;
                    toast = Toast.makeText(context, text, duration);
                    toast.show();

                }





            }

        });

    }

    public boolean controlloPassword(String a, String b){
        if (a.length()<4 && b.length()>8){
            return false;
        }else  if (a.equals(b)){
            return true;
        }else{
            return false;}

    }
}


