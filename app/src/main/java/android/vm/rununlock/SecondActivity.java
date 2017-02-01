package android.vm.rununlock;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    TextView nameTv, nameTvError;
    Intent intent;
    String username;
    Button reset, send;
    EditText nome, cognome, cf, email, telefono, abb_atac;
    int maxLength = 16;
    Switch aSwitch;
    String codice;
    String abbonamento;
    String mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        nameTv = (TextView) findViewById(R.id.name_Tv);
        nameTvError = (TextView) findViewById(R.id.name_Tv_Error);
        nome = (EditText) findViewById(R.id.insert_name);
        cognome = (EditText) findViewById(R.id.last_name);
        reset = (Button) findViewById(R.id.button_reset);
        send = (Button) findViewById(R.id.button_send);

        cf = (EditText) findViewById(R.id.editCF);
        email = (EditText) findViewById(R.id.email);
        telefono = (EditText) findViewById(R.id.editText);
        abb_atac = (EditText) findViewById(R.id.abbonamento);
        aSwitch = (Switch) findViewById(R.id.switch1);
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
                Context context = getApplicationContext();
                CharSequence text = "I campi sono stati resettati correttamente!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                codice = cf.getText().toString();
                abbonamento = abb_atac.getText().toString();

                if (codice.equals("") || abbonamento.equals("")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Mi dispiace non puoi proseguire devi inserire tutti i campi!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();


                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Grazie per aver scelto il servizio RunUnock ti faremo sapere presto via E-Mail.";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    String codice = cf.getText().toString();
                    String abbonamento = abb_atac.getText().toString();

                }
            }
        });


        cf.setFilters(new InputFilter[]{new InputFilter.AllCaps(), new InputFilter.LengthFilter(maxLength)});


        abb_atac.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean buttonSwitch = aSwitch.getSplitTrack();
                mail = email.getText().toString();
                if (mail.equals("")) {
                    if (buttonSwitch = true) {
                        Context context = getApplicationContext();
                        CharSequence text = "Impossibile attivare il servizio RunUnlock";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        buttonSwitch = false;
                        buttonView.setChecked(false);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Il servizio RunUnlock è stato attivato!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        buttonSwitch = true;
                    }

                }
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