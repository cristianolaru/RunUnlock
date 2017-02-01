package android.vm.rununlock;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Francesco on 25/01/2017.
 */

public class MainActivity extends AppCompatActivity  {
    Button changeTextBtn, exitTextBtn;//, registrati;
    TextView welcomeTv, register;
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
        register=(TextView) findViewById(R.id.registratiTextView);
        //registrati=(Button) findViewById(R.id.registrazione);
        //changeTextEdit = (EditText) findViewById(R.id.change_text_hint);
        changeTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //welcomeTv.setText(changeTextEdit.getText());
                //username =  changeTextEdit.getText().toString();
                String user = username.getText().toString();
                String passw = password.getText().toString();

                if(user.equals("Francesco") || passw.equals("1234") && user.equals("Cristian") || user.equals("1234")){

                    Intent intent = new Intent(activity, SecondActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                    Context context = getApplicationContext();
                    CharSequence text = "Accesso avvenuto correttamente";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    Context context = getApplicationContext();
                    CharSequence text = "Mi dispiace non puoi proseguire devi inserire tutti i campi!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                }

            }
        });
        register.setOnClickListener(new View.OnClickListener(){
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.impostazioni:
                impostazioni();
                return true;
            case R.id.Info:
                showInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showInfo() {
        View v = null;
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.main);
        popup.show();
       /* setContentView(R.layout.info_activity);
        Intent intent = new Intent(activity, SecondActivity.class);*/
    }

    private void impostazioni() {
        setContentView(R.layout.setting_activity);
    }
}



