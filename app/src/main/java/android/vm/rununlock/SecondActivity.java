package android.vm.rununlock;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity{

        TextView  nameTv,nameTvError;
        Intent intent;
        String username;
        Button reset,send;
        EditText nome,cognome,cf,email,telefono,abb_atac;
        //Switch switch;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.second_activity);
                nameTv= (TextView) findViewById(R.id.name_Tv);
                nameTvError=(TextView) findViewById(R.id.name_Tv_Error);
                nome = (EditText) findViewById(R.id.insert_name);
                cognome= (EditText) findViewById(R.id.last_name);
                reset = (Button) findViewById(R.id.button_reset);
                send = (Button) findViewById(R.id.button_send);
                //switch = findViewById(R.id.switch1);
                cf = (EditText) findViewById(R.id.editCF);
                email = (EditText) findViewById(R.id.email);
                telefono=(EditText) findViewById(R.id.editText);
                abb_atac = (EditText) findViewById(R.id.abbonamento);
                intent = getIntent();
                username = intent.getStringExtra("username");
                nameTv.setText(username);

                reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                nome.setText("");
                                cognome.setText("");
                                cf.setText("");
                                email.setText("");
                                telefono.setText("");
                                abb_atac.setText("");


                        }
                });

                send.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            String codice = cf.getText().toString();
                            String abbonamento = abb_atac.getText().toString();
                            if(codice.equals("") || abbonamento.equals("")) {
                                nameTvError.setText("Mi dispiace non puoi proseguire devi inserire tutti i campi!");



                            }
                            else{
                                nameTvError.setText("Grazie per aver scelto il servizio RunUnock ti faremo sapere presto via E-Mail.");
                            }
                        }
                });




        }
}
