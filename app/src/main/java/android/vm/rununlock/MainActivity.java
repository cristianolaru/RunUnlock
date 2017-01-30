package android.vm.rununlock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Francesco on 25/01/2017.
 */

public class MainActivity extends AppCompatActivity {
    Button changeTextBtn, exitTextBtn;
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
        //changeTextEdit = (EditText) findViewById(R.id.change_text_hint);
        changeTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //welcomeTv.setText(changeTextEdit.getText());
                //username =  changeTextEdit.getText().toString();
                String user = username.getText().toString();
                String passw = password.getText().toString();
                if(user.equals("") || passw.equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Mi dispiace non puoi proseguire devi inserire tutti i campi!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    Intent intent = new Intent(activity, SecondActivity.class);
                    //intent.putExtra("username",username);
                    startActivity(intent);
                    Context context = getApplicationContext();
                    CharSequence text = "Accesso avvenuto correttamente";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }

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
