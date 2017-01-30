package android.vm.rununlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Francesco on 25/01/2017.
 */

public class MainActivity extends AppCompatActivity {
    Button changeTextBtn, exitTextBtn, registrati;
    TextView welcomeTv;
    EditText changeTextEdit;
    Activity activity = this;
    EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exitTextBtn=(Button) findViewById(R.id.exit_text_btn);
        welcomeTv = (TextView) findViewById(R.id.welcome_tv);
        changeTextBtn= (Button) findViewById(R.id.change_text_btn);
        username = (EditText) findViewById(R.id.editUsername);
        password = (EditText) findViewById(R.id.editPassword);
        registrati=(Button) findViewById(R.id.registrazione);
        //changeTextEdit = (EditText) findViewById(R.id.change_text_hint);
        changeTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //welcomeTv.setText(changeTextEdit.getText());
                //username =  changeTextEdit.getText().toString();
                String user = username.getText().toString();
                String passw = password.getText().toString();
                if(username.equals("") || passw.equals("")) {
                    welcomeTv.setText("Mi dispiace ma non puoi loggarti se non inserisci i dati necessari!");
                }else{
                    Intent intent = new Intent(activity, SecondActivity.class);
                    //intent.putExtra("username",username);
                    startActivity(intent);

                }

            }
        });
        registrati.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(activity, ThirdActivity.class);
                startActivity(intent2);
            }
        });

        exitTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               System.exit(0);
            }
        });
    }
}
