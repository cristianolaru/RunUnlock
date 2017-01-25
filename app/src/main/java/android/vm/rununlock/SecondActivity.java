package android.vm.rununlock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

        TextView  nameTv;
        Intent intent;
        String username;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.second_activity);
                nameTv= (TextView) findViewById(R.id.name_Tv);
                intent = getIntent();
                username = intent.getStringExtra("username");
                nameTv.setText(username);



        }
}
